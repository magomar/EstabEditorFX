package net.deludobellico.stabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.Insignia;
import net.deludobellico.stabeditor.data.jaxb.Nation;
import net.deludobellico.stabeditor.data.jaxb.Service;

/**
 * Created by Mario on 29/10/2014.
 */
public class NationModel implements PojoJFXModel<Nation> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty nationality = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final ObservableList<ServiceModel> service = FXCollections.observableArrayList();

    @Override
    public Nation getPojo() {
        Nation nation = new Nation();
        nation.setId(id.get());
        nation.setName(name.get());
        nation.setDescription(description.get());
        nation.setNationality(nationality.get());
        Insignia largeIns = new Insignia();
        largeIns.setId(largeInsignia.get());
        nation.setLargeInsignia(largeIns);
        Insignia smallIns = new Insignia();
        smallIns.setId(smallInsignia.get());
        nation.setSmallInsignia(largeIns);
        service.stream().forEach((serviceModel) -> {
            nation.getService().add(serviceModel.getPojo());
        });
        return nation;
    }

    @Override
    public void setPojo(Nation pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        nationality.set(pojo.getNationality());
        largeInsignia.set(pojo.getLargeInsignia().getId());
        smallInsignia.set(pojo.getSmallInsignia().getId());
        pojo.getService().stream().map((s) -> {
            ServiceModel serviceModel = new ServiceModel();
            serviceModel.setPojo(s);
            return serviceModel;
        }).forEach((serviceModel) -> {
            service.add(serviceModel);
        });
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getNationality() {
        return nationality.get();
    }

    public StringProperty nationalityProperty() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public int getLargeInsignia() {
        return largeInsignia.get();
    }

    public IntegerProperty largeInsigniaProperty() {
        return largeInsignia;
    }

    public void setLargeInsignia(int largeInsignia) {
        this.largeInsignia.set(largeInsignia);
    }

    public int getSmallInsignia() {
        return smallInsignia.get();
    }

    public IntegerProperty smallInsigniaProperty() {
        return smallInsignia;
    }

    public void setSmallInsignia(int smallInsignia) {
        this.smallInsignia.set(smallInsignia);
    }

    public ObservableList<ServiceModel> getService() {
        return service;
    }
}

