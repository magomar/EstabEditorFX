package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.model.temp.Icon;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by Mario on 29/10/2014.
 */
public class ForceModel implements PojoJFXModel<Force> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<Icon> icon = new SimpleObjectProperty<Icon>();
    private final ObjectProperty<ForceType> type = new SimpleObjectProperty<ForceType>();
    private final ObjectProperty<ForceSubtype> subType = new SimpleObjectProperty<ForceSubtype>();
    private final ObjectProperty<ForceSize> size = new SimpleObjectProperty<ForceSize>();
    private final ObjectProperty<CombatClass> combatClass = new SimpleObjectProperty<CombatClass>();
    private final ObjectProperty<TargetClass> targetClass = new SimpleObjectProperty<TargetClass>();
    private final IntegerProperty infantryValue = new SimpleIntegerProperty();
    private final IntegerProperty reconValue = new SimpleIntegerProperty();
    private final IntegerProperty engineeringValue = new SimpleIntegerProperty();
    private final ObjectProperty<MoveType> moveType = new SimpleObjectProperty<MoveType>();
    private final IntegerProperty persQty = new SimpleIntegerProperty();
    private final IntegerProperty staffCapacity = new SimpleIntegerProperty();
    private final FloatProperty basicsQty = new SimpleFloatProperty();
    private final FloatProperty basicsConsumptionRateModifier = new SimpleFloatProperty();
    private final IntegerProperty commanderRank = new SimpleIntegerProperty();
    private final FloatProperty fuelQty = new SimpleFloatProperty();
    private final FloatProperty fuelLoad = new SimpleFloatProperty();
    private final ObjectProperty<SpeedDataModel> speed = new SimpleObjectProperty<SpeedDataModel>();
    private final ObjectProperty<DeploymentDuration> deploymentDuration = new SimpleObjectProperty<DeploymentDuration>();
    private final ObjectProperty<XMLGregorianCalendar> deployed = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> dugIn = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> entrenched = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> fortified = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final StringProperty readyToFireDuration = new SimpleStringProperty();
    private final StringProperty readyToBombardDuration = new SimpleStringProperty();
    private final ObservableList<EquipmentModel> equipmentList = FXCollections.observableArrayList();
    private final ObservableList<AmmoLoadModel> ammoList = FXCollections.observableArrayList();
    private final BooleanProperty canBombard = new SimpleBooleanProperty();

    // TODO getters & setters, but first do the pojo methods. Please read the following Notes

    /**
     * NOTES
     * <p>
     * the xsd defines ammoList as an objet of type AmmmoList, which is a list of AmmoQty,
     * but the content of AmmoQty looks the same of AmmoLoad, so it seems a duplication
     * Have a look, but I think we can use a single model for both elements, the AmmoLoadModel
     * However, a conversion would be needed in the pojo methods
     * <p>
     * EquipmentModel and ArmamentModel look the same, they have the same attributes, but semantically there
     * is a difference: Armament refers only to weapons, while equipment may refer to weapons as well as vehicles
     */

    @Override
    public Force getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(Force pojo) {
        // TODO
    }
}
