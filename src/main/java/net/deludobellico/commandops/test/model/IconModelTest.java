package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.ForceSize;
import net.deludobellico.commandops.estabeditor.data.jaxb.PictureSymbol;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;
import net.deludobellico.commandops.estabeditor.model.IconModel;
import net.deludobellico.commandops.estabeditor.model.RGBColorModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IconModelTest {

    IconModel ours;
    RGBColorModel backgroundColor = new RGBColorModel(255, 255, 255);
    RGBColorModel backgroundDarkColor = new RGBColorModel(255, 255, 255);
    RGBColorModel backgroundLightColor = new RGBColorModel(255, 255, 255);
    RGBColorModel designationColor = new RGBColorModel(0, 0, 0);
    ForceSize forceSize = ForceSize.ARMY;
    PictureSymbol pictureSymbol = PictureSymbol.AMMO;
    SymbolColor symbolColor = SymbolColor.BLACK;
    boolean hq = false;
    int militarySymbol = 10;

    @Before
    public void setUp() throws Exception {
        ours = new IconModel();
        ours.setBackgroundColor(backgroundColor);
        ours.setBackgroundDarkColor(backgroundDarkColor);
        ours.setBackgroundLightColor(backgroundLightColor);
        ours.setDesignationColor(designationColor);
        ours.setForceSizeIcon(forceSize);
        ours.setIsHq(hq);
        ours.setMilitarySymbol(militarySymbol);
        ours.setPictureSymbol(pictureSymbol);
        ours.setSymbolColor(symbolColor);
    }

    @Test
    public void testEquals() throws Exception {
        IconModel other = new IconModel();
        other.setBackgroundColor(backgroundColor);
        other.setBackgroundDarkColor(backgroundDarkColor);
        other.setBackgroundLightColor(backgroundLightColor);
        other.setDesignationColor(designationColor);
        other.setForceSizeIcon(forceSize);
        other.setIsHq(hq);
        other.setMilitarySymbol(militarySymbol);
        other.setPictureSymbol(pictureSymbol);
        other.setSymbolColor(symbolColor);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        IconModel other = new IconModel();
        other.setBackgroundColor(backgroundColor);
        other.setBackgroundDarkColor(backgroundDarkColor);
        other.setBackgroundLightColor(backgroundLightColor);
        other.setDesignationColor(designationColor);
        other.setForceSizeIcon(forceSize);
        other.setIsHq(hq);
        other.setMilitarySymbol(militarySymbol);
        other.setPictureSymbol(pictureSymbol);
        other.setSymbolColor(symbolColor);
        assertEquals(ours.hashCode(), other.hashCode());
    }


    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        IconModel other = new IconModel();
        other.setBackgroundColor(null);
        other.setBackgroundDarkColor(null);
        other.setBackgroundLightColor(null);
        other.setDesignationColor(null);
        other.setForceSizeIcon(null);
        other.setIsHq(hq);
        other.setMilitarySymbol(militarySymbol);
        other.setPictureSymbol(null);
        other.setSymbolColor(null);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        IconModel other = new IconModel();
        other.setBackgroundColor(null);
        other.setBackgroundDarkColor(null);
        other.setBackgroundLightColor(null);
        other.setDesignationColor(null);
        other.setForceSizeIcon(null);
        other.setIsHq(hq);
        other.setMilitarySymbol(militarySymbol);
        other.setPictureSymbol(null);
        other.setSymbolColor(null);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}