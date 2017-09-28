package service.impl;

import api.Pipeline;
import api.Valve;

/**
 * @author esther
 * @create 2017-09-28 19:22
 * $DESCRIPTION}
 */

public class StandardPipeline implements Pipeline {
    protected Valve first = null;
    protected Valve basic = null;
    public void addValve(Valve valve) {
        if (first == null) {
            first = valve;
            valve.setNext(basic);
        } else {
            Valve current = first;
            while (current != null) {
                if (current.getNext() == basic) {
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }
    public Valve getBasic() {
        return basic;
    }
    public Valve getFirst() {
        return first;
    }
    public void setBasic(Valve valve) {
        this.basic = valve;
    }
}
