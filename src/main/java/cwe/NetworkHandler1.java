package cwe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jasyu on 2020/12/14.
 **/
public class NetworkHandler1 {
    private final ExecutorService executor;

    NetworkHandler1(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public void startThreads() {
        for (int i = 0; i < 3; i++) {
            executor.execute(new HandleRequest());
        }
    }

    public void shutdownPool() {
        executor.shutdown();
    }

    public static void main(String[] args)  {
        NetworkHandler1 nh = new NetworkHandler1(3);
        nh.startThreads();
        nh.shutdownPool();
    }
}
