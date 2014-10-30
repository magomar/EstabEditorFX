package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.JFXModelUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 28/10/2014.
 */
public class WeaponModel implements AssetModel, PojoJFXModel<Weapon> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();
    private final FloatProperty weight = new SimpleFloatProperty();
    private final IntegerProperty crew = new SimpleIntegerProperty();
    private final FloatProperty reliability = new SimpleFloatProperty();
    private final ObjectProperty<WeaponType> type = new SimpleObjectProperty<>();
    private final BooleanProperty singleShot = new SimpleBooleanProperty();
    private final ObjectProperty<PrimaryRole> primaryRole = new SimpleObjectProperty<>();
    private final FloatProperty calibre = new SimpleFloatProperty();
    private final IntegerProperty muzzleVelocity = new SimpleIntegerProperty();
    private final BooleanProperty mustDeployToFire = new SimpleBooleanProperty();
    private final ObservableList<PerformanceModel> performances = FXCollections.observableArrayList();

    public WeaponModel(Weapon weapon) {
        setPojo(weapon);
    }

    @Override
    public Weapon getPojo() {
        Weapon weapon = new Weapon();
        weapon.setId(id.get());
        weapon.setName(name.get());
        weapon.setDescription(description.get());
        Picture p = new Picture();
        p.setId(pictureId.get());
        weapon.setPicture(p);
        weapon.setPictureFilename(pictureFilename.get());
        WeaponSize weaponSize = new WeaponSize();
        weaponSize.setWidth((float) 1.0);
        weaponSize.setHeight((float) 1.0);
        weaponSize.setLength((float) 1.0);
        weaponSize.setWeight(weight.get());
        weapon.setSize(weaponSize);
        weapon.setCrew(crew.get());
        weapon.setReliability(reliability.get());
        weapon.setType(type.get());
        weapon.setSingleShot(JFXModelUtil.booleanToYesNo(singleShot.get()));
        weapon.setPrimaryRole(primaryRole.get());
        weapon.setCalibre(calibre.get());
        weapon.setMuzzleVelocity(muzzleVelocity.get());
        weapon.setMustDeployToFire(JFXModelUtil.booleanToYesNo(mustDeployToFire.get()));
        PerformanceList pl = new PerformanceList();
        performances.stream().forEach((performanceModel) -> {
            pl.getPerformance().add(performanceModel.getPojo());
        });
        return weapon;
    }

    @Override
    public void setPojo(Weapon pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        pictureId.set(pojo.getPicture().getId());
        pictureFilename.set(pojo.getPictureFilename());
        weight.set(pojo.getSize().getWeight());
        crew.set(pojo.getCrew());
        reliability.set(pojo.getReliability());
        type.set(pojo.getType());
        singleShot.set(JFXModelUtil.yesNoToBoolean(pojo.getSingleShot()));
        primaryRole.set(pojo.getPrimaryRole());
        calibre.set(pojo.getCalibre());
        muzzleVelocity.set(pojo.getMuzzleVelocity());
        mustDeployToFire.set(JFXModelUtil.yesNoToBoolean(pojo.getMustDeployToFire()));
        // Random null pointer exception
        if (pojo.getPerformanceList() != null) {
            if (pojo.getPerformanceList().getPerformance() != null) {
                performances.clear();
                pojo.getPerformanceList().getPerformance().stream().map((performance) -> new PerformanceModel(performance)).forEach((performanceModel) -> {
                    performances.add(performanceModel);
                });
            }
        }
    }

    public Integer getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getPictureId() {
        return pictureId.get();
    }

    public IntegerProperty pictureIdProperty() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId.set(pictureId);
    }

    public String getPictureFilename() {
        return pictureFilename.get();
    }

    public StringProperty pictureFilenameProperty() {
        return pictureFilename;
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename.set(pictureFilename);
    }

    public float getWeight() {
        return weight.get();
    }

    public FloatProperty weightProperty() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }

    public int getCrew() {
        return crew.get();
    }

    public IntegerProperty crewProperty() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew.set(crew);
    }

    public float getReliability() {
        return reliability.get();
    }

    public FloatProperty reliabilityProperty() {
        return reliability;
    }

    public void setReliability(float reliability) {
        this.reliability.set(reliability);
    }

    public WeaponType getType() {
        return type.get();
    }

    public ObjectProperty<WeaponType> typeProperty() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type.set(type);
    }

    public boolean getSingleShot() {
        return singleShot.get();
    }

    public BooleanProperty singleShotProperty() {
        return singleShot;
    }

    public void setSingleShot(boolean singleShot) {
        this.singleShot.set(singleShot);
    }

    public PrimaryRole getPrimaryRole() {
        return primaryRole.get();
    }

    public ObjectProperty<PrimaryRole> primaryRoleProperty() {
        return primaryRole;
    }

    public void setPrimaryRole(PrimaryRole primaryRole) {
        this.primaryRole.set(primaryRole);
    }

    public float getCalibre() {
        return calibre.get();
    }

    public FloatProperty calibreProperty() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre.set(calibre);
    }

    public int getMuzzleVelocity() {
        return muzzleVelocity.get();
    }

    public IntegerProperty muzzleVelocityProperty() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(int muzzleVelocity) {
        this.muzzleVelocity.set(muzzleVelocity);
    }

    public boolean getMustDeployToFire() {
        return mustDeployToFire.get();
    }

    public BooleanProperty mustDeployToFireProperty() {
        return mustDeployToFire;
    }

    public void setMustDeployToFire(boolean mustDeployToFire) {
        this.mustDeployToFire.set(mustDeployToFire);
    }

    public ObservableList<PerformanceModel> getPerformances() {
        return performances;
    }

    public static Map<FireType, Boolean> getFireTypeMap(WeaponModel weapon) {
        Map<FireType, Boolean> fireTypeMap = new HashMap<>();
        if (fireTypeMap.isEmpty()) {
            for (FireType f : FireType.values()) fireTypeMap.put(f, false);
            for (PerformanceModel p : weapon.getPerformances()) fireTypeMap.put(p.getFireType(), true);
        }
        return fireTypeMap;
    }
}
