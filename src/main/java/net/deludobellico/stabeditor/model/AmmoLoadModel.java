package net.deludobellico.stabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.stabeditor.data.jaxb.AmmoLoad;

/**
 * Created by Mario on 28/10/2014.
 */
public class AmmoLoadModel implements PojoJFXModel<AmmoLoad> {
    private final IntegerProperty objectId = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty load = new SimpleIntegerProperty();

    @Override
    public AmmoLoad getPojo() {
        AmmoLoad ammoLoad = new AmmoLoad();
        ammoLoad.setObjectId(objectId.get());
        ammoLoad.setName(name.get());
        ammoLoad.setLoad(load.get());
        return ammoLoad;
    }

    @Override
    public void setPojo(AmmoLoad pojo) {
        objectId.set(pojo.getObjectId());
        name.set(pojo.getName());
        load.set(pojo.getLoad());
    }

    public int getObjectId() {
        return objectId.get();
    }

    public void setObjectId(int objectId) {
        this.objectId.set(objectId);
    }

    public IntegerProperty objectIdProperty() {
        return objectId;
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

    public int getLoad() {
        return load.get();
    }

    public void setLoad(int load) {
        this.load.set(load);
    }

    public IntegerProperty loadProperty() {
        return load;
    }

}
