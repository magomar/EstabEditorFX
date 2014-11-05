package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Insignia;
import net.deludobellico.commandops.estabeditor.data.jaxb.Side;

/**
 * Created by Mario on 29/10/2014.
 */
public class SideModel implements ElementModel, PojoJFXModel<Side> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final DoubleProperty basicsConsumptionRate = new SimpleDoubleProperty();
    private final IntegerProperty defaultEnemyAperFp = new SimpleIntegerProperty();
    private final IntegerProperty defaultEnemyAarmFp = new SimpleIntegerProperty();
    private final ObservableList<NationModel> nation = FXCollections.observableArrayList();

    public SideModel(Side side) {
        setPojo(side);
    }

    @Override
    public Side getPojo() {
        Side side = new Side();
        side.setId(id.get());
        side.setName(name.get());
        side.setDescription(description.get());
        Insignia largeIns = new Insignia();
        largeIns.setId(largeInsignia.get());
        side.setLargeInsignia(largeIns);
        Insignia smallIns = new Insignia();
        smallIns.setId(smallInsignia.get());
        side.setSmallInsignia(largeIns);
        side.setBasicsConsumptionRate(basicsConsumptionRate.get());
        side.setDefaultEnemyAperFp(defaultEnemyAperFp.get());
        side.setDefaultEnemyAarmFp(defaultEnemyAarmFp.get());
        nation.stream().forEach((nationModel) -> {
            side.getNation().add(nationModel.getPojo());
        });
        return side;
    }

    @Override
    public void setPojo(Side pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        largeInsignia.set(pojo.getLargeInsignia().getId());
        smallInsignia.set(pojo.getSmallInsignia().getId());
        basicsConsumptionRate.set(pojo.getBasicsConsumptionRate());
        defaultEnemyAperFp.set(pojo.getDefaultEnemyAperFp());
        defaultEnemyAarmFp.set(pojo.getDefaultEnemyAarmFp());
        nation.clear();
        pojo.getNation().stream()
                .map(NationModel::new)
                .forEach((nationModel) -> {
                    nation.add(nationModel);
                });
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

    public double getBasicsConsumptionRate() {
        return basicsConsumptionRate.get();
    }

    public void setBasicsConsumptionRate(double basicsConsumptionRate) {
        this.basicsConsumptionRate.set(basicsConsumptionRate);
    }

    public DoubleProperty basicsConsumptionRateProperty() {
        return basicsConsumptionRate;
    }

    public int getDefaultEnemyAperFp() {
        return defaultEnemyAperFp.get();
    }

    public void setDefaultEnemyAperFp(int defaultEnemyAperFp) {
        this.defaultEnemyAperFp.set(defaultEnemyAperFp);
    }

    public IntegerProperty defaultEnemyAperFpProperty() {
        return defaultEnemyAperFp;
    }

    public int getDefaultEnemyAarmFp() {
        return defaultEnemyAarmFp.get();
    }

    public void setDefaultEnemyAarmFp(int defaultEnemyAarmFp) {
        this.defaultEnemyAarmFp.set(defaultEnemyAarmFp);
    }

    public IntegerProperty defaultEnemyAarmFpProperty() {
        return defaultEnemyAarmFp;
    }

    public ObservableList<NationModel> getNation() {
        return nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SideModel)) return false;

        SideModel sideModel = (SideModel) o;

        if (basicsConsumptionRate != null ? !basicsConsumptionRate.equals(sideModel.basicsConsumptionRate) : sideModel.basicsConsumptionRate != null)
            return false;
        if (defaultEnemyAarmFp != null ? !defaultEnemyAarmFp.equals(sideModel.defaultEnemyAarmFp) : sideModel.defaultEnemyAarmFp != null)
            return false;
        if (defaultEnemyAperFp != null ? !defaultEnemyAperFp.equals(sideModel.defaultEnemyAperFp) : sideModel.defaultEnemyAperFp != null)
            return false;
        if (description != null ? !description.equals(sideModel.description) : sideModel.description != null)
            return false;
        if (id != null ? !id.equals(sideModel.id) : sideModel.id != null) return false;
        if (largeInsignia != null ? !largeInsignia.equals(sideModel.largeInsignia) : sideModel.largeInsignia != null)
            return false;
        if (name != null ? !name.equals(sideModel.name) : sideModel.name != null) return false;
        if (nation != null ? !nation.equals(sideModel.nation) : sideModel.nation != null) return false;
        if (smallInsignia != null ? !smallInsignia.equals(sideModel.smallInsignia) : sideModel.smallInsignia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (largeInsignia != null ? largeInsignia.hashCode() : 0);
        result = 31 * result + (smallInsignia != null ? smallInsignia.hashCode() : 0);
        result = 31 * result + (basicsConsumptionRate != null ? basicsConsumptionRate.hashCode() : 0);
        result = 31 * result + (defaultEnemyAperFp != null ? defaultEnemyAperFp.hashCode() : 0);
        result = 31 * result + (defaultEnemyAarmFp != null ? defaultEnemyAarmFp.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        return result;
    }
}
