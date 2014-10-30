package net.deludobellico.stabeditor.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import net.deludobellico.stabeditor.data.jaxb.FuelConsumption;

/**
 * Created by Mario on 29/10/2014.
 */
public class FuelConsumptionModel implements PojoJFXModel<FuelConsumption> {
    private final DoubleProperty maxFuelConsumption = new SimpleDoubleProperty();
    private final DoubleProperty normalFuelConsumption = new SimpleDoubleProperty();

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

    public double getMax() {
        return maxFuelConsumption.get();
    }

    public void setMax(double maxFuelConsumption) {
        this.maxFuelConsumption.set(maxFuelConsumption);
    }

    public DoubleProperty maxProperty() {
        return maxFuelConsumption;
    }

    public double getNormal() {
        return normalFuelConsumption.get();
    }

    public DoubleProperty normalProperty() {
        return normalFuelConsumption;
    }

    public void setNormalFuelConsumption(double normalFuelConsumption) {
        this.normalFuelConsumption.set(normalFuelConsumption);
    }

}
