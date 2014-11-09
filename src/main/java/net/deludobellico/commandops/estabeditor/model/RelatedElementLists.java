package net.deludobellico.commandops.estabeditor.model;

import java.util.*;

/**
 * Created by Heine on 10/27/2014.
 */
public class RelatedElementLists {

    private Map<Class, List<ElementModel>> allElementsListMap;
    private Map<Class, List<ElementModel>> repeatedElementsListMap;
    private Map<Class, List<ElementModel>> nonRepeatedElementsListsMap;
    private boolean sorted;

    public RelatedElementLists() {
        allElementsListMap = new HashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        repeatedElementsListMap = new HashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);
        nonRepeatedElementsListsMap = new HashMap<>(ElementModel.ELEMENT_MODEL_CLASSES.length);

        for (int i = 0; i < ElementModel.ELEMENT_MODEL_CLASSES.length; i++) {
            allElementsListMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            repeatedElementsListMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
            nonRepeatedElementsListsMap.put(ElementModel.ELEMENT_MODEL_CLASSES[i], new ArrayList<>());
        }
    }

    public boolean hasRepeatedElements() {
        boolean hasRepeated = false;
        int i = 0;
        while (!hasRepeated && i < ElementModel.ELEMENT_MODEL_CLASSES.length) {
            hasRepeated = !repeatedElementsListMap.get(ElementModel.ELEMENT_MODEL_CLASSES[i]).isEmpty();
            i++;
        }
        return hasRepeated;
    }

    public List<ElementModel> getAll(Class elementModelClass) {
        return allElementsListMap.get(elementModelClass);
    }

    public List<ElementModel> getNonRepeated(Class elementModelClass) {
        return nonRepeatedElementsListsMap.get(elementModelClass);
    }

    public List<ElementModel> getRepeated(Class elementModelClass) {
        return repeatedElementsListMap.get(elementModelClass);
    }

    public List<ElementModel> getRepeatedElements() {
        List<ElementModel> repeatedElements = new ArrayList<>((int) repeatedElementsListMap.values().stream().mapToInt(List::size).sum());
        repeatedElementsListMap.values().forEach(repeatedElements::addAll);
        return repeatedElements;
    }

    public List<ElementModel> getAllElements() {
        List<ElementModel> allElements = new LinkedList<>();
        allElementsListMap.values().forEach(allElements::addAll);
        return allElements;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
}
