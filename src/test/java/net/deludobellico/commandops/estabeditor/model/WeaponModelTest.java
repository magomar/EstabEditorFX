package net.deludobellico.commandops.estabeditor.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.PrimaryRole;
import net.deludobellico.commandops.estabeditor.data.jaxb.WeaponType;
import net.deludobellico.commandops.estabeditor.model.PerformanceModel;
import net.deludobellico.commandops.estabeditor.model.WeaponModel;
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
    public void testEquals() throws Exception {
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
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCode() throws Exception {
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
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsDifferentIDs() throws Exception {
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
        assertEquals(true, other.equals(ours));
    }

    @Test
    public void testHashCodeDifferentIDs() throws Exception {
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
        other.setId(id + 3);
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
        assertEquals(other.hashCode(), ours.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
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
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
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
        assertEquals(ours.hashCode(), other.hashCode());
    }
}