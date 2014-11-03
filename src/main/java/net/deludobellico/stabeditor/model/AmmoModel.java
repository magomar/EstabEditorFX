package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import net.deludobellico.stabeditor.data.jaxb.Ammo;

/**
 * Created by Mario on 28/10/2014.
 */
public class AmmoModel implements ElementModel, PojoJFXModel<Ammo> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty minOrderQty = new SimpleIntegerProperty();
    private final DoubleProperty minOrderWeight = new SimpleDoubleProperty();

    public AmmoModel(Ammo ammo) {
        setPojo(ammo);
    }

    @Override
    public Ammo getPojo() {
        Ammo ammo = new Ammo();
        ammo.setId(id.get());
        ammo.setName(name.get());
        ammo.setDescription(description.get());
        ammo.setMinOrderQty(minOrderQty.get());
        ammo.setMinOrderWeight(minOrderWeight.get());
        return ammo;
    }

    @Override
    public void setPojo(Ammo pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        minOrderQty.set(pojo.getMinOrderQty());
        minOrderWeight.set(pojo.getMinOrderWeight());
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
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
    public String toString(){
        return name.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmmoModel ammoModel = (AmmoModel) o;

        if (description != null ? !description.equals(ammoModel.description) : ammoModel.description != null)
            return false;
        if (minOrderQty != null ? !minOrderQty.equals(ammoModel.minOrderQty) : ammoModel.minOrderQty != null)
            return false;
        if (minOrderWeight != null ? !minOrderWeight.equals(ammoModel.minOrderWeight) : ammoModel.minOrderWeight != null)
            return false;
        if (name != null ? !name.equals(ammoModel.name) : ammoModel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (minOrderQty != null ? minOrderQty.hashCode() : 0);
        result = 31 * result + (minOrderWeight != null ? minOrderWeight.hashCode() : 0);
        return result;
    }
}
