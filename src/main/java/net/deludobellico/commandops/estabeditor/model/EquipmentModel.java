//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Equipment;


public class EquipmentModel implements PojoJFXModel<Equipment> {

    private final transient IntegerProperty equipmentObjectId = new SimpleIntegerProperty();
    private final transient StringProperty name = new SimpleStringProperty();
    private final transient IntegerProperty qty = new SimpleIntegerProperty();

    public EquipmentModel(Equipment pojo) {
        setPojo(pojo);
    }

    @Override
    public Equipment getPojo() {
        Equipment armament = new Equipment();
        armament.setEquipmentObjectId(equipmentObjectId.get());
        armament.setName(name.get());
        armament.setQty(qty.get());
        return armament;
    }

    @Override
    public void setPojo(Equipment pojo) {
        equipmentObjectId.set(pojo.getEquipmentObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    public int getEquipmentObjectId() {
        return equipmentObjectId.get();
    }

    public void setEquipmentObjectId(int equipmentObjectId) {
        this.equipmentObjectId.set(equipmentObjectId);
    }

    public IntegerProperty equipmentObjectIdProperty() {
        return equipmentObjectId;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getQty() {
        return qty.get();
    }

    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public IntegerProperty qtyProperty() {
        return qty;
    }

}
