package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.AmmoQtyModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}