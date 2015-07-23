package net.deludobellico.estabeditorfx.util;

import net.deludobellico.estabeditorfx.model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mario on 21/07/2015.
 */
public class Tools {
    static int RESERVED_ID = 4999;
    static int MIN_NEW_ID = 5000;


    public static void compactIds(EstabModel estab) {
        Map<Integer, Pair<Integer, Map<Integer, ? extends ElementModel>>> ids = new HashMap<>();
        int newId = MIN_NEW_ID;

        for (Map<Integer, ? extends ElementModel> map : estab.getAll().values()) {
            for (ElementModel element : map.values()) {
                int oldId = element.getId();
                if (oldId > RESERVED_ID) {
                    ids.put(element.getId(), new Pair<>(newId, map));
                    element.setId(newId);
                    newId++;
                }
            }
        }
        for (Map.Entry<Integer, Pair<Integer, Map<Integer, ? extends ElementModel>>> transformation : ids.entrySet()) {
            updateMap(transformation.getValue().getValue(), transformation.getKey(), transformation.getValue().getKey());
        }
        for (ReferenceModel reference : getAllReferences(estab)) {
            int oldId = reference.getId();
            if (ids.containsKey(oldId)) reference.setId(ids.get(oldId).getKey());
        }

        for (WeaponModel weapon : estab.getWeapons().values()) {
            int oldId = weapon.getPictureId();
            if (ids.containsKey(oldId)) weapon.setPictureId(ids.get(oldId).getKey());
        }
        for (VehicleModel vehicle : estab.getVehicles().values()) {
            int oldId = vehicle.getPictureId();
            if (ids.containsKey(oldId)) vehicle.setPictureId(ids.get(oldId).getKey());
        }
        for (SideModel side : estab.getSides().values()) {
            int oldId = side.getLargeInsignia();
            if (ids.containsKey(oldId)) side.setLargeInsignia(ids.get(oldId).getKey());
            oldId = side.getSmallInsignia();
            if (ids.containsKey(oldId)) side.setSmallInsignia(ids.get(oldId).getKey());
            for (NationModel nation : side.getNation()) {
                oldId = nation.getLargeInsignia();
                if (ids.containsKey(oldId)) nation.setLargeInsignia(ids.get(oldId).getKey());
                oldId = nation.getSmallInsignia();
                if (ids.containsKey(oldId)) nation.setSmallInsignia(ids.get(oldId).getKey());
                for (ServiceModel service : nation.getService()) {
                    oldId = service.getLargeInsignia();
                    if (ids.containsKey(oldId)) service.setLargeInsignia(ids.get(oldId).getKey());
                    oldId = service.getSmallInsignia();
                    if (ids.containsKey(oldId)) service.setSmallInsignia(ids.get(oldId).getKey());
                }
            }
        }
        ElementModelFactory.setMaxId(newId);
    }


    private static <T extends ElementModel> void updateMap(Map<Integer, T> map, int oldId, int newId) {
        T element = map.remove(oldId);
        map.put(newId, element);
    }

    public static List<ElementModel> getAllElements(EstabModel estab) {
        List<ElementModel> elements = new ArrayList<>();
        for (Map<Integer, ? extends ElementModel> map : estab.getAll().values()) {
            elements.addAll(map.values());
        }
//        elements.addAll(estabModel.getAll().values().parallelStream().map(integerMap -> integerMap.values()).collect(Collectors.toList()))
        Collections.sort(elements, (o1, o2) -> o1.getId() - o2.getId());
        return elements;
    }

    public static List<ReferenceModel> getAllReferences(EstabModel estab) {
        List<ReferenceModel> references = new ArrayList<>();
        for (WeaponModel weapon : estab.getWeapons().values()) {
            references.addAll(weapon.getPerformances().stream().map(PerformanceModel::getAmmoLoad).collect(Collectors.toList()));
        }
        for (VehicleModel vehicle : estab.getVehicles().values()) {
            references.addAll(vehicle.getArmaments().stream().collect(Collectors.toList()));
        }
        for (ForceModel force : estab.getForces().values()) {
            references.addAll(force.getEquipmentList().stream().collect(Collectors.toList()));
            references.addAll(force.getForceComposition().stream().collect(Collectors.toList()));
        }
        return references;
    }

    public static List<ReferenceModel> getReferencesToFix(EstabModel estab) {
        return getAllReferences(estab).stream().filter(reference -> !reference.referenceIsOk()).collect(Collectors.toList());
//        List<ReferenceModel> referencesToFix = new ArrayList<>();
//        for (WeaponModel weapon : estab.getWeapons().values()) {
//            referencesToFix.addAll(weapon.getPerformances().stream().map(PerformanceModel::getAmmoLoad).filter(ammoLoad -> !ammoLoad.referenceIsOk()).collect(Collectors.toList()));
//        }
//        for (VehicleModel vehicle : estab.getVehicles().values()) {
//            referencesToFix.addAll(vehicle.getArmaments().stream().filter(armament -> !armament.referenceIsOk()).collect(Collectors.toList()));
//        }
//        for (ForceModel force : estab.getForces().values()) {
//            referencesToFix.addAll(force.getEquipmentList().stream().filter(equipmentQty -> !equipmentQty.referenceIsOk()).collect(Collectors.toList()));
//            referencesToFix.addAll(force.getForceComposition().stream().filter(forceQty -> !forceQty.referenceIsOk()).collect(Collectors.toList()));
//        }
//        return referencesToFix;
    }
}
