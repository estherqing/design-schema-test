package dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2017-12-19 14:03
 * 拦截器：实现MethodInterceptor接口的类，在intercept方法中实现对代理目标类的方法拦截。
 * 但同时Cglib为简化和提高性能提供了一些专门的回调类型如FixedValue（可以在实现的方法loadObject中指定返回固定值，而不调用目标类函数）、
 * NoOp（把对回调方法的调用直接委派到这个方法的父类，即不进行拦截）
 */

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz); //① 设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create(); //②通过字节码技术动态创建子类实例

    }

    //③拦截父类所有方法的调用
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName()+"."+method. getName());//③-1
        Object result=proxy.invokeSuper(obj, args); //③-2  使用Cglib代理调用
        PerformanceMonitor.end();//③-1通过代理类调用父类中的方法
        return result;
    }
}
