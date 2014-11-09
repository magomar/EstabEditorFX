package net.deludobellico.commandops.estabeditor.model;

import java.util.*;

/**
 * Created by Heine on 10/27/2014.
 */
public class RelatedElementLists {

    private Map<Class, List<ElementModel>> allElementsListsMap;
    private Map<Class, List<ElementModel>> repeatedElementsListsMap;
    private Map<Class, List<ElementModel>> nonRepeatedElementsListsMap;
    private boolean sorted;

    public RelatedElementLists() {
        allElementsListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        repeatedElementsListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        nonRepeatedElementsListsMap = new LinkedHashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);

        for (int i = 0; i < ElementModel.ELEMENT_MODEL_CLASSES.length; i++) {
            allElementsListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            repeatedElementsListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            nonRepeatedElementsListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
        }
    }

    public boolean hasRepeatedElements() {
        boolean hasRepeated = false;
        int i = 0;
        while (!hasRepeated && i < ElementModel.ELEMENT_MODEL_CLASSES.length) {
            hasRepeated = !repeatedElementsListsMap.get(ElementModel.ELEMENT_MODEL_CLASSES[i]).isEmpty();
            i++;
        }
        return hasRepeated;
    }

    public List<ElementModel> getAll(Class elementModelClass) {
        return allElementsListsMap.get(elementModelClass);
    }

    public List<ElementModel> getNonRepeated(Class elementModelClass) {
        return nonRepeatedElementsListsMap.get(elementModelClass);
    }

    public List<ElementModel> getRepeated(Class elementModelClass) {
        return repeatedElementsListsMap.get(elementModelClass);
    }

    public List<ElementModel> getAllElements() {
        List<ElementModel> allElements = new ArrayList<>(allElementsListsMap.values().stream().mapToInt(List::size).sum());
        allElementsListsMap.values().forEach(allElements::addAll);
        return allElements;
    }

    public List<ElementModel> getRepeatedElements() {
        List<ElementModel> repeatedElements = new ArrayList<>((int) repeatedElementsListsMap.values().stream().mapToInt(List::size).sum());
        repeatedElementsListsMap.values().forEach(repeatedElements::addAll);
        return repeatedElements;
    }

    public List<ElementModel> getNonRepeatedElements() {
        List<ElementModel> nonRepeatedElements = new ArrayList<>((int) nonRepeatedElementsListsMap.values().stream().mapToInt(List::size).sum());
        nonRepeatedElementsListsMap.values().forEach(nonRepeatedElements::addAll);
        return nonRepeatedElements;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
}
