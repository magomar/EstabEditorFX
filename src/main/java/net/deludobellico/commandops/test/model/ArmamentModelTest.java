package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.ArmamentModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmamentModelTest {
    private int id = 10;
    private String name = "Armament Model Test";
    private int qty = 5;


    @Test
    public void testEquals() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id + 1);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id + 1);
        other.setEquipmentName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(null);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(null);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setEquipmentObjectId(id);
        ours.setEquipmentName(null);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setEquipmentObjectId(id);
        other.setEquipmentName(null);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}