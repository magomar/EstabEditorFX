package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.Insignia;
import net.deludobellico.stabeditor.data.jaxb.Side;

/**
 * Created by Mario on 29/10/2014.
 */
public class SideModel implements PojoJFXModel<Side> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty largeInsignia = new SimpleIntegerProperty();
    private final IntegerProperty smallInsignia = new SimpleIntegerProperty();
    private final FloatProperty basicsConsumptionRate = new SimpleFloatProperty();
    private final IntegerProperty defaultEnemyAperFp = new SimpleIntegerProperty();
    private final IntegerProperty defaultEnemyAarmFp = new SimpleIntegerProperty();
    private final ObservableList<NationModel> nation = FXCollections.observableArrayList();

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

    public float getBasicsConsumptionRate() {
        return basicsConsumptionRate.get();
    }

    public FloatProperty basicsConsumptionRateProperty() {
        return basicsConsumptionRate;
    }

    public void setBasicsConsumptionRate(float basicsConsumptionRate) {
        this.basicsConsumptionRate.set(basicsConsumptionRate);
    }

    public int getDefaultEnemyAperFp() {
        return defaultEnemyAperFp.get();
    }

    public IntegerProperty defaultEnemyAperFpProperty() {
        return defaultEnemyAperFp;
    }

    public void setDefaultEnemyAperFp(int defaultEnemyAperFp) {
        this.defaultEnemyAperFp.set(defaultEnemyAperFp);
    }

    public int getDefaultEnemyAarmFp() {
        return defaultEnemyAarmFp.get();
    }

    public IntegerProperty defaultEnemyAarmFpProperty() {
        return defaultEnemyAarmFp;
    }

    public void setDefaultEnemyAarmFp(int defaultEnemyAarmFp) {
        this.defaultEnemyAarmFp.set(defaultEnemyAarmFp);
    }

    public ObservableList<NationModel> getNation() {
        return nation;
    }

    @Override
    public Side getPojo() {
        Side side = new Side();
        side.setId(id.get());
        side.setName(name.get());
        side.setDescription(description.get());
        Insignia insignia = new Insignia();
        insignia.setId(largeInsignia.get());
        side.setLargeInsignia(insignia);
        insignia.setId(smallInsignia.get());
        side.setSmallInsignia(insignia);
        side.setBasicsConsumptionRate(basicsConsumptionRate.get());
        side.setDefaultEnemyAperFp(defaultEnemyAperFp.get());
        side.setDefaultEnemyAarmFp(defaultEnemyAarmFp.get());
        nation.stream().forEach((n) -> {
            side.getNation().add(n.getPojo());
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
        pojo.getNation().stream().map((n) -> {
            NationModel nationModel = new NationModel();
            nationModel.setPojo(n);
            return nationModel;
        }).forEach((nationModel) -> {
            nation.add(nationModel);
        });
    }
}
