package net.deludobellico.commandops.estabeditor.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.NationModel;
import net.deludobellico.commandops.estabeditor.model.ServiceModel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NationModelTest {

    private String name;
    private String description;
    private int id;
    private int largeInsignia;
    private int smallInsignia;
    private final List<ServiceModel> services = FXCollections.observableArrayList();
    private final Flag[] flags = new Flag[]{Flag.REMOVE, Flag.COPY};


    @Test
    public void testCompareTo() throws Exception {
        NationModel ours = new NationModel();
        ours.setName(name);
        ours.setId(id);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        ours.getService().addAll(services);

        NationModel other = new NationModel();
        other.setName(name);
        other.setId(id);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        other.getService().addAll(services);
        assertEquals(true, ours.compareTo(other));
    }
    
    @Test
    public void testCompareToDifferentIDs() throws Exception {
        NationModel ours = new NationModel();
        ours.setName(name);
        ours.setId(id);
        ours.setDescription(description);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        ours.getService().addAll(services);

        NationModel other = new NationModel();
        other.setName(name);
        other.setId(id + 2);
        other.setDescription(description);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        other.getService().addAll(services);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        NationModel ours = new NationModel();
        ours.setName(null);
        ours.setId(id);
        ours.setDescription(null);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setFlag((Flag[]) null);
        services.clear();
        services.add(new ServiceModel());
        ours.getService().addAll(services);

        NationModel other = new NationModel();
        other.setName(null);
        other.setId(id);
        other.setDescription(null);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setFlag((Flag[]) null);
        services.clear();
        services.add(new ServiceModel());
        other.getService().addAll(services);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        NationModel ours = new NationModel();
        ours.setId(id);

        NationModel other = new NationModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        NationModel ours = new NationModel();
        ours.setId(id);

        NationModel other = new NationModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}