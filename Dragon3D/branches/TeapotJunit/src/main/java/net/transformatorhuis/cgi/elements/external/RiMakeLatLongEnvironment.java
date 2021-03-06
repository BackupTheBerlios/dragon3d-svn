package net.transformatorhuis.cgi.elements.external;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;

/**
 * @author cyberroadie
 *
 */
public class RiMakeLatLongEnvironment extends AbstractRib {

    /**
     * Logger.
     */
    private static Logger logger =
        Logger.getLogger(RiMakeLatLongEnvironment.class);

    /**
     * MakeLatLongEnvironment.
     */
    public RiMakeLatLongEnvironment() {
        super();
    }

    /**
     * MakeLatLongEnvironment.
     * @param param extra parameters
     */
    public RiMakeLatLongEnvironment(final String param) {
        super(param);
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
