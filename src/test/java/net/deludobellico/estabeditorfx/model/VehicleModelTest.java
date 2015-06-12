package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.VehicleType;
import net.deludobellico.estabeditorfx.model.ArmamentModel;
import net.deludobellico.estabeditorfx.model.VehicleModel;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VehicleModelTest {
    private final int id = 10;
    private final String name = "VehicleModel Test";
    private final String description = "VehicleModel Desc";
    private final int pictureId = 100;
    private final String pictureFilename = "VehiclePicture";
    /* */
    private final double width = 100.1;
    private final double height = 100.2;
    private final double length = 100.3;
    private final double weight = 100.4;
    /* end VehicleSize */
    private final int crew = 5;
    private final double reliability = 11.2;
    private final List<ArmamentModel> armaments = FXCollections.observableArrayList();
    private final VehicleType type = VehicleType.ARMOURED_CAR;
    private final double fuelCapacity = 12.2;
    private final double maxRoadSpeed = 12.5;
    private final double normalRoadSpeed = 346.3;
    private final double maxCrossCountrySpeed = 34.2;
    private final double normalCrossCountrySpeed = 345.2;
    private final double maxFuelConsumption = 7.4;
    private final double normalFuelConsumption = 32.2;
    // end VehicleSpeeds
    private final double ronsonability = 6.3;
    private final int maxGradient = 6;
    private final int maxFordingDepth = 9;
    private final int maxTrenchWidth = 8;
    private final double towingCapacity = 321.2;
    private final int personnelCapacity = 5;
    private final double bulkFuelCapacity = 23.;
    private final double payloadCapacity = 5.2;
    private final double takeCoverMod = 6.3;
    private final boolean hasTurret = false;
    private final boolean hasOpenTop = false;
    private final double battleWeight = 35.2;
    private final double frontArmor = 34.2;
    private final double sideArmor = 65.2;
    private final double rearArmor = 46.3;
    private final double topArmor = 654.2;
    private final Flag[] flags = new Flag[]{Flag.NEW, Flag.COPY};

    @Test
    public void testCompareTo() throws Exception {
        VehicleModel ours = new VehicleModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(pictureFilename);
        ours.setWidth(width);
        ours.setHeight(height);
        ours.setLength(length);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        ours.getArmaments().addAll(armaments);
        ours.setType(type);
        ours.setFuelCapacity(fuelCapacity);
        ours.setMaxRoadSpeed(maxRoadSpeed);
        ours.setNormalRoadSpeed(normalRoadSpeed);
        ours.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        ours.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        ours.setMaxFuelConsumption(maxFuelConsumption);
        ours.setNormalFuelConsumption(normalFuelConsumption);
        ours.setRonsonability(ronsonability);
        ours.setMaxGradient(maxGradient);
        ours.setMaxFordingDepth(maxFordingDepth);
        ours.setMaxTrenchWidth(maxTrenchWidth);
        ours.setTowingCapacity(towingCapacity);
        ours.setPersonnelCapacity(personnelCapacity);
        ours.setBulkFuelCapacity(bulkFuelCapacity);
        ours.setPayloadCapacity(payloadCapacity);
        ours.setTakeCoverMod(takeCoverMod);
        ours.setHasTurret(hasTurret);
        ours.setHasOpenTop(hasOpenTop);
        ours.setBattleWeight(battleWeight);
        ours.setFrontArmor(frontArmor);
        ours.setSideArmor(sideArmor);
        ours.setRearArmor(rearArmor);
        ours.setTopArmor(topArmor);
        ours.setFlag(flags);

        VehicleModel other = new VehicleModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setPictureId(pictureId);
        other.setPictureFilename(pictureFilename);
        other.setWidth(width);
        other.setHeight(height);
        other.setLength(length);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        other.getArmaments().addAll(armaments);
        other.setType(type);
        other.setFuelCapacity(fuelCapacity);
        other.setMaxRoadSpeed(maxRoadSpeed);
        other.setNormalRoadSpeed(normalRoadSpeed);
        other.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        other.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        other.setMaxFuelConsumption(maxFuelConsumption);
        other.setNormalFuelConsumption(normalFuelConsumption);
        other.setRonsonability(ronsonability);
        other.setMaxGradient(maxGradient);
        other.setMaxFordingDepth(maxFordingDepth);
        other.setMaxTrenchWidth(maxTrenchWidth);
        other.setTowingCapacity(towingCapacity);
        other.setPersonnelCapacity(personnelCapacity);
        other.setBulkFuelCapacity(bulkFuelCapacity);
        other.setPayloadCapacity(payloadCapacity);
        other.setTakeCoverMod(takeCoverMod);
        other.setHasTurret(hasTurret);
        other.setHasOpenTop(hasOpenTop);
        other.setBattleWeight(battleWeight);
        other.setFrontArmor(frontArmor);
        other.setSideArmor(sideArmor);
        other.setFlag(flags);
        other.setRearArmor(rearArmor);
        other.setTopArmor(topArmor);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
        VehicleModel ours = new VehicleModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(pictureFilename);
        ours.setWidth(width);
        ours.setHeight(height);
        ours.setLength(length);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        ours.getArmaments().addAll(armaments);
        ours.setType(type);
        ours.setFuelCapacity(fuelCapacity);
        ours.setMaxRoadSpeed(maxRoadSpeed);
        ours.setNormalRoadSpeed(normalRoadSpeed);
        ours.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        ours.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        ours.setMaxFuelConsumption(maxFuelConsumption);
        ours.setNormalFuelConsumption(normalFuelConsumption);
        ours.setRonsonability(ronsonability);
        ours.setMaxGradient(maxGradient);
        ours.setMaxFordingDepth(maxFordingDepth);
        ours.setMaxTrenchWidth(maxTrenchWidth);
        ours.setTowingCapacity(towingCapacity);
        ours.setPersonnelCapacity(personnelCapacity);
        ours.setBulkFuelCapacity(bulkFuelCapacity);
        ours.setPayloadCapacity(payloadCapacity);
        ours.setTakeCoverMod(takeCoverMod);
        ours.setHasTurret(hasTurret);
        ours.setHasOpenTop(hasOpenTop);
        ours.setBattleWeight(battleWeight);
        ours.setFrontArmor(frontArmor);
        ours.setSideArmor(sideArmor);
        ours.setRearArmor(rearArmor);
        ours.setTopArmor(topArmor);
        ours.setFlag(flags);

        VehicleModel other = new VehicleModel();
        other.setId(id + 3);
        other.setName(name);
        other.setDescription(description);
        other.setPictureId(pictureId);
        other.setPictureFilename(pictureFilename);
        other.setWidth(width);
        other.setHeight(height);
        other.setLength(length);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        other.getArmaments().addAll(armaments);
        other.setType(type);
        other.setFuelCapacity(fuelCapacity);
        other.setMaxRoadSpeed(maxRoadSpeed);
        other.setNormalRoadSpeed(normalRoadSpeed);
        other.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        other.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        other.setMaxFuelConsumption(maxFuelConsumption);
        other.setNormalFuelConsumption(normalFuelConsumption);
        other.setRonsonability(ronsonability);
        other.setMaxGradient(maxGradient);
        other.setMaxFordingDepth(maxFordingDepth);
        other.setMaxTrenchWidth(maxTrenchWidth);
        other.setTowingCapacity(towingCapacity);
        other.setPersonnelCapacity(personnelCapacity);
        other.setBulkFuelCapacity(bulkFuelCapacity);
        other.setPayloadCapacity(payloadCapacity);
        other.setTakeCoverMod(takeCoverMod);
        other.setHasTurret(hasTurret);
        other.setHasOpenTop(hasOpenTop);
        other.setBattleWeight(battleWeight);
        other.setFrontArmor(frontArmor);
        other.setSideArmor(sideArmor);
        other.setFlag(flags);
        other.setRearArmor(rearArmor);
        other.setTopArmor(topArmor);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        VehicleModel ours = new VehicleModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(null);
        ours.setWidth(width);
        ours.setHeight(height);
        ours.setLength(length);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        ours.getArmaments().addAll(armaments);
        ours.setType(null);
        ours.setFuelCapacity(fuelCapacity);
        ours.setMaxRoadSpeed(maxRoadSpeed);
        ours.setNormalRoadSpeed(normalRoadSpeed);
        ours.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        ours.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        ours.setMaxFuelConsumption(maxFuelConsumption);
        ours.setNormalFuelConsumption(normalFuelConsumption);
        ours.setRonsonability(ronsonability);
        ours.setMaxGradient(maxGradient);
        ours.setMaxFordingDepth(maxFordingDepth);
        ours.setMaxTrenchWidth(maxTrenchWidth);
        ours.setTowingCapacity(towingCapacity);
        ours.setPersonnelCapacity(personnelCapacity);
        ours.setBulkFuelCapacity(bulkFuelCapacity);
        ours.setPayloadCapacity(payloadCapacity);
        ours.setTakeCoverMod(takeCoverMod);
        ours.setHasTurret(hasTurret);
        ours.setHasOpenTop(hasOpenTop);
        ours.setBattleWeight(battleWeight);
        ours.setFrontArmor(frontArmor);
        ours.setSideArmor(sideArmor);
        ours.setRearArmor(rearArmor);
        ours.setTopArmor(topArmor);
        ours.setFlag((Flag[]) null);

        VehicleModel other = new VehicleModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setPictureId(pictureId);
        other.setPictureFilename(null);
        other.setWidth(width);
        other.setHeight(height);
        other.setLength(length);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        armaments.clear();
        armaments.add(new ArmamentModel());
        other.getArmaments().addAll(armaments);
        other.setType(null);
        other.setFuelCapacity(fuelCapacity);
        other.setMaxRoadSpeed(maxRoadSpeed);
        other.setNormalRoadSpeed(normalRoadSpeed);
        other.setMaxCrossCountrySpeed(maxCrossCountrySpeed);
        other.setNormalCrossCountrySpeed(normalCrossCountrySpeed);
        other.setMaxFuelConsumption(maxFuelConsumption);
        other.setNormalFuelConsumption(normalFuelConsumption);
        other.setRonsonability(ronsonability);
        other.setMaxGradient(maxGradient);
        other.setMaxFordingDepth(maxFordingDepth);
        other.setMaxTrenchWidth(maxTrenchWidth);
        other.setTowingCapacity(towingCapacity);
        other.setPersonnelCapacity(personnelCapacity);
        other.setBulkFuelCapacity(bulkFuelCapacity);
        other.setPayloadCapacity(payloadCapacity);
        other.setTakeCoverMod(takeCoverMod);
        other.setHasTurret(hasTurret);
        other.setHasOpenTop(hasOpenTop);
        other.setBattleWeight(battleWeight);
        other.setFrontArmor(frontArmor);
        other.setSideArmor(sideArmor);
        other.setFlag((Flag[]) null);
        other.setRearArmor(rearArmor);
        other.setTopArmor(topArmor);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        VehicleModel ours = new VehicleModel();
        ours.setId(id);

        VehicleModel other = new VehicleModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        VehicleModel ours = new VehicleModel();
        ours.setId(id);

        VehicleModel other = new VehicleModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}