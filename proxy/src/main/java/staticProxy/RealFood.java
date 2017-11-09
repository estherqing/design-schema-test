package staticProxy;

/**
 * @author esther
 * @create 2017-11-09 15:02
 * $DESCRIPTION}
 */

//核心业务操作类
class RealFood implements Food{
    @Override
    public void eat() {
        System.out.println("马小超在吃饭！");
    }
}
