package net.deludobellico.estabeditorfx;

import net.deludobellico.estabeditorfx.model.EstabModel;
import net.deludobellico.estabeditorfx.model.VehicleModel;
import net.deludobellico.estabeditorfx.util.LimitedList;
import net.deludobellico.estabeditorfx.util.Pair;
import net.deludobellico.estabeditorfx.util.Stopwatch;
import net.deludobellico.estabeditorfx.model.VehicleModel;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by Heine on 12/2/2014.
 */
public class CollectionsTest {
    private static final Logger LOG = Logger.getLogger(MainTest.class.getName());
    private final static EstabModel ESTAB_MODEL = new EstabModel(new File(System.getProperty("user.dir") + "/src/main/resources/datasets/BFTBEstab.xml"));
    private final static int MAX_ADD_REPS = 100;
    private final static int TEST_REPS = 17;

    public static void start() {


        Deque linkedList = new LinkedList<>();
        Collection arrayList = new ArrayList<>();
        Collection arrayListInit = new ArrayList<>(MAX_ADD_REPS);
        Deque arrayDeque = new ArrayDeque<>();
        Deque arrayDequeInit = new ArrayDeque<>(MAX_ADD_REPS);
        Collection limitedList = new LimitedList<>(MAX_ADD_REPS);

        List<Pair<String, Deque>> pairs = new ArrayList<>();
//        collections.add(new Pair<>("arrayList", arrayList));
//        collections.add(new Pair<>("arrayListInit", arrayListInit));
        pairs.add(new Pair<>("linkedList", linkedList));
//        collections.add(new Pair<>("limitedList", limitedList));
        pairs.add(new Pair<>("arrayDeque", arrayDeque));
        pairs.add(new Pair<>("arrayDequeInit", arrayDequeInit));

        List<Pair<String, Consumer<Deque>>> methods = new ArrayList<>();
//        methods.add(new Pair<>("addIterator", net.deludobellico.commandops.estabeditor.CollectionsTest::addIterator));
        methods.add(new Pair<>("addVehicles", CollectionsTest::addVehicles));
//        methods.add(new Pair<>("contains", (Consumer<Collection>) (t) -> t.contains("0")));
//        methods.add(new Pair<>("listGet", net.deludobellico.commandops.estabeditor.CollectionsTest::listGet));
//        methods.add(new Pair<>("addModelObjects", net.deludobellico.commandops.estabeditor.CollectionsTest::addModelObjects));
//        methods.add(new Pair<>("removeModelObjects", net.deludobellico.commandops.estabeditor.CollectionsTest::removeModelObjects));
//        methods.add(new Pair<>("removeIterator", net.deludobellico.commandops.estabeditor.CollectionsTest::removeIterator));
//        methods.add(new Pair<>("clear", Collection::clear));
        methods.add(new Pair<>("pollFirst", CollectionsTest::pollFirst));
        methods.add(new Pair<>("addVehicles", CollectionsTest::addVehicles));
        methods.add(new Pair<>("pop", CollectionsTest::pop));

        Map<Pair<String, String>, Long> times = new LinkedHashMap<>();

        Stopwatch s = new Stopwatch();
        for (int i = 0; i < TEST_REPS; ++i) {
            for (Pair<String, Consumer<Deque>> methodPair : methods) {
                for (Pair<String, Deque> listPair : pairs) {
                    s.start();
                    methodPair.getValue().accept(listPair.getValue());
                    s.stop();
                    Long prevTime = times.get(new Pair<>(listPair.getKey(), methodPair.getKey()));
                    if (prevTime == null)
                        times.put(new Pair<>(listPair.getKey(), methodPair.getKey()), s.getTotalTime());
                    else times.put(new Pair<>(listPair.getKey(), methodPair.getKey()), prevTime + s.getTotalTime());
                }
            }
        }

        String block = "";
        String divider = "-------------";
        for (Map.Entry<Pair<String, String>, Long> timesEntry : times.entrySet()) {
            if (!block.equals(timesEntry.getKey().getValue())) {
                block = timesEntry.getKey().getValue();
                System.out.println(divider);
            }
            System.out.println(String.format("Collection: %15s | Method: %20s | Avg: %10d  - Total %15d", timesEntry.getKey().getKey(), timesEntry.getKey().getValue(), timesEntry.getValue() / TEST_REPS, timesEntry.getValue()));
        }

    }

    private static void listGet(Collection collection) {
        if (collection instanceof List)
            for (int i = 0; i < collection.size(); ++i) {
                ((List) collection).get(i);
            }
    }


    private static void addModelObjects(Collection collection) {
        for (Object m : ESTAB_MODEL.getAll().values()) {
            ((Map)m).values().stream().forEach(collection::add);
        }
    }

    private static void addVehicles(Collection collection) {
        for (int i = 0; i < MAX_ADD_REPS; ++i) {
            collection.add(new VehicleModel());
        }
    }

    private static void addIterator(Collection collection) {
        if (collection instanceof List) {
            ListIterator it = ((List) collection).listIterator();
            for (int i = 0; i < MAX_ADD_REPS; ++i) {
                it.add(i);
            }
        }
    }

    private static void removeModelObjects(Collection collection) {
        for (Object m : ESTAB_MODEL.getAll().values()) {
            ((Map) m).values().stream().forEach(collection::remove);

        }
    }

    private static void removeIterator(Collection collection) {
        if (collection instanceof List) {
            Iterator it = ((List) collection).listIterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    private static void pollFirst(Deque list) {
        for (int i = 0; i < list.size(); ++i) {
            list.pollFirst();
        }
    }

    private static void pop(Deque deque) {
        for (int i = 0; i < deque.size(); ++i) {
            deque.pollLast();
        }
    }
}
