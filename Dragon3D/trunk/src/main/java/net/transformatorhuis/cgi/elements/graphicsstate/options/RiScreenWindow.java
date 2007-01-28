package net.transformatorhuis.cgi.elements.graphicsstate.options;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;

/**
 * @author cyberroadie
 *
 */
public class RiScreenWindow extends AbstractRib {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiScreenWindow.class);

    /**
     * ScreenWindow.
     */
    public RiScreenWindow() {
        super();
    }

    /**
     * ScreenWindow.
     * @param param extra parameters
     */
    public RiScreenWindow(final String param) {
        super(param);
    }

}
