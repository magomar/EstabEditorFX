package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.estabeditorfx.data.jaxb.*;

/**
 * Model wrapper for the {@code Performance} class
 *
 * @author Mario
 * @author Heine
 */
public class PerformanceModel implements PojoAdapter<Performance> {
    private final ObjectProperty<AmmoLoadModel> ammoLoad = new SimpleObjectProperty<>();
    private final IntegerProperty minRange = new SimpleIntegerProperty();
    private final DoubleProperty slowROF = new SimpleDoubleProperty();
    private final DoubleProperty normalROF = new SimpleDoubleProperty();
    private final DoubleProperty rapidROF = new SimpleDoubleProperty();
    private final IntegerProperty burstRadius = new SimpleIntegerProperty();
    private final DoubleProperty shellWeight = new SimpleDoubleProperty();
    private final ObservableList<RangeItemModel> ranges = FXCollections.observableArrayList();
    private final ObjectProperty<FireType> fireType = new SimpleObjectProperty<>();

    public PerformanceModel() {
    }

    public PerformanceModel(Performance performance) {
        initialize(performance);
    }

    @Override
    public Performance getPojo() {
        Performance performance = new Performance();
        performance.setAmmo(ammoLoad.get() != null ? ammoLoad.get().getPojo() : new AmmoLoadModel().getPojo());
        performance.setMinRange(minRange.get());
        ROF rof = new ROF();
        rof.setSlow(slowROF.get());
        rof.setNormal(normalROF.get());
        rof.setRapid(rapidROF.get());
        performance.setRof(rof);
        performance.setBurstRadius(burstRadius.get());
        performance.setShellWeight(shellWeight.get());
        RangeTable rangeTable = new RangeTable();
        if (ranges.isEmpty()) rangeTable.getRangeItem().add(new RangeItem());
        else ranges.stream().map(RangeItemModel::getPojo).forEach(rangeTable.getRangeItem()::add);
        performance.setRangeTable(rangeTable);
        performance.setFireType(fireType.get() != null ? fireType.get() : FireType.APER);
        return performance;
    }

    @Override
    public void initialize(Performance pojo) {
        AmmoLoadModel ammoLoadModel = new AmmoLoadModel(pojo.getAmmo());
        ammoLoad.set(ammoLoadModel);
        minRange.set(pojo.getMinRange());
        ROF rof = pojo.getRof();
        slowROF.set(rof.getSlow());
        normalROF.set(rof.getNormal());
        rapidROF.set(rof.getRapid());
        burstRadius.set(pojo.getBurstRadius());
        shellWeight.set(pojo.getShellWeight());
        ranges.clear();
        pojo.getRangeTable().getRangeItem().stream().map(RangeItemModel::new).forEach(ranges::add);
        fireType.set(pojo.getFireType());
    }

    public AmmoLoadModel getAmmoLoad() {
        return ammoLoad.get();
    }

    public void setAmmoLoad(AmmoLoadModel ammoLoad) {
        this.ammoLoad.set(ammoLoad);
    }

    public ObjectProperty<AmmoLoadModel> ammoLoadProperty() {
        return ammoLoad;
    }

    public int getMinRange() {
        return minRange.get();
    }

    public void setMinRange(int minRange) {
        this.minRange.set(minRange);
    }

    public IntegerProperty minRangeProperty() {
        return minRange;
    }

    public double getSlowROF() {
        return slowROF.get();
    }

    public void setSlowROF(double slowROF) {
        this.slowROF.set(slowROF);
    }

    public DoubleProperty slowROFProperty() {
        return slowROF;
    }

    public double getNormalROF() {
        return normalROF.get();
    }

    public void setNormalROF(double normalROF) {
        this.normalROF.set(normalROF);
    }

    public DoubleProperty normalROFProperty() {
        return normalROF;
    }

    public double getRapidROF() {
        return rapidROF.get();
    }

    public void setRapidROF(double rapidROF) {
        this.rapidROF.set(rapidROF);
    }

    public DoubleProperty rapidROFProperty() {
        return rapidROF;
    }

    public int getBurstRadius() {
        return burstRadius.get();
    }

    public void setBurstRadius(int burstRadius) {
        this.burstRadius.set(burstRadius);
    }

    public IntegerProperty burstRadiusProperty() {
        return burstRadius;
    }

    public double getShellWeight() {
        return shellWeight.get();
    }

    public void setShellWeight(double shellWeight) {
        this.shellWeight.set(shellWeight);
    }

    public DoubleProperty shellWeightProperty() {
        return shellWeight;
    }

    public ObservableList<RangeItemModel> getRanges() {
        return ranges;
    }

    public FireType getFireType() {
        return fireType.get();
    }

    public void setFireType(FireType fireType) {
        this.fireType.set(fireType);
    }

    public ObjectProperty<FireType> fireTypeProperty() {
        return fireType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerformanceModel that = (PerformanceModel) o;

        return ammoLoad.equals(that.ammoLoad);

    }

    @Override
    public int hashCode() {
        return ammoLoad.hashCode();
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PerformanceModel that = (PerformanceModel) o;
//
//        if (getAmmoLoad() != (that.getAmmoLoad())) return false;
//        if (getBurstRadius() != (that.getBurstRadius())) return false;
//        if ((getFireType() != null ? !getFireType().equals(that.getFireType()) : that.getFireType() != null))
//            return false;
//        if (getMinRange() != (that.getMinRange())) return false;
//        if (getNormalROF() != (that.getNormalROF())) return false;
//        if (getRapidROF() != (that.getRapidROF())) return false;
//        if (getShellWeight() != (that.getShellWeight())) return false;
//        if (getSlowROF() != (that.getSlowROF())) return false;
//        if (that.getRanges().size() != ranges.size() || !ranges.containsAll(that.getRanges()))
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getAmmoLoad() != null ? getAmmoLoad().hashCode() : 0;
//        result = 31 * result + getMinRange();
//        result = (int) (31 * result + getSlowROF());
//        result = (int) (31 * result + getNormalROF());
//        result = (int) (31 * result + getRapidROF());
//        result = 31 * result + getBurstRadius();
//        result = (int) (31 * result + getShellWeight());
//        result = 31 * result + ranges.stream().mapToInt(RangeItemModel::hashCode).sum();
//        result = 31 * result + (getFireType() != null ? getFireType().hashCode() : 0);
//        return result;
//    }
}
