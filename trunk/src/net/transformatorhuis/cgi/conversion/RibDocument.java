/* 
   +----------------------------------------------------------------------+
   | RendermanXML                                                         |
   +----------------------------------------------------------------------+
   | Copyright (c) 2004 Cyberroadie                                       |
   +----------------------------------------------------------------------+
   | This source file is subject to version 2 of the GNU General Public   |
   | License, that is bundled with this package in the file LICENSE.      |
   |                                                                      |
   | This program is free software; you can redistribute it and/or modify |
   | it under the terms of the GNU General Public License as published by |
   | the Free Software Foundation; either version 2 of the License, or    |
   | (at your option) any later version.                                  |
   |                                                                      |
   | This program is distributed in the hope that it will be useful,      |
   | but WITHOUT ANY WARRANTY; without even the implied warranty of       |
   | MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the        |
   | GNU General Public License for more details.                         |
   |                                                                      |
   | You should have received a copy of the GNU General Public License    |
   | along with this program; if not, write to the Free Software          |
   | Foundation, Inc., 59 Temple Place, Suite 330, Boston,                |
   | MA  02111-1307  USA                                                  |
   |                                                                      |
   +----------------------------------------------------------------------+
   | Author: Olivier Van Acker <cyberroadie@yahoo.co.uk>                  |
   +----------------------------------------------------------------------+
*/
package net.transformatorhuis.cgi.conversion;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.xml.DOMConfigurator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;

import java.util.Stack;
import java.util.EmptyStackException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;

import javax.xml.transform.dom.DOMSource; 

import javax.xml.transform.stream.StreamResult; 

/**
 * Holds all information about status rib xml document
 * together with the document itself. 
 * Implements Singleton pattern.
 */
public class RibDocument implements RibOutput {

    static Logger logger = Logger.getLogger(RibDocument.class);
    
    private static RibDocument instance = null;
    
    /* Vector to keep track of current active xml element */
    private Stack parentNodes;
    
    private Element root;

    /**
     * All classes make use of the same (thus static) document 
     * Rib2Xml starts with empty document which get filled via 
     * the RibFactory. 
     */
    private static Document ribDoc;
    
    private Class ribClazz;

    private RibDocument() {
    
        /* Create empty xml document */
        DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
            ribDoc = docBuilder.newDocument();
        } catch (ParserConfigurationException ex) { } // No exception, empty document is created
    
        root = ribDoc.createElement("rib");
       
        parentNodes = new Stack();
        
        // Add first (root) element of xml doc
        parentNodes.push(root);
        logger.debug("Stack size (constructor): " + parentNodes.size());
        
    };

    /**
     * Instantiate the Ribdocument or get the already existing one.
     * RibDocument starts element calculation from within
     */
    public static RibDocument newInstance() {
            
        if(instance == null) {
            instance = new RibDocument();
            logger.debug("Created new RibDocument");
        }
        
        return instance;
        
    }
    
    public void doJob(Rib rib) {

        if(rib.isEndElement()) {
            try {
                parentNodes.pop();
                logger.debug("Stack size: " + parentNodes.size());
                logger.debug("--> End element");
            } catch (EmptyStackException ese) {
                logger.error("Wrong rib structure: " + ese.toString());
            }
        } else {
            // Here the Rib element get called to calculate the xml by giving it
            // to the xml document, needed to create nodes.
            logger.debug("Stack size: " + parentNodes.size());
            Node parentNode = (Node) parentNodes.pop();
            Node currentNode = rib.createXML(this);
            parentNode.appendChild(currentNode);
            parentNodes.push(parentNode);
            if(rib.hasChildElements()) {
                parentNodes.push(currentNode);
            }       
        }
        
    }
    
    public Element requestElement(String name) {
    
        return ribDoc.createElement(name);
        
    }
    
    public Text requestTextNode(String data) {
    
        return ribDoc.createTextNode(data);
        
    }
    
    public Comment requestComment(String data) {
    
        return ribDoc.createComment(data);
        
    }
    
    public void toFile() {
    
        ribDoc.appendChild(root);
        
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            
            DOMSource source = new DOMSource(ribDoc);
            StreamResult result = new StreamResult(System.out);
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(source, result);    
    
        } catch (TransformerConfigurationException tce) { 
            logger.debug(tce.toString());
        } catch (TransformerException te) {
            logger.debug(te.toString());
        }
        
        // Document is finished, so cleaning up
        finalize();
        
    }

    public void finalize() {
        instance = null;
    }

}