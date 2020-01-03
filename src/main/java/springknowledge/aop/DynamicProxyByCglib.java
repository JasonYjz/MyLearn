package springknowledge.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by jasyu on 2019/12/31.
 *
 * 用Cglib演示动态代理
 *
 * 目标类不能处理被final关键字修饰，因为被final修饰的类是不可继承的。
 * 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 *
 * 如果加入容器的目标对象有实现接口,用JDK代理
 * 　　如果目标对象没有实现接口,用Cglib代理 　　
 * 　　如果目标对象实现了接口，且强制使用cglib代理，则会使用cglib代理。
 * 查看DefaultAopProxyFactory --> createAopProxy方法
 **/
public class DynamicProxyByCglib implements MethodInterceptor {
    private Object target;

    public Object bind(Object target) {
        this.target = target;

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("DynamicProxyByCglib: do a operation.");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxyByCglib dynamicProxyByCglib = new DynamicProxyByCglib();
        TargeUserImpl targeUser = (TargeUserImpl) dynamicProxyByCglib.bind(new TargeUserImpl());

        targeUser.addUser("xxxxxx");
    }
}
