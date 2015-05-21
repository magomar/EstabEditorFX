package net.deludobellico.commandops.estabeditor.model;

import javafx.scene.paint.Color;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates new element models and keeps track of the maximum ID
 *
 * @author Mario
 * @author Heine
 */
public final class ElementModelFactory {
    private static Integer maxId = 3611;

    private ElementModelFactory() {
    }

    /**
     * Auto-increment of the maximum ID in use.
     * This method is synchronized to prevent inconsistencies.
     *
     * @return the maximum id in use
     */
    public static synchronized int incrementMaxId() {
        return ++maxId;
    }

    /**
     * Sets the maximum ID in use.
     * This method is synchronized to prevent inconsistencies.
     *
     * @param maxId id to set if it's greater than the current max ID.
     */
    public static synchronized void setMaxId(int maxId) {
        if (ElementModelFactory.maxId < maxId)
            ElementModelFactory.maxId = ++maxId;
    }

    /**
     * New created elements append their ID inside parentheses to their name.
     * In order to avoid having multiple IDs in the name, this method strips the last ID and appends the new one.
     *
     * @param name  string to format
     * @param newId to append
     * @return formatted name with the id inside parentheses
     */
    public static String formatName(String name, int newId) {
        Pattern p = Pattern.compile(" (\\#\\d+)");
        Matcher m = p.matcher(name);
        String oldId = "";
        while (m.find()) oldId = m.group();
        return String.format("%s #%d", name.replace(oldId, ""), newId);
    }

    /**
     * Creates a new VehicleModel instance.
     *
     * @return new vehicle model
     */
    public static VehicleModel createVehicle() {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(++maxId);
        vehicleModel.setName(ElementModelFactory.formatName("New Vehicle", vehicleModel.getId()));
        vehicleModel.setDescription("");
        vehicleModel.setPictureFilename("");
        vehicleModel.setType(VehicleType.CAR);
        vehicleModel.getFlags().add(Flag.NEW);
        return vehicleModel;
    }

    /**
     * Creates a new WeaponModel instance.
     *
     * @return new weapon model
     */
    public static WeaponModel createWeapon() {
        WeaponModel weaponModel = new WeaponModel();
        weaponModel.setId(++maxId);
        weaponModel.setName(ElementModelFactory.formatName("New Weapon", weaponModel.getId()));
        weaponModel.getFlags().add(Flag.NEW);
        return weaponModel;
    }

    /**
     * Creates a new AmmoModel instance.
     *
     * @return new ammo model
     */
    public static AmmoModel createAmmo() {
        AmmoModel ammoModel = new AmmoModel();
        ammoModel.setId(++maxId);
        ammoModel.setName(ElementModelFactory.formatName("New Ammo", ammoModel.getId()));
        ammoModel.getFlags().add(Flag.NEW);
        return ammoModel;
    }

    /**
     * Creates a new ImageModel instance.
     *
     * @return new image model
     */
    public static ImageModel createImage() {
        ImageModel imageModel = new ImageModel();
        imageModel.setId(++maxId);
        imageModel.setName(ElementModelFactory.formatName("New Image", imageModel.getId()));
        imageModel.getFlags().add(Flag.NEW);
        return imageModel;
    }

    public static ForceModel createForce(ServiceModel serviceModel) {
        ForceModel forceModel = new ForceModel();
        forceModel.setId(++maxId);
        forceModel.setName(ElementModelFactory.formatName("New Force", forceModel.getId()));
        forceModel.setDescription("");
        forceModel.getFlags().add(Flag.NEW);
        IconModel iconModel = new IconModel();
        iconModel.setBackgroundColor(serviceModel.getBackgroundColor());
        iconModel.setBackgroundDarkColor(serviceModel.getBackgroundDarkColor());
        iconModel.setBackgroundLightColor(serviceModel.getBackgroundLightColor());
        iconModel.setDesignationColor(serviceModel.getDesignationColor());
        iconModel.setSymbolColor(serviceModel.getSymbolColor());
        iconModel.setMilitarySymbol(IconModel.MilitarySymbol.values()[22]);
        iconModel.setPictureSymbol(PictureSymbol.INFANTRY);
        iconModel.setForceSizeIcon(ForceSize.COMPANY);
        iconModel.setIsHq(false);
        forceModel.setIcon(iconModel);
        forceModel.setType(ForceType.INFANTRY);
        forceModel.setSize(ForceSize.COMPANY);
        forceModel.setCombatClass(CombatClass.LINE);
        forceModel.setTargetClass(TargetClass.SOFT);
        forceModel.setInfantryValue(100);
        forceModel.setReconValue(10);
        forceModel.setEngineeringValue(0);
        forceModel.setMoveType(MoveType.FOOT);
        forceModel.setPersQty(100);
        forceModel.setStaffCapacity(4);
        forceModel.setBasicsQty(448.0);
        forceModel.setBasicsConsumptionRateModifier(1.0);
        forceModel.setCommanderRank(2);
        forceModel.setFuelQty(0.0);
        forceModel.setFuelLoad(10.0);
        forceModel.setMaxSpeed(6.5);
        forceModel.setNormalSpeed(5.4);
        forceModel.setDeployed(LocalTime.of(0, 0, 5));
        forceModel.setDugIn(LocalTime.of(0, 2, 0));
        forceModel.setEntrenched(LocalTime.of(2, 0, 0));
        forceModel.setFortified(LocalTime.of(1, 0, 0));
        forceModel.setReadyToFireDuration(LocalTime.of(0, 0, 0));
        forceModel.setReadyToBombardDuration(LocalTime.of(0, 0, 0));
        forceModel.setCanBombard(false);
        forceModel.setSubType(ForceSubtype.LEG_INFANTRY);
        forceModel.setService(serviceModel);
        return forceModel;
    }

