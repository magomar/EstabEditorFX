package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.ForceSize;
import net.deludobellico.estabeditorfx.data.jaxb.Icon;
import net.deludobellico.estabeditorfx.data.jaxb.PictureSymbol;
import net.deludobellico.estabeditorfx.data.jaxb.SymbolColor;
import net.deludobellico.estabeditorfx.util.ColorUtil;

/**
 * Model wrapper for the {@code Icon} class
 *
 * @author Mario
 * @author Heine
 */
public class IconModel implements PojoAdapter<Icon> {
    private final ObjectProperty<Color> backgroundColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundDarkColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundLightColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> designationColor = new SimpleObjectProperty<>();
    private final ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final ObjectProperty<MilitarySymbol> militarySymbol = new SimpleObjectProperty<>();
    private final ObjectProperty<PictureSymbol> pictureSymbol = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSize> forceSizeIcon = new SimpleObjectProperty<>();
    private final BooleanProperty isHq = new SimpleBooleanProperty();
    private static final int symbolWidth = 16;
    private static final int militarySymbolHeight = 10;
    private static final int pictureSymbolHeight = 11;
    private static final int sizeSymbolWidth = 18;
    private static final int sizeSymbolHeight = 7;
    private static final int columns = 5;
    private static Image militarySymbols;
    private static Image pictureSymbols;
    private static Image forceSizeSymbols;

    static {
        militarySymbols = new Image(MilitarySymbol.class.getClassLoader().getResourceAsStream("images/military-symbols.png"));
        pictureSymbols = new Image(MilitarySymbol.class.getClassLoader().getResourceAsStream("images/picture-symbols.png"));
        forceSizeSymbols = new Image(MilitarySymbol.class.getClassLoader().getResourceAsStream("images/force-size-symbols.png"));
    }

    public IconModel(Icon pojo) {
        initialize(pojo);
    }

    public IconModel() {

    }

    @Override
    public Icon getPojo() {
        Icon icon = new Icon();
        icon.setBackgroundColor(ColorUtil.getRGBColor(backgroundColor.get()));
        icon.setBackgroundDarkColor(ColorUtil.getRGBColor(backgroundDarkColor.get()));
        icon.setBackgroundLightColor(ColorUtil.getRGBColor(backgroundLightColor.get()));
        icon.setDesignationColor(ColorUtil.getRGBColor(designationColor.get()));
        icon.setSymbolColor(symbolColor.get());
        icon.setMilitarySymbol(militarySymbol.get().ordinal());
        icon.setPictureSymbol(pictureSymbol.get());
        icon.setForceSizeIcon(forceSizeIcon.get());
        icon.setIsHq(PojoAdapter.booleanToYesNo(isHq.get()));
        return icon;
    }

