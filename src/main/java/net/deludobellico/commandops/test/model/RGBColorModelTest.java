package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.RGBColorModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RGBColorModelTest {

    RGBColorModel ours;
    int red = 255;
    int blue = 1;
    int green = 3;

    @Before
    public void setUp() throws Exception {
        ours = new RGBColorModel(red, blue, green);
    }

    @Test
    public void testEquals() throws Exception {
        RGBColorModel other = new RGBColorModel(red, blue, green);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        RGBColorModel other = new RGBColorModel(red, blue, green);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}