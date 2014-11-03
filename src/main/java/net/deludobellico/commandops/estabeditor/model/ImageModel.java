package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Image;

/**
 * Created by Mario on 03/11/2014.
 */
public class ImageModel implements PojoJFXModel<Image> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty fileId = new SimpleStringProperty();

    public ImageModel(Image image) {
        setPojo(image);
    }

    @Override
    public Image getPojo() {
        Image image = new Image();
        image.setId(id.get());
        image.setFileId(fileId.get());
        return image;
    }

    @Override
    public void setPojo(Image pojo) {
        id.set(pojo.getId());
        fileId.set(pojo.getFileId());
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

    public String getFileId() {
        return fileId.get();
    }

    public StringProperty fileIdProperty() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId.set(fileId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageModel)) return false;

        ImageModel that = (ImageModel) o;

        if (fileId != null ? !fileId.equals(that.fileId) : that.fileId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        return result;
    }
}
