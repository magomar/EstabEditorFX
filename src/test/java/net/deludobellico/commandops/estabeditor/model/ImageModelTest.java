package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageModelTest {

    private final int id = 10;
    private final String name = "ImageModel Test";
    private final String fileId = "ImageModel FileId";
    private final Flag[] flags = new Flag[]{Flag.USER, Flag.COPY};

    @Test
    public void testCompareTo() throws Exception {
        ImageModel ours = new ImageModel();
        ours.setName(name);
        ours.setFileId(fileId);
        ours.setFlag(flags);

        ImageModel other = new ImageModel();
        other.setName(name);
        other.setFileId(fileId);
        other.setFlag(flags);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {

        ImageModel ours = new ImageModel();
        ours.setName(null);
        ours.setFileId(null);
        ours.setFlag((Flag[]) null);

        ImageModel other = new ImageModel();
        other.setName(null);
        other.setFileId(null);
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.compareTo(other));
    }
    
    @Test
    public void testSameIdEqualsTrue() throws Exception {
        ImageModel ours = new ImageModel();
        ours.setId(id);

        ImageModel other = new ImageModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        ImageModel ours = new ImageModel();
        ours.setId(id);

        ImageModel other = new ImageModel();
        other.setId(id + 1);
        assertEquals(false, other.equals(ours));
    }
}