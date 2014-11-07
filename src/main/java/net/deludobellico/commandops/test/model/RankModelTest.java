package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.RankModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RankModelTest {
    RankModel ours;
    String shortName = "RankModel Short Test";
    String fullName = "RankModel Full Test";

    @Before
    public void setUp() throws Exception {
        ours = new RankModel();
        ours.setFullName(fullName);
        ours.setShortName(shortName);
    }

    @Test
    public void testEquals() throws Exception {
        RankModel other = new RankModel();
        other.setFullName(fullName);
        other.setShortName(shortName);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        RankModel other = new RankModel();
        other.setFullName(fullName);
        other.setShortName(shortName);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}