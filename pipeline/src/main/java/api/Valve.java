package api;

/**
 * @author esther
 * @create 2017-09-28 19:18
 * $DESCRIPTION}
 */

public interface Valve {
    public Valve getNext();
    public void setNext(Valve valve);
    public void invoke(String handling);
}
