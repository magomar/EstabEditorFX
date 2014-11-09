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
 * Created by Mario on 04/11/2014.
 */
public class RadioModel implements ElementModel<RadioModel>, PojoJFXModel<Radio> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private List<Flag> flags = FXCollections.observableArrayList();

    public RadioModel(Radio radio) {
        setPojo(radio);
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
    public void setPojo(Radio pojo) {
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
    public void copyToMap(Map<Integer, RadioModel> map) {
        Radio copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new RadioModel(copy));
    }

    @Override
    public void insertInToMap(Map<Integer, RadioModel> map) {
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
    public String toString() {
        return name.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadioModel)) return false;

        RadioModel that = (RadioModel) o;

//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (that.getFlags().size() != flags.size() || !flags.containsAll(that.getFlags()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + flags.stream().mapToInt(Flag::hashCode).sum();
        return result;
    }
}
