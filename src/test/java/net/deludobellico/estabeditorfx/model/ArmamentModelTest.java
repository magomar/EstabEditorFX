package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.model.ArmamentModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmamentModelTest {
    private final int id = 10;
    private final String name = "Armament Model Test";
    private final int qty = 5;


    @Test
    public void testEquals() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(null);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        ArmamentModel ours = new ArmamentModel();
        ours.setId(id);
        ours.setName(null);
        ours.setQty(qty);

        ArmamentModel other = new ArmamentModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}