package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.FormationEffects;
import net.deludobellico.commandops.estabeditor.data.jaxb.FormationType;

import java.util.List;

/**
 * Created by Mario on 04/11/2014.
 */
public class FormationEffectsModel implements ElementModel, PojoJFXModel<FormationEffects> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();

    public FormationEffectsModel(FormationEffects formationEffects) {
        setPojo(formationEffects);
    }

    @Override
    public FormationEffects getPojo() {
        FormationEffects formationEffects = new FormationEffects();
        formationEffects.setId(id.get());
        formationEffects.setType(FormationType.fromValue(name.get()));
        return formationEffects;
    }

    @Override
    public void setPojo(FormationEffects pojo) {
        id.set(pojo.getId());
        name.set(pojo.getType().value());
    }

    @Override
    public int getId() {
        return id.get();
    }

    @Override
    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public List<Flag> getFlags() {
        return null;
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public StringProperty nameProperty() {
        return name;
    }

}
