package concurrency.singleton;

/**
 * Created by jasyu on 2020/1/6.
 *
 * 懒汉式(线程安全)
 *
 * getInstance方法用synchronized关键字保护
 * 优点：当需要用到的时候，才实例化
 * 缺点：效率不高，多个同时调用时候，其中一个在执行，其他被阻塞
 **/
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {}

    public synchronized static Singleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }

        return INSTANCE;
    }
}
