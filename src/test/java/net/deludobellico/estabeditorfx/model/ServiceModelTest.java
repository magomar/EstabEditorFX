package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.SymbolColor;
import net.deludobellico.estabeditorfx.model.ForceModel;
import net.deludobellico.estabeditorfx.model.RGBColorModel;
import net.deludobellico.estabeditorfx.model.RankModel;
import net.deludobellico.estabeditorfx.model.ServiceModel;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceModelTest {

    private final Integer id = 10;
    private final String name = "ServiceModel Test";
    private final String description = "ServiceModel Desc";
    private final Integer largeInsignia = 5;
    private final Integer smallInsignia = 3;
    private final ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    private final Color backgroundColor = Color.rgb(255, 255, 255);
    private final Color backgroundDarkColor = Color.rgb(255, 255, 255);
    private final Color backgroundLightColor = Color.rgb(255, 255, 255);
    private final Color designationColor = Color.rgb(255, 255, 255);
    private final SymbolColor symbolColor = SymbolColor.BLACK;
    private final ObservableList<ForceModel> force = FXCollections.observableArrayList();
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.NEW};


    @Test
    public void testCompareTo() throws Exception {
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
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
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
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
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
        assertEquals(true, ours.compareTo(other));
    }
    
    @Test
    public void testSameIdEqualsTrue() throws Exception {
        ServiceModel ours = new ServiceModel();
        ours.setId(id);

        ServiceModel other = new ServiceModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        ServiceModel ours = new ServiceModel();
        ours.setId(id);

        ServiceModel other = new ServiceModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}