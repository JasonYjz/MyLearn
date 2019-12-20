package concurrencyknowledge;

/**
 * Created by jasyu on 2019/12/13.
 **/
public class MultiThreadsError implements Runnable {


    private static MultiThreadsError instance = new MultiThreadsError();
    private int index;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("表面上的结果是：" + instance.index);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;

        }
    }
}
