package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.model.AmmoQtyModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmmoQtyModelTest {

    private final int id = 10;
    private final String name = "Ammo Qty Test";
    private final int qty = 10;

    @Test
    public void testEquals() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(name);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(name);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id + 1);
        other.setName(name);
        other.setQty(qty);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(null);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        AmmoQtyModel ours = new AmmoQtyModel();
        ours.setId(id);
        ours.setName(null);
        ours.setQty(qty);

        AmmoQtyModel other = new AmmoQtyModel();
        other.setId(id);
        other.setName(null);
        other.setQty(qty);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}