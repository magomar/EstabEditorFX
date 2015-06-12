package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import net.deludobellico.estabeditorfx.data.jaxb.Equipment;
import net.deludobellico.estabeditorfx.data.jaxb.Equipment;

/**
 * Model wrapper for the {@code Equipment} class
 *
 * @author Mario
 * @author Heine
 */
public class EquipmentQtyModel implements PojoAdapter<Equipment> {

    private final transient IntegerProperty id = new SimpleIntegerProperty();
    private final transient StringProperty name = new SimpleStringProperty();
    private final transient IntegerProperty qty = new SimpleIntegerProperty();
    // TODO check if equipmentClass is really needed (where is it being used?)
    private final transient ObjectProperty<Class> equipmentClass = new SimpleObjectProperty<>();

    public EquipmentQtyModel(Equipment pojo) {
        initialize(pojo);
    }

    public EquipmentQtyModel() {

    }

    @Override
    public Equipment getPojo() {
        Equipment armament = new Equipment();
        armament.setEquipmentObjectId(id.get());
        armament.setName(name.get());
        armament.setQty(qty.get());
        return armament;
    }

    @Override
    public void initialize(Equipment pojo) {
        id.set(pojo.getEquipmentObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
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

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getQty() {
        return qty.get();
    }

    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public IntegerProperty qtyProperty() {
        return qty;
    }

    public Class getEquipmentClass() {
        return equipmentClass.get();
    }

    public void setEquipmentClass(Class equipmentClass) {
        this.equipmentClass.set(equipmentClass);
    }

    public ObjectProperty<Class> equipmentClassProperty() {
        return equipmentClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentQtyModel)) return false;

        EquipmentQtyModel that = (EquipmentQtyModel) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getQty() != that.getQty()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result + getId();
        result = 62 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getQty();
        return result;
    }

}
