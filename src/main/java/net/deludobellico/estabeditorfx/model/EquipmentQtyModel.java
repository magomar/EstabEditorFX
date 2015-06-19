package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import net.deludobellico.estabeditorfx.data.jaxb.Equipment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Model wrapper for the {@code Equipment} class
 *
 * @author Mario
 * @author Heine
 */
public class EquipmentQtyModel extends AbstractReferenceModel implements PojoAdapter<Equipment> {

    private final ObjectProperty<EquipmentType> equipmentType = new SimpleObjectProperty<>();

    public EquipmentQtyModel() {
        super(ElementModel.class);
    }

    public EquipmentQtyModel(Equipment pojo) {
        super(ElementModel.class);
        initialize(pojo);
    }


    @Override
    public Equipment getPojo() {
        Equipment armament = new Equipment();
        armament.setEquipmentObjectId(getId());
        armament.setName(getName());
        armament.setQty(getQty());
        return armament;
    }

    @Override
    public void initialize(Equipment pojo) {
        setId(pojo.getEquipmentObjectId());
        setName(pojo.getName());
        setQty(pojo.getQty());
    }

    public boolean link(EstabModel estab) {
        super.link(estab);
        if (getReferenceStatus() == ReferenceStatus.REF_OK) {
            if (estab.getVehicles().containsKey(getId())) {
                setEquipmentType(EquipmentType.VEHICLE);
            } else if (estab.getWeapons().containsKey(getId())) {
                setEquipmentType(EquipmentType.WEAPON);
            } else {
                setEquipmentType(EquipmentType.UNKNOWN);
            }
            return true;
        } else return false;
    }

    public ElementModel getReferenceById(EstabModel estab) {
        if (estab.getVehicles().containsKey(getId())) return estab.getVehicles().get(getId());
        if (estab.getWeapons().containsKey(getId())) return estab.getWeapons().get(getId());
        return null;
    }

    @Override
    public ElementModel getReferenceByName(EstabModel estab) {
        List<ElementModel> elements = estab.searchExactElement(getName(), VehicleModel.class);
        List<VehicleModel> vehicles = elements.stream().map(elementModel -> (VehicleModel) elementModel).collect(Collectors.toList());
        if (!vehicles.isEmpty()) {
            // TODO if size > 0 let the user select one (or none)
            return vehicles.get(0);
        }
        elements = estab.searchExactElement(getName(), WeaponModel.class);
        List<WeaponModel> weapons = elements.stream().map(elementModel -> (WeaponModel) elementModel).collect(Collectors.toList());
        if (!weapons.isEmpty()) {
            // TODO if size > 0 let the user select one (or none)
            return weapons.get(0);
        }
        return null;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType.get();
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType.set(equipmentType);
        setReferenceClass(equipmentType.getModelClass());
    }

    public ObjectProperty<EquipmentType> equipmentTypeProperty() {
        return equipmentType;
    }

    public enum EquipmentType {
        WEAPON("Weapon", WeaponModel.class),
        VEHICLE("Vehicle", VehicleModel.class),
        UNKNOWN("Unknown", ElementModel.class);
        private final String type;
        private final Class<? extends ElementModel> modelClass;

        EquipmentType(String type, Class<? extends ElementModel> modelClass) {
            this.type = type;
            this.modelClass = modelClass;
        }

        public String getType() {
            return type;
        }

        public Class<? extends ElementModel> getModelClass() {
            return modelClass;
        }
    }


}
