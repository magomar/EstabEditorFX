package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import net.deludobellico.estabeditorfx.data.jaxb.Equipment;

import java.util.Map;

/**
 * Model wrapper for the {@code Equipment} class
 *
 * @author Mario
 * @author Heine
 */
public class EquipmentQtyModel implements PojoAdapter<Equipment> {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();
    private final ObjectProperty<EquipmentType> equipmentType = new SimpleObjectProperty<>();

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

    public EquipmentType getEquipmentType() {
        return equipmentType.get();
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType.set(equipmentType);
    }

    public ObjectProperty<EquipmentType> equipmentTypeProperty() {
        return equipmentType;
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

    public enum EquipmentType {
        WEAPON("Weapon"),
        VEHICLE("Vehicle");
        private final String type;

        EquipmentType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


}
