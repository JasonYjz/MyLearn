package interview;

/**
 * Created by jasyu on 2019/11/21.
 * 用两个线程交替打印奇偶数
 * 1. 新建两个线程
 * 2. 谁抢到了锁，就打印。
 * 3. 打印完了，就唤醒其他线程
 * 4. 任务没完成的话，自己就休眠
 **/
public class OddEvenWaitNotify implements Runnable {
    private int count;
    private Object lock = new Object();

    public void run() {
        while (count <= 100) {
            synchronized (lock) {
//                if ((count & 1) == 1) {
//                    System.out.println(Thread.currentThread().getName() + ":" + count);
//                } else {
//                    System.out.println(Thread.currentThread().getName() + ":" + count);
//                }
                //拿到了锁，就打印
                System.out.println(Thread.currentThread().getName() + ":" + count++);
                //打印完了，就唤醒其他线程
                lock.notify();

                if (count <= 100) {
                    try {
                        // 任务没结束，就让出自己的锁，并休眠。
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenWaitNotify oddEvenWaitNotify = new OddEvenWaitNotify();
        Thread thread1 = new Thread(oddEvenWaitNotify, "偶数");
        Thread thread2 = new Thread(oddEvenWaitNotify, "奇数");

        thread1.start();
        thread2.start();
    }
}
