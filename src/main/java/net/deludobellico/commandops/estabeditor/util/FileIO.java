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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mario on 24/07/2014.
 */
public class FileIO {
    /**
     * Resources paths
     */
    //Settings
    public static final String SETTINGS_XML_FILE = "estab-settings.xml";
    //Datasets
    public static final String DATASETS_FOLDER = "/datasets";
    public static final String NEW_ESTAB_PATH = "newestab.xml";
    public static final String DATASET_FILE_SUFFIX = "Estab.xml";
    public static final String DATASET_IMAGE_FOLDER_SUFFIX = "Estab_Images";
    public static final String DATASET_IMAGE_FOLDER_INDEX = "index";
    //Views
    public static final String VIEWS_FOLDER = "/views";
    public static final String ESTAB_EDITOR_VIEW = VIEWS_FOLDER + "/main.fxml";
    public static final String VEHICLE_VIEW = VIEWS_FOLDER + "/vehicle-editor-v2.0.fxml";
    public static final String WEAPON_VIEW = VIEWS_FOLDER + "/weapon-editor-v2.0.fxml";
    public static final String AMMO_VIEW = VIEWS_FOLDER + "/ammo-editor-v2.0.fxml";
    public static final String SEARCH_DIALOG_VIEW = VIEWS_FOLDER + "/search-dialog.fxml";
    public static final String SELECTION_DIALOG_VIEW = VIEWS_FOLDER + "/selection-list-dialog.fxml";
    public static final String INFO_DIALOG_VIEW = VIEWS_FOLDER + "/info-dialog.fxml";
    // Images
    public static final String IMAGES_FOLDER = "/images";
    public static final String REMOVE_ICON_RESOURCE = IMAGES_FOLDER + "/removeicon.png";
    public static final String COPY_ICON_RESOURCE = IMAGES_FOLDER + "/copyicon.png";
    public static final String WARNING_ICON_RESOURCE = IMAGES_FOLDER + "/warning.png";
    public static final String VEHICLE_ICON_RESOURCE = IMAGES_FOLDER + "/vehicleicon.png";
    public static final String WEAPON_ICON_RESOURCE = IMAGES_FOLDER + "/weaponicon.png";
    public static final String AMMO_ICON_RESOURCE = IMAGES_FOLDER + "/ammoicon.png";
    public static final String APP_ICON = IMAGES_FOLDER + "/appicon.png";
    /**
     * File filters
     */
    public static final FileChooser.ExtensionFilter[] FILECHOOSER_FILTERS = {
            new FileChooser.ExtensionFilter("XML (*.xml)", "*.xml"),
            new FileChooser.ExtensionFilter("All (*.*)", "*.*")
    };
    private static final Logger LOG = Logger.getLogger(FileIO.class.getName());
    /**
     * JAXB
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

    private FileIO() {
    }


    public static List<File> listFiles(File directory, FilenameFilter filter, boolean recursively) {
        List<File> files = new ArrayList<>();
        File[] entries = directory.listFiles();
        for (File entry : entries) {
            if (filter == null || filter.accept(directory, entry.getName())) {
                files.add(entry);
            }
            if (recursively && entry.isDirectory()) {
                files.addAll(listFiles(entry, filter, recursively));
            }
        }

        return files;
    }


    public static Settings loadProperties() {
        return null;
    }

    public static void loadSettings() {
        File file = new File(FileIO.getSettingsPath().toString());
        if (!file.exists()) file = getNewSettingsFile();
        JAXB_SETTINGS.unmarshallXML(file);
    }

    public static void saveSettings() {
        JAXB_SETTINGS.marshallXML(Settings.getInstance(), getFileOrCreateNew(getSettingsPath().toAbsolutePath().toString()));
    }

    /**
     * Tries to create a new file in @path, if it exists then returns the file
     *
     * @param path
     * @return
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

    public static File getOrCreateNewEstabFile() {
        File f = null;
        try {
            f = getFileOrCreateNew(getNewEstabPath().toString());
            FileOutputStream fos = new FileOutputStream(f, false);
            fos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><estab-data></estab-data>".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            LOG.log(Level.SEVERE, "Error creating new estab file: " + f.getPath(), e);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Error creating new estab file: " + f.getPath(), e);
        }
        return f;
    }

    public static File getNewSettingsFile() {
        File f = null;
        try {
            f = getFileOrCreateNew(getSettingsPath().toString());
            FileOutputStream fos = new FileOutputStream(f, false);
            fos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><settings><vertical-panes>true</vertical-panes><visible-source-panel>true</visible-source-panel><visible-target-panel>true</visible-target-panel><visible-toolbar>true</visible-toolbar><window-height>800.0</window-height><window-width>1280.0</window-width><expanded-source-pane>true</expanded-source-pane><expanded-target-pane>false</expanded-target-pane></settings>".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void copy(File sourceFile, File targetFile) {
        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File.createNewFile() proxy
     *
     * @param file
     * @return
     */
    public static File createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void copy(InputStream resourceAsStream, Path path) {
        try {
            Files.copy(resourceAsStream, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getNewEstabPath() {
        return FileSystems.getDefault().getPath(System.getProperty("user.dir"), NEW_ESTAB_PATH);
    }

    public static Path getSettingsPath() {
        return FileSystems.getDefault().getPath(System.getProperty("user.home"), SETTINGS_XML_FILE);
    }

    public static File installDataset(String datasetName, File targetFolder) {
        LOG.log(Level.INFO, String.format("Installing %s dataset in folder: %s ", datasetName, targetFolder.getName()));
        File targetFile = new File(targetFolder.getPath(), datasetName + DATASET_FILE_SUFFIX);
        if (targetFile != null && targetFile.exists()) {
            LOG.log(Level.SEVERE, String.format("Aborting installation. %s dataset already exists in folder: %s", datasetName, targetFolder.getName()));
            targetFile = null;
        } else {
            // Installing dataset from resources to file
            FileIO.copy(FileIO.class.getResourceAsStream(FileIO.DATASETS_FOLDER + "/" + targetFile.getName()), targetFile.getAbsoluteFile().toPath());

            // Installing all dataset images included in the index
            // Preparing the image folder on disk
            File targetImageFolder = new File(targetFolder, datasetName + DATASET_IMAGE_FOLDER_SUFFIX);
            targetImageFolder.mkdirs();

            String datasetResourceImageFolder = FileIO.DATASETS_FOLDER + "/" + targetImageFolder.getName();
            String datasetResourceImageIndex = datasetResourceImageFolder + "/" + datasetName + DATASET_IMAGE_FOLDER_INDEX;
            InputStream is = FileIO.class.getResourceAsStream(datasetResourceImageIndex);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String imageFileName;
            try {
                while ((imageFileName = reader.readLine()) != null) {
                    FileIO.copy(FileIO.class.getResourceAsStream(datasetResourceImageFolder + "/" + imageFileName), new File(targetImageFolder, imageFileName).toPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return targetFile;
    }

    /**
     * Gets an image from the dataset image folder
     * Names are strict and have to match the following pattern:
     * <p>Dataset name: COTAEstab_Images</p>
     * <p>Dataset file: COTAEstab.xml</p>
     * <p>Dataset image folder: COTAimage</p>
     *
     * @param datasetFile
     * @param imageFileName
     * @return
     */
    //TODO: create progress bar? maybe for loading new estabs?
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

    public static Object loadEstab(File estabFile) {
        return JAXB_POJO.unmarshallXML(estabFile);
    }

    public static void saveEstab(EstabData data, File file) {
        JAXB_POJO.marshallXML(data, file);
    }
}
