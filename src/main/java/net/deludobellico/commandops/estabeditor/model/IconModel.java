package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import net.deludobellico.commandops.estabeditor.data.jaxb.ForceSize;
import net.deludobellico.commandops.estabeditor.data.jaxb.Icon;
import net.deludobellico.commandops.estabeditor.data.jaxb.PictureSymbol;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;

/**
 * Model wrapper for the {@code Icon} class
 *
 * @author Mario
 * @author Heine
 */
public class IconModel implements PojoJFXModel<Icon> {
    private final ObjectProperty<Color> backgroundColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundDarkColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundLightColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> designationColor = new SimpleObjectProperty<>();
    private final ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final IntegerProperty militarySymbol = new SimpleIntegerProperty();
    private final ObjectProperty<PictureSymbol> pictureSymbol = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSize> forceSizeIcon = new SimpleObjectProperty<>();
    private final BooleanProperty isHq = new SimpleBooleanProperty();

    public IconModel(Icon pojo) {
        initialize(pojo);
    }

    public IconModel() {

    }

    @Override
    public Icon getPojo() {
        Icon icon = new Icon();
        icon.setBackgroundColor(RGBColorModel.getRGBColor(backgroundColor.get()));
        icon.setBackgroundDarkColor(RGBColorModel.getRGBColor(backgroundDarkColor.get()));
        icon.setBackgroundLightColor(RGBColorModel.getRGBColor(backgroundLightColor.get()));
        return icon;
    }

    @Override
    public void initialize(Icon pojo) {
        backgroundColor.set(RGBColorModel.getColor(pojo.getBackgroundColor()));
        backgroundDarkColor.set(RGBColorModel.getColor(pojo.getBackgroundDarkColor()));
        backgroundLightColor.set(RGBColorModel.getColor(pojo.getBackgroundLightColor()));
    }

    public Color getBackgroundColor() {
        return backgroundColor.get();
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor.set(backgroundColor);
    }

    public ObjectProperty<Color> backgroundColorProperty() {
        return backgroundColor;
    }

    public Color getBackgroundDarkColor() {
        return backgroundDarkColor.get();
    }

    public void setBackgroundDarkColor(Color backgroundDarkColor) {
        this.backgroundDarkColor.set(backgroundDarkColor);
    }

    public ObjectProperty<Color> backgroundDarkColorProperty() {
        return backgroundDarkColor;
    }

    public Color getBackgroundLightColor() {
        return backgroundLightColor.get();
    }

    public void setBackgroundLightColor(Color backgroundLightColor) {
        this.backgroundLightColor.set(backgroundLightColor);
    }

    public ObjectProperty<Color> backgroundLightColorProperty() {
        return backgroundLightColor;
    }

    public Color getDesignationColor() {
        return designationColor.get();
    }

    public void setDesignationColor(Color designationColor) {
        this.designationColor.set(designationColor);
    }

    public ObjectProperty<Color> designationColorProperty() {
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
        if (o == null || getClass() != o.getClass()) return false;

        IconModel iconModel = (IconModel) o;

        if (getBackgroundColor() != null ? !getBackgroundColor().equals(iconModel.getBackgroundColor()) : iconModel.getBackgroundColor() != null)
            return false;
        if (getBackgroundDarkColor() != null ? !getBackgroundDarkColor().equals(iconModel.getBackgroundDarkColor()) : iconModel.getBackgroundDarkColor() != null)
            return false;
        if (getBackgroundLightColor() != null ? !getBackgroundLightColor().equals(iconModel.getBackgroundLightColor()) : iconModel.getBackgroundLightColor() != null)
            return false;
        if (getDesignationColor() != null ? !getDesignationColor().equals(iconModel.getDesignationColor()) : iconModel.getDesignationColor() != null)
            return false;
        if (getForceSizeIcon() != null ? !getForceSizeIcon().equals(iconModel.getForceSizeIcon()) : iconModel.getForceSizeIcon() != null)
            return false;
        if (getIsHq() != iconModel.getIsHq()) return false;
        if (getMilitarySymbol() != iconModel.getMilitarySymbol()) return false;
        if (getPictureSymbol() != null ? !getPictureSymbol().equals(iconModel.getPictureSymbol()) : iconModel.getPictureSymbol() != null)
            return false;
        if (getSymbolColor() != null ? !getSymbolColor().equals(iconModel.getSymbolColor()) : iconModel.getSymbolColor() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getBackgroundColor() != null ? getBackgroundColor().hashCode() : 0;
        result = 31 * result + (getBackgroundDarkColor() != null ? getBackgroundDarkColor().hashCode() : 0);
        result = 31 * result + (getBackgroundLightColor() != null ? getBackgroundLightColor().hashCode() : 0);
        result = 31 * result + (getDesignationColor() != null ? getDesignationColor().hashCode() : 0);
        result = 31 * result + (getSymbolColor() != null ? getSymbolColor().hashCode() : 0);
        result = 31 * result + getMilitarySymbol();
        result = 31 * result + (getPictureSymbol() != null ? getPictureSymbol().hashCode() : 0);
        result = 31 * result + (getForceSizeIcon() != null ? getForceSizeIcon().hashCode() : 0);
        result = 31 * result + ((getIsHq()) ? 1 : 0);
        return result;
    }
}
