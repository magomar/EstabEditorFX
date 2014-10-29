package net.deludobellico.stabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import net.deludobellico.stabeditor.data.jaxb.RGBColor;

/**
 * Created by Mario on 29/10/2014.
 */
public class RGBColorModel implements PojoJFXModel<RGBColor> {
    private final IntegerProperty red = new SimpleIntegerProperty();
    private final IntegerProperty green = new SimpleIntegerProperty();
    private final IntegerProperty blue = new SimpleIntegerProperty();

    // TODO getters & setters, but first do the pojo methods

    @Override
    public RGBColor getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(RGBColor pojo) {
        // TODO
    }
}
