package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.*;
import net.deludobellico.estabeditorfx.util.ColorUtil;

import java.util.Collection;
import java.util.Map;

/**
 * Model wrapper for the {@code Service} class
 *
 * @author Mario
 * @author Heine
 */
public class ServiceModel extends AbstractElementModel<ServiceModel> implements PojoAdapter<Service> {
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    private final ObjectProperty<Color> backgroundColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundDarkColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundLightColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> designationColor = new SimpleObjectProperty<>();
    private final ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final ObservableList<ForceModel> force = FXCollections.observableArrayList();
    private final ObjectProperty<NationModel> nation = new SimpleObjectProperty<>();

    public ServiceModel(Service service) {
        initialize(service);
    }

    public ServiceModel() {

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
        service.setSmallInsignia(smallIns);
        service.setRankList(new RankList());
        rankList.stream().forEach((rankModel) -> service.getRankList().getRank().add(rankModel.getPojo()));
        DefaultIconColors iconColors = new DefaultIconColors();
        iconColors.setBackgroundColor(ColorUtil.getRGBColor(backgroundColor.get()));
        iconColors.setBackgroundDarkColor(ColorUtil.getRGBColor(backgroundDarkColor.get()));
        iconColors.setBackgroundLightColor(ColorUtil.getRGBColor(backgroundLightColor.get()));
        iconColors.setDesignationColor(ColorUtil.getRGBColor(designationColor.get()));
        iconColors.setSymbolColor(symbolColor.get());
        service.setDefaultIconColors(iconColors);
        force.stream().forEach((forceModel) -> service.getForce().add(forceModel.getPojo()));
        service.getFlags().addAll(flags);
        return service;
    }

    @Override
    public void initialize(Service pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        largeInsignia.set(pojo.getLargeInsignia().getId());
        smallInsignia.set(pojo.getSmallInsignia().getId());
        pojo.getRankList().getRank().stream().map(RankModel::new).forEach(rankList::add);
        DefaultIconColors iconColors = pojo.getDefaultIconColors();
        backgroundColor.set(ColorUtil.getColor(iconColors.getBackgroundColor()));
        backgroundDarkColor.set(ColorUtil.getColor(iconColors.getBackgroundDarkColor()));
        backgroundLightColor.set(ColorUtil.getColor(iconColors.getBackgroundLightColor()));
        designationColor.set(ColorUtil.getColor(iconColors.getDesignationColor()));
        symbolColor.set(iconColors.getSymbolColor());
        pojo.getForce().stream()
                .map(ForceModel::new)
                .forEach(f -> {
                    f.setService(this);
                    force.add(f);
                });
        flags.addAll(pojo.getFlags());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, ServiceModel> map) {
        Service copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new ServiceModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, ServiceModel> map) {
        Service copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new ServiceModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, ServiceModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<ServiceModel> collection) {
        collection.add(this);
    }

    @Override
    public ServiceModel createNewInMap(Map<Integer, ServiceModel> map) {
        ServiceModel newElement = ElementModelFactory.createService(nation.get());
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, ServiceModel> map) {
        map.remove(getId());
    }

    @Override
    public Class getPojoClass() {
        return Service.class;
    }

    public int getLargeInsignia() {
        return largeInsignia.get();
    }

    public void setLargeInsignia(int largeInsignia) {
        this.largeInsignia.set(largeInsignia);
    }

    public IntegerProperty largeInsigniaProperty() {
        return largeInsignia;
    }

    public int getSmallInsignia() {
        return smallInsignia.get();
    }

    public void setSmallInsignia(int smallInsignia) {
        this.smallInsignia.set(smallInsignia);
    }

    public IntegerProperty smallInsigniaProperty() {
        return smallInsignia;
    }

    public ObservableList<RankModel> getRankList() {
        return rankList;
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

    public ObservableList<ForceModel> getForce() {
        return force;
    }

    public NationModel getNation() {
        return nation.get();
    }

    public void setNation(NationModel nation) {
        this.nation.setValue(nation);
    }

    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceModel)) return false;

        ServiceModel that = (ServiceModel) o;

        if (getBackgroundColor() != null ? !getBackgroundColor().equals(that.getBackgroundColor()) : that.getBackgroundColor() != null)
            return false;
        if (getBackgroundDarkColor() != null ? !getBackgroundDarkColor().equals(that.getBackgroundDarkColor()) : that.getBackgroundDarkColor() != null)
            return false;
        if (getBackgroundLightColor() != null ? !getBackgroundLightColor().equals(that.getBackgroundLightColor()) : that.getBackgroundLightColor() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getDesignationColor() != null ? !getDesignationColor().equals(that.getDesignationColor()) : that.getDesignationColor() != null)
            return false;
        if (getLargeInsignia() != that.getLargeInsignia()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSmallInsignia() != that.getSmallInsignia()) return false;
        if (getSymbolColor() != null ? !getSymbolColor().equals(that.getSymbolColor()) : that.getSymbolColor() != null)
            return false;
        if (that.getForce().size() != force.size() || !force.containsAll(that.getForce()))
            return false;
        if (that.getRankList().size() != rankList.size() || !rankList.containsAll(that.getRankList()))
            return false;
        return true;
    }
}
