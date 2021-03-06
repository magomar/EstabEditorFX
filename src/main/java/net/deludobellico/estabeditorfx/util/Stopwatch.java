package net.deludobellico.estabeditorfx.util;

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

    public void stop() {
        stop = System.nanoTime();
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
