package net.deludobellico.commandops.test.model;

import net.deludobellico.commandops.estabeditor.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EstabModelTest {
    private EstabModel estabModel;
    private Map<Integer, VehicleModel> vehicles;
    private Map<Integer, WeaponModel> weapons;
    private Map<Integer, AmmoModel> ammos;

    @Before
    public void setUp() throws Exception {
        int maxElements = 30;
        vehicles = new HashMap<>();
        weapons = new HashMap<>();
        ammos = new HashMap<>();
        for (int i = 0; i < maxElements; ++i) {
            VehicleModel em = ElementModelFactory.createVehicle();
            em.setName("Test vehicles");
            vehicles.put(em.getId(), em);
        }
        for (int i = 0; i < maxElements; ++i) {
            WeaponModel em = ElementModelFactory.createWeapon();
            em.setName("Test weapons");
            weapons.put(em.getId(), em);
        }
        for (int i = 0; i < maxElements; ++i) {
            AmmoModel em = ElementModelFactory.createAmmo();
            em.setName("Test ammo");
            ammos.put(em.getId(), em);
        }
        estabModel = new EstabModel();
        estabModel.setVehicles(vehicles);
        estabModel.setWeapons(weapons);
        estabModel.setAmmos(ammos);
    }

    @Test
    public void testSearchElementVehicle() throws Exception {
        assertEquals(vehicles.size(), estabModel.searchElement("Test", VehicleModel.class).size());
    }

    @Test
    public void testSearchElementWeapons() throws Exception {
        assertEquals(weapons.size(), estabModel.searchElement("Test", WeaponModel.class).size());
    }

    @Test
    public void testSearchElementAmmos() throws Exception {
        assertEquals(ammos.size(), estabModel.searchElement("Test", AmmoModel.class).size());
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