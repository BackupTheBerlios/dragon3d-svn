package net.transformatorhuis.cgi.elements.primitives;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRibType;

/**
 * @author cyberroadie
 *
 */
public class RiCurves extends AbstractRibType {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiCurves.class);

    /**
     * Curves.
     */
    public RiCurves() {
        super();
    }

    /**
     * Curves.
     * @param param extra parameters
     */
    public RiCurves(final String param) {
        super(param);
    }

}