    @Override
    public void initialize(Icon pojo) {
        backgroundColor.set(ColorUtil.getColor(pojo.getBackgroundColor()));
        backgroundDarkColor.set(ColorUtil.getColor(pojo.getBackgroundDarkColor()));
        backgroundLightColor.set(ColorUtil.getColor(pojo.getBackgroundLightColor()));
        backgroundLightColor.set(ColorUtil.getColor(pojo.getBackgroundLightColor()));
        designationColor.set(ColorUtil.getColor(pojo.getDesignationColor()));
        symbolColor.set(pojo.getSymbolColor());
        militarySymbol.set(MilitarySymbol.values()[pojo.getMilitarySymbol()]);
        pictureSymbol.set(pojo.getPictureSymbol());
        forceSizeIcon.set(pojo.getForceSizeIcon());
        isHq.set(PojoAdapter.yesNoToBoolean(pojo.getIsHq()));
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

    public MilitarySymbol getMilitarySymbol() {
        return militarySymbol.get();
    }

    public ObjectProperty<MilitarySymbol> militarySymbolProperty() {
        return militarySymbol;
    }

    public void setMilitarySymbol(MilitarySymbol militarySymbol) {
        this.militarySymbol.set(militarySymbol);
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
        result = 31 * result + (getMilitarySymbol() != null ? getMilitarySymbol().ordinal() : 0);
        result = 31 * result + (getPictureSymbol() != null ? getPictureSymbol().hashCode() : 0);
        result = 31 * result + (getForceSizeIcon() != null ? getForceSizeIcon().hashCode() : 0);
        result = 31 * result + ((getIsHq()) ? 1 : 0);
        return result;
    }

    public enum MilitarySymbol {
        ARMY_GROUP_HQ,
        ARMY_HQ,
        CORPS_HQ,
        RECON,
        ARMOR,
        ARMORED_RECON,
        ARMORED_CAR,
        ASSAULT_GUN,
        ARTILLERY,
        MOTOR_ARTILLERY,
        SP_ARTY,
        PARACHUTED_ARTY,
        AIRBORNE_ARTY,
        ROCKET_LAUNCHER,
        MOTORIZED_ROCKET_LAUNCHER,
        SP_ROCKET_LAUNCHER,
        ANTI_TANK,
        MOTOR_ANTI_TANK,
        SP_ANTI_TANK,
        FLAK,
        MOTORIZED_FLAK,
        SP_FLAK,
        INFANTRY,
        MOTORIZED_INFANTRY,
        MECHANIZED_INFANTRY,
        MOUNTAIN_INFANTRY,
        MOTORIZED_MOUNTAIN_INF,
        PARACHUTED_INFANTRY,
        MOTORIZED_PARACHUTED_INF,
        AIRBORNE_INFANTRY,
        MOTORIZED_AIRBORNE_INF,
        SF_INFANTRY, // SUPPORT FIRE INFANTRY? LIKE MGS & LIGHT MORTARS?
        MOTORIZED_SUF,
        MG_INFANTRY,
        MOTORIZED_MG_INFANTRY,
        HEAVY_WEAPONS_INF,
        MOTORIZED_HW_INF,
        AIRBORNE_RECON,
        MOTORIZED_ABN_RECON,
        ENGINEERS,
        MOTORIZED_ENGINEERS,
        MECHANIZED_ENGINEERS,
        BRIDGE_ENGINEERS,
        MOTORIZED_BRIDGE_ENG,
        SP_BRIDGE_ENGINEERS,
        TRANSPORT,
        SUPPLY,
        INFANTRY_GUN,
        MOTORIZED_INF_GUN,
        SP_INFANTRY_GUN;
        private Image symbolImage;

        public javafx.scene.image.Image getMilitarySymbol() {
            if (null != symbolImage) return symbolImage;
            else {
                int i = ordinal() / columns;
                int j = ordinal() % columns;
                int x = j * (symbolWidth + 1);
                int y = i * (militarySymbolHeight + 1);
                symbolImage = new WritableImage(militarySymbols.getPixelReader(), x, y, symbolWidth, militarySymbolHeight);
                return symbolImage;
            }
        }
    }

    public static javafx.scene.image.Image getPictureSymbol(PictureSymbol pictureSymbol) {
        int i = pictureSymbol.ordinal() / columns;
        int j = pictureSymbol.ordinal() % columns;
        int x = j * (symbolWidth + 1);
        int y = i * (pictureSymbolHeight + 2);
        return new WritableImage(pictureSymbols.getPixelReader(), x, y, symbolWidth, pictureSymbolHeight);
    }

    public static javafx.scene.image.Image getForceSizeSymbol(ForceSize forceSize) {
        int i = (ForceSize.values().length - 1 - forceSize.ordinal()) / columns;
        int j = (ForceSize.values().length - 1 - forceSize.ordinal()) % columns;
        int x = j * (sizeSymbolWidth + 1);
        int y = i * (sizeSymbolHeight + 1);
        return new WritableImage(forceSizeSymbols.getPixelReader(), x, y, sizeSymbolWidth, sizeSymbolHeight);
    }

}
