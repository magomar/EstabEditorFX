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
    private final DoubleProperty basicsConsumptionRate = new SimpleDoubleProperty();
    private final IntegerProperty defaultEnemyAperFp = new SimpleIntegerProperty();
    private final IntegerProperty defaultEnemyAarmFp = new SimpleIntegerProperty();
    private final ObservableList<NationModel> nation = FXCollections.observableArrayList();

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
        nation.clear();
        pojo.getNation().stream().map((n) -> {
            NationModel nationModel = new NationModel();
            nationModel.setPojo(n);
            return nationModel;
        }).forEach((nationModel) -> {
            nation.add(nationModel);
        });
    }
}
