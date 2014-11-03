package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Insignia;
import net.deludobellico.commandops.estabeditor.data.jaxb.Nation;

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

    public NationModel(Nation nation) {
        setPojo(nation);
    }

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
        service.stream().forEach((serviceModel) -> nation.getService().add(serviceModel.getPojo()));
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
        service.clear();
        pojo.getService().stream().map(ServiceModel::new).forEach((serviceModel) -> service.add(serviceModel));
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getNationality() {
        return nationality.get();
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public StringProperty nationalityProperty() {
        return nationality;
    }

    public int getLargeInsignia() {
        return largeInsignia.get();
    }

    public void setLargeInsignia(int largeInsignia) {
        this.largeInsignia.set(largeInsignia);
    }

    public IntegerProperty largeInsigniaProperty() {
        return largeInsignia;
    }

    public int getSmallInsignia() {
        return smallInsignia.get();
    }

    public void setSmallInsignia(int smallInsignia) {
        this.smallInsignia.set(smallInsignia);
    }

    public IntegerProperty smallInsigniaProperty() {
        return smallInsignia;
    }

    public ObservableList<ServiceModel> getService() {
        return service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NationModel)) return false;

        NationModel that = (NationModel) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (largeInsignia != null ? !largeInsignia.equals(that.largeInsignia) : that.largeInsignia != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (smallInsignia != null ? !smallInsignia.equals(that.smallInsignia) : that.smallInsignia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (largeInsignia != null ? largeInsignia.hashCode() : 0);
        result = 31 * result + (smallInsignia != null ? smallInsignia.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        return result;
    }
}

