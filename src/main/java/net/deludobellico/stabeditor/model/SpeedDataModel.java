//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import net.deludobellico.stabeditor.data.jaxb.SpeedData;

public class SpeedDataModel implements PojoJFXModel<SpeedData> {

    private final DoubleProperty max = new SimpleDoubleProperty();
    private final DoubleProperty normal = new SimpleDoubleProperty();

    public SpeedDataModel(Double max, Double normal) {
        setMax(max);
        setNormal(normal);
    }

    @Override
    public SpeedData getPojo() {
        SpeedData speedData = new SpeedData();
        speedData.setMax(max.getValue());
        speedData.setNormal(normal.getValue());
        return speedData;
    }

    @Override
    public void setPojo(SpeedData pojo) {
        max.set(pojo.getMax());
        normal.set(pojo.getNormal());
    }

    public double getMax() {
        return max.get();
    }

    public void setMax(double max) {
        this.max.set(max);
    }

    public DoubleProperty maxProperty() {
        return max;
    }

    public double getNormal() {
        return normal.get();
    }

    public void setNormal(double normal) {
        this.normal.set(normal);
    }

    public DoubleProperty normalProperty() {
        return normal;
    }

}
