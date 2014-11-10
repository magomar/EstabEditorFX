package net.deludobellico.commandops.estabeditor.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;
import net.deludobellico.commandops.estabeditor.model.ForceModel;
import net.deludobellico.commandops.estabeditor.model.RGBColorModel;
import net.deludobellico.commandops.estabeditor.model.RankModel;
import net.deludobellico.commandops.estabeditor.model.ServiceModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceModelTest {

    private final Integer id = 10;
    private final String name = "ServiceModel Test";
    private final String description = "ServiceModel Desc";
    private final Integer largeInsignia = 5;
    private final Integer smallInsignia = 3;
    private final ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    private final RGBColorModel backgroundColor = new RGBColorModel(255, 255, 255);
    private final RGBColorModel backgroundDarkColor = new RGBColorModel(255, 255, 255);
    private final RGBColorModel backgroundLightColor = new RGBColorModel(255, 255, 255);
    private final RGBColorModel designationColor = new RGBColorModel(255, 255, 255);
    private final SymbolColor symbolColor = SymbolColor.BLACK;
    private final ObservableList<ForceModel> force = FXCollections.observableArrayList();
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.NEW};


    @Test
    public void testEquals() throws Exception {
        ServiceModel ours = new ServiceModel();
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
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());

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
        ServiceModel ours = new ServiceModel();
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
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());

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

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        ServiceModel ours = new ServiceModel();
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
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());

        ServiceModel other = new ServiceModel();
        other.setId(id + 2);
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
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        ServiceModel ours = new ServiceModel();
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
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());

        ServiceModel other = new ServiceModel();
        other.setId(id + 6);
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
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        ServiceModel ours = new ServiceModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBackgroundLightColor(null);
        ours.setBackgroundColor(null);
        ours.setBackgroundDarkColor(null);
        ours.setDesignationColor(null);
        ours.setSymbolColor(null);
        ours.setFlag((Flag[]) null);
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());

        ServiceModel other = new ServiceModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBackgroundLightColor(null);
        other.setBackgroundColor(null);
        other.setBackgroundDarkColor(null);
        other.setDesignationColor(null);
        other.setSymbolColor(null);
        other.setFlag((Flag[]) null);
        rankList.clear();
        rankList.add(new RankModel());
        force.clear();
        force.add(new ForceModel());
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        ServiceModel ours = new ServiceModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBackgroundLightColor(null);
        ours.setBackgroundColor(null);
        ours.setBackgroundDarkColor(null);
        ours.setDesignationColor(null);
        ours.setSymbolColor(null);
        ours.setFlag((Flag[]) null);
        rankList.clear();
        force.clear();
        rankList.add(new RankModel());
        force.add(new ForceModel());


        ServiceModel other = new ServiceModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBackgroundLightColor(null);
        other.setBackgroundColor(null);
        other.setBackgroundDarkColor(null);
        other.setDesignationColor(null);
        other.setSymbolColor(null);
        other.setFlag((Flag[]) null);
        rankList.clear();
        rankList.add(new RankModel());
        force.clear();
        force.add(new ForceModel());
        assertEquals(ours.hashCode(), other.hashCode());
    }
}