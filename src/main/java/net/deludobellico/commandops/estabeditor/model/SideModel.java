package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.Insignia;
import net.deludobellico.commandops.estabeditor.data.jaxb.Side;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Mario on 29/10/2014.
 */
public class SideModel implements ElementModel<SideModel>, PojoJFXModel<Side> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final DoubleProperty basicsConsumptionRate = new SimpleDoubleProperty();
    private final IntegerProperty defaultEnemyAperFp = new SimpleIntegerProperty();
    private final IntegerProperty defaultEnemyAarmFp = new SimpleIntegerProperty();
    private final ObservableList<NationModel> nation = FXCollections.observableArrayList();
    private List<Flag> flags = FXCollections.observableArrayList();

    public SideModel(Side side) {
        setPojo(side);
    }

    public SideModel() {

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
        nation.stream().map(NationModel::getPojo).forEach(side.getNation()::add);
        side.getFlags().addAll(flags);
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
        flags.addAll(pojo.getFlags());
        pojo.getNation().stream()
                .map(NationModel::new)
                .forEach(nation::add);
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, SideModel> map) {
        Side copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        map.put(copy.getId(), new SideModel(copy));
    }

    @Override
    public void copyToMap(Map<Integer, SideModel> map) {
        Side copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new SideModel(copy));
    }

    @Override
    public void insertInToMap(Map<Integer, SideModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<SideModel> collection) {
        collection.add(this);
    }

    @Override
    public SideModel createNewInMap(Map<Integer, SideModel> modelMap) {
        throw new UnsupportedOperationException("Method not implemented");
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

    @Override
    public List<Flag> getFlags() {
        return flags;
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

    @Override
    public String toString() {
        return name.get();
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
        if (o == null || getClass() != o.getClass()) return false;

        SideModel that = (SideModel) o;
//        if (!id.equals(that.id)) return false;
        if (getBasicsConsumptionRate() != (that.getBasicsConsumptionRate())) return false;
        if (getDefaultEnemyAarmFp() != (that.getDefaultEnemyAarmFp())) return false;
        if (getDefaultEnemyAperFp() != (that.getDefaultEnemyAperFp())) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getLargeInsignia() != (that.getLargeInsignia())) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSmallInsignia() != (that.getSmallInsignia())) return false;
        if (that.getFlags().size() != flags.size() || !flags.containsAll(that.getFlags()))
            return false;
        if (that.getNation().size() != nation.size() || !nation.containsAll(that.getNation()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        // id
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + flags.stream().mapToInt(Flag::hashCode).sum();
        result = 31 * result + nation.stream().mapToInt(NationModel::hashCode).sum();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getLargeInsignia();
        result = 31 * result + getSmallInsignia();
        result = (int) (31 * result + getBasicsConsumptionRate());
        result = 31 * result + getDefaultEnemyAperFp();
        result = 31 * result + getDefaultEnemyAarmFp();
        return result;
    }
}
