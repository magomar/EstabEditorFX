package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import net.deludobellico.stabeditor.data.jaxb.Ammo;

/**
 * Created by Mario on 28/10/2014.
 */
public class AmmoModel implements PojoJFXModel<Ammo>{
    private final  IntegerProperty id = new SimpleIntegerProperty();
    private final  StringProperty name = new SimpleStringProperty();
    private final  StringProperty description = new SimpleStringProperty();
    private final  IntegerProperty minOrderQty = new SimpleIntegerProperty();
    private final  FloatProperty minOrderWeight = new SimpleFloatProperty();

    @Override
    public Ammo getPojo() {
        Ammo a = new Ammo();
        a.setId(id.get());
        a.setName(name.get());
        a.setDescription(description.get());
        a.setMinOrderQty(minOrderQty.get());
        a.setMinOrderWeight(minOrderWeight.get());
        return null;
    }

    @Override
    public void setPojo(Ammo pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        minOrderQty.set(pojo.getMinOrderQty());
        minOrderWeight.set(pojo.getMinOrderWeight());
    }
}
