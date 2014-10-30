package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import net.deludobellico.stabeditor.data.jaxb.Ammo;

/**
 * Created by Mario on 28/10/2014.
 */
public class AmmoModel implements AssetModel, PojoJFXModel<Ammo> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty minOrderQty = new SimpleIntegerProperty();
    private final FloatProperty minOrderWeight = new SimpleFloatProperty();

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

    public int getMinOrderQty() {
        return minOrderQty.get();
    }

    public IntegerProperty minOrderQtyProperty() {
        return minOrderQty;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty.set(minOrderQty);
    }

    public float getMinOrderWeight() {
        return minOrderWeight.get();
    }

    public FloatProperty minOrderWeightProperty() {
        return minOrderWeight;
    }

    public void setMinOrderWeight(float minOrderWeight) {
        this.minOrderWeight.set(minOrderWeight);
    }

}
