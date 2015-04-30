package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.Image;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Image} class
 *
 * @author Mario
 * @author Heine
 */
public class ImageModel extends AbstractElementModel<ImageModel> implements PojoAdapter<Image> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty fileId = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private List<Flag> flags = FXCollections.observableArrayList();

    public ImageModel(Image image) {
        initialize(image);
    }

    public ImageModel() {

    }

    @Override
    public Image getPojo() {
        Image image = new Image();
        image.setId(id.get());
        image.setFileId(fileId.get());
        return image;
    }

    @Override
    public void initialize(Image pojo) {
        id.set(pojo.getId());
        fileId.set(pojo.getFileId());
        name.set(pojo.getFileId());
    }

    @Override
    public void cloneToMap(int i, Map<Integer, ImageModel> map) {
        Image copy = getPojo();
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new ImageModel(copy));
    }

    @Override
    public void hardCopyToMap(Map<Integer, ImageModel> map) {
        Image copy = getPojo();
        copy.getFlags().add((Flag.COPY));
        map.put(copy.getId(), new ImageModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, ImageModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<ImageModel> collection) {
        collection.add(this);
    }

    @Override
    public ImageModel createNewInMap(Map<Integer, ImageModel> map) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void removeFromMap(Map<Integer, ImageModel> map) {
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
        return Image.class;
    }

    @Override
    public List<Flag> getFlags() {
        return flags;
    }

    public String getFileId() {
        return fileId.get();
    }

    public void setFileId(String fileId) {
        this.fileId.set(fileId);
    }

    public StringProperty fileIdProperty() {
        return fileId;
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
        if (!(o instanceof ImageModel)) return false;

        ImageModel that = (ImageModel) o;
        if (getFileId() != null ? !getFileId().equals(that.getFileId()) : that.getFileId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return true;
    }
}
