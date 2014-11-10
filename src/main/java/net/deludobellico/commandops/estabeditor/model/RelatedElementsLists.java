package net.deludobellico.commandops.estabeditor.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The main purpose of this class is to store elements related to a given element or element collection.
 * For example, a {@code VehicleModel v} will store all its related weapons and ammo into its {@code relatedElementsList}
 * <p>
 * When invoking {@link #findRepeatedElementsInTargetModel}, items present in the target model will be distributed to
 * {@code repeatedElementsList}, and the remaining items to {@code nonRepeatedElementsList}.
 * <p>
 * At the end, this class will hold all the related elements in the original model, and which of them are repeated or not
 * in the target model.
 */
public class RelatedElementsLists {

    private final Map<Class, List<ElementModel>> relatedElementsListsMap;
    private final Map<Class, List<ElementModel>> repeatedElementsInTargetModelListsMap;
    private final Map<Class, List<ElementModel>> nonRepeatedElementsInTargetModelListsMap;
    private boolean distributed;

    /**
     * Stores lists for every element model class in maps.
     */
    public RelatedElementsLists() {
        relatedElementsListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        repeatedElementsInTargetModelListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        nonRepeatedElementsInTargetModelListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);

        for (int i = 0; i < ElementModel.ELEMENT_MODEL_CLASSES.length; i++) {
            relatedElementsListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            repeatedElementsInTargetModelListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            nonRepeatedElementsInTargetModelListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
        }
    }

    /**
     * Returns true if elements in {@code relatedElementsList} have been distributed to
     * {@code repeatedElementsList} and {@code nonRepeatedElementsList}
     *
     * @return true if elements have been distributed, false otherwise
     * @see #findRepeatedElementsInTargetModel
     */
    public boolean isDistributed() {
        return distributed;
    }

    /**
     * Find which elements in the {@code relatedElementsList} are present in the target model.
     * Repeated elements will be distributed to {@code repeatedElementsLists},
     * and the rest to {@code nonRepeatedElementsList}.
     *
     * @param targetModel {@code EstabModel} to compare
     */
    public void findRepeatedElementsInTargetModel(EstabModel targetModel) {
        assert !distributed;
        for (Class modelClass : ElementModel.ELEMENT_MODEL_CLASSES) {
            for (ElementModel e : getAll(modelClass)) {
                if (targetModel.getAll().get(modelClass).containsKey(e.getId()))
                    getRepeated(modelClass).add(e);
                else getNonRepeated(modelClass).add(e);
            }
        }
        distributed = true;
    }

    /**
     * Check if any {@code repeatedElementsList} is not empty
     *
     * @return true if any {@code repeatedElementsList} is not empty, false otherwise
     */
    public boolean hasRepeatedElements() {
        boolean hasRepeated = false;
        int i = 0;
        while (!hasRepeated && i < ElementModel.ELEMENT_MODEL_CLASSES.length) {
            hasRepeated = !repeatedElementsInTargetModelListsMap.get(ElementModel.ELEMENT_MODEL_CLASSES[i]).isEmpty();
            i++;
        }
        return hasRepeated;
    }

    public List<ElementModel> getAll(Class elementModelClass) {
        return relatedElementsListsMap.get(elementModelClass);
    }

    public List<ElementModel> getNonRepeated(Class elementModelClass) {
        return nonRepeatedElementsInTargetModelListsMap.get(elementModelClass);
    }

    public List<ElementModel> getRepeated(Class elementModelClass) {
        return repeatedElementsInTargetModelListsMap.get(elementModelClass);
    }

    public List<ElementModel> getAllElements() {
        List<ElementModel> allElements = new ArrayList<>(relatedElementsListsMap.values().stream().mapToInt(List::size).sum());
        relatedElementsListsMap.values().forEach(allElements::addAll);
        return allElements;
    }

    public List<ElementModel> getRepeatedElements() {
        List<ElementModel> repeatedElements = new ArrayList<>((int) repeatedElementsInTargetModelListsMap.values().stream().mapToInt(List::size).sum());
        repeatedElementsInTargetModelListsMap.values().forEach(repeatedElements::addAll);
        return repeatedElements;
    }

    public List<ElementModel> getNonRepeatedElements() {
        List<ElementModel> nonRepeatedElements = new ArrayList<>((int) nonRepeatedElementsInTargetModelListsMap.values().stream().mapToInt(List::size).sum());
        nonRepeatedElementsInTargetModelListsMap.values().forEach(nonRepeatedElements::addAll);
        return nonRepeatedElements;
    }
}
