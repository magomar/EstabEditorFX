package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Equipment;


public class EquipmentModel implements PojoJFXModel<Equipment> {

    private final transient IntegerProperty equipmentObjectId = new SimpleIntegerProperty();
    private final transient StringProperty name = new SimpleStringProperty();
    private final transient IntegerProperty qty = new SimpleIntegerProperty();

    public EquipmentModel(Equipment pojo) {
        setPojo(pojo);
    }

    @Override
    public Equipment getPojo() {
        Equipment armament = new Equipment();
        armament.setEquipmentObjectId(equipmentObjectId.get());
        armament.setName(name.get());
        armament.setQty(qty.get());
        return armament;
    }

    @Override
    public void setPojo(Equipment pojo) {
        equipmentObjectId.set(pojo.getEquipmentObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    public int getEquipmentObjectId() {
        return equipmentObjectId.get();
    }

    public void setEquipmentObjectId(int equipmentObjectId) {
        this.equipmentObjectId.set(equipmentObjectId);
    }

    public IntegerProperty equipmentObjectIdProperty() {
        return equipmentObjectId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentModel)) return false;

        EquipmentModel that = (EquipmentModel) o;

        if (equipmentObjectId != null ? !equipmentObjectId.equals(that.equipmentObjectId) : that.equipmentObjectId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentObjectId != null ? equipmentObjectId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        return result;
    }
}
