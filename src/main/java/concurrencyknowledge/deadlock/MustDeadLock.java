package concurrencyknowledge.deadlock;

/**
 * Created by jasyu on 2020/1/16.
 **/
public class MustDeadLock implements Runnable {

    private int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r0 = new MustDeadLock();
        MustDeadLock r1 = new MustDeadLock();
        r0.flag = 0;
        r1.flag = 1;

        Thread thread0 = new Thread(r0);
        Thread thread1 = new Thread(r1);

        thread0.start();
        thread1.start();
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (o1) {
                try {
                    System.out.println("拿到了o1的锁");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {
                    System.out.println("拿到了o1和o2两把锁");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    System.out.println("拿到了o2的锁");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o1) {
                    System.out.println("拿到了o2和o1两把锁");
                }
            }
        }
    }
}
