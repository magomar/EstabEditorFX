package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.PrimaryRole;
import net.deludobellico.estabeditorfx.data.jaxb.WeaponType;
import net.deludobellico.estabeditorfx.model.PerformanceModel;
import net.deludobellico.estabeditorfx.model.WeaponModel;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.data.jaxb.PrimaryRole;
import net.deludobellico.estabeditorfx.data.jaxb.WeaponType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeaponModelTest {
    private final int id = 234;
    private final String name = "WeaponModel Test";
    private final String description = "WeaponModel Desc";
    private final int pictureId = 43;
    private final String pictureFilename = "Weapon Picture";
    private final double weight = 23.2;
    private final int crew = 5;
    private final double reliability = 23.1;
    private final WeaponType type = WeaponType.OTHER;
    private final boolean singleShot = false;
    private final PrimaryRole primaryRole = PrimaryRole.ANTI_PERSONNEL;
    private final double calibre = 64.2;
    private final int muzzleVelocity = 34;
    private final boolean mustDeployToFire = false;
    private final List<PerformanceModel> performances = FXCollections.observableArrayList();
    private final Flag[] flags = new Flag[]{Flag.NEW, Flag.REMOVE};

    @Test
    public void testCompareTo() throws Exception {
        WeaponModel ours = new WeaponModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(pictureFilename);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        ours.setType(type);
        ours.setSingleShot(singleShot);
        ours.setPrimaryRole(primaryRole);
        ours.setCalibre(calibre);
        ours.setMuzzleVelocity(muzzleVelocity);
        ours.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        ours.getPerformances().addAll(performances);
        ours.setFlag(flags);


        WeaponModel other = new WeaponModel();
        other.setId(id);
        other.setName(name);
        other.setDescription(description);
        other.setPictureId(pictureId);
        other.setPictureFilename(pictureFilename);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        other.setType(type);
        other.setSingleShot(singleShot);
        other.setPrimaryRole(primaryRole);
        other.setCalibre(calibre);
        other.setMuzzleVelocity(muzzleVelocity);
        other.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        other.getPerformances().addAll(performances);
        other.setFlag(flags);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToDifferentIDs() throws Exception {
        WeaponModel ours = new WeaponModel();
        ours.setId(id);
        ours.setName(name);
        ours.setDescription(description);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(pictureFilename);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        ours.setType(type);
        ours.setSingleShot(singleShot);
        ours.setPrimaryRole(primaryRole);
        ours.setCalibre(calibre);
        ours.setMuzzleVelocity(muzzleVelocity);
        ours.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        ours.getPerformances().addAll(performances);
        ours.setFlag(flags);

        WeaponModel other = new WeaponModel();
        other.setId(id + 2);
        other.setName(name);
        other.setDescription(description);
        other.setPictureId(pictureId);
        other.setPictureFilename(pictureFilename);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        other.setType(type);
        other.setSingleShot(singleShot);
        other.setPrimaryRole(primaryRole);
        other.setCalibre(calibre);
        other.setMuzzleVelocity(muzzleVelocity);
        other.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        other.getPerformances().addAll(performances);
        other.setFlag(flags);
        assertEquals(true, other.compareTo(ours));
    }

    @Test
    public void testCompareToNullableFieldsAreNull() throws Exception {
        WeaponModel ours = new WeaponModel();
        ours.setId(id);
        ours.setName(null);
        ours.setDescription(null);
        ours.setPictureId(pictureId);
        ours.setPictureFilename(null);
        ours.setWeight(weight);
        ours.setCrew(crew);
        ours.setReliability(reliability);
        ours.setType(null);
        ours.setSingleShot(singleShot);
        ours.setPrimaryRole(null);
        ours.setCalibre(calibre);
        ours.setMuzzleVelocity(muzzleVelocity);
        ours.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        ours.getPerformances().addAll(performances);
        ours.setFlag((Flag[]) null);

        WeaponModel other = new WeaponModel();
        other.setId(id);
        other.setName(null);
        other.setDescription(null);
        other.setPictureId(pictureId);
        other.setPictureFilename(null);
        other.setWeight(weight);
        other.setCrew(crew);
        other.setReliability(reliability);
        other.setType(null);
        other.setSingleShot(singleShot);
        other.setPrimaryRole(null);
        other.setCalibre(calibre);
        other.setMuzzleVelocity(muzzleVelocity);
        other.setMustDeployToFire(mustDeployToFire);
        performances.clear();
        performances.add(new PerformanceModel());
        other.getPerformances().addAll(performances);
        other.setFlag((Flag[]) null);
        assertEquals(true, ours.compareTo(other));
    }

    @Test
    public void testSameIdEqualsTrue() throws Exception {
        WeaponModel ours = new WeaponModel();
        ours.setId(id);

        WeaponModel other = new WeaponModel();
        other.setId(id);
        assertEquals(true, other.equals(ours));
    }


    @Test
    public void testDifferentIdEqualsFalse() throws Exception {
        WeaponModel ours = new WeaponModel();
        ours.setId(id);

        WeaponModel other = new WeaponModel();
        other.setId(id+1);
        assertEquals(false, other.equals(ours));
    }
}