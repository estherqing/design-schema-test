package dynamic.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2017-12-20 15:49
 * net.sf.cglib.proxy.CallbackFilter有选择的对一些方法使用回调。

CallbackFilter可以实现不同的方法使用不同的回调方法。所以CallbackFilter称为"回调选择器"更合适一些。

CallbackFilter中的accept方法，根据不同的method返回不同的值i，这个值是在callbacks中callback对象的序号，就是调用了callbacks[i]。
 */

public class CallbackFilterDemo {

    public static void main(String[] args) {

        // 回调实例数组

        Callback[] callbacks = new Callback[]{new MethodInterceptorImpl(), NoOp.INSTANCE};


        // 使用enhancer，设置相关参数。

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(User.class);

        enhancer.setCallbacks(callbacks);

        enhancer.setCallbackFilter(new CallbackFilterImpl());


        // 产生代理对象

        User proxyUser = (User) enhancer.create();


        proxyUser.pay(); // 买

        proxyUser.eat(); // 吃

    }


    /**
     * 回调过滤器类。
     */

    private static class CallbackFilterImpl implements CallbackFilter {


        @Override
        public int accept(Method method) {

            String methodName = method.getName();

            if ("eat".equals(methodName)) {

                return 1; // eat()方法使用callbacks[1]对象拦截。

            } else if ("pay".equals(methodName)) {

                return 0; // pay()方法使用callbacks[0]对象拦截。

            }

            return 0;

        }

    }


    /**
     * 自定义回调类。
     */

    private static class MethodInterceptorImpl implements MethodInterceptor {


        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

            System.out.println("Before invoke " + method);

            Object result = proxy.invokeSuper(obj, args); // 原方法调用。

            System.out.println("After invoke" + method);

            return result;

        }

    }

}
    class User {

        public void pay() {

            System.out.println("买东西");

        }


        public void eat() {

            System.out.println("吃东西");

        }

    }



