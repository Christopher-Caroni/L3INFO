package fil.coo;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestingFileUtils {

    private static Logger logger = Logger.getLogger(TestingFileUtils.class.getSimpleName());

    private TestingFileUtils() {
    }


    /**
     * Creates the directory denoted by testingDirPath
     *
     * @param testingDirPath the path to the folder to create
     * @param resetFolder    if an existing directory with the same path should be erased beforehand
     * @return the path to the newly created folder
     * @throws IOException the error, if encountered, while manipulating the directory
     */
    public static Path setupTestDir(Path testingDirPath, boolean resetFolder) throws IOException {
        if (testingDirPath == null) {
            throw new IllegalArgumentException("Cannot create a null directory");
        }

        if (resetFolder) {
            verifyAndDeletedExistingFolder(testingDirPath);
        }
        return createTestingFolder(testingDirPath);
    }

    /**
     * Creates the directory denoted by testingDirPath and fills it with files that have the names from filenamesToCreate
     *
     * @param testingDirPath    the name of your testing directory you want to create
     * @param filenamesToCreate the list of filenames to create in testDirName, can be empty
     * @param resetFolder       if the folder should be emptied beforehand
     * @throws IOException the error, if encountered, while manipulating the directory or files
     */
    public static Path setupTestDir(Path testingDirPath, List<String> filenamesToCreate, boolean resetFolder) throws IOException {
        if (filenamesToCreate == null) {
            throw new IllegalArgumentException("Cannot create null files");
        }

        Path newPath = setupTestDir(testingDirPath, resetFolder);
        createTempFiles(newPath, filenamesToCreate);
        return newPath;
    }

    /**
     * If the directory exists, empties and deletes it
     *
     * @param testDirPath the path to the folder to check
     */
    private static void verifyAndDeletedExistingFolder(Path testDirPath) {
        File testingDir = new File(testDirPath.normalize().toString());
        if (testingDir.exists()) {

            verifyFileIsDirectory(testingDir);

            logger.debug("\"" + testDirPath.toString() + "\" exists, will delete");
            deleteContentsOfDirectory(testingDir);
            deleteFile(testingDir);
        } else {
            logger.debug("no need to delete: \"" + testDirPath.toString() + "\" does not point to an existing folder");
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

    public static void deleteFile(Path tempRootDirPath) {
        File testingDir = new File(tempRootDirPath.normalize().toString());
        deleteFile(testingDir);
    }

    public static void deleteFileInDirectory(Path rootTestingFolder, String fileToCreate) {
        verifyPathLeadsToDirectory(rootTestingFolder);

        File file = new File(rootTestingFolder.normalize().toString() + "/" + fileToCreate);
        if (!file.exists()) {
            logger.debug("File does not exist, cannot delete");
        } else {
            boolean delete = file.delete();
            logger.debug("deleted file in dir \"" + file.toString() + "\" : " + delete);
        }
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
     * Deletes the contents of a folder
     *
     * @param testingDirPath the folder to delete the contents of
     */
    public static void deleteContentsOfDirectory(Path testingDirPath) {
        verifyPathLeadsToDirectory(testingDirPath);
        File testingDir = new File(testingDirPath.toString());

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
            createFileInDirectory(testingDirPath, file);
        }
    }

    /**
     * Creates the file with the name file in the directory denoted by testingDirPath
     *
     * @param testingDirPath the path to the directory to create the file in
     * @param file           the name of the file to create
     * @throws IOException the error, if encountered, while creating the file
     */
    public static void createFileInDirectory(Path testingDirPath, String file) throws IOException {
        verifyPathLeadsToDirectory(testingDirPath);

        String prefix = testingDirPath.normalize().toString() + "/";

        Path pathToNewFile = Files.createFile(Paths.get(prefix + file));
        logger.debug("created file at \"" + pathToNewFile.toAbsolutePath().toString() + "\"");
    }

    private static void verifyPathLeadsToDirectory(Path dirPath) {
        File testingDir = new File(dirPath.normalize().toString());
        verifyFileIsDirectory(testingDir);
    }

    private static void verifyFileIsDirectory(File dir) {
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir.getAbsolutePath() + " is not a directory");
        }
    }

    /**
     * Deletes the contents and the directory denoted by dirPath
     *
     * @param dirPath that path to the directory to empty and delete
     */
    public static void deleteDirectory(Path dirPath) {
        deleteContentsOfDirectory(dirPath);
        deleteFile(dirPath);
    }

    public static void copyFileToDir(Path filePath, Path destPath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("Cannot copy with null path");
        }

        File fileToCopy = new File(filePath.toAbsolutePath().toString());
        if (!fileToCopy.isFile()) {
            throw new UnsupportedOperationException(filePath.toAbsolutePath().toString() + " is not a file");
        }

        Files.copy(filePath, destPath);
    }

}
