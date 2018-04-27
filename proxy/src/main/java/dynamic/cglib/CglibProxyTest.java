package dynamic.cglib;

import org.springframework.aop.support.AopUtils;

/**
 * @author esther
 * 2017-12-19 14:50
 * CGLib采用非常底层的字节码技术，可以为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，并顺势织入横切逻辑。
 * cglib是针对类来实现代理的，它的原理是对指定的目标类生成一个类，并覆盖其中方法实现增强，看上述例子的cglib动态代理的实现：
 *
 *  spring 默认使用的jdk的动态代理；

1.如果目标对象实现了接口，在默认情况下采用jdk的动态代理实现aop

2.如果目标对象实现了接口，也可以强制使用cglib生成代理实现aop

3.如果目标对象没有实现接口，那么必须引入cglib，spring会在jdk的动态代理和cglib代理之间切换

如何使用cglib强制生成代理;

 * 加入cglib类库，cglib/*.jar

 * 加入如下配置，表示强制使用cglib代理

<aop:aspectj-autoproxy proxy-target-class="true"/>

jdk动态代理和cglib代理的区别：

 * jdk动态代理对实现了接口的类进行代理

 * cglib代理可以对类代理，主要对指定的类生成一个子类，因为是继承，所以我们的目标最好不要使用使用final声明；
 */

public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        DaoImpl2 dao = (DaoImpl2) proxy.getProxy(DaoImpl2.class);
        dao.doSave();
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(dao));
        System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(dao));
    }
}
