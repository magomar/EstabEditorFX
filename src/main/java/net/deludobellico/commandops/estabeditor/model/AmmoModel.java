package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Ammo;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Ammo} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoModel extends AbstractElementModel<AmmoModel> implements PojoAdapter<Ammo> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty minOrderQty = new SimpleIntegerProperty();
    private final DoubleProperty minOrderWeight = new SimpleDoubleProperty();
    private final ObservableList<Flag> flags = FXCollections.observableArrayList();

    public AmmoModel(Ammo ammo) {
        initialize(ammo);
    }

    public AmmoModel() {

    }

    @Override
    public Ammo getPojo() {
        Ammo pojo = new Ammo();
        pojo.setId(id.get());
        pojo.setName(name.get());
        pojo.setDescription(description.get());
        pojo.setMinOrderQty(minOrderQty.get());
        pojo.setMinOrderWeight(minOrderWeight.get());
        pojo.getFlags().addAll(flags);
        return pojo;
    }

    @Override
    public void initialize(Ammo pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        minOrderQty.set(pojo.getMinOrderQty());
        minOrderWeight.set(pojo.getMinOrderWeight());
        flags.addAll(pojo.getFlags());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, AmmoModel> map) {
        Ammo copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new AmmoModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, AmmoModel> map) {
        Ammo copy = getPojo();
        copy.getFlags().add((Flag.COPY));
        map.put(copy.getId(), new AmmoModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, AmmoModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<AmmoModel> collection) {
        collection.add(this);
    }

    @Override
    public AmmoModel createNewInMap(Map<Integer, AmmoModel> map) {
        AmmoModel newElement = ElementModelFactory.createAmmo();
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, AmmoModel> map) {
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
        return Ammo.class;
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

    public int getMinOrderQty() {
        return minOrderQty.get();
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty.set(minOrderQty);
    }

    public IntegerProperty minOrderQtyProperty() {
        return minOrderQty;
    }

    public double getMinOrderWeight() {
        return minOrderWeight.get();
    }

    public void setMinOrderWeight(double minOrderWeight) {
        this.minOrderWeight.set(minOrderWeight);
    }

    public DoubleProperty minOrderWeightProperty() {
        return minOrderWeight;
    }

    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmmoModel that = (AmmoModel) o;
        //if(getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getMinOrderQty() != that.getMinOrderQty()) return false;
        if (getMinOrderWeight() != that.getMinOrderWeight()) return false;
        return true;
    }
}
