package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.ForceQty;
import net.deludobellico.estabeditorfx.data.jaxb.ForceQty;

/**
 * Created by Mario on 06/06/2015.
 */
public class ForceQtyModel implements PojoAdapter<ForceQty> {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();


    public ForceQtyModel(ForceQty pojo) {
        initialize(pojo);
    }

    public ForceQtyModel() {
    }


    @Override
    public ForceQty getPojo() {
        ForceQty pojo = new ForceQty();
        pojo.setForceObjectId(id.get());
        pojo.setName(name.get());
        pojo.setQty(qty.get());
        return pojo;
    }

    @Override
    public void initialize(ForceQty pojo) {
        id.set(pojo.getForceObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    public int getId() {
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

    public void setQty(int qty) {
        this.qty.set(qty);
    }
}
