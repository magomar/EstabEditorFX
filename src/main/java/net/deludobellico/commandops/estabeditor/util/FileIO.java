package net.deludobellico.commandops.estabeditor.util;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import net.deludobellico.commandops.estabeditor.data.jaxb.EstabData;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class controls all access to disk and stores resources paths.
 *
 * @author Mario
 * @author Heine
 */
public class FileIO {
    /**
     * File filters
     */
    public static final FileChooser.ExtensionFilter[] EXTENSION_FILTERS = {
            new FileChooser.ExtensionFilter("XML (*.xml)", "*.xml"),
            new FileChooser.ExtensionFilter("All (*.*)", "*.*")
    };
    private static final Logger LOG = Logger.getLogger(FileIO.class.getName());
    /**
     * Resources paths
     */
    //Settings
    private static final String CLIENT_SETTINGS_FILE_PATH = "estab-settings.xml";
    //Datasets
    private static final String DATASETS_FOLDER = "/datasets";
    private static final String NEW_ESTAB_PATH = "newestab.xml";
    private static final String DATASET_FILE_SUFFIX = "Estab.xml";
    private static final String DATASET_IMAGE_FOLDER_SUFFIX = "Estab_Images";
    private static final String DATASET_IMAGE_FOLDER_INDEX = "index";
    //Views
    private static final String VIEWS_FOLDER = "/views";
    public static final String ESTAB_EDITOR_VIEW = VIEWS_FOLDER + "/main.fxml";
    public static final String FORCE_VIEW = VIEWS_FOLDER + "/force-editor.fxml";
    public static final String VEHICLE_VIEW = VIEWS_FOLDER + "/vehicle-editor.fxml";
    public static final String WEAPON_VIEW = VIEWS_FOLDER + "/weapon-editor.fxml";
    public static final String AMMO_VIEW = VIEWS_FOLDER + "/ammo-editor.fxml";
    public static final String SEARCH_DIALOG_VIEW = VIEWS_FOLDER + "/search-dialog.fxml";
    public static final String SELECTION_DIALOG_VIEW = VIEWS_FOLDER + "/selection-list-dialog.fxml";
    public static final String INFO_DIALOG_VIEW = VIEWS_FOLDER + "/info-dialog.fxml";
    // Images
    private static final String IMAGES_FOLDER = "/images";
    public static final String WARNING_ICON_RESOURCE = IMAGES_FOLDER + "/warning.png";
    public static final String INFO_ICON_RESOURCE = IMAGES_FOLDER + "/info.png";
    public static final String APP_ICON = IMAGES_FOLDER + "/app-icon.png";
    /**
     * Saved JAXB contexts for POJO classes and the Settings file
     */
    private static JAXBFactory JAXB_POJO;
    private static JAXBFactory JAXB_SETTINGS;

