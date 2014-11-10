package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.FormationEffectsModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormationEffectsModelTest {

    private final int id = 10;
    private final String name = "FormationEffectsModel Test";
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.USER};

    @Test
    public void testEquals() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id + 2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id + 2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(null);
        ours.setFlag((Flag[]) null);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(null);
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(null);
        ours.setFlag((Flag[]) null);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(null);
        other.setFlag((Flag[]) null);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}