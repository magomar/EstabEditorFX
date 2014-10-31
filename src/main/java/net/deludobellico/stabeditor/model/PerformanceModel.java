package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.FireType;
import net.deludobellico.stabeditor.data.jaxb.Performance;
import net.deludobellico.stabeditor.data.jaxb.ROF;
import net.deludobellico.stabeditor.data.jaxb.RangeTable;

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

}