    static {
        try {
            JAXB_POJO = new JAXBFactory("net.deludobellico.commandops.estabeditor.data.jaxb");
            JAXB_SETTINGS = new JAXBFactory(Settings.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Protect the class from being instantiated
     */
    private FileIO() {
    }

    /**
     * Tries to create a new file in a given path, if it already exists then returns the file.
     *
     * @param path of the file we want to retrieve
     * @return null if the file could not be created or retrieved
     */
    public static File getFileOrCreateNew(String path) {
        File f = null;
        try {
            f = new File(path);
            boolean exists = f.exists();
            if (!exists) {
                boolean createNew = f.createNewFile();
                if (!createNew) {
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error creating: " + path, new IOException());
        }
        return f;
    }

    /**
     * Copies all contents from a source file to a target file.
     *
     * @param sourceFile source file with the contents to copy
     * @param targetFile target file where the contents will be copied
     */
    public static void copy(File sourceFile, File targetFile) {
        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a stream to disk
     *
     * @param stream stream to save
     * @param path   path where the stream is saved
     * @return the number of bytes read or written
     */
    public static long copy(InputStream stream, Path path) {
        try {
            return Files.copy(stream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Installs a Estab dataset from the jar to disk.
     *
     * @param datasetName  dataset name
     * @param targetFolder target folder
     * @return dataset file with the Estab contents
     */
    public static File installDataset(String datasetName, File targetFolder) {

        LOG.log(Level.INFO, String.format("Installing %s dataset in folder: %s ", datasetName, targetFolder.getName()));
        File targetFile = new File(targetFolder.getPath(), datasetName + DATASET_FILE_SUFFIX);

        if (targetFile.exists()) {
            LOG.log(Level.SEVERE, String.format("Aborting installation. %s dataset already exists in folder: %s", datasetName, targetFolder.getName()));
            targetFile = null;
        } else {
            // Installing dataset from resources to file
            installDatasetFile(targetFile.getName(), targetFile.getAbsoluteFile().toPath());

            // Installing all dataset images included in the index
            installDatasetImages(datasetName, targetFolder);
        }
        return targetFile;
    }

    /**
     * Installs the dataset file from the jar to disk
     *
     * @param datasetFile    dataset location
     * @param targetFilePath target folder
     * @return true if the file was copied, false otherwise
     */
    private static boolean installDatasetFile(String datasetFile, Path targetFilePath) {
        return 0 < FileIO.copy(FileIO.class.getResourceAsStream(FileIO.DATASETS_FOLDER + "/" + datasetFile), targetFilePath);
    }

    /**
     * Installs the dataset images folder from the jar to disk
     *
     * @param datasetName  dataset name ("BFTB", "COTA", etc.)
     * @param targetFolder target folder
     */
    private static void installDatasetImages(String datasetName, File targetFolder) {

        // Preparing the image folder on disk
        File targetImageFolder = new File(targetFolder, datasetName + DATASET_IMAGE_FOLDER_SUFFIX);
        try {
            if (!targetImageFolder.mkdirs())
                throw new IOException("Could not create folder: " + targetImageFolder.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // I love all this boiler plate
        String datasetResourceImageFolder = FileIO.DATASETS_FOLDER + "/" + targetImageFolder.getName();
        String datasetResourceImageIndex = datasetResourceImageFolder + "/" + datasetName + DATASET_IMAGE_FOLDER_INDEX;

        try (InputStream is = FileIO.class.getResourceAsStream(datasetResourceImageIndex);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String imageFileName;
            while ((imageFileName = reader.readLine()) != null) {
                InputStream imageResource = FileIO.class.getResourceAsStream(datasetResourceImageFolder + "/" + imageFileName);
                FileIO.copy(imageResource, new File(targetImageFolder, imageFileName).toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets an image from the dataset image folder
     * Names are strict and have to match the following pattern:
     * <p>
     * Dataset name: COTA
     * Dataset file: COTAEstab.xml
     * Dataset image folder: COTAEstab_Images
     *
     * @param datasetFile   where the dataset is stored on disk
     * @param imageFileName file name of the image the method will load
     * @return the image if it was correctly loaded, null otherwise
     */
    public static Image getDatasetImage(File datasetFile, String imageFileName) {
        String datasetName = datasetFile.getName().split(DATASET_FILE_SUFFIX)[0];
        File datasetImageFolder = new File(datasetFile.getParent(), datasetName + DATASET_IMAGE_FOLDER_SUFFIX);
        File datasetPicture = new File(datasetImageFolder, imageFileName);
        Image picture = null;
        try {
            picture = new Image(datasetPicture.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return picture;
    }

    public static File getDatasetImageFolder(File datasetFile) {
        String datasetName = datasetFile.getName().split(DATASET_FILE_SUFFIX)[0];
        File datasetImageFolder = new File(datasetFile.getParent(), datasetName + DATASET_IMAGE_FOLDER_SUFFIX);
        return datasetImageFolder;
    }

    /**
     * Returns the path of the default empty Estab dataset on disk.
     *
     * @return the path of the default empty Estab dataset on disk.
     */
    public static Path getNewEstabPath() {
        return FileSystems.getDefault().getPath(System.getProperty("user.dir"), NEW_ESTAB_PATH);
    }

    /**
     * Copies the default empty Estab dataset from resources to disk.
     *
     * @return the created file, null if there was an error.
     */
    public static File getOrCreateNewEstabFile() {
        File f = getFileOrCreateNew(getNewEstabPath().toString());
        if(!installDatasetFile("Default" + DATASET_FILE_SUFFIX, getNewEstabPath())) f = null;
        return f;
    }

    /**
     * Loads Estab from disk
     *
     * @param estabFile file to load
     * @return loaded EstabData
     */
    public static Object loadEstab(File estabFile) {
        return JAXB_POJO.unmarshallXML(estabFile);
    }

    /**
     * Saves Estabs to disk
     *
     * @param data EstabData to save
     * @param file target file
     */
    public static void saveEstab(EstabData data, File file) {
        JAXB_POJO.marshallXML(data, file);
    }

    /**
     * Returns the path of the default settings file.
     *
     * @return the path of the default settings file
     */
    public static Path getClientSettingsPath() {
        return FileSystems.getDefault().getPath(System.getProperty("user.home"), CLIENT_SETTINGS_FILE_PATH);
    }

    /**
     * Loads the settings file. Creates a new one if it doesn't exist.
     */
    public static void loadSettings() {
        File file = new File(FileIO.getClientSettingsPath().toString());
        if (!file.exists()) return; // Loading default settings
        JAXB_SETTINGS.unmarshallXML(file);
    }

    /**
     * Saves settings to disk. Creates a new settings file if it doesn't exist.
     */
    public static void saveSettings() {
        JAXB_SETTINGS.marshallXML(Settings.getInstance(), getFileOrCreateNew(getClientSettingsPath().toAbsolutePath().toString()));
    }
}
