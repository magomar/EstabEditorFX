package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.*;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForceModelTest {

    private final int id = 10;
    private final String name = "ForceModel Text";
    private final String description = "ForceModel Desc";
    private final IconModel icon = new IconModel();
    private final ForceType type = ForceType.ARMOUR;
    private final ForceSubtype subType = ForceSubtype.ABN_ARTY;
    private final ForceSize size = ForceSize.ARMY;
    private final CombatClass combatClass = CombatClass.BASE;
    private final TargetClass targetClass = TargetClass.HARD;
    private final int infantryValue = 10;
    private final int reconValue = 20;
    private final int engineeringValue = 30;
    private final MoveType moveType = MoveType.AIR;
    private final int persQty = 40;
    private final int staffCapacity = 50;
    private final double basicsQty = 60;
    private final double basicsConsumptionRateModifier = 70;
    private final int commanderRank = 80;
    private final double fuelQty = 90;
    private final double fuelLoad = 100;
    private final double maxSpeed = 110;
    private final double normalSpeed = 100;
    private final LocalTime deployed = LocalTime.now();
    private final LocalTime dugIn = LocalTime.now();
    private final LocalTime entrenched = LocalTime.now();
    private final LocalTime fortified = LocalTime.now();
    private final LocalTime readyToFireDuration =LocalTime.now();
    private final LocalTime readyToBombardDuration = LocalTime.now();
    private final List<EquipmentQtyModel> equipmentList = FXCollections.observableArrayList();
    private final List<AmmoQtyModel> ammoList = FXCollections.observableArrayList();
    private final boolean canBombard = false;

    
    @Test
    public void testCompareTo() throws Exception {
        ForceModel ours = new ForceModel();
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
        ours.setPersonnel(persQty);
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
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        ours.getEquipmentList().addAll(equipmentList);
        ours.getAmmoList().addAll(ammoList);

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
        other.setPersonnel(persQty);
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
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        other.getEquipmentList().addAll(equipmentList);
        other.getAmmoList().addAll(ammoList);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
        ForceModel ours = new ForceModel();
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
        ours.setPersonnel(persQty);
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
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        ours.getEquipmentList().addAll(equipmentList);
        ours.getAmmoList().addAll(ammoList);

        ForceModel other = new ForceModel();
        other.setId(id + 2);
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
        other.setPersonnel(persQty);
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
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        other.getEquipmentList().addAll(equipmentList);
        other.getAmmoList().addAll(ammoList);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        ForceModel ours = new ForceModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setIcon(null);
        ours.setType(null);
        ours.setSubType(null);
        ours.setSize(null);
        ours.setCombatClass(null);
        ours.setTargetClass(null);
        ours.setInfantryValue(infantryValue);
        ours.setReconValue(reconValue);
        ours.setEngineeringValue(engineeringValue);
        ours.setMoveType(null);
        ours.setPersonnel(persQty);
        ours.setStaffCapacity(staffCapacity);
        ours.setBasicsQty(basicsQty);
        ours.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier);
        ours.setCommanderRank(commanderRank);
        ours.setFuelQty(fuelQty);
        ours.setFuelLoad(fuelLoad);
        ours.setMaxSpeed(maxSpeed);
        ours.setNormalSpeed(normalSpeed);
        ours.setCanBombard(canBombard);
        ours.setDeployed(null);
        ours.setDugIn(null);
        ours.setEntrenched(null);
        ours.setFortified(null);
        ours.setReadyToFireDuration(null);
        ours.setReadyToBombardDuration(null);
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        ours.getEquipmentList().addAll(equipmentList);
        ours.getAmmoList().addAll(ammoList);

        ForceModel other = new ForceModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setIcon(null);
        other.setType(null);
        other.setSubType(null);
        other.setSize(null);
        other.setCombatClass(null);
        other.setTargetClass(null);
        other.setInfantryValue(infantryValue);
        other.setReconValue(reconValue);
        other.setEngineeringValue(engineeringValue);
        other.setMoveType(null);
        other.setPersonnel(persQty);
        other.setStaffCapacity(staffCapacity);
        other.setBasicsQty(basicsQty);
        other.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier);
        other.setCommanderRank(commanderRank);
        other.setFuelQty(fuelQty);
        other.setFuelLoad(fuelLoad);
        other.setMaxSpeed(maxSpeed);
        other.setNormalSpeed(normalSpeed);
        other.setCanBombard(canBombard);
        other.setDeployed(null);
        other.setDugIn(null);
        other.setEntrenched(null);
        other.setFortified(null);
        other.setReadyToFireDuration(null);
        other.setReadyToBombardDuration(null);
        equipmentList.clear();
        ammoList.clear();
        equipmentList.add(new EquipmentQtyModel());
        ammoList.add(new AmmoQtyModel());
        other.getEquipmentList().addAll(equipmentList);
        other.getAmmoList().addAll(ammoList);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        ForceModel ours = new ForceModel();
        ours.setId(id);

        ForceModel other = new ForceModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        ForceModel ours = new ForceModel();
        ours.setId(id);

        ForceModel other = new ForceModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}