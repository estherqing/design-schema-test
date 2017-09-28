package api;

/**
 * @author esther
 * @create 2017-09-28 19:19
 * $DESCRIPTION}
 */

public interface Pipeline {
    public Valve getFirst();
    public Valve getBasic();
    public void setBasic(Valve valve);
    public void addValve(Valve valve);
}