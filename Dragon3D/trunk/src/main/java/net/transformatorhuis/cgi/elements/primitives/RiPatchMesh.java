package net.transformatorhuis.cgi.elements.primitives;

import org.apache.log4j.Logger;
import net.transformatorhuis.cgi.conversion.Rib;

public class RiPatchMesh extends Rib {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(RiPatchMesh.class);

    /**
     * PatchMesh.
     */
    public RiPatchMesh() {
        super();
    }

    /**
     * PatchMesh.
     * @param param extra parameters
     */
    public RiPatchMesh(final String param) {
        super(param);
    }

}
