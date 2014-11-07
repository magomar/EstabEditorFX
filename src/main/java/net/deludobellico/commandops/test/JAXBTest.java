package net.deludobellico.commandops.test;

import net.deludobellico.commandops.estabeditor.data.jaxb.EstabData;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.JAXBFactory;
import net.deludobellico.commandops.estabeditor.util.Stopwatch;

import javax.xml.bind.JAXBException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Heine on 11/6/2014.
 */
public class JAXBTest {

    public static void marshallTest() {
        Stopwatch sw = new Stopwatch();

        ClassLoader cl = JAXBTest.class.getClassLoader();
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL u1 = cl.getResource(FileIO.DATASETS_FOLDER + "/BFTBEstab.xml");
        JAXBFactory jaxb = null;
        try {
            jaxb = new JAXBFactory("net.deludobellico.commandops.estabeditor.data.jaxb");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Path resPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/");
        Path sourcePath = FileSystems.getDefault().getPath(resPath.toString(), "datasets/BFTBEstab.xml");
        Path targetPathJSON = FileSystems.getDefault().getPath(resPath.toString(), "datasets/Jarama1937Estab.json");
        Path targetPathXML = FileSystems.getDefault().getPath(resPath.toString(), "datasets/Jarama1937Estab.xml");
        sw.start();
        EstabData data = (EstabData) FileIO.loadEstab(sourcePath.toFile());
        sw.stop();
        System.out.println("Unmarshaling XML completed -->" + sw);
        sw.start();
        JAXBFactory.marshallJson(data, targetPathJSON.toFile());
        sw.stop();
        System.out.println("Marshalling JSON completed -->" + sw);
        sw.start();
        jaxb.marshallXML(data, targetPathXML.toFile());
        sw.stop();
        System.out.println("Marshalling XML  completed -->" + sw);
    }
}