package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.RangeItemModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeItemModelTest {
    RangeItemModel ours;
    int range = 10;
    double accuracy = 20.0;
    double armourPenetrationProperty = 30.0;

    @Before
    public void setUp() throws Exception {
        ours = new RangeItemModel();
        ours.setAccuracy(accuracy);
        ours.setArmourPenetration(armourPenetrationProperty);
        ours.setRange(range);
    }

    @Test
    public void testEquals() throws Exception {
        RangeItemModel other = new RangeItemModel();
        other.setAccuracy(accuracy);
        other.setArmourPenetration(armourPenetrationProperty);
        other.setRange(range);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        RangeItemModel other = new RangeItemModel();
        other.setAccuracy(accuracy);
        other.setArmourPenetration(armourPenetrationProperty);
        other.setRange(range);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}