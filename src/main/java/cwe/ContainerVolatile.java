package cwe;

import java.util.Random;
import java.util.Vector;

/**
 * Created by jasyu on 2020/12/15.
 *
 * THI05-J. Do not use Thread.stop() to terminate threads
 **/
public final class ContainerVolatile implements Runnable {
    private final Vector<Integer> vector = new Vector<Integer>(1000);
    private volatile boolean done = false;

    public Vector<Integer> getVector() {
        return vector;
    }

    public void shutdown() {
        done = true;
    }

    @Override public synchronized void run() {
        Random number = new Random(123L);
        int i = vector.capacity();
        while (!done && i > 0) {
            vector.add(number.nextInt(100));
            i--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ContainerVolatile container = new ContainerVolatile();
        Thread thread = new Thread(container);
        thread.start();
        Thread.sleep(5000);
        container.shutdown();
    }
}
