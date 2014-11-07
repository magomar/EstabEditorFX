package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.AmmoQtyModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AmmoQtyModelTest {

    AmmoQtyModel ours;
    private int id = 10;
    private String name = "Ammo Qty Test";
    private int qty = 10;

    @Before
    public void setUp() throws Exception {
        ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);
    }

    @Test
    public void testEquals() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}