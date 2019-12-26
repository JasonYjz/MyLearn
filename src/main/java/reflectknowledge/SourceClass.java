package reflectknowledge;

/**
 * Created by jasyu on 2019/12/24.
 * Java中Class.forName和classloader都可以用来对类进行加载。
 *   Class.forName(“className”);
 *         其实这种方法调运的是：Class.forName(className, true, ClassLoader.getCallerClassLoader())方法
 *         参数一：className，需要加载的类的名称。
 *         参数二：true，是否对class进行初始化（需要initialize）
 *         参数三：classLoader，对应的类加载器
 *
 *    ClassLoader.laodClass(“className”);
 *         其实这种方法调运的是：ClassLoader.loadClass(name, false)方法
 *         参数一：name,需要加载的类的名称
 *         参数二：false，这个类加载以后是否需要去连接（不需要linking）
 *
 * 可见Class.forName除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。
 *
 * 而classloader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容，只有在newInstance才会去执行static块
 **/
public class SourceClass {
    static {
        System.out.println("static loading ------> SourceClass");
    }

    private static String field1 = method1();

    private String field2 = method2();

    private static String method2() {
        System.out.println("execute method2.");
        return "staticMethod2";
    }

    public static String method1() {
        System.out.println("execute method1.");
        return "staticMethod1";
    }

    public String getField() {
        return field1;
    }
}
