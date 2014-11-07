package net.deludobellico.commandops.test.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.NationModel;
import net.deludobellico.commandops.estabeditor.model.SideModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SideModelTest {
    SideModel ours;
    int id = 10;
    String name = "SideModel Test";
    String description = "SideModel Desc";
    int largeInsignia = 2;
    int smallInsignia = 3;
    double basicsConsumptionRate = 0.3;
    int defaultEnemyAperFp = 2;
    int defaultEnemyAarmFp = 5;
    List<NationModel> nation = FXCollections.observableArrayList();
    Flag[] flags = new Flag[]{Flag.COPY, Flag.REMOVE};

    @Before
    public void setUp() throws Exception {
        ours = new SideModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBasicsConsumptionRate(basicsConsumptionRate);
        ours.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        ours.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.add(new NationModel());
        ours.getNation().addAll(nation);
        ours.setFlag(flags);
    }

    @Test
    public void testEquals() throws Exception {
        SideModel other = new SideModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        SideModel other = new SideModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(flags);
        assertEquals(ours.hashCode(), other.hashCode());
    }
    @Test
    public void testEqualsDifferentIDs() throws Exception {
        SideModel other = new SideModel();
        other.setId(id+2);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        SideModel other = new SideModel();
        other.setId(id+3);
        other.setName(name);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        SideModel other = new SideModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(null);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        SideModel other = new SideModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setBasicsConsumptionRate(basicsConsumptionRate);
        other.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        other.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        other.getNation().addAll(nation);
        other.setFlag(null);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}