package net.deludobellico.stabeditor.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
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
    private static final Logger LOG = Logger.getLogger(FileIO.class.getName());
    private static final String JAXB_CONTEXT_PATH = "net.deludobellico.stabeditor.data.jaxb";
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

}
