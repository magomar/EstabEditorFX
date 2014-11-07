package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.RadioModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioModelTest {


    int id = 10;
    String name = "RadioModel Test";
    Flag[] flags = new Flag[]{Flag.COPY, Flag.USER};


    @Test
    public void testEquals() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        RadioModel other = new RadioModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        RadioModel other = new RadioModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        RadioModel other = new RadioModel();
        other.setId(id + 2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        RadioModel other = new RadioModel();
        other.setId(id + 3);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(null);
        ours.setFlag(null);

        RadioModel other = new RadioModel();
        other.setId(id);
        other.setName(null);
        other.setFlag(null);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        RadioModel ours = new RadioModel();
        ours.setId(id);
        ours.setName(null);
        ours.setFlag(null);

        RadioModel other = new RadioModel();
        other.setId(id);
        other.setName(null);
        other.setFlag(null);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}