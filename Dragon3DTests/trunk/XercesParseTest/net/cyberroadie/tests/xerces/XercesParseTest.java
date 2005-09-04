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
        
        new XercesParseTest(args[0]);
        
	}
	
	public XercesParseTest(String xsdFile) {
		
		try {
			System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			XSImplementation xsImpl = (XSImplementation) registry.getDOMImplementation("XS-Loader");
			XSLoader loader = xsImpl.createXSLoader(null);
			
			XSModel model = loader.loadURI(xsdFile);
			XSNamedMap map = model.getComponents(XSConstants.ELEMENT_DECLARATION);
			
			for(int i = 0; i < map.getLength(); i++) {
				XSObject object = map.item(i);
				System.out.println(object.toString());
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
	

    private static void printUsage() {
        System.err.println("Usage: java net.cyberroadie.tests.xerces. [rib file]");
    }
    
}