    public static ServiceModel createService(NationModel nationModel) {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setId(++maxId);
        serviceModel.setName(ElementModelFactory.formatName("New Service", serviceModel.getId()));
        serviceModel.setDescription("");
        serviceModel.getFlags().add(Flag.NEW);
        serviceModel.setBackgroundColor(Color.rgb(156, 156, 156));
        serviceModel.setBackgroundDarkColor(Color.rgb(107, 107, 107));
        serviceModel.setBackgroundLightColor(Color.rgb(207, 207, 207));
        serviceModel.setDesignationColor(Color.rgb(0, 0, 0));
        serviceModel.setSymbolColor(SymbolColor.BLACK);
        serviceModel.setNation(nationModel);
        serviceModel.getRankList().addAll(SpanishRank.getRankModelList());
        serviceModel.setLargeInsignia(nationModel.getLargeInsignia());
        serviceModel.setSmallInsignia(nationModel.getSmallInsignia());
        serviceModel.setNation(nationModel);
        return serviceModel;
    }

    public static NationModel createNation(SideModel sideModel) {
        NationModel nationModel = new NationModel();
        nationModel.setId(++maxId);
        nationModel.setName(ElementModelFactory.formatName("New Nation", nationModel.getId()));
        nationModel.setDescription("");
        nationModel.getFlags().add(Flag.NEW);
        nationModel.setLargeInsignia(sideModel.getLargeInsignia());
        nationModel.setSmallInsignia(sideModel.getSmallInsignia());
        nationModel.setSide(sideModel);
        return nationModel;
    }

    public static SideModel createSide() {
        SideModel sideModel = new SideModel();
        sideModel.setId(++maxId);
        sideModel.setName(ElementModelFactory.formatName("New Side", sideModel.getId()));
        sideModel.setDescription("");
        sideModel.getFlags().add(Flag.NEW);
//        sideModel.setLargeInsignia(0);
//        sideModel.setSmallInsignia(0);
        sideModel.setBasicsConsumptionRate(5.0);
        sideModel.setDefaultEnemyAperFp(1);
        sideModel.setDefaultEnemyAarmFp(1);
        return sideModel;
    }


    enum SpanishRank {
        ALF("Alf", "Alférrez"),
        TEN("Ten", "Teniente"),
        CAP("Cap", "Capitán"),
        COM("Com", "Comandante"),
        TCOR("Ten Cor", "Teniente Coronel"),
        COR("Cor", "Coronel"),
        GBRIG("Gen Brig", "General de Brigada"),
        GDIV("Gen Div", "General de División"),
        TGEN("Ten Gen", "Teniente General"),
        GEJ("Gen Ej", "General de Ejército"),
        CG("CG", "Capitán General");
        final String name;
        final String fullName;

        SpanishRank(final String name, final String fullName) {
            this.name = name;
            this.fullName = fullName;
        }

        public String getFullName() {
            return fullName;
        }

        public String getName() {
            return name;
        }

        public static List<RankModel> getRankModelList() {
            List<RankModel> rankModels = new ArrayList<>(SpanishRank.values().length);
            for (SpanishRank rank : SpanishRank.values()) {
                RankModel rankModel  = new RankModel();
                rankModel.setIndex(rank.ordinal());
                rankModel.setShortName(rank.name);
                rankModel.setFullName(rank.fullName);
                rankModels.add(rankModel);
            }
            return rankModels;
        }
    }
}
