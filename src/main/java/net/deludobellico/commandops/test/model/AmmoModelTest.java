package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmmoModelTest {

    private AmmoModel ours;
    private int id = 10;
    private String name = "Ammo Model Test";
    private String description = "Ammo Model Desc";
    private int minOrderQty = 1;
    private int minOrderWeight = 2;
    private Flag[] flags = new Flag[]{Flag.COPY, Flag.NEW};

    @Before
    public void setUp() throws Exception {
        ours = new AmmoModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag(flags);
    }

    @Test
    public void testEquals() throws Exception {
        AmmoModel other = new AmmoModel();
        other.setId(id);
        //other.setId(id+1);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCode() throws Exception {
        AmmoModel other = new AmmoModel();
        //other.setId(id+1);
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }
}