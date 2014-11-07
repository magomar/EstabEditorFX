package net.deludobellico.commandops.test.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.VehicleType;
import net.deludobellico.commandops.estabeditor.model.ArmamentModel;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VehicleModelTest {
    VehicleModel ours = new VehicleModel();
    int id = 10;
    String name = "VehicleModel Test";
    String description = "VehicleModel Desc";
    int pictureId = 100;
    String pictureFilename = "VehiclePicture";
    /* */
    double width = 100.1;
    double height = 100.2;
    double length = 100.3;
    double weight = 100.4;
    /* end VehicleSize */
    int crew = 5;
    double reliability = 11.2;
    List<ArmamentModel> armaments = FXCollections.observableArrayList();
    VehicleType type = VehicleType.ARMOURED_CAR;
    double fuelCapacity = 12.2;
    double maxRoadSpeed = 12.5;
    double normalRoadSpeed = 346.3;
    double maxCrossCountrySpeed = 34.2;
    double normalCrossCountrySpeed = 345.2;
    double maxFuelConsumption = 7.4;
    double normalFuelConsumption = 32.2;
    // end VehicleSpeeds
    double ronsonability = 6.3;
    int maxGradient = 6;
    int maxFordingDepth = 9;
    int maxTrenchWidth = 8;
    double towingCapacity = 321.2;
    int personnelCapacity = 5;
    double bulkFuelCapacity = 23.;
    double payloadCapacity = 5.2;
    double takeCoverMod = 6.3;
    boolean hasTurret = false;
    boolean hasOpenTop = false;
    double battleWeight = 35.2;
    double frontArmor = 34.2;
    double sideArmor = 65.2;
    double rearArmor = 46.3;
    double topArmor = 654.2;
    Flag[] flags = new Flag[]{Flag.NEW, Flag.COPY};

    @Before
    public void setUp() throws Exception {
        ours = new VehicleModel();
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
    }

    @Test
    public void testEquals() throws Exception {
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
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
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
        assertEquals(ours.hashCode(), other.hashCode());
    }
}