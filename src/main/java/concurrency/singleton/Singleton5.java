package concurrency.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 懒汉式(线程非安全)  不可用
 *
 **/
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            //当两个线程同时都进入到这行代码，
            //其中一个线程A，先拿到锁，执行了 INSTANCE = new Singleton5()
            //完了，释放锁后。另一个线程B，拿到锁后，会再执行INSTANCE = new Singleton5()
            //导致了前后不一致的实例对象。
            synchronized (Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }

        return INSTANCE;
    }
}
