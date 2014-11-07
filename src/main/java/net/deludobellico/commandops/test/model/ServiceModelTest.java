package net.deludobellico.commandops.test.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;
import net.deludobellico.commandops.estabeditor.model.ForceModel;
import net.deludobellico.commandops.estabeditor.model.RGBColorModel;
import net.deludobellico.commandops.estabeditor.model.RankModel;
import net.deludobellico.commandops.estabeditor.model.ServiceModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceModelTest {
    ServiceModel ours;
    Integer id = 10;
    String name = "ServiceModel Test";
    String description = "ServiceModel Desc";
    Integer largeInsignia = 5;
    Integer smallInsignia = 3;
    ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    RGBColorModel backgroundColor = new RGBColorModel(255, 255, 255);
    RGBColorModel backgroundDarkColor = new RGBColorModel(255, 255, 255);
    RGBColorModel backgroundLightColor = new RGBColorModel(255, 255, 255);
    RGBColorModel designationColor = new RGBColorModel(255, 255, 255);
    SymbolColor symbolColor = SymbolColor.BLACK;
    ObservableList<ForceModel> force = FXCollections.observableArrayList();
    Flag[] flags = new Flag[]{Flag.COPY, Flag.NEW};

    @Before
    public void setUp() throws Exception {
        ours = new ServiceModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBackgroundLightColor(backgroundLightColor);
        ours.setBackgroundColor(backgroundColor);
        ours.setBackgroundDarkColor(backgroundDarkColor);
        ours.setDesignationColor(designationColor);
        ours.setSymbolColor(symbolColor);
        ours.setFlag(flags);
        rankList.add(new RankModel());
        force.add(new ForceModel());
    }

    @Test
    public void testEquals() throws Exception {
        ServiceModel other = new ServiceModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBackgroundLightColor(backgroundLightColor);
        other.setBackgroundColor(backgroundColor);
        other.setBackgroundDarkColor(backgroundDarkColor);
        other.setDesignationColor(designationColor);
        other.setSymbolColor(symbolColor);
        other.setFlag(flags);
        rankList.clear();
        rankList.add(new RankModel());
        force.clear();
        force.add(new ForceModel());
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ServiceModel other = new ServiceModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBackgroundLightColor(backgroundLightColor);
        other.setBackgroundColor(backgroundColor);
        other.setBackgroundDarkColor(backgroundDarkColor);
        other.setDesignationColor(designationColor);
        other.setSymbolColor(symbolColor);
        other.setFlag(flags);
        rankList.clear();
        rankList.add(new RankModel());
        force.clear();
        force.add(new ForceModel());
        assertEquals(ours.hashCode(), other.hashCode());
    }
}