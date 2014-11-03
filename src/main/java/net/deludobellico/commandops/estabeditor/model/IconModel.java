package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import net.deludobellico.commandops.estabeditor.data.jaxb.ForceSize;
import net.deludobellico.commandops.estabeditor.data.jaxb.Icon;
import net.deludobellico.commandops.estabeditor.data.jaxb.PictureSymbol;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;

/**
 * Created by Mario on 29/10/2014.
 */
public class IconModel implements PojoJFXModel<Icon> {
    private final ObjectProperty<RGBColorModel> backgroundColor = new SimpleObjectProperty<>();
    private final ObjectProperty<RGBColorModel> backgroundDarkColor = new SimpleObjectProperty<>();
    private final ObjectProperty<RGBColorModel> backgroundLightColor = new SimpleObjectProperty<>();
    private final ObjectProperty<RGBColorModel> designationColor = new SimpleObjectProperty<>();
    private final ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final IntegerProperty militarySymbol = new SimpleIntegerProperty();
    private final ObjectProperty<PictureSymbol> pictureSymbol = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSize> forceSizeIcon = new SimpleObjectProperty<>();
    private final BooleanProperty isHq = new SimpleBooleanProperty();

    public IconModel(Icon pojo) {
        setPojo(pojo);
    }

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
        backgroundColor.set(new RGBColorModel(pojo.getBackgroundColor()));
        backgroundDarkColor.set(new RGBColorModel(pojo.getBackgroundDarkColor()));
        backgroundLightColor.set(new RGBColorModel(pojo.getBackgroundLightColor()));
    }

    public RGBColorModel getBackgroundColor() {
        return backgroundColor.get();
    }

    public void setBackgroundColor(RGBColorModel backgroundColor) {
        this.backgroundColor.set(backgroundColor);
    }

    public ObjectProperty<RGBColorModel> backgroundColorProperty() {
        return backgroundColor;
    }

    public RGBColorModel getBackgroundDarkColor() {
        return backgroundDarkColor.get();
    }

    public void setBackgroundDarkColor(RGBColorModel backgroundDarkColor) {
        this.backgroundDarkColor.set(backgroundDarkColor);
    }

    public ObjectProperty<RGBColorModel> backgroundDarkColorProperty() {
        return backgroundDarkColor;
    }

    public RGBColorModel getBackgroundLightColor() {
        return backgroundLightColor.get();
    }

    public void setBackgroundLightColor(RGBColorModel backgroundLightColor) {
        this.backgroundLightColor.set(backgroundLightColor);
    }

    public ObjectProperty<RGBColorModel> backgroundLightColorProperty() {
        return backgroundLightColor;
    }

    public RGBColorModel getDesignationColor() {
        return designationColor.get();
    }

    public void setDesignationColor(RGBColorModel designationColor) {
        this.designationColor.set(designationColor);
    }

    public ObjectProperty<RGBColorModel> designationColorProperty() {
        return designationColor;
    }

    public SymbolColor getSymbolColor() {
        return symbolColor.get();
    }

    public void setSymbolColor(SymbolColor symbolColor) {
        this.symbolColor.set(symbolColor);
    }

    public ObjectProperty<SymbolColor> symbolColorProperty() {
        return symbolColor;
    }

    public int getMilitarySymbol() {
        return militarySymbol.get();
    }

    public void setMilitarySymbol(int militarySymbol) {
        this.militarySymbol.set(militarySymbol);
    }

    public IntegerProperty militarySymbolProperty() {
        return militarySymbol;
    }

    public PictureSymbol getPictureSymbol() {
        return pictureSymbol.get();
    }

    public void setPictureSymbol(PictureSymbol pictureSymbol) {
        this.pictureSymbol.set(pictureSymbol);
    }

    public ObjectProperty<PictureSymbol> pictureSymbolProperty() {
        return pictureSymbol;
    }

    public ForceSize getForceSizeIcon() {
        return forceSizeIcon.get();
    }

    public void setForceSizeIcon(ForceSize forceSizeIcon) {
        this.forceSizeIcon.set(forceSizeIcon);
    }

    public ObjectProperty<ForceSize> forceSizeIconProperty() {
        return forceSizeIcon;
    }

    public boolean getIsHq() {
        return isHq.get();
    }

    public void setIsHq(boolean isHq) {
        this.isHq.set(isHq);
    }

    public BooleanProperty isHqProperty() {
        return isHq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IconModel)) return false;

        IconModel iconModel = (IconModel) o;

        if (backgroundColor != null ? !backgroundColor.equals(iconModel.backgroundColor) : iconModel.backgroundColor != null)
            return false;
        if (backgroundDarkColor != null ? !backgroundDarkColor.equals(iconModel.backgroundDarkColor) : iconModel.backgroundDarkColor != null)
            return false;
        if (backgroundLightColor != null ? !backgroundLightColor.equals(iconModel.backgroundLightColor) : iconModel.backgroundLightColor != null)
            return false;
        if (designationColor != null ? !designationColor.equals(iconModel.designationColor) : iconModel.designationColor != null)
            return false;
        if (forceSizeIcon != null ? !forceSizeIcon.equals(iconModel.forceSizeIcon) : iconModel.forceSizeIcon != null)
            return false;
        if (isHq != null ? !isHq.equals(iconModel.isHq) : iconModel.isHq != null) return false;
        if (militarySymbol != null ? !militarySymbol.equals(iconModel.militarySymbol) : iconModel.militarySymbol != null)
            return false;
        if (pictureSymbol != null ? !pictureSymbol.equals(iconModel.pictureSymbol) : iconModel.pictureSymbol != null)
            return false;
        if (symbolColor != null ? !symbolColor.equals(iconModel.symbolColor) : iconModel.symbolColor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = backgroundColor != null ? backgroundColor.hashCode() : 0;
        result = 31 * result + (backgroundDarkColor != null ? backgroundDarkColor.hashCode() : 0);
        result = 31 * result + (backgroundLightColor != null ? backgroundLightColor.hashCode() : 0);
        result = 31 * result + (designationColor != null ? designationColor.hashCode() : 0);
        result = 31 * result + (symbolColor != null ? symbolColor.hashCode() : 0);
        result = 31 * result + (militarySymbol != null ? militarySymbol.hashCode() : 0);
        result = 31 * result + (pictureSymbol != null ? pictureSymbol.hashCode() : 0);
        result = 31 * result + (forceSizeIcon != null ? forceSizeIcon.hashCode() : 0);
        result = 31 * result + (isHq != null ? isHq.hashCode() : 0);
        return result;
    }
}
