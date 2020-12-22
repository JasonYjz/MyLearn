package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jasyu on 2019/12/31.
 *
 * 演示JDK的动态代理
 * 不同于静态代理需要硬编码的方式指定，而动态代理支持运行时动态生成这种实现方式。
 *
 * Proxy类中是静态方法,且接收的三个参数依次为:
 *
 * ClassLoader loader,:指定当前目标对象使用类加载器
 * Class<?>[] interfaces,:代理类需要实现的接口列表
 * InvocationHandler h:调用处理程序,将目标对象的方法分派到该调用处理程序
 *
 **/
public class DynamicProxyByJDK implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);

        System.out.println("DynamicProxy: do a operation.");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxyByJDK dynamicProxyByJDK = new DynamicProxyByJDK();
        IUser iUser = (IUser) dynamicProxyByJDK.bind(new TargeUserImpl());

        iUser.addUser("test");
    }
}
