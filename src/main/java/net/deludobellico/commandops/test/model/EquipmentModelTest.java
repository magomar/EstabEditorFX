package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.EquipmentModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id+1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id+1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(null);
        other.setQty(qty);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}