package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import net.deludobellico.estabeditorfx.data.jaxb.Equipment;
import net.deludobellico.estabeditorfx.data.jaxb.Vehicle;

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

    @Override
    public ElementModel getReferenceById(EstabModel estab) {
        if (equipmentType.equals(EquipmentQtyModel.EquipmentType.WEAPON)) {
            return estab.getWeapons().get(getId());
        } else {
            return estab.getVehicles().get(getId());
        }
    }

    @Override
    public ElementModel getReferenceByName(EstabModel estab) {
        if (null == getReferenceClass()) {
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
        }
        return null;
    }


    public enum EquipmentType {
        WEAPON("Weapon", WeaponModel.class),
        VEHICLE("Vehicle", VehicleModel.class);
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
