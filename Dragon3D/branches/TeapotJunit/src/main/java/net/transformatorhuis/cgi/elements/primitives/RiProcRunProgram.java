package net.transformatorhuis.cgi.elements.primitives;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRib;
import net.transformatorhuis.cgi.conversion.AbstractRibType;

/**
 * @author cyberroadie
 *
 */
public class RiProcRunProgram extends AbstractRibType {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiProcRunProgram.class);

    /**
     * ProcRunProgram.
     */
    public RiProcRunProgram() {
        super();
    }

    /**
     * ProcRunProgram.
     * @param param extra parameters
     */
    public RiProcRunProgram(final String param) {
        super(param);
    }

}
