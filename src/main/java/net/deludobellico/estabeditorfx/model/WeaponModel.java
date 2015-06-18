package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.estabeditorfx.data.jaxb.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Weapon} class
 *
 * @author Mario
 * @author Heine
 */
public class WeaponModel extends AbstractGraphicalElementModel<WeaponModel> implements PojoAdapter<Weapon> {
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
        initialize(weapon);
    }

    public WeaponModel() {

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
        Weapon pojo = new Weapon();
        pojo.setId(id.get());
        pojo.setName(name.get() != null ? name.get() : "");
        pojo.setDescription(description.get() != null ? description.get() : "");
        Picture p = new Picture();
        p.setId(pictureId.get());
        pojo.setPicture(p);
        pojo.setPictureFilename(pictureFilename.get() != null ? pictureFilename.get() : "");
        WeaponSize weaponSize = new WeaponSize();
        weaponSize.setWidth(1.0);
        weaponSize.setHeight(1.0);
        weaponSize.setLength(1.0);
        weaponSize.setWeight(weight.get());
        pojo.setSize(weaponSize);
        pojo.setCrew(crew.get());
        pojo.setReliability(reliability.get());
        pojo.setType(type.get() != null ? type.get() : WeaponType.GUN);
        pojo.setSingleShot(PojoAdapter.booleanToYesNo(singleShot.get()));
        pojo.setPrimaryRole(primaryRole.get() != null ? primaryRole.get() : PrimaryRole.ANTI_PERSONNEL);
        pojo.setCalibre(calibre.get());
        pojo.setMuzzleVelocity(muzzleVelocity.get());
        pojo.setMustDeployToFire(PojoAdapter.booleanToYesNo(mustDeployToFire.get()));
        pojo.setArmaments("");
        pojo.setPerformanceList(new PerformanceList());
        if (performances.isEmpty()) pojo.getPerformanceList().getPerformance().add(new PerformanceModel().getPojo());
        else
            performances.stream().map(PerformanceModel::getPojo).forEach(pojo.getPerformanceList().getPerformance()::add);
        pojo.getFlags().addAll(flags);
        return pojo;
    }

    @Override
    public void initialize(Weapon pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        pictureId.set(pojo.getPicture().getId());
        pictureFilename.set(pojo.getPictureFilename());
        weight.set(pojo.getSize().getWeight());
        crew.set(pojo.getCrew());
        reliability.set(pojo.getReliability());
        type.set(pojo.getType());
        singleShot.set(PojoAdapter.yesNoToBoolean(pojo.getSingleShot()));
        primaryRole.set(pojo.getPrimaryRole());
        calibre.set(pojo.getCalibre());
        muzzleVelocity.set(pojo.getMuzzleVelocity());
        mustDeployToFire.set(PojoAdapter.yesNoToBoolean(pojo.getMustDeployToFire()));
        pojo.getPerformanceList().getPerformance().stream().map(PerformanceModel::new).forEach(performances::add);
        flags.addAll(pojo.getFlags());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, WeaponModel> map) {
        Weapon copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new WeaponModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, WeaponModel> map) {
        Weapon copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new WeaponModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, WeaponModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<WeaponModel> collection) {
        collection.add(this);
    }

    @Override
    public WeaponModel createNewInMap(Map<Integer, WeaponModel> map) {
        WeaponModel newElement = ElementModelFactory.createWeapon();
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, WeaponModel> map) {
        map.remove(getId());
    }

    @Override
    public Class getPojoClass() {
        return Weapon.class;
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
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponModel that = (WeaponModel) o;

        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getPictureFilename() != null ? !getPictureFilename().equals(that.getPictureFilename()) : that.getPictureFilename() != null)
            return false;
        if (getPrimaryRole() != null ? !getPrimaryRole().equals(that.getPrimaryRole()) : that.getPrimaryRole() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;


        if (getCalibre() != that.getCalibre()) return false;
        if (getCrew() != that.getCrew()) return false;
        if (getMustDeployToFire() != that.getMustDeployToFire()) return false;
        if (getMuzzleVelocity() != that.getMuzzleVelocity()) return false;

        if (getPictureId() != that.getPictureId()) return false;
        if (getReliability() != that.getReliability()) return false;
        if (getSingleShot() != that.getSingleShot()) return false;
        if (getWeight() != that.getWeight()) return false;
        if (that.getPerformances().size() != performances.size() || !performances.containsAll(that.getPerformances()))
            return false;
        return true;
    }
}
