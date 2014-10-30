package net.deludobellico.stabeditor.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import net.deludobellico.stabeditor.data.jaxb.FuelConsumption;
import net.deludobellico.stabeditor.data.jaxb.SpeedData;

/**
 * Created by Mario on 29/10/2014.
 */
public class FuelConsumptionModel implements PojoJFXModel<FuelConsumption> {
    private final FloatProperty maxFuelConsumption = new SimpleFloatProperty();
    private final FloatProperty normalFuelConsumption = new SimpleFloatProperty();

    public FuelConsumptionModel(FuelConsumption fuelConsumption) {
        setPojo(fuelConsumption);
    }

    @Override
    public FuelConsumption getPojo() {
        FuelConsumption fuelConsumption = new FuelConsumption();
        fuelConsumption.setMax(maxFuelConsumption.getValue());
        fuelConsumption.setNormal(normalFuelConsumption.getValue());
        return fuelConsumption;
    }

    @Override
    public void setPojo(FuelConsumption pojo) {
        maxFuelConsumption.set(pojo.getMax());
        normalFuelConsumption.set(pojo.getNormal());
    }

    public float getMax() {
        return maxFuelConsumption.get();
    }

    public FloatProperty maxProperty() {
        return maxFuelConsumption;
    }

    public void setMax(float maxFuelConsumption) {
        this.maxFuelConsumption.set(maxFuelConsumption);
    }

    public float getNormal() {
        return normalFuelConsumption.get();
    }

    public FloatProperty normalProperty() {
        return normalFuelConsumption;
    }

    public void setNormalFuelConsumption(float normalFuelConsumption) {
        this.normalFuelConsumption.set(normalFuelConsumption);
    }

}
