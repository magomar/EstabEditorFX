package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.model.RGBColorModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RGBColorModelTest {

    private RGBColorModel ours;
    private final int red = 255;
    private final int blue = 1;
    private final int green = 3;

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