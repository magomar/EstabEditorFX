package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ImageModelTest {
    ImageModel ours;
    String name = "ImageModel Test";
    String fileId = "ImageModel FileId";
    Flag[] flags = new Flag[]{Flag.USER, Flag.COPY};

    @Before
    public void setUp() throws Exception {
        ours = new ImageModel();
        ours.setName(name);
        ours.setFileId(fileId);
        ours.setFlag(flags);
    }

    @Test
    public void testEquals() throws Exception {
        ImageModel other = new ImageModel();
        other.setName(name);
        other.setFileId(fileId);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ImageModel other = new ImageModel();
        other.setName(name);
        other.setFileId(fileId);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
        assertEquals(ours.hashCode(), other.hashCode());
    }
    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        ImageModel other = new ImageModel();
        other.setName(null);
        other.setFileId(null);
        other.setFlag(null);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        ImageModel other = new ImageModel();
        other.setName(null);
        other.setFileId(null);
        other.setFlag(null);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}