package net.deludobellico.stabeditor.util;

import net.deludobellico.stabeditor.data.jaxb.EstabData;

import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * Created by Mario on 24/07/2014.
 */
public class MainTest {
    private static final Logger LOG = Logger.getLogger(MainTest.class.getName());


    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();


        ClassLoader cl = MainTest.class.getClassLoader();
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL u1 = cl.getResource("./datasets/BFTBEstab.xml");

        Path resPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/");
        Path sourcePath = FileSystems.getDefault().getPath(resPath.toString(), "datasets/BFTBEstab.xml");
        Path targetPathJSON = FileSystems.getDefault().getPath(resPath.toString(), "datasets/Jarama1937Estab.json");
        Path targetPathXML = FileSystems.getDefault().getPath(resPath.toString(), "datasets/Jarama1937Estab.xml");
        sw.start();
        EstabData data = (EstabData) FileIO.unmarshallXML(sourcePath.toFile(), FileIO.UNMARSHALLER);
        sw.stop();
        System.out.println("Unmarshaling XML completed -->" + sw);
        sw.start();
        FileIO.marshallJson(data,targetPathJSON.toFile());
        sw.stop();
        System.out.println("Marshalling JSON completed -->" + sw);
        sw.start();
        FileIO.marshallXML(data,targetPathXML.toFile(), FileIO.MARSHALLER);
        sw.stop();
        System.out.println("Marshalling XML  completed -->" + sw);
    }
}
