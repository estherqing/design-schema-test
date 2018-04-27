package dynamic.cglib;

/**
 * @author esther
 * 2017-12-20 15:56
 * $DESCRIPTION}
 */

public class DaoImpl2 {

    public void doSave() {
        System.out.println("执行保存方法【doSave】");
    }

    public Object getById(String id) {
        System.out.println("执行根据Id查询方法【getById】");
        return null;
    }
}