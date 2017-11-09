package dynamic;

/**
 * @author esther
 * @create 2017-11-09 13:58
 * $DESCRIPTION}
 */

public class DaoImpl implements IDao{
    @Override
    public void doSave() {
        System.out.println("执行保存方法【doSave】");
    }

    public Object getById(String id) {
        System.out.println("执行根据Id查询方法【getById】");
        return null;
    }
}
