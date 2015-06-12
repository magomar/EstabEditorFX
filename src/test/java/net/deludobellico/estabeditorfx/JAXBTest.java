package net.deludobellico.estabeditorfx;

import net.deludobellico.estabeditorfx.data.jaxb.EstabData;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.JAXBFactory;
import net.deludobellico.estabeditorfx.util.Stopwatch;
import net.deludobellico.estabeditorfx.util.FileIO;

import javax.xml.bind.JAXBException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Heine on 11/6/2014.
 */
class JAXBTest {

    public static void marshallTest() {
        Stopwatch sw = new Stopwatch();

        ClassLoader cl = JAXBTest.class.getClassLoader();
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        URL u1 = cl.getResource(FileIO.DATASETS_FOLDER + "/BFTBEstab.xml");
        JAXBFactory jaxb = null;
        try {
            jaxb = new JAXBFactory("net.deludobellico.estabeditorfx.data.jaxb");
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
//        sw.start();
//        JAXBFactory.marshallJson(data, targetPathJSON.toFile());
//        sw.stop();
//        System.out.println("Marshalling JSON completed -->" + sw);
        sw.start();
        assert jaxb != null;
        jaxb.marshallXML(data, targetPathXML.toFile());
        sw.stop();
        System.out.println("Marshalling XML  completed -->" + sw);
    }
}
