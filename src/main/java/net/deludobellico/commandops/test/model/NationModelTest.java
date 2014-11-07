package net.deludobellico.commandops.test.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.NationModel;
import net.deludobellico.commandops.estabeditor.model.ServiceModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NationModelTest {
    NationModel ours;
    String name;
    String description;
    String nationality;
    int id;
    int largeInsignia;
    int smallInsignia;
    List<ServiceModel> services = FXCollections.observableArrayList();
    Flag[] flags = new Flag[]{Flag.REMOVE, Flag.COPY};

    @Before
    public void setUp() throws Exception {
        ours = new NationModel();
        ours.setName(name);
        ours.setId(id);
        ours.setDescription(description);
        ours.setNationality(nationality);
        ours.setLargeInsignia(largeInsignia);
        ours.setSmallInsignia(smallInsignia);
        ours.setFlag(flags);
        services.add(new ServiceModel());
        ours.getService().addAll(services);
    }

    @Test
    public void testEquals() throws Exception {
        NationModel other = new NationModel();
        other.setName(name);
        other.setId(id);
        other.setDescription(description);
        other.setNationality(nationality);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        other.getService().addAll(services);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        NationModel other = new NationModel();
        other.setName(name);
        other.setId(id);
        other.setDescription(description);
        other.setNationality(nationality);
        other.setLargeInsignia(largeInsignia);
        other.setSmallInsignia(smallInsignia);
        other.setFlag(flags);
        services.clear();
        services.add(new ServiceModel());
        other.getService().addAll(services);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}