package cweknowledge;

/**
 * Created by jasyu on 2020/12/11.
 **/
public class ProcessStep implements Runnable {
    private static final Object lock = new Object();
    private static int time = 0;
    private final int step; // Do Perform operations when field time
    // reaches this value

    public ProcessStep(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (time != step) {
                    System.out.println(Thread.currentThread().getName() + "_BeforeWait: step[" + step + "], time:[" + time + "]");
                    lock.wait();
                }

                System.out.println(Thread.currentThread().getName() + "_AfterWait: step[" + step + "], time:[" + time + "]");
                // Perform operations
                time++;
                System.out.println(Thread.currentThread().getName() + "_BeforeNotify: step[" + step + "], time:[" + time + "]");
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "_Finish: step[" + step + "], time:[" + time + "]\r\n");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt(); // Reset interrupted status
        }
    }

    public static void main(String[] args) {
        for (int i = 2; i >= 0; i--) {
            new Thread(new ProcessStep(i), "Thread" + i).start();
        }
    }
}
