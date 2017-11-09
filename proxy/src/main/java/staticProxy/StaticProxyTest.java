package staticProxy;

/**
 * @author esther
 * @create 2017-11-09 15:05
 * 代理模式的核心思路就是一个接口有两个子类，一个子类完成核心的业务操作，另一个子类完成与核心业务有关的辅助性操作。
   代理模式分为静态代理模式和动态代理模式。
 */

public class StaticProxyTest {
    public static void main(String[] args) {
        Food food = new ProxyFood().bind(new RealFood());
        food.eat();
    }
}
