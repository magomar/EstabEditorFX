package net.deludobellico.stabeditor.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import net.deludobellico.stabeditor.data.jaxb.RangeItem;

/**
 * Created by Mario on 28/10/2014.
 */
public class RangeItemModel implements PojoJFXModel<RangeItem> {
    private final  IntegerProperty range = new SimpleIntegerProperty();
    private final  FloatProperty accuracy = new SimpleFloatProperty();
    private final  FloatProperty armourPenetration = new SimpleFloatProperty();

    @Override
    public RangeItem getPojo() {
        RangeItem rangeItem = new RangeItem();
        rangeItem.setRange(range.get());
        rangeItem.setAccuracy(accuracy.get());
        rangeItem.setArmourPenetration(armourPenetration.get());
        return rangeItem;
    }

    @Override
    public void setPojo(RangeItem pojo) {
        range.set(pojo.getRange());
        accuracy.set(pojo.getAccuracy());
        armourPenetration.set(pojo.getArmourPenetration());
    }

    public int getRange() {
        return range.get();
    }

    public IntegerProperty rangeProperty() {
        return range;
    }

    public void setRange(int range) {
        this.range.set(range);
    }

    public float getAccuracy() {
        return accuracy.get();
    }

    public FloatProperty accuracyProperty() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy.set(accuracy);
    }

    public float getArmourPenetration() {
        return armourPenetration.get();
    }

    public FloatProperty armourPenetrationProperty() {
        return armourPenetration;
    }

    public void setArmourPenetration(float armourPenetration) {
        this.armourPenetration.set(armourPenetration);
    }


}
