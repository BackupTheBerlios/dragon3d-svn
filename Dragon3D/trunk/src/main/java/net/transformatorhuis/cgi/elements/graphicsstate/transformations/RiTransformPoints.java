package net.transformatorhuis.cgi.elements.graphicsstate.transformations;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;

/**
 * @author cyberroadie
 *
 */
public class RiTransformPoints extends AbstractRib {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiTransformPoints.class);

    /**
     * TransformPoints.
     */
    public RiTransformPoints() {
        super();
    }

    /**
     * TransformPoints.
     * @param param extra paramters
     */
    public RiTransformPoints(final String param) {
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
