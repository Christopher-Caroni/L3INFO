import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class.getSimpleName());

    private FileUtils() {
    }

    /**
     * Creates a test dir testDirName and the files from files
     *
     * @param testingDirPath the name of your testing directory you want to create
     * @param files          the list of filenames to create in testDirName
     * @param resetFolder    if the folder should be emptied beforehand
     * @throws IOException the error, if encountered, while manipulating the directory or files
     */
    public static void setupTestDir(Path testingDirPath, List<String> files, boolean resetFolder) throws IOException {
        if (resetFolder) {
            verifyExistingFolder(testingDirPath);
            createTestingFolder(testingDirPath);
        }

        createTempFiles(testingDirPath, files);

    }

    /**
     * If the directory exists, empty it, delete it and then recreate it
     *
     * @param testDirPath the path to the folder to check
     */
    private static void verifyExistingFolder(Path testDirPath) {
        File testingDir = new File(testDirPath.normalize().toString());
        verifyFileIsDirectory(testingDir);

        if (testingDir.exists()) {
            logger.debug("test folder exists, will delete");
            deleteContentsOfDirectory(testingDir);
            deleteFile(testingDir);
        } else {
            logger.debug("testDirPath does not point to an existing folder");
        }
    }

    /**
     * Deletes a file
     *
     * @param file the file to delete
     */
    public static void deleteFile(File file) {
        boolean delete = file.delete();
        logger.debug("deleted dir \"" + file.toString() + "\" : " + delete);
    }

    /**
     * Deletes the contents of a folder
     *
     * @param testingDir the folder to delete the contents of
     */
    public static void deleteContentsOfDirectory(File testingDir) {
        verifyFileIsDirectory(testingDir);

        String[] entries = testingDir.list();
        for (String s : entries) {
            File currentFile = new File(testingDir.getPath(), s);
            deleteFile(currentFile);
        }
    }


    /**
     * Creates a directory with a path to testingDirPath
     *
     * @param testingDirPath the path to where the new directory should be
     * @return the path, as created by Java, to the new directory
     * @throws IOException the error, if encountered, while creating the directory
     */
    private static Path createTestingFolder(Path testingDirPath) throws IOException {
        return Files.createDirectory(testingDirPath);
    }

    /**
     * @param testingDirPath the path to the directory in which to create all the files
     * @param files          the list of names with which to create the files
     * @throws IOException the error, if encountered, while creating the file
     */
    private static void createTempFiles(Path testingDirPath, List<String> files) throws IOException {
        verifyPathLeadsToDirectory(testingDirPath);

        for (String file : files) {
            createFile(testingDirPath, file);
        }
    }

    /**
     * Creates the file with the name file in the directory denoted by testingDirPath
     *
     * @param testingDirPath the path to the directory to create the file in
     * @param file           the name of the file to create
     * @throws IOException the error, if encountered, while creating the file
     */
    private static void createFile(Path testingDirPath, String file) throws IOException {
        verifyPathLeadsToDirectory(testingDirPath);

        String prefix = testingDirPath.normalize().toString() + "/";

        Path startsWithCPath = Files.createFile(Paths.get(prefix + file));
        logger.debug("created test file StartsWithC at \"" + startsWithCPath.toAbsolutePath().toString() + "\"");
    }

    private static void verifyPathLeadsToDirectory(Path dirPath) {
        File testingDir = new File(dirPath.normalize().toString());
        verifyFileIsDirectory(testingDir);
    }

    private static void verifyFileIsDirectory(File dir) {
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("testingDir is not a directory");
        }
    }
}
