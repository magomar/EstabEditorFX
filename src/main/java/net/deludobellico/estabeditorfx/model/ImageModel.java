package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.Image;

import java.util.Collection;
import java.util.Map;

/**
 * Model wrapper for the {@code Image} class
 *
 * @author Mario
 * @author Heine
 */
public class ImageModel extends AbstractElementModel<ImageModel> implements PojoAdapter<Image> {
    private final StringProperty fileName = new SimpleStringProperty();

    public ImageModel(Image image) {
        initialize(image);
    }

    public ImageModel() {

    }

    @Override
    public Image getPojo() {
        Image image = new Image();
        image.setId(id.get());
        image.setFileId(fileName.get());
        return image;
    }

    @Override
    public void initialize(Image pojo) {
        id.set(pojo.getId());
        String imageFilename = pojo.getFileId();
        fileName.set(imageFilename);
        name.set(imageFilename.substring(0, imageFilename.lastIndexOf('.')));
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
        ImageModel newElement = ElementModelFactory.createImage();
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, ImageModel> map) {
        map.remove(getId());
    }

    @Override
    public Class getPojoClass() {
        return Image.class;
    }


    public String getFileName() {
        return fileName.get();
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }


    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageModel)) return false;

        ImageModel that = (ImageModel) o;
        if (getFileName() != null ? !getFileName().equals(that.getFileName()) : that.getFileName() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return true;
    }
}
