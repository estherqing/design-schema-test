package dynamic;


/**
 * @author esther
 * @create 2017-11-09 13:59
 * 动态代理模式可以让我们在不改变原来代码结构的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到控制被代理对象的行为。
 * 动态代理模式运用的知识点就是Java的反射机制
 */

public class DynamicProxyTest {
    public static void main(String[] args) {
        //获得代理的实例
        IDao dao = (IDao) new DaoProxy().bind(new DaoImpl());
        //调用被代理类中的保存方法
        dao.doSave();
        System.out.println("-----------------------------");
        dao.getById("1");

        /*
        进行日志记录，方法为：doSave
        执行保存方法【doSave】
        事务提交。
        -----------------------------
        进行日志记录，方法为：getById
        执行根据Id查询方法【getById】
        */
    }
}
