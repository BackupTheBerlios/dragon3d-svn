package net.transformatorhuis.cgi.elements.graphicsstate.attributes;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import net.transformatorhuis.xsd.GeneralRibTest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * RiColor Tester.
 *
 * @author Cyberroadie
 * @since <pre>05/13/2007</pre>
 * @version 1.0
 */
public class RiColorTest extends GeneralRibTest {

    private static Logger logger = Logger.getLogger(RiColorTest.class);

    private String testXMLFragment = "<color r=\"1\" g=\".6\" b=\"0\"/>";

    private String testRIBFragment = "Color [1 .6 0]";

    public RiColorTest() {
        super();     
    }

    @Ignore
    @Test
     public void testGetJAXBNode() throws IOException, SAXException, ParserConfigurationException, JAXBException {

         // Create DOM document
         Document docFromString = getDOMDocument(testXMLFragment);
         logger.info(docFromString.toString());

         // Create JAXB
         RiColor rib = new RiColor(testRIBFragment);
         Document docFromJAXB = getDOMFromJAXB(rib.getJAXBNode());

         assertTrue(compareDocuments(docFromString, docFromJAXB));

     }
    
}