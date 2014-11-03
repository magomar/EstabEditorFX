package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.RangeItem;

/**
 * Created by Mario on 28/10/2014.
 */
public class RangeItemModel implements PojoJFXModel<RangeItem> {
    private final IntegerProperty range = new SimpleIntegerProperty();
    private final DoubleProperty accuracy = new SimpleDoubleProperty();
    private final DoubleProperty armourPenetration = new SimpleDoubleProperty();

    public RangeItemModel() {

    }

    public RangeItemModel(RangeItem pojo) {
        setPojo(pojo);
    }

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

    public void setRange(int range) {
        this.range.set(range);
    }

    public IntegerProperty rangeProperty() {
        return range;
    }

    public double getAccuracy() {
        return accuracy.get();
    }

    public void setAccuracy(double accuracy) {
        this.accuracy.set(accuracy);
    }

    public DoubleProperty accuracyProperty() {
        return accuracy;
    }

    public double getArmourPenetration() {
        return armourPenetration.get();
    }

    public void setArmourPenetration(double armourPenetration) {
        this.armourPenetration.set(armourPenetration);
    }

    public DoubleProperty armourPenetrationProperty() {
        return armourPenetration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RangeItemModel)) return false;

        RangeItemModel that = (RangeItemModel) o;

        if (accuracy != null ? !accuracy.equals(that.accuracy) : that.accuracy != null) return false;
        if (armourPenetration != null ? !armourPenetration.equals(that.armourPenetration) : that.armourPenetration != null)
            return false;
        if (range != null ? !range.equals(that.range) : that.range != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = range != null ? range.hashCode() : 0;
        result = 31 * result + (accuracy != null ? accuracy.hashCode() : 0);
        result = 31 * result + (armourPenetration != null ? armourPenetration.hashCode() : 0);
        return result;
    }
}
