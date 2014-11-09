package net.deludobellico.commandops.estabeditor.util;

/**
 * @author Mario Gomez
 */
public class Stopwatch {
    private long start;
    private long stop;

    /**
     *
     */
    public void start() {
        start = System.nanoTime(); // start timing
        stop = start;
    }

    public long stop() {
        stop = System.nanoTime();
        return stop;
    }


    public long getTotalTime() {
        return stop - start;
    }

    public long getTimeFromLastStop() {
        return System.nanoTime() - stop;
    }

    @Override
    public String toString() {
        return "   Time: " + Long.toString(getTotalTime()) + "ms"; // returns execution time
    }

}
