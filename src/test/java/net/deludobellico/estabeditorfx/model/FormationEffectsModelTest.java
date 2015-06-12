package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.model.FormationEffectsModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormationEffectsModelTest {

    private final int id = 10;
    private final String name = "FormationEffectsModel Test";
    private final Flag[] flags = new Flag[]{Flag.COPY, Flag.USER};

    @Test
    public void testCompareTo() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(name);
        ours.setFlag(flags);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id + 2);
        other.setName(name);
        other.setFlag(flags);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);
        ours.setName(null);
        ours.setFlag((Flag[]) null);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        other.setName(null);
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        FormationEffectsModel ours = new FormationEffectsModel();
        ours.setId(id);

        FormationEffectsModel other = new FormationEffectsModel();
        other.setId(id + 1);
        assertEquals(false, other.equals(ours));
    }
}