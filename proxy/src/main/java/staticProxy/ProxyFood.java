package staticProxy;

/**
 * @author esther
 * @create 2017-11-09 15:04
 * $DESCRIPTION}
 */

//与核心业务有关的辅助性操作
class ProxyFood implements Food {
    private Food food;

    public Food bind(Food food) {
        this.food = food;
        return this;
    }

    @Override
    public void eat() {
        this.prepare();
        this.food.eat();
        this.after();
    }

    private void prepare() {
        System.out.println("吃饭钱准备：洗手");
    }

    private void after() {
        System.out.println("吃饭后收拾：洗碗");
    }
}
