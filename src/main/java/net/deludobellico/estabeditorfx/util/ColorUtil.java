package net.deludobellico.estabeditorfx.util;

import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.RGBColor;

/**
 * Color utilities
 *
 * @author Mario
 */
public class ColorUtil {

    public static RGBColor getRGBColor(Color color) {
        RGBColor rgbColor = new RGBColor();
        rgbColor.setRed((int) (color.getRed() * 255));
        rgbColor.setGreen((int) (color.getGreen() * 255));
        rgbColor.setBlue((int) (color.getBlue() * 255));
        return rgbColor;
    }

    public static Color getColor(RGBColor rgbColor) {
        return Color.color(rgbColor.getRed() / 255.0, rgbColor.getGreen() / 255.0, rgbColor.getBlue() / 255.0);
    }

    public static Color getColor(int r, int g, int b) {
        return Color.color(r / 255.0, g / 255.0, b / 255.0);
    }

}
