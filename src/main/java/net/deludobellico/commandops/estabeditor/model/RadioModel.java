package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.Radio;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Radio} class
 *
 * @author Mario
 * @author Heine
 */
public class RadioModel extends AbstractElementModel<RadioModel> implements PojoJFXModel<Radio> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final List<Flag> flags = FXCollections.observableArrayList();

    public RadioModel(Radio radio) {
        initialize(radio);
    }

    public RadioModel() {

    }

    @Override
    public Radio getPojo() {
        Radio radio = new Radio();
        radio.setId(id.get());
        radio.setName(name.get());
        return radio;
    }

    @Override
    public void initialize(Radio pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, RadioModel> map) {
        Radio copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new RadioModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, RadioModel> map) {
        Radio copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new RadioModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, RadioModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<RadioModel> collection) {
        collection.add(this);
    }

    @Override
    public RadioModel createNewInMap(Map<Integer, RadioModel> map) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void removeFromMap(Map<Integer, RadioModel> map) {
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
        return Radio.class;
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
        if (!(o instanceof RadioModel)) return false;

        RadioModel that = (RadioModel) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return true;
    }

}
