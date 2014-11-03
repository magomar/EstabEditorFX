package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.JFXModelUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Mario on 28/10/2014.
 */
public class WeaponModel implements ElementModel, PojoJFXModel<Weapon> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();
    private final DoubleProperty weight = new SimpleDoubleProperty();
    private final IntegerProperty crew = new SimpleIntegerProperty();
    private final DoubleProperty reliability = new SimpleDoubleProperty();
    private final ObjectProperty<WeaponType> type = new SimpleObjectProperty<>();
    private final BooleanProperty singleShot = new SimpleBooleanProperty();
    private final ObjectProperty<PrimaryRole> primaryRole = new SimpleObjectProperty<>();
    private final DoubleProperty calibre = new SimpleDoubleProperty();
    private final IntegerProperty muzzleVelocity = new SimpleIntegerProperty();
    private final BooleanProperty mustDeployToFire = new SimpleBooleanProperty();
    private final ObservableList<PerformanceModel> performances = FXCollections.observableArrayList();

    public WeaponModel(Weapon weapon) {
        setPojo(weapon);
    }

    public static Map<FireType, PerformanceModel> getFireTypeMap(WeaponModel weapon) {
        Map<FireType, PerformanceModel> fireTypeMap = new HashMap<>(FireType.values().length);
        if (fireTypeMap.isEmpty()) {
            for (FireType f : FireType.values()) fireTypeMap.put(f, null);
            for (PerformanceModel p : weapon.getPerformances()) fireTypeMap.put(p.getFireType(), p);
        }
        return fireTypeMap;
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
        weaponSize.setWidth((double) 1.0);
        weaponSize.setHeight((double) 1.0);
        weaponSize.setLength((double) 1.0);
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
        weapon.setPerformanceList(new PerformanceList());
        performances.stream().map(PerformanceModel::getPojo).forEach(pp -> weapon.getPerformanceList().getPerformance().add(pp));
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
        pojo.getPerformanceList().getPerformance().stream().map(PerformanceModel::new).forEach(p -> performances.add(p));
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public int getPictureId() {
        return pictureId.get();
    }

    public void setPictureId(int pictureId) {
        this.pictureId.set(pictureId);
    }

    public IntegerProperty pictureIdProperty() {
        return pictureId;
    }

    public String getPictureFilename() {
        return pictureFilename.get();
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename.set(pictureFilename);
    }

    public StringProperty pictureFilenameProperty() {
        return pictureFilename;
    }

    public double getWeight() {
        return weight.get();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public int getCrew() {
        return crew.get();
    }

    public void setCrew(int crew) {
        this.crew.set(crew);
    }

    public IntegerProperty crewProperty() {
        return crew;
    }

    public double getReliability() {
        return reliability.get();
    }

    public void setReliability(double reliability) {
        this.reliability.set(reliability);
    }

    public DoubleProperty reliabilityProperty() {
        return reliability;
    }

    public WeaponType getType() {
        return type.get();
    }

    public void setType(WeaponType type) {
        this.type.set(type);
    }

    public ObjectProperty<WeaponType> typeProperty() {
        return type;
    }

    public boolean getSingleShot() {
        return singleShot.get();
    }

    public void setSingleShot(boolean singleShot) {
        this.singleShot.set(singleShot);
    }

    public BooleanProperty singleShotProperty() {
        return singleShot;
    }

    public PrimaryRole getPrimaryRole() {
        return primaryRole.get();
    }

    public void setPrimaryRole(PrimaryRole primaryRole) {
        this.primaryRole.set(primaryRole);
    }

    public ObjectProperty<PrimaryRole> primaryRoleProperty() {
        return primaryRole;
    }

    public double getCalibre() {
        return calibre.get();
    }

    public void setCalibre(double calibre) {
        this.calibre.set(calibre);
    }

    public DoubleProperty calibreProperty() {
        return calibre;
    }

    public int getMuzzleVelocity() {
        return muzzleVelocity.get();
    }

    public void setMuzzleVelocity(int muzzleVelocity) {
        this.muzzleVelocity.set(muzzleVelocity);
    }

    public IntegerProperty muzzleVelocityProperty() {
        return muzzleVelocity;
    }

    public boolean getMustDeployToFire() {
        return mustDeployToFire.get();
    }

    public void setMustDeployToFire(boolean mustDeployToFire) {
        this.mustDeployToFire.set(mustDeployToFire);
    }

    public BooleanProperty mustDeployToFireProperty() {
        return mustDeployToFire;
    }

    public ObservableList<PerformanceModel> getPerformances() {
        return performances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponModel that = (WeaponModel) o;

        if (calibre != null ? !calibre.equals(that.calibre) : that.calibre != null) return false;
        if (crew != null ? !crew.equals(that.crew) : that.crew != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (mustDeployToFire != null ? !mustDeployToFire.equals(that.mustDeployToFire) : that.mustDeployToFire != null)
            return false;
        if (muzzleVelocity != null ? !muzzleVelocity.equals(that.muzzleVelocity) : that.muzzleVelocity != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (performances != null ? !performances.equals(that.performances) : that.performances != null) return false;
        if (pictureFilename != null ? !pictureFilename.equals(that.pictureFilename) : that.pictureFilename != null)
            return false;
        if (pictureId != null ? !pictureId.equals(that.pictureId) : that.pictureId != null) return false;
        if (primaryRole != null ? !primaryRole.equals(that.primaryRole) : that.primaryRole != null) return false;
        if (reliability != null ? !reliability.equals(that.reliability) : that.reliability != null) return false;
        if (singleShot != null ? !singleShot.equals(that.singleShot) : that.singleShot != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureId != null ? pictureId.hashCode() : 0);
        result = 31 * result + (pictureFilename != null ? pictureFilename.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (crew != null ? crew.hashCode() : 0);
        result = 31 * result + (reliability != null ? reliability.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (singleShot != null ? singleShot.hashCode() : 0);
        result = 31 * result + (primaryRole != null ? primaryRole.hashCode() : 0);
        result = 31 * result + (calibre != null ? calibre.hashCode() : 0);
        result = 31 * result + (muzzleVelocity != null ? muzzleVelocity.hashCode() : 0);
        result = 31 * result + (mustDeployToFire != null ? mustDeployToFire.hashCode() : 0);
        result = 31 * result + (performances != null ? performances.hashCode() : 0);
        return result;
    }
}
