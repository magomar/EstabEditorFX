package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.AmmoQty;

/**
 * Model wrapper for the {@code AmmoQty} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoQtyModel implements PojoAdapter<AmmoQty> {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();

    public AmmoQtyModel(AmmoQty pojo) {
        initialize(pojo);
    }

    public AmmoQtyModel() {
    }

    @Override
    public AmmoQty getPojo() {
        AmmoQty pojo = new AmmoQty();
        pojo.setAmmoObjectId(id.get());
        pojo.setName(name.get());
        pojo.setQty(qty.get());
        return pojo;
    }

    @Override
    public void initialize(AmmoQty pojo) {
        id.set(pojo.getAmmoObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
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

    public void setQty(Integer qty) {
        this.qty.set(qty);
    }

    public IntegerProperty qtyProperty() {
        return qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmmoQtyModel)) return false;

        AmmoQtyModel that = (AmmoQtyModel) o;
        //if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getQty() != that.getQty()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 62 * (getName() != null ? getName().hashCode() : 0);
//        result = 31 * result + getId();
        result = 31 * result + getQty();
        return result;
    }
}
