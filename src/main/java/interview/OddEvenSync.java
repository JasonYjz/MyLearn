package interview;

/**
 * Created by jasyu on 2019/11/20.
 * 用两个线程交替打印奇偶数
 * 1. 新建两个线程
 * 2. 用synchronized关键字同步代码块
 * 3. 谁抢到了锁，就打印。
 * <p>
 * 缺点：有一些废操作，比如在奇数线程中，count++后变成偶数了，
 * 在一段时间内，奇数线程占有了锁，但不满足打印条件，
 * 就直接跳过继续循环，直到CPU调度到偶数线程进行了打印
 **/
public class OddEvenSync {
    private static int count;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "奇数").start();

        new Thread(new Runnable() {
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "偶数").start();
    }
}
