package reflectknowledge;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jasyu on 2019/12/25.
 **/
public class SourceClassTest {

    private String classPath = "reflectknowledge.SourceClass";

    @Test
    public void testClassLoader() throws ClassNotFoundException {
        System.out.println("**************testClassLoader**************");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class c = classLoader.loadClass(classPath);
        System.out.println(c.getName());
    }

    @Test
    public void testClassForName() throws ClassNotFoundException {
        System.out.println("**************testClassForName**************");
        Class c = Class.forName(classPath);
        System.out.println(c.getName());
    }

}