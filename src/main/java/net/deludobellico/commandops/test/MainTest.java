package net.deludobellico.commandops.test;

import net.deludobellico.commandops.estabeditor.model.EstabModel;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;
import net.deludobellico.commandops.estabeditor.util.LimitedList;
import net.deludobellico.commandops.estabeditor.util.Pair;
import net.deludobellico.commandops.estabeditor.util.Stopwatch;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by Mario on 24/07/2014.
 */
public class MainTest {
    private static final Logger LOG = Logger.getLogger(MainTest.class.getName());
    private final static EstabModel ESTAB_MODEL = new EstabModel(new File(System.getProperty("user.dir") + "/src/main/resources/datasets/BFTBEstab.xml"));
    private final static int MAX_ADD_REPS = 100;
    private final static int TEST_REPS = 17;

    public static void main(String[] args) {
        //JAXBTest.marshallTest();
        listsTest();
    }

    public static void listsTest() {


        Deque linkedList = new LinkedList<>();
        Collection arrayList = new ArrayList<>();
        Collection arrayListInit = new ArrayList<>(MAX_ADD_REPS);
        Deque arrayDeque = new ArrayDeque<>();
        Deque arrayDequeInit = new ArrayDeque<>(MAX_ADD_REPS);
        Collection limitedList = new LimitedList<>(MAX_ADD_REPS);

        List<Pair<String, Deque>> deques = new ArrayList<>();
//        collections.add(new Pair<>("arrayList", arrayList));
//        collections.add(new Pair<>("arrayListInit", arrayListInit));
        deques.add(new Pair<>("linkedList", linkedList));
//        collections.add(new Pair<>("limitedList", limitedList));
        deques.add(new Pair<>("arrayDeque", arrayDeque));
        deques.add(new Pair<>("arrayDequeInit", arrayDequeInit));

        List<Pair<String, Consumer<Deque>>> methods = new ArrayList<>();
//        methods.add(new Pair<>("addIterator", MainTest::addIterator));
        methods.add(new Pair<>("addVehicles", MainTest::addVehicles));
//        methods.add(new Pair<>("contains", (Consumer<Collection>) (t) -> t.contains("0")));
//        methods.add(new Pair<>("listGet", MainTest::listGet));
//        methods.add(new Pair<>("addModelObjects", MainTest::addModelObjects));
//        methods.add(new Pair<>("removeModelObjects", MainTest::removeModelObjects));
//        methods.add(new Pair<>("removeIterator", MainTest::removeIterator));
//        methods.add(new Pair<>("clear", Collection::clear));
        methods.add(new Pair<>("pollFirst", MainTest::pollFirst));
        methods.add(new Pair<>("addVehicles", MainTest::addVehicles));
        methods.add(new Pair<>("pop", MainTest::pop));

        Map<Pair<String, String>, Long> times = new LinkedHashMap<>();

        Stopwatch s = new Stopwatch();
        for (int i = 0; i < TEST_REPS; ++i) {
            for (Pair<String, Consumer<Deque>> methodPair : methods) {
                for (Pair<String, Deque> listPair : deques) {
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
            for (Object o : ((Map) m).values()) {
                collection.add(o);
            }
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
            for (Object o : ((Map) m).values()) {
                collection.remove(o);
            }
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
