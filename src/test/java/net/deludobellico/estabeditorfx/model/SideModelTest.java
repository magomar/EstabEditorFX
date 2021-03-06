package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.model.NationModel;
import net.deludobellico.estabeditorfx.model.SideModel;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SideModelTest {
    private final int id = 10;
    private final String name = "SideModel Test";
    private final String description = "SideModel Desc";
    private final int largeInsignia = 2;
    private final int smallInsignia = 3;
    private final double basicsConsumptionRate = 0.3;
    private final int defaultEnemyAperFp = 2;
    private final int defaultEnemyAarmFp = 5;
    private final List<NationModel> nation = FXCollections.observableArrayList();
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.REMOVE};


    @Test
public void testCompareTo() throws Exception {
        SideModel ours = new SideModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBasicsConsumptionRate(basicsConsumptionRate);
        ours.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        ours.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        ours.getNation().addAll(nation);
        ours.setFlag(flags);

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
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
        SideModel ours = new SideModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBasicsConsumptionRate(basicsConsumptionRate);
        ours.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        ours.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        ours.getNation().addAll(nation);
        ours.setFlag(flags);

        SideModel other = new SideModel();
        other.setId(id + 2);
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
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        SideModel ours = new SideModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setBasicsConsumptionRate(basicsConsumptionRate);
        ours.setDefaultEnemyAarmFp(defaultEnemyAarmFp);
        ours.setDefaultEnemyAperFp(defaultEnemyAperFp);
        nation.clear();
        nation.add(new NationModel());
        ours.getNation().addAll(nation);
        ours.setFlag((Flag[]) null);

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
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        SideModel ours = new SideModel();
        ours.setId(id);

        SideModel other = new SideModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        SideModel ours = new SideModel();
        ours.setId(id);

        SideModel other = new SideModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}