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

    @Override
    public Icon getPojo() {
        Icon icon = new Icon();
        icon.setBackgroundColor(backgroundColor.get().getPojo());
        icon.setBackgroundDarkColor(backgroundDarkColor.get().getPojo());
        icon.setBackgroundLightColor(backgroundLightColor.get().getPojo());
        return icon;
    }

    @Override
    public void setPojo(Icon pojo) {
        RGBColorModel bColor = new RGBColorModel();
        bColor.setPojo(pojo.getBackgroundColor());
        backgroundColor.set(bColor);
        RGBColorModel bdColor = new RGBColorModel();
        bdColor.setPojo(pojo.getBackgroundDarkColor());
        backgroundDarkColor.set(bdColor);
        RGBColorModel blColor = new RGBColorModel();
        blColor.setPojo(pojo.getBackgroundLightColor());
        backgroundLightColor.set(blColor);
    }

    public RGBColorModel getBackgroundColor() {
        return backgroundColor.get();
    }

    public ObjectProperty<RGBColorModel> backgroundColorProperty() {
        return backgroundColor;
    }

    public void setBackgroundColor(RGBColorModel backgroundColor) {
        this.backgroundColor.set(backgroundColor);
    }

    public RGBColorModel getBackgroundDarkColor() {
        return backgroundDarkColor.get();
    }

    public ObjectProperty<RGBColorModel> backgroundDarkColorProperty() {
        return backgroundDarkColor;
    }

    public void setBackgroundDarkColor(RGBColorModel backgroundDarkColor) {
        this.backgroundDarkColor.set(backgroundDarkColor);
    }

    public RGBColorModel getBackgroundLightColor() {
        return backgroundLightColor.get();
    }

    public ObjectProperty<RGBColorModel> backgroundLightColorProperty() {
        return backgroundLightColor;
    }

    public void setBackgroundLightColor(RGBColorModel backgroundLightColor) {
        this.backgroundLightColor.set(backgroundLightColor);
    }

    public RGBColorModel getDesignationColor() {
        return designationColor.get();
    }

    public ObjectProperty<RGBColorModel> designationColorProperty() {
        return designationColor;
    }

    public void setDesignationColor(RGBColorModel designationColor) {
        this.designationColor.set(designationColor);
    }

    public SymbolColor getSymbolColor() {
        return symbolColor.get();
    }

    public ObjectProperty<SymbolColor> symbolColorProperty() {
        return symbolColor;
    }

    public void setSymbolColor(SymbolColor symbolColor) {
        this.symbolColor.set(symbolColor);
    }

    public int getMilitarySymbol() {
        return militarySymbol.get();
    }

    public IntegerProperty militarySymbolProperty() {
        return militarySymbol;
    }

    public void setMilitarySymbol(int militarySymbol) {
        this.militarySymbol.set(militarySymbol);
    }

    public PictureSymbol getPictureSymbol() {
        return pictureSymbol.get();
    }

    public ObjectProperty<PictureSymbol> pictureSymbolProperty() {
        return pictureSymbol;
    }

    public void setPictureSymbol(PictureSymbol pictureSymbol) {
        this.pictureSymbol.set(pictureSymbol);
    }

    public ForceSize getForceSizeIcon() {
        return forceSizeIcon.get();
    }

    public ObjectProperty<ForceSize> forceSizeIconProperty() {
        return forceSizeIcon;
    }

    public void setForceSizeIcon(ForceSize forceSizeIcon) {
        this.forceSizeIcon.set(forceSizeIcon);
    }

    public boolean getIsHq() {
        return isHq.get();
    }

    public BooleanProperty isHqProperty() {
        return isHq;
    }

    public void setIsHq(boolean isHq) {
        this.isHq.set(isHq);
    }
}
