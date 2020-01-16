package concurrencyknowledge.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 饿汉式(静态代码块) 同Singleton1
 **/
public class Singleton2 {
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
