package concurrencyknowledge.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 静态内部类(线程安全)
 **/
public class Singleton7 {
    private Singleton7() {}

    public static Singleton7 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static Singleton7 INSTANCE = new Singleton7();
    }
}
