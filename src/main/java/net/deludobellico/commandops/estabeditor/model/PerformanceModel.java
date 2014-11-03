package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.FireType;
import net.deludobellico.commandops.estabeditor.data.jaxb.Performance;
import net.deludobellico.commandops.estabeditor.data.jaxb.ROF;
import net.deludobellico.commandops.estabeditor.data.jaxb.RangeTable;

/**
 * Created by Mario on 28/10/2014.
 */
public class PerformanceModel implements PojoJFXModel<Performance> {
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
        setPojo(performance);
    }

    @Override
    public Performance getPojo() {
        Performance performance = new Performance();
        performance.setAmmo(ammoLoad.get().getPojo());
        performance.setMinRange(minRange.get());
        ROF rof = new ROF();
        rof.setSlow(slowROF.get());
        rof.setNormal(normalROF.get());
        rof.setRapid(rapidROF.get());
        performance.setRof(rof);
        performance.setBurstRadius(burstRadius.get());
        performance.setShellWeight(shellWeight.get());
        RangeTable rangeTable = new RangeTable();

        ranges.stream().map(RangeItemModel::getPojo).forEach(r -> rangeTable.getRangeItem().add(r));
        performance.setRangeTable(rangeTable);
        performance.setFireType(fireType.get());
        return performance;
    }

    @Override
    public void setPojo(Performance pojo) {
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
        pojo.getRangeTable().getRangeItem().stream().map(RangeItemModel::new).forEach(r -> ranges.add(r));
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
        if (!(o instanceof PerformanceModel)) return false;

        PerformanceModel that = (PerformanceModel) o;

        if (ammoLoad != null ? !ammoLoad.equals(that.ammoLoad) : that.ammoLoad != null) return false;
        if (burstRadius != null ? !burstRadius.equals(that.burstRadius) : that.burstRadius != null) return false;
        if (fireType != null ? !fireType.equals(that.fireType) : that.fireType != null) return false;
        if (minRange != null ? !minRange.equals(that.minRange) : that.minRange != null) return false;
        if (normalROF != null ? !normalROF.equals(that.normalROF) : that.normalROF != null) return false;
        if (ranges != null ? !ranges.equals(that.ranges) : that.ranges != null) return false;
        if (rapidROF != null ? !rapidROF.equals(that.rapidROF) : that.rapidROF != null) return false;
        if (shellWeight != null ? !shellWeight.equals(that.shellWeight) : that.shellWeight != null) return false;
        if (slowROF != null ? !slowROF.equals(that.slowROF) : that.slowROF != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ammoLoad != null ? ammoLoad.hashCode() : 0;
        result = 31 * result + (minRange != null ? minRange.hashCode() : 0);
        result = 31 * result + (slowROF != null ? slowROF.hashCode() : 0);
        result = 31 * result + (normalROF != null ? normalROF.hashCode() : 0);
        result = 31 * result + (rapidROF != null ? rapidROF.hashCode() : 0);
        result = 31 * result + (burstRadius != null ? burstRadius.hashCode() : 0);
        result = 31 * result + (shellWeight != null ? shellWeight.hashCode() : 0);
        result = 31 * result + (ranges != null ? ranges.hashCode() : 0);
        result = 31 * result + (fireType != null ? fireType.hashCode() : 0);
        return result;
    }
}
