package concurrencyknowledge.singleton;

/**
 * Created by jasyu on 2020/1/6.
 * <p>
 * 双重检查(线程安全)  推荐用
 * <p>
 * 一方面既保证了懒加载， 也同时保证了线程安全
 *
 * 加上volatile关键字，是防止对象创建时候在JVM中发生重排序。
 *
 * 对象创建，事实上并非一个原子操作，完成了3个步骤
 * 1. 给instance分配内存
 * 2. 调用构造函数，来初始化成员变量
 * 3. 将instance对象指向分配的内存
 *
 * 如果发生重排序，可能按照步骤1->3->2，则在3执行完毕后，2执行之前。
 * A线程被调度器暂停，B线程进入后，对第一重检查，看到的instance不是null了，则直接返回了。
 * 但此时的instance里面的成员变量并未完成赋值，如果使用的话，就会报错或者非预期的值。
 *
 * 加上volatile后，防止出现重排序，确保对象创建是按照1->2->3顺序执行
 **/
public class Singleton6 {
    private static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
