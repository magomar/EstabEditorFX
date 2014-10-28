package net.deludobellico.stabeditor.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.stabeditor.data.jaxb.Picture;

/**
 * Created by Mario on 26/10/2014.
 */
public class PictureModel implements PojoJFXModel<Picture> {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty pictureFilename = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPictureFilename() {
        return pictureFilename.get();
    }

    public StringProperty pictureFilenameProperty() {
        return pictureFilename;
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename.set(pictureFilename);
    }

    @Override
    public Picture getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(Picture pojo) {
        // TODO
    }
}
