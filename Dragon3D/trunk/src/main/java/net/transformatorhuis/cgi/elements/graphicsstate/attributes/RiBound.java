package net.transformatorhuis.cgi.elements.graphicsstate.attributes;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.Rib;

/**
 * @author cyberroadie
 *
 */
public class RiBound extends Rib {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiBound.class);

    /**
     * Bound.
     */
    public RiBound() {
        super();
    }

    /**
     * Bound.
     * @param param extra parameters
     */
    public RiBound(final String param) {
        super(param);
    }

}
