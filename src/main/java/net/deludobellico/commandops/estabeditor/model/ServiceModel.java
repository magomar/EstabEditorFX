package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;

/**
 * Created by Mario on 29/10/2014.
 */
public class ServiceModel implements PojoJFXModel<Service> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    private final transient ObjectProperty<RGBColorModel> backgroundColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> backgroundDarkColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> backgroundLightColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> designationColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final ObservableList<ForceModel> force = FXCollections.observableArrayList();

    public ServiceModel(Service service) {
        setPojo(service);
    }

    @Override
    public Service getPojo() {
        Service service = new Service();
        service.setId(id.get());
        service.setName(name.get());
        service.setDescription(description.get());
        Insignia largeIns = new Insignia();
        largeIns.setId(largeInsignia.get());
        service.setLargeInsignia(largeIns);
        Insignia smallIns = new Insignia();
        smallIns.setId(smallInsignia.get());
        service.setSmallInsignia(largeIns);
        rankList.stream().forEach((rankModel)-> service.getRankList().getRank().add(rankModel.getPojo()));
        DefaultIconColors iconColors = new DefaultIconColors();
        iconColors.setBackgroundColor(backgroundColor.get().getPojo());
        iconColors.setBackgroundDarkColor(backgroundDarkColor.get().getPojo());
        iconColors.setBackgroundLightColor(backgroundLightColor.get().getPojo());
        iconColors.setDesignationColor(designationColor.get().getPojo());
        iconColors.setSymbolColor(symbolColor.get());
        service.setDefaultIconColors(iconColors);
        force.stream().forEach((forceModel)-> service.getForce().add(forceModel.getPojo()));
        return service;
    }

    @Override
    public void setPojo(Service pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        largeInsignia.set(pojo.getLargeInsignia().getId());
        smallInsignia.set(pojo.getSmallInsignia().getId());
        pojo.getRankList().getRank().stream().map(RankModel::new).forEach((rankModel) -> rankList.add(rankModel));
        DefaultIconColors iconColors = pojo.getDefaultIconColors();
        backgroundColor.set(new RGBColorModel(iconColors.getBackgroundColor()));
        backgroundDarkColor.set(new RGBColorModel(iconColors.getBackgroundDarkColor()));
        backgroundLightColor.set(new RGBColorModel(iconColors.getBackgroundLightColor()));
        symbolColor.set(iconColors.getSymbolColor());
        pojo.getForce().stream().map(ForceModel::new).forEach((forceModel) -> force.add(forceModel));
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getLargeInsignia() {
        return largeInsignia.get();
    }

    public IntegerProperty largeInsigniaProperty() {
        return largeInsignia;
    }

    public void setLargeInsignia(int largeInsignia) {
        this.largeInsignia.set(largeInsignia);
    }

    public int getSmallInsignia() {
        return smallInsignia.get();
    }

    public IntegerProperty smallInsigniaProperty() {
        return smallInsignia;
    }

    public void setSmallInsignia(int smallInsignia) {
        this.smallInsignia.set(smallInsignia);
    }

    public ObservableList<RankModel> getRankList() {
        return rankList;
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

    public ObservableList<ForceModel> getForce() {
        return force;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceModel)) return false;

        ServiceModel that = (ServiceModel) o;

        if (backgroundColor != null ? !backgroundColor.equals(that.backgroundColor) : that.backgroundColor != null)
            return false;
        if (backgroundDarkColor != null ? !backgroundDarkColor.equals(that.backgroundDarkColor) : that.backgroundDarkColor != null)
            return false;
        if (backgroundLightColor != null ? !backgroundLightColor.equals(that.backgroundLightColor) : that.backgroundLightColor != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (designationColor != null ? !designationColor.equals(that.designationColor) : that.designationColor != null)
            return false;
        if (force != null ? !force.equals(that.force) : that.force != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (largeInsignia != null ? !largeInsignia.equals(that.largeInsignia) : that.largeInsignia != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (rankList != null ? !rankList.equals(that.rankList) : that.rankList != null) return false;
        if (smallInsignia != null ? !smallInsignia.equals(that.smallInsignia) : that.smallInsignia != null)
            return false;
        if (symbolColor != null ? !symbolColor.equals(that.symbolColor) : that.symbolColor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (largeInsignia != null ? largeInsignia.hashCode() : 0);
        result = 31 * result + (smallInsignia != null ? smallInsignia.hashCode() : 0);
        result = 31 * result + (rankList != null ? rankList.hashCode() : 0);
        result = 31 * result + (backgroundColor != null ? backgroundColor.hashCode() : 0);
        result = 31 * result + (backgroundDarkColor != null ? backgroundDarkColor.hashCode() : 0);
        result = 31 * result + (backgroundLightColor != null ? backgroundLightColor.hashCode() : 0);
        result = 31 * result + (designationColor != null ? designationColor.hashCode() : 0);
        result = 31 * result + (symbolColor != null ? symbolColor.hashCode() : 0);
        result = 31 * result + (force != null ? force.hashCode() : 0);
        return result;
    }
}
