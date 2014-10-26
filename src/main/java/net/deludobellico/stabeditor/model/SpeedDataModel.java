//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class SpeedDataModel {

    private final  FloatProperty max = new SimpleFloatProperty();
    private final  FloatProperty normal = new SimpleFloatProperty();
    private final  FloatProperty maxFuelConsumption = new SimpleFloatProperty();
    private final  FloatProperty normalFuelConsumption = new SimpleFloatProperty();

    public float getMax() {
        return max.get();
    }

    public FloatProperty maxProperty() {
        return max;
    }

    public void setMax(float max) {
        this.max.set(max);
    }

    public float getNormal() {
        return normal.get();
    }

    public FloatProperty normalProperty() {
        return normal;
    }

    public void setNormal(float normal) {
        this.normal.set(normal);
    }

    public float getMaxFuelConsumption() {
        return maxFuelConsumption.get();
    }

    public FloatProperty maxFuelConsumptionProperty() {
        return maxFuelConsumption;
    }

    public void setMaxFuelConsumption(float maxFuelConsumption) {
        this.maxFuelConsumption.set(maxFuelConsumption);
    }

    public float getNormalFuelConsumption() {
        return normalFuelConsumption.get();
    }

    public FloatProperty normalFuelConsumptionProperty() {
        return normalFuelConsumption;
    }

    public void setNormalFuelConsumption(float normalFuelConsumption) {
        this.normalFuelConsumption.set(normalFuelConsumption);
    }
}
