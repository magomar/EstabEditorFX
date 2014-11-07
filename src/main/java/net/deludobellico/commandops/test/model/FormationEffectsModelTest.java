package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.FormationEffectsModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FormationEffectsModelTest {

    FormationEffectsModel ours;
    int id = 10;
    String name = "FormationEffectsModel Test";
    Flag[] flags = new Flag[]{Flag.COPY, Flag.USER};

    @Before
    public void setUp() throws Exception {
        ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);
    }

    @Test
    public void testEquals() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(ours.hashCode(), other.hashCode());
    }
    @Test
    public void testEqualsDifferentIDs() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id+2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id+2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(null);
        other.setFlag(null);
        assertEquals(false, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(null);
        other.setFlag(null);
        assertNotEquals(ours.hashCode(), other.hashCode());
    }
}