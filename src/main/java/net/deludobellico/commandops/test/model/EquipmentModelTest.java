package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.EquipmentModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquipmentModelTest {
    EquipmentModel ours;
    int id = 10;
    String name = "EquipmentModel Test";
    int qty = 5;

    @Before
    public void setUp() throws Exception {
        ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(name);
        ours.setQty(qty);
    }

    @Test
    public void testEquals() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}