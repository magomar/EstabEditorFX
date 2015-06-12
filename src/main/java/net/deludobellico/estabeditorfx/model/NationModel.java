package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.Insignia;
import net.deludobellico.estabeditorfx.data.jaxb.Nation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Nation} class
 *
 * @author Mario
 * @author Heine
 */
public class NationModel extends AbstractElementModel<NationModel> implements PojoAdapter<Nation> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final ObservableList<ServiceModel> service = FXCollections.observableArrayList();
    private final List<Flag> flags = FXCollections.observableArrayList();
    private final ObjectProperty<SideModel> side = new SimpleObjectProperty<>();

    public NationModel(Nation nation) {
        initialize(nation);
    }

    public NationModel() {

    }

    @Override
    public Nation getPojo() {
        Nation nation = new Nation();
        nation.setId(id.get());
        nation.setName(name.get());
        nation.setDescription(description.get());
        //nation.setNationality("");
        Insignia largeIns = new Insignia();
        largeIns.setId(largeInsignia.get());
        nation.setLargeInsignia(largeIns);
        Insignia smallIns = new Insignia();
        smallIns.setId(smallInsignia.get());
        nation.setSmallInsignia(largeIns);
        service.stream().forEach((serviceModel) -> nation.getService().add(serviceModel.getPojo()));
        return nation;
    }

    @Override
    public void initialize(Nation pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        largeInsignia.set(pojo.getLargeInsignia().getId());
        smallInsignia.set(pojo.getSmallInsignia().getId());
        service.clear();
        pojo.getService().stream()
                .map(ServiceModel::new)
                .forEach(s -> {
                    s.setNation(this);
                    service.add(s);
                });
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, NationModel> map) {
        Nation copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new NationModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, NationModel> map) {
        Nation copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new NationModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, NationModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<NationModel> collection) {
        collection.add(this);
    }

    @Override
    public NationModel createNewInMap(Map<Integer, NationModel> map) {
        NationModel newElement = ElementModelFactory.createNation(side.get());
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, NationModel> map) {
        map.remove(getId());
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public Class getPojoClass() {
        return Nation.class;
    }

    @Override
    public List<Flag> getFlags() {
        return flags;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
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

    public ObservableList<ServiceModel> getService() {
        return service;
    }

    public SideModel getSide() {
        return side.get();
    }

    public void setSide(SideModel side) {
        this.side.setValue(side);
    }

    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (!(o instanceof NationModel)) return false;

        NationModel that = (NationModel) o;

        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getLargeInsignia() != that.getLargeInsignia()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSmallInsignia() != that.getSmallInsignia()) return false;
        if (that.getService().size() != service.size() || !service.containsAll(that.getService()))
            return false;

        return true;
    }
}

