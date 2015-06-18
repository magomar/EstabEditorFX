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
public class EquipmentQtyModel extends AbstractReferenceModel<ElementModel> implements PojoAdapter<Equipment> {

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
    public ElementModel getReferencedElement(EstabModel estab) {
        if (equipmentType.equals(EquipmentQtyModel.EquipmentType.WEAPON)) {
            return estab.getWeapons().get(id.get());
        } else {
            return estab.getVehicles().get(id.get());
        }
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
