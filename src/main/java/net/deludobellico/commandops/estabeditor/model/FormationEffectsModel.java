package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.FormationEffects;
import net.deludobellico.commandops.estabeditor.data.jaxb.FormationType;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code FormationEffects} class
 *
 * @author Mario
 * @author Heine
 */
public class FormationEffectsModel extends AbstractElementModel<FormationEffectsModel> implements PojoAdapter<FormationEffects> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private List<Flag> flags = FXCollections.observableArrayList();

    public FormationEffectsModel(FormationEffects formationEffects) {
        initialize(formationEffects);
    }

    public FormationEffectsModel() {

    }

    @Override
    public FormationEffects getPojo() {
        FormationEffects formationEffects = new FormationEffects();
        formationEffects.setId(id.get());
        formationEffects.setType(FormationType.fromValue(name.get()));
        return formationEffects;
    }

    @Override
    public void initialize(FormationEffects pojo) {
        id.set(pojo.getId());
        name.set(pojo.getType().value());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, FormationEffectsModel> map) {
        FormationEffects copy = getPojo();
        copy.setId(newId);
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new FormationEffectsModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, FormationEffectsModel> map) {
        FormationEffects copy = getPojo();
        copy.getFlags().add((Flag.COPY));
        map.put(copy.getId(), new FormationEffectsModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, FormationEffectsModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<FormationEffectsModel> collection) {
        collection.add(this);
    }

    @Override
    public FormationEffectsModel createNewInMap(Map<Integer, FormationEffectsModel> map) {
//        FormationEffectsModel newElement = ElementModelFactory.create()
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void removeFromMap(Map<Integer, FormationEffectsModel> map) {
        map.remove(getId());
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
    public Class getPojoClass() {
        return FormationEffects.class;
    }

    @Override
    public List<Flag> getFlags() {
        return flags;
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

    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormationEffectsModel that = (FormationEffectsModel) o;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return true;
    }
}
