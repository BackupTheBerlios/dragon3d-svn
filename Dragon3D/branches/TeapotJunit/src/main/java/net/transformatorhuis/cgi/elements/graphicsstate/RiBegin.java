package net.transformatorhuis.cgi.elements.graphicsstate;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;

/**
 * @author cyberroadie
 *
 */
public class RiBegin extends AbstractRib {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiBegin.class);

    /**
     * Begin.
     */
    public RiBegin() {
        super();
    }


    /**
     * Begin.
     * @param param extra parameters
     */
    public RiBegin(final String param) {
        super(param);
    }

    /**
     * @return has children
     */
    public final boolean hasChildElements() {
        return true;
    }

    /**
     * Abstract method to return
     *
     * @return JAXB node returned for RIB element
     */
    public Object getJAXBNode() {
        return null;
    }

}
