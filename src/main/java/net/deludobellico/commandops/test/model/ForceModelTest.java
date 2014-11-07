package net.deludobellico.commandops.test.model;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.model.AmmoQtyModel;
import net.deludobellico.commandops.estabeditor.model.EquipmentModel;
import net.deludobellico.commandops.estabeditor.model.ForceModel;
import net.deludobellico.commandops.estabeditor.model.IconModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForceModelTest {
    ForceModel ours;
    int id = 10;
    String name = "ForceModel Text";
    String description = "ForceModel Desc";
    IconModel icon = new IconModel();
    ForceType type = ForceType.ARMOUR;
    ForceSubtype subType = ForceSubtype.ABN_ARTY;
    ForceSize size = ForceSize.ARMY;
    CombatClass combatClass = CombatClass.BASE;
    TargetClass targetClass = TargetClass.HARD;
    int infantryValue = 10;
    int reconValue = 20;
    int engineeringValue = 30;
    MoveType moveType = MoveType.AIR;
    int persQty = 40;
    int staffCapacity = 50;
    double basicsQty = 60;
    double basicsConsumptionRateModifier = 70;
    int commanderRank = 80;
    double fuelQty = 90;
    double fuelLoad = 100;
    double maxSpeed = 110;
    double normalSpeed = 100;
    XMLGregorianCalendar deployed = new XMLGregorianCalendarImpl();
    XMLGregorianCalendar dugIn = new XMLGregorianCalendarImpl();
    XMLGregorianCalendar entrenched = new XMLGregorianCalendarImpl();
    XMLGregorianCalendar fortified = new XMLGregorianCalendarImpl();
    String readyToFireDuration = "00:00:00";
    String readyToBombardDuration = "00:00:00";
    List<EquipmentModel> equipmentList = FXCollections.observableArrayList();
    List<AmmoQtyModel> ammoList = FXCollections.observableArrayList();
    boolean canBombard = false;

    @Before
    public void setUp() throws Exception {
        ours = new ForceModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setIcon(icon);
        ours.setType(type);
        ours.setSubType(subType);
        ours.setSize(size);
        ours.setCombatClass(combatClass);
        ours.setTargetClass(targetClass);
        ours.setInfantryValue(infantryValue);
        ours.setReconValue(reconValue);
        ours.setEngineeringValue(engineeringValue);
        ours.setMoveType(moveType);
        ours.setPersQty(persQty);
        ours.setStaffCapacity(staffCapacity);
        ours.setBasicsQty(basicsQty);
        ours.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier);
        ours.setCommanderRank(commanderRank);
        ours.setFuelQty(fuelQty);
        ours.setFuelLoad(fuelLoad);
        ours.setMaxSpeed(maxSpeed);
        ours.setNormalSpeed(normalSpeed);
        ours.setCanBombard(canBombard);
        ours.setDeployed(deployed);
        ours.setDugIn(dugIn);
        ours.setEntrenched(entrenched);
        ours.setFortified(fortified);
        ours.setReadyToFireDuration(readyToFireDuration);
        ours.setReadyToBombardDuration(readyToBombardDuration);
        equipmentList.add(new EquipmentModel());
        ammoList.add(new AmmoQtyModel());
        ours.getEquipmentList().addAll(equipmentList);
        ours.getAmmoList().addAll(ammoList);
    }

    @After
    public void tearDown() throws Exception {
        equipmentList.clear();
        ammoList.clear();
    }

    @Test
    public void testEquals() throws Exception {
        ForceModel other = new ForceModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setIcon(icon);
        other.setType(type);
        other.setSubType(subType);
        other.setSize(size);
        other.setCombatClass(combatClass);
        other.setTargetClass(targetClass);
        other.setInfantryValue(infantryValue);
        other.setReconValue(reconValue);
        other.setEngineeringValue(engineeringValue);
        other.setMoveType(moveType);
        other.setPersQty(persQty);
        other.setStaffCapacity(staffCapacity);
        other.setBasicsQty(basicsQty);
        other.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier);
        other.setCommanderRank(commanderRank);
        other.setFuelQty(fuelQty);
        other.setFuelLoad(fuelLoad);
        other.setMaxSpeed(maxSpeed);
        other.setNormalSpeed(normalSpeed);
        other.setCanBombard(canBombard);
        other.setDeployed(deployed);
        other.setDugIn(dugIn);
        other.setEntrenched(entrenched);
        other.setFortified(fortified);
        other.setReadyToFireDuration(readyToFireDuration);
        other.setReadyToBombardDuration(readyToBombardDuration);
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentModel());
        ammoList.add(new AmmoQtyModel());
        other.getEquipmentList().addAll(equipmentList);
        other.getAmmoList().addAll(ammoList);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        ForceModel other = new ForceModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setIcon(icon);
        other.setType(type);
        other.setSubType(subType);
        other.setSize(size);
        other.setCombatClass(combatClass);
        other.setTargetClass(targetClass);
        other.setInfantryValue(infantryValue);
        other.setReconValue(reconValue);
        other.setEngineeringValue(engineeringValue);
        other.setMoveType(moveType);
        other.setPersQty(persQty);
        other.setStaffCapacity(staffCapacity);
        other.setBasicsQty(basicsQty);
        other.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier);
        other.setCommanderRank(commanderRank);
        other.setFuelQty(fuelQty);
        other.setFuelLoad(fuelLoad);
        other.setMaxSpeed(maxSpeed);
        other.setNormalSpeed(normalSpeed);
        other.setCanBombard(canBombard);
        other.setDeployed(deployed);
        other.setDugIn(dugIn);
        other.setEntrenched(entrenched);
        other.setFortified(fortified);
        other.setReadyToFireDuration(readyToFireDuration);
        other.setReadyToBombardDuration(readyToBombardDuration);
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentModel());
        ammoList.add(new AmmoQtyModel());
        other.getEquipmentList().addAll(equipmentList);
        other.getAmmoList().addAll(ammoList);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}