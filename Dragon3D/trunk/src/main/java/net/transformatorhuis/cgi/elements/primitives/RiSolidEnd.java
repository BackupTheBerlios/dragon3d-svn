package net.transformatorhuis.cgi.elements.primitives;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;
import net.transformatorhuis.cgi.conversion.AbstractRibType;

/**
 * @author cyberroadie
 *
 */
public class RiSolidEnd extends AbstractRibType {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiSolidEnd.class);

    /**
     * SolidEnd.
     */
    public RiSolidEnd() {
        super();
    }

    /**
     * SolidEnd.
     * @param param extra parameters
     */
    public RiSolidEnd(final String param) {
        super(param);
    }

}
