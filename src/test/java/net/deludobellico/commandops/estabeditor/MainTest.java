package net.deludobellico.commandops.estabeditor;

import net.deludobellico.commandops.estabeditor.model.EstabModel;
import net.deludobellico.commandops.estabeditor.model.SideModel;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;
import net.deludobellico.commandops.estabeditor.util.LimitedList;
import net.deludobellico.commandops.estabeditor.util.Pair;
import net.deludobellico.commandops.estabeditor.util.Stopwatch;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by Mario on 24/07/2014.
 */
class MainTest {


    public static void main(String[] args) {
        //net.deludobellico.commandops.estabeditor.JAXBTest.marshallTest();
//        CollectionsTest.start();
        SideModel side = new SideModel();
        SideModel side2 = new SideModel();
        side.setId(5);
        side.setName("Side");
        side2.setId(8);
        side2.setName("Side2");

        Pair pair1 = new Pair(1, side);
        Pair pair2 = new Pair(1, side2);
        if (pair1.equals(pair2)) {
            System.out.println("they are equal");
        } else {
            System.out.println("not equal");
        }
    }

}
