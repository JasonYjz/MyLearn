package concurrency.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 懒汉式(线程不安全)
 *
 * 优点：当需要用到的时候，才实例化
 * 缺点：线程不安全，多个线程同时调用getInstance方法，会实例化多次
 **/
public class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton3();
        }

        return INSTANCE;
    }
}
