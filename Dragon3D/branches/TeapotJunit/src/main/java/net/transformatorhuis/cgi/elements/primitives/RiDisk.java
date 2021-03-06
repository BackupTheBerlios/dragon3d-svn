package net.transformatorhuis.cgi.elements.primitives;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.AbstractRibType;

/**
 * @author cyberroadie
 *
 */
public class RiDisk extends AbstractRibType {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiDisk.class);

    /**
     * Disk.
     */
    public RiDisk() {
        super();
    }

    /**
     * Disk.
     * @param param extra parameters
     */
    public RiDisk(final String param) {
        super(param);
    }

}
