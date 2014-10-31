package net.deludobellico.stabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.stabeditor.data.jaxb.AmmoQty;

/**
 * Created by Heine on 10/31/2014.
 */
public class AmmoQtyModel implements PojoJFXModel<AmmoQty> {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();

    public AmmoQtyModel(AmmoQty pojo) {
        setPojo(pojo);
    }

    @Override
    public AmmoQty getPojo() {
        return null;
    }

    @Override
    public void setPojo(AmmoQty pojo) {

    }

    public Integer getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getQty() {
        return qty.get();
    }

    public IntegerProperty qtyProperty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty.set(qty);
    }
}
