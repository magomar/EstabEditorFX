package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import net.deludobellico.stabeditor.data.jaxb.ForceSize;
import net.deludobellico.stabeditor.data.jaxb.Icon;
import net.deludobellico.stabeditor.data.jaxb.PictureSymbol;
import net.deludobellico.stabeditor.data.jaxb.SymbolColor;

/**
 * Created by Mario on 29/10/2014.
 */
public class IconModel implements PojoJFXModel<Icon> {
    private final  ObjectProperty<RGBColorModel> backgroundColor = new SimpleObjectProperty<>();
    private final  ObjectProperty<RGBColorModel> backgroundDarkColor = new SimpleObjectProperty<>();
    private final  ObjectProperty<RGBColorModel> backgroundLightColor = new SimpleObjectProperty<>();
    private final  ObjectProperty<RGBColorModel> designationColor = new SimpleObjectProperty<>();
    private final  ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final  IntegerProperty militarySymbol = new SimpleIntegerProperty();
    private final  ObjectProperty<PictureSymbol> pictureSymbol = new SimpleObjectProperty<>();
    private final  ObjectProperty<ForceSize> forceSizeIcon = new SimpleObjectProperty<>();
    private final  BooleanProperty isHq = new SimpleBooleanProperty();

    // TODO getters & setters, but first do the pojo methods

    @Override
    public Icon getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(Icon pojo) {
        // TODO
    }
}
