package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmmoModelTest {

    private final int id = 10;
    private final String name = "Ammo Model Test";
    private final String description = "Ammo Model Desc";
    private final int minOrderQty = 1;
    private final int minOrderWeight = 2;
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.NEW};

    @Test
    public void testEquals() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag(flags);

        AmmoModel other = new AmmoModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCode() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag(flags);

        AmmoModel other = new AmmoModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag(flags);

        AmmoModel other = new AmmoModel();
        other.setId(id + 1);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag(flags);

        AmmoModel other = new AmmoModel();
        other.setId(id + 1);
        other.setName(name);
        other.setDescription(description);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag((Flag[]) null);

        AmmoModel other = new AmmoModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        AmmoModel ours = new AmmoModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setMinOrderQty(minOrderQty);
        ours.setMinOrderWeight(minOrderWeight);
        ours.setFlag((Flag[]) null);

        AmmoModel other = new AmmoModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setMinOrderQty(minOrderQty);
        other.setMinOrderWeight(minOrderWeight);
        other.setFlag((Flag[]) null);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}