package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Service;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;

/**
 * Created by Mario on 29/10/2014.
 */
public class ServiceModel implements PojoJFXModel<Service> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final ObservableList<RankModel> rankList = FXCollections.observableArrayList();
    private final transient ObjectProperty<RGBColorModel> backgroundColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> backgroundDarkColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> backgroundLightColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<RGBColorModel> designationColor = new SimpleObjectProperty<>();
    private final transient ObjectProperty<SymbolColor> symbolColor = new SimpleObjectProperty<>();
    private final ObservableList<ForceModel> force = FXCollections.observableArrayList();

    @Override
    public Service getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(Service pojo) {
        // TODO
    }

    // TODO getters & setters, but first do the pojo methods
}
