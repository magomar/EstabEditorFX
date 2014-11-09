package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EstabModelTest {
    EstabModel estabModel;

    @Before
    public void setUp() throws Exception {
        int maxElements = 30;
        estabModel = new EstabModel();
        for (int i = 0; i < maxElements; ++i) {
            VehicleModel em = ElementModelFactory.createVehicle();
            em.setName("Test vehicles");
            em.insertInToMap((Map<Integer, VehicleModel>) estabModel.getAll().get(VehicleModel.class));
        }
        for (int i = 0; i < maxElements; ++i) {
            WeaponModel em = ElementModelFactory.createWeapon();
            em.setName("Test weapons");
            em.insertInToMap((Map<Integer, WeaponModel>) estabModel.getAll().get(WeaponModel.class));
        }
        for (int i = 0; i < maxElements; ++i) {
            AmmoModel em = ElementModelFactory.createAmmo();
            em.setName("Test ammo");
            em.insertInToMap((Map<Integer, AmmoModel>) estabModel.getAll().get(AmmoModel.class));
        }
    }

    @Test
    public void testSearchElementVehicle() throws Exception {
        assertEquals(estabModel.getAll().get(VehicleModel.class).size(), estabModel.searchElement("Test", VehicleModel.class).size());
    }

    @Test
    public void testSearchElementWeapons() throws Exception {
        assertEquals(estabModel.getAll().get(WeaponModel.class).size(), estabModel.searchElement("Test", WeaponModel.class).size());
    }

    @Test
    public void testSearchElementAmmos() throws Exception {
        assertEquals(estabModel.getAll().get(AmmoModel.class).size(), estabModel.searchElement("Test", AmmoModel.class).size());

    }

    @Test
    public void testGetRelatedElements() throws Exception {

    }

    @Test
    public void testGetRelatedElements1() throws Exception {

    }

    @Test
    public void testSortRelatedElements() throws Exception {

    }

    @Test
    public void testRemoveCollection() throws Exception {

    }

    @Test
    public void testRemoveRelatedElementsList() throws Exception {

    }

    @Test
    public void testPaste() throws Exception {

    }
}