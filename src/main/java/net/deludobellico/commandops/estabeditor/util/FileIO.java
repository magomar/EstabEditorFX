package net.deludobellico.commandops.estabeditor.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import org.xml.sax.SAXParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
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
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
     * JAXB paths
     *
     */
    // TODO: move jaxb class
    private static final String JAXB_CONTEXT_PATH = "net.deludobellico.commandops.estabeditor.data.jaxb";
    private static JAXBContext JAXB_CONTEXT;
    private static Marshaller MARSHALLER;
    private static Unmarshaller UNMARSHALLER;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
            UNMARSHALLER = JAXB_CONTEXT.createUnmarshaller();
            MARSHALLER = JAXB_CONTEXT.createMarshaller();
            MARSHALLER.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private FileIO() {
    }

    /**
     * Unmarshalls XML element from file into java object
     *
     * @param file the XML file to be unmarshalled
     * @return the object unmarshalled from the {@code file}
     */
    public static Object unmarshallXML(File file) {
        Object object = null;
        try {
            StreamSource source = new StreamSource(file);
            object = UNMARSHALLER.unmarshal(source);
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "Exception unmarshalling XML", ex);
        } finally {
            return object;
        }
    }

    /**
     * Marshalls Java object into XML file
     *
     * @param object object to be marshalled
     * @param file   file to save the marshalled object
     * @return the XML file
     */
    public static File marshallXML(Object object, File file) {
        try {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                MARSHALLER.marshal(object, fos);
                return file;
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
            }
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static StringWriter marshallXML(Object object) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MARSHALLER.marshal(object, sw);
                return sw;
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
            }
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
        }
        return null;
    }

    /**
     * Marshalls Java object in a zipped XMl file
     *
     * @param object object to be marshalled
     * @param file   non zip file to save the marshalled object
     * @return the ZIP file
     */
    public static File marshallZipped(Object object, File file) {
        File zipFile = new File(file.getAbsolutePath() + ".zip");
        try {
            try {
                FileOutputStream fos = new FileOutputStream(zipFile);
                try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos))) {
                    ZipEntry ze = new ZipEntry(file.getName());
                    zos.putNextEntry(ze);
                    MARSHALLER.marshal(object, zos);
                    return zipFile;
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
                }
            } catch (FileNotFoundException ex) {
                LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
            }

        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
        }
        return null;
    }

    /**
     * Marshalls Java object in a gzipped XMl file
     *
     * @param object object to be marshalled
     * @param file   file to save the marshalled object
     * @return the Gzip file
     */
    public static File marshallGzipped(Object object, File file) {
        File gzFile = new File(file.getAbsolutePath() + ".gz");
        try {
            try {
                FileOutputStream fos = new FileOutputStream(gzFile);
                try {
                    GZIPOutputStream gz = new GZIPOutputStream(fos);
                    MARSHALLER.marshal(object, gz);
                    return gzFile;
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
                }
            } catch (FileNotFoundException ex) {
                LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
            }

        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "Exception marshalling XML", ex);
        }
        return null;
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

    /**
     * Unmarshalls Json element of type {@code c} from the {@code file}.
     *
     * @param c    the class of object to be unmarshalled
     * @param file the Json file containing the marshalled object
     * @return the object of type {@code T} from the {@code file}
     */
    public static <T> T unmarshallJson(File file, Class<T> c) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        T object = null;
        try {
            object = mapper.readValue(file, c);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Exception unmarshalling Json", ex);
        }
        return object;
    }

    /**
     * Marshalls Java object into a Json file
     *
     * @param object object to be marshalled
     * @param file   file to save the marshalled object
     * @return
     */
    public static File marshallJson(Object object, File file) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        try {
            writer.writeValue(file, object);
            return file;
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Exception marshalling Json", ex);
        }
        return null;
    }

    public static Settings loadProperties() {
        return null;
    }

    public static void loadSettings() {
        try {
            File file = new File(FileIO.getSettingsPath().toString());
            if (!file.exists()) {
                file = getNewSettingsFile();
            }
            Unmarshaller um = JAXBContext.newInstance(Settings.class).createUnmarshaller();
            um.unmarshal(file);

        } catch (JAXBException e) {
            System.out.println(e);
            if (e.getLinkedException().getClass().equals(SAXParseException.class)) {
                LOG.log(Level.WARNING, "Settings file has incorrect syntax", e);
            }
        }
    }

    public static void saveSettings() {
        try {
            Marshaller m = JAXBContext.newInstance(Settings.class).createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(Settings.getInstance(), getFileOrCreateNew(SETTINGS_XML_FILE));

        } catch (JAXBException e) {
            LOG.log(Level.WARNING, "Couldn't save settings", e);
        }
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

    public static File getNewEstabFile() {
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
        return FileSystems.getDefault().getPath(System.getProperty("user.dir"), SETTINGS_XML_FILE);
    }

    public static File installDataset(String datasetName, File targetFolder) {
        LOG.log(Level.INFO, "Installing " + datasetName + " dataset in folder: " + targetFolder.getName());
        File targetFile = new File(targetFolder.getPath(), datasetName + "Estab.xml");
        if (targetFile != null && targetFile.exists()) {
            LOG.log(Level.SEVERE, "Aborting installation. " +datasetName + " dataset already exists in folder: " + targetFolder.getName());
            targetFile = null;
        } else {
            // Installing dataset from resources to file
            FileIO.copy(FileIO.class.getResourceAsStream(FileIO.DATASETS_FOLDER + "/" + targetFile.getName()), targetFile.getAbsoluteFile().toPath());

            // Installing all dataset images included in the index
            // Preparing the image folder on disk
            File targetImageFolder = new File(targetFolder, datasetName + "image");
            targetImageFolder.mkdirs();

            String datasetResourceImageFolder = FileIO.IMAGES_FOLDER + "/" + datasetName;
            String datasetResourceImageIndex = datasetResourceImageFolder + "/" + datasetName + "index";
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
     * <p>Dataset name: COTA</p>
     * <p>Dataset file: COTAEstab.xml</p>
     * <p>Dataset image folder: COTAimage</p>
     * @param datasetFile
     * @param imageFileName
     * @return
     */
    public static Image getDatasetImage(File datasetFile, String imageFileName) {
        String datasetName = datasetFile.getName().split("Estab.xml")[0];
        File datasetImageFolder = new File(datasetFile.getParent(), datasetName + "image");
        File datasetPicture = new File(datasetImageFolder, imageFileName);
        Image picture = null;
        try {
            picture = new Image(datasetPicture.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return picture;
    }
}
