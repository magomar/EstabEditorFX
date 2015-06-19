package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.Insignia;
import net.deludobellico.estabeditorfx.data.jaxb.Side;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.Side;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Side} class
 *
 * @author Mario
 * @author Heine
 */
public class SideModel extends AbstractElementModel<SideModel> implements PojoAdapter<Side> {
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final DoubleProperty basicsConsumptionRate = new SimpleDoubleProperty();
    private final IntegerProperty defaultEnemyAperFp = new SimpleIntegerProperty();
    private final IntegerProperty defaultEnemyAarmFp = new SimpleIntegerProperty();
    private final ObservableList<NationModel> nation = FXCollections.observableArrayList();

    public SideModel() {

    }

    public SideModel(Side side) {
        initialize(side);
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
    public void initialize(Side pojo) {
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
                .forEach(n -> {
                    n.setSide(this);
                    nation.add(n);
                });
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
    public void hardCopyToMap(Map<Integer, SideModel> map) {
        Side copy = getPojo();
        copy.getFlags().add(Flag.COPY);
        map.put(copy.getId(), new SideModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, SideModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<SideModel> collection) {
        collection.add(this);
    }

    @Override
    public SideModel createNewInMap(Map<Integer, SideModel> map) {
        SideModel newElement = ElementModelFactory.createSide();
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, SideModel> map) {
        map.remove(getId());
    }

    @Override
    public Class getPojoClass() {
        return Side.class;
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
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SideModel that = (SideModel) o;
        if (getBasicsConsumptionRate() != (that.getBasicsConsumptionRate())) return false;
        if (getDefaultEnemyAarmFp() != (that.getDefaultEnemyAarmFp())) return false;
        if (getDefaultEnemyAperFp() != (that.getDefaultEnemyAperFp())) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getLargeInsignia() != (that.getLargeInsignia())) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSmallInsignia() != (that.getSmallInsignia())) return false;
        if (that.getNation().size() != nation.size() || !nation.containsAll(that.getNation()))
            return false;
        return true;
    }
}
