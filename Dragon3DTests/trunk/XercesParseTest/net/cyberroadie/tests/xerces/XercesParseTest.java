/**
 * 
 */
package net.cyberroadie.tests.xerces;

import java.io.FileReader;
import java.io.IOException;

import org.apache.xerces.xs.XSConstants;
import org.apache.xerces.xs.XSImplementation;
import org.apache.xerces.xs.XSLoader;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSObject;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.LSParser;

/**
 * @author mgs
 *
 */
public class XercesParseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // is there anything to do?
        if (args.length == 0) {
            printUsage();
            System.exit(1);
        }
        
        try {
            new XercesParseTest(args[0]);
        } catch (IOException ioe) {
            System.exit(1);
        }
        
	}
	
	public XercesParseTest(String xsdFile) {
		
		
		
		
	}
	

    private static void printUsage() {
        System.err.println("Usage: java net.cyberroadie.tests.xerces. [rib file]");
    }
    
}
