package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.ArmamentModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArmamentModelTest {
    private ArmamentModel ours;
    private int id = 10;
    private String name = "Armament Model Test";
    private int qty = 5;

    @Before
    public void setUp() throws Exception {
        ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(name);
        ours.setQty(qty);
    }

    @Test
    public void testEquals() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id+1);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id+1);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(null);
        other.setQty(qty);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(null);
        other.setQty(qty);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}