package concurrencyknowledge.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @Created by jasyu 2019/12/26
 */
public class OutOfOrderException {

    private static int a = 0, x = 0;
    private static int b = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        int i = 0;

        for (; ;) {
            i++;
            a = 0;
            x = 0;
            b = 0;
            y = 0;

            Thread one = new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });

            Thread two = new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            one.start();
            two.start();

            latch.countDown();

            one.join();
            two.join();

            String result = "[run " + i + "times] x = " + x + ", y = " + y;

            if (x == 1 && y == 1) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}
