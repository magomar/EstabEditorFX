package net.deludobellico.estabeditorfx.model;

import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.ForceSize;
import net.deludobellico.estabeditorfx.data.jaxb.PictureSymbol;
import net.deludobellico.estabeditorfx.data.jaxb.SymbolColor;
import net.deludobellico.estabeditorfx.util.ColorUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IconModelTest {


    private final Color backgroundColor = ColorUtil.getColor(255, 255, 255);
    private final Color backgroundDarkColor = ColorUtil.getColor(255, 255, 255);
    private final Color backgroundLightColor = ColorUtil.getColor(255, 255, 255);
    private final Color designationColor = ColorUtil.getColor(0, 0, 0);
    private final ForceSize forceSize = ForceSize.ARMY;
    private final PictureSymbol pictureSymbol = PictureSymbol.AMMO;
    private final SymbolColor symbolColor = SymbolColor.BLACK;
    private final boolean hq = false;
    private final IconModel.MilitarySymbol militarySymbol = IconModel.MilitarySymbol.values()[10];

    @Test
    public void testEquals() throws Exception {
        IconModel ours = new IconModel();
        ours.setBackgroundColor(backgroundColor);
        ours.setBackgroundDarkColor(backgroundDarkColor);
        ours.setBackgroundLightColor(backgroundLightColor);
        ours.setDesignationColor(designationColor);
        ours.setForceSizeIcon(forceSize);
        ours.setIsHq(hq);
        ours.setMilitarySymbol(militarySymbol);
        ours.setPictureSymbol(pictureSymbol);
        ours.setSymbolColor(symbolColor);

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
        IconModel ours = new IconModel();
        ours.setBackgroundColor(backgroundColor);
        ours.setBackgroundDarkColor(backgroundDarkColor);
        ours.setBackgroundLightColor(backgroundLightColor);
        ours.setDesignationColor(designationColor);
        ours.setForceSizeIcon(forceSize);
        ours.setIsHq(hq);
        ours.setMilitarySymbol(militarySymbol);
        ours.setPictureSymbol(pictureSymbol);
        ours.setSymbolColor(symbolColor);

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
        IconModel ours = new IconModel();
        ours.setBackgroundColor(null);
        ours.setBackgroundDarkColor(null);
        ours.setBackgroundLightColor(null);
        ours.setDesignationColor(null);
        ours.setForceSizeIcon(null);
        ours.setIsHq(hq);
        ours.setMilitarySymbol(militarySymbol);
        ours.setPictureSymbol(null);
        ours.setSymbolColor(null);

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
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        IconModel ours = new IconModel();
        ours.setBackgroundColor(null);
        ours.setBackgroundDarkColor(null);
        ours.setBackgroundLightColor(null);
        ours.setDesignationColor(null);
        ours.setForceSizeIcon(null);
        ours.setIsHq(hq);
        ours.setMilitarySymbol(militarySymbol);
        ours.setPictureSymbol(null);
        ours.setSymbolColor(null);

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
        assertEquals(ours.hashCode(), other.hashCode());
    }
}