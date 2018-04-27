package dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author esther
 * @create 2017-11-09 13:58
 * 实现InvocationHandler接口，该接口定义了一个 invoke(Object proxy, Method method, Object[] args)的方法，
 * 1,proxy是最终生成的代理实例，一般不会用到；
 * 2,method是被代理目标实例的某个具体方法，通过它可以发起目标实例方法的反射调用；
 * 3,args是通过被代理实例某一个方法的入参，在方法反射调用时使用。
 */

public class DaoProxy2<T> implements InvocationHandler {

    //被代理类的对象
    public T target;

    //绑定被代理对象
    public T bind(T target) {
        this.target = target;
        //返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型
        //创建代理对象，注意这里被代理的对象类必须实现至少一个接口
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    private void log(String method) {
        System.out.println("进行日志记录，方法为：" + method);
    }

    private void commit() {
        System.out.println("事务提交。");
    }

    /**
     *
     * <p>Discription:覆盖InvocationHandler接口中的invoke()方法</p>
     * @param proxy 需要代理的对象
     * @param method 真实主体要调用的执行方法
     * @param args 调用方法时传递的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.log(method.getName());
        //使用反射中的invoke()对方法进行动态调用
        Object object = method.invoke(this.target, args);
        //过滤出以do开头的方法，该方法对数据库进行修改，进行事物提交操作
        if (method.getName().matches("do[a-zA-Z0-9]+")) {
            this.commit();
        }
        return object;
    }
}
