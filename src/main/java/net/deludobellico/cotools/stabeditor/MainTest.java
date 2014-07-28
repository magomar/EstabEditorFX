package net.deludobellico.cotools.stabeditor;

import net.deludobellico.cotools.data.jaxb.EstabData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * Created by Mario on 24/07/2014.
 */
public class MainTest {
    private static final Logger LOG = Logger.getLogger(MainTest.class.getName());
    private static final String JAXB_CONTEXT_PATH = "net.deludobellico.cotools.data.jaxb";
    private static final String JAXB_NAMESPACE = "net/deludobellico/cotools";
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

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();


        ClassLoader cl = MainTest.class.getClassLoader();
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL u1 = cl.getResource("./examples/BFTBEstab.xml");

        Path resPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/");
        Path sourcePath = FileSystems.getDefault().getPath(resPath.toString(), "examples/BFTBEstab.xml");
        Path targetPathJSON = FileSystems.getDefault().getPath(resPath.toString(), "examples/Jarama1937Estab.json");
        Path targetPathXML = FileSystems.getDefault().getPath(resPath.toString(), "examples/Jarama1937Estab.xml");
        sw.start();
        EstabData data = (EstabData) FileIO.unmarshallXML(sourcePath.toFile(), UNMARSHALLER);
        sw.stop();
        System.out.println("Unmarshaling XML completed -->" + sw);
        sw.start();
        FileIO.marshallJson(data,targetPathJSON.toFile());
        sw.stop();
        System.out.println("Marshalling JSON completed -->" + sw);
        sw.start();
        FileIO.marshallXML(data,targetPathXML.toFile(), MARSHALLER);
        sw.stop();
        System.out.println("Marshalling XML  completed -->" + sw);
    }
}
