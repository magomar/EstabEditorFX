package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.AmmoLoadModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AmmoLoadModelTest {
    AmmoLoadModel ours;
    private int id = 10;
    private String name = "Ammo Load Test";
    private int load = 1;

    @Before
    public void setUp() throws Exception {
        ours = new AmmoLoadModel();
        ours.setId(id);
        ours.setName(name);
        ours.setLoad(load);

    }

    @Test
    public void testEquals() throws Exception {
        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id);
        other.setName(name);
        other.setLoad(load);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id);
        other.setName(name);
        other.setLoad(load);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id+1);
        other.setName(name);
        other.setLoad(load);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id+1);
        other.setName(name);
        other.setLoad(load);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {

        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id);
        other.setName(null);
        other.setLoad(load);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        AmmoLoadModel other = new AmmoLoadModel();
        other.setId(id);
        other.setName(null);
        other.setLoad(load);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}