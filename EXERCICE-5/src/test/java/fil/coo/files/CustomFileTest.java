package fil.coo.files;

import fil.coo.TestingFileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomFileTest {

    private static final List<String> testFiles = Arrays.asList("dummy", "dummy2", "dummy.class", "fake", "fake.class");

    private CustomFile customFile;
    private MockFilter mockFilter;

    @Before
    public void setup() throws IOException {
        Path testPath = TestingFileUtils.setupTestDir(Paths.get("testing"), testFiles, true);
        customFile = new CustomFile(testPath.toAbsolutePath().toString());
        mockFilter = new MockFilter();
    }

    @After
    public void teardown() {
        TestingFileUtils.deleteDirectory(customFile.toPath());
    }

    @Test
    public void testSetup() {
        List<String> contents = customFile.list((dir, name) -> true, null);

        for (String fileName : testFiles) {
            assertThat(contents.contains(fileName), is(true));
        }
    }

    @Test
    public void testThatListIgnoresAlreadyTestedFiles() {
        assertThat(mockFilter.testCounter, is(0));
        assertThat(mockFilter.testedFiles.isEmpty(), is(true));

        int ignoredCount = 2;
        int expectedTestCount = testFiles.size() - ignoredCount;
        List<String> filesToIgnore = testFiles.subList(0, ignoredCount);

        List<String> contents = customFile.list(mockFilter, filesToIgnore);
        assertThat(mockFilter.testCounter, is(expectedTestCount));

        // Assert that the tested filenames list does not contain any of the filenames to ignore
        assertThat(Collections.disjoint(mockFilter.testedFiles, filesToIgnore), is(true));

        // assert that the "new" contents contains all the original test testFiles
        assertThat(contents.containsAll(testFiles), is(true));
    }

    private static class MockFilter implements FilenameFilter {

        int testCounter = 0;
        List<String> testedFiles;

        public MockFilter() {
            testedFiles = new ArrayList<>();
        }

        @Override
        public boolean accept(File dir, String name) {
            testCounter++;
            testedFiles.add(name);
            return true;
        }
    }

}