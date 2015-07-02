package net.deludobellico.estabeditorfx.util;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import net.deludobellico.estabeditorfx.data.jaxb.EstabData;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
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
    /** Resources paths **/

    //Main resource folders
    private static final String TEMPLATES_FOLDER = "/templates";
    private static final String VIEWS_FOLDER = "/views";
    private static final String IMAGES_FOLDER = "/images";

    //Views (fxml)
    public static final String MAIN_VIEW = VIEWS_FOLDER + "/main.fxml";
    public static final String FORCE_VIEW = VIEWS_FOLDER + "/force-editor.fxml";
    public static final String VEHICLE_VIEW = VIEWS_FOLDER + "/vehicle-editor.fxml";
    public static final String WEAPON_VIEW = VIEWS_FOLDER + "/weapon-editor.fxml";
    public static final String AMMO_VIEW = VIEWS_FOLDER + "/ammo-editor.fxml";
    public static final String SIDE_VIEW = VIEWS_FOLDER + "/side-editor.fxml";
    public static final String NATION_VIEW = VIEWS_FOLDER + "/nation-editor.fxml";
    public static final String SERVICE_VIEW = VIEWS_FOLDER + "/service-editor.fxml";
    public static final String SEARCH_DIALOG_VIEW = VIEWS_FOLDER + "/search-dialog.fxml";
    public static final String SELECTION_DIALOG_VIEW = VIEWS_FOLDER + "/selection-list-dialog.fxml";
    public static final String INFO_DIALOG_VIEW = VIEWS_FOLDER + "/info-dialog.fxml";

    /** Settings and utility strings **/
    private static final String CLIENT_SETTINGS_FILE_PATH = "estab-settings.xml";
    private static final String NEW_ESTAB_PATH = "newestab.xml";
    private static final String ESTAB_TEMPLATE = "DefaultEstab.xml";
    private static final String ESTAB_IMAGE_FOLDER_SUFFIX = "_Images";

    /**
     * Saved JAXB contexts for POJO classes and the Settings file
     */
    private static JAXBFactory JAXB_POJO;

    static {
        try {
            JAXB_POJO = new JAXBFactory("net.deludobellico.estabeditorfx.data.jaxb");
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
    public static boolean copy(InputStream stream, Path path) {
        try {
            Files.copy(stream, path, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns an image loaded from a file with the given filename. Files are searched inside the default images folder.
     * @param filename
     * @return
     */
    public static Image getImageFromFile(String filename) {
        InputStream inputStream = FileIO.class.getResourceAsStream(FileIO.IMAGES_FOLDER + "/" + filename);
        Image image = new Image(inputStream);
        return image;
    }

    /**
     * Installs the dataset file from the jar to disk
     *
     * @param datasetFile    dataset location
     * @param targetFilePath target folder
     * @return true if the file was copied, false otherwise
     */
    private static boolean installEstabFile(String datasetFile, Path targetFilePath) {
        InputStream inputStream = FileIO.class.getResourceAsStream(FileIO.TEMPLATES_FOLDER + "/" + datasetFile);
        return FileIO.copy(inputStream, targetFilePath);
    }

//    /**
//     * Installs the dataset images folder from the jar to disk
//     *
//     * @param datasetName  dataset name ("BFTB", "COTA", etc.)
//     * @param targetFolder target folder
//     */
//    private static void installDatasetImages(String datasetName, File targetFolder) {
//
//        // Preparing the image folder on disk
//        File targetImageFolder = new File(targetFolder, datasetName + ESTAB_IMAGE_FOLDER_SUFFIX);
//        try {
//            if (!targetImageFolder.mkdirs())
//                throw new IOException("Could not create folder: " + targetImageFolder.getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // I love all this boiler plate
//        String datasetResourceImageFolder = FileIO.DATASETS_FOLDER + "/" + targetImageFolder.getName();
//        String datasetResourceImageIndex = datasetResourceImageFolder + "/" + datasetName + "index";
//
//        try (InputStream is = FileIO.class.getResourceAsStream(datasetResourceImageIndex);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
//            String imageFileName;
//            while ((imageFileName = reader.readLine()) != null) {
//                InputStream imageResource = FileIO.class.getResourceAsStream(datasetResourceImageFolder + "/" + imageFileName);
//                FileIO.copy(imageResource, new File(targetImageFolder, imageFileName).toPath());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * Gets an image from the estab image folder
     * Names are strict and have to match the following pattern:
     * <p>
     * Dataset name: COTA
     * Dataset file: COTAEstab.xml
     * Dataset image folder: COTAEstab_Images
     *
     * @param estabFile   where the dataset is stored on disk
     * @param imageFileName file name of the image the method will load
     * @return the image if it was correctly loaded, null otherwise
     */
    public static Image getEstabImage(File estabFile, String imageFileName) {
        String estabName = getFilenameWithoutExtension(estabFile);
        File estabImageFolder = new File(estabFile.getParent(), estabName + ESTAB_IMAGE_FOLDER_SUFFIX);
        File estabPicture = new File(estabImageFolder, imageFileName);
        Image picture = null;
        try {
            picture = new Image(estabPicture.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return picture;
    }

    public static File getEstabImageFolder(File estabFile) {
        String estabName = getFilenameWithoutExtension(estabFile);
        File estabImageFolder = new File(estabFile.getParent(), estabName + ESTAB_IMAGE_FOLDER_SUFFIX);
        return estabImageFolder;
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
        if(!installEstabFile(ESTAB_TEMPLATE, getNewEstabPath())) f = null;
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

    public static String getFilenameWithoutExtension(File file) {
        return file.getName().replaceAll(".*[\\\\/]|\\.[^\\.]*$", "");
    }
}
