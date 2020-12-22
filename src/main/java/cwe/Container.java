package cwe;

import java.util.Random;
import java.util.Vector;

/**
 * Created by jasyu on 2020/12/15.
 *
 * THI05-J. Do not use Thread.stop() to terminate threads
 **/
public final class Container implements Runnable {
    private final Vector<Integer> vector = new Vector<Integer>(1000);

    public Vector<Integer> getVector() {
        return vector;
    }

    @Override public synchronized void run() {
        Random number = new Random(123L);
        int i = vector.capacity();
        while (i > 0) {
            vector.add(number.nextInt(100));
            i--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Container());
        thread.start();
        Thread.sleep(5000);
        thread.stop();
    }
}
