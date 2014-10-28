package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.*;

/**
 * Created by Mario on 28/10/2014.
 */
public class PerformanceModel implements PojoJFXModel<Performance> {
    private final ObjectProperty<AmmoLoadModel> ammoLoad = new SimpleObjectProperty<>();
    private final IntegerProperty minRange = new SimpleIntegerProperty();
    private final FloatProperty slowROF = new SimpleFloatProperty();
    private final FloatProperty normalROF = new SimpleFloatProperty();
    private final FloatProperty rapidROF = new SimpleFloatProperty();
    private final IntegerProperty burstRadius = new SimpleIntegerProperty();
    private final FloatProperty shellWeight = new SimpleFloatProperty();
    private final ObservableList<RangeItemModel> ranges = FXCollections.observableArrayList();
    private final ObjectProperty<FireType> fireType = new SimpleObjectProperty<FireType>();

    public AmmoLoadModel getAmmoLoad() {
        return ammoLoad.get();
    }

    public ObjectProperty<AmmoLoadModel> ammoLoadProperty() {
        return ammoLoad;
    }

    public void setAmmoLoad(AmmoLoadModel ammoLoad) {
        this.ammoLoad.set(ammoLoad);
    }

    public int getMinRange() {
        return minRange.get();
    }

    public IntegerProperty minRangeProperty() {
        return minRange;
    }

    public void setMinRange(int minRange) {
        this.minRange.set(minRange);
    }

    public float getSlowROF() {
        return slowROF.get();
    }

    public FloatProperty slowROFProperty() {
        return slowROF;
    }

    public void setSlowROF(float slowROF) {
        this.slowROF.set(slowROF);
    }

    public float getNormalROF() {
        return normalROF.get();
    }

    public FloatProperty normalROFProperty() {
        return normalROF;
    }

    public void setNormalROF(float normalROF) {
        this.normalROF.set(normalROF);
    }

    public float getRapidROF() {
        return rapidROF.get();
    }

    public FloatProperty rapidROFProperty() {
        return rapidROF;
    }

    public void setRapidROF(float rapidROF) {
        this.rapidROF.set(rapidROF);
    }

    public int getBurstRadius() {
        return burstRadius.get();
    }

    public IntegerProperty burstRadiusProperty() {
        return burstRadius;
    }

    public void setBurstRadius(int burstRadius) {
        this.burstRadius.set(burstRadius);
    }

    public float getShellWeight() {
        return shellWeight.get();
    }

    public FloatProperty shellWeightProperty() {
        return shellWeight;
    }

    public void setShellWeight(float shellWeight) {
        this.shellWeight.set(shellWeight);
    }

    public ObservableList<RangeItemModel> getRanges() {
        return ranges;
    }

    public FireType getFireType() {
        return fireType.get();
    }

    public ObjectProperty<FireType> fireTypeProperty() {
        return fireType;
    }

    public void setFireType(FireType fireType) {
        this.fireType.set(fireType);
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
        for (RangeItemModel rangeItemModel : ranges) {
            rangeTable.getRangeItem().add(rangeItemModel.getPojo());
        }
        performance.setRangeTable(rangeTable);
        performance.setFireType(fireType.get());
        return performance;
    }

    @Override
    public void setPojo(Performance pojo) {
        AmmoLoadModel ammoLoadModel = new AmmoLoadModel();
        ammoLoadModel.setPojo(pojo.getAmmo());
        ammoLoad.set(ammoLoadModel);
        minRange.set(pojo.getMinRange());
        ROF rof = pojo.getRof();
        slowROF.set(rof.getSlow());
        normalROF.set(rof.getNormal());
        rapidROF.set(rof.getRapid());
        burstRadius.set(pojo.getBurstRadius());
        shellWeight.set(pojo.getShellWeight());
        for (RangeItem rangeItem : pojo.getRangeTable().getRangeItem()) {
            RangeItemModel rangeItemModel = new RangeItemModel();
            rangeItemModel.setPojo(rangeItem);
            ranges.add(rangeItemModel);
        }
        fireType.set(pojo.getFireType());
    }
}
