package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.model.EquipmentModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquipmentModelTest {

    private final int id = 10;
    private final String name = "EquipmentModel Test";
    private final int qty = 5;


    @Test
    public void testEquals() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(name);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(name);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(name);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(name);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(null);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        EquipmentModel ours = new EquipmentModel();
        ours.setEquipmentObjectId(id);
        ours.setName(null);
        ours.setQty(qty);

        EquipmentModel other = new EquipmentModel();
        other.setEquipmentObjectId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}