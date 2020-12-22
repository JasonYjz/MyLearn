package concurrency.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 饿汉式(静态变量） 可用
 *
 * JVM加载时就把instance给实例化好
 * 缺点：不管用不用，都实例化了，占内存
 **/
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
