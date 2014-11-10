package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.model.RankModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RankModelTest {
    private final String shortName = "RankModel Short Test";
    private final String fullName = "RankModel Full Test";


    @Test
    public void testEquals() throws Exception {
        RankModel ours = new RankModel();
        ours.setFullName(fullName);
        ours.setShortName(shortName);

        RankModel other = new RankModel();
        other.setFullName(fullName);
        other.setShortName(shortName);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        RankModel ours = new RankModel();
        ours.setFullName(fullName);
        ours.setShortName(shortName);

        RankModel other = new RankModel();
        other.setFullName(fullName);
        other.setShortName(shortName);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        RankModel ours = new RankModel();
        ours.setFullName(null);
        ours.setShortName(null);

        RankModel other = new RankModel();
        other.setFullName(null);
        other.setShortName(null);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        RankModel ours = new RankModel();
        ours.setFullName(null);
        ours.setShortName(null);

        RankModel other = new RankModel();
        other.setFullName(null);
        other.setShortName(null);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}