package net.transformatorhuis.xsd;

import org.junit.Before;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import net.transformatorhuis.xsd.ObjectFactory;
import net.transformatorhuis.xsd.Rib;
import net.transformatorhuis.teapot.BrokenTeapotException;

import java.util.List;
import java.io.StringReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: cyberroadie
 * Date: Feb 15, 2007
 * Time: 12:00:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralRibTest {

    /**
     * JAXB context.
     */
    private JAXBContext jc;

    private Marshaller m;

    private ObjectFactory objFactory;

    protected Rib rib;

    private List ribList;

    /**
     * Root element.
     */
    private Element root;

    private String xmlFragment;

    /**
     * DOM document
     */
    protected Document ribDoc;

    public Document getDOMFromJAXB(Object jaxbNode) throws JAXBException, ParserConfigurationException, IOException, SAXException {

        /* First create the JAXB container */
        jc = JAXBContext.newInstance("net.transformatorhuis.xsd");
        m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        objFactory = new ObjectFactory();

        // Intial setup renderman file
        rib = objFactory.createRib();
        rib.setVersion("3.03");
        ribList = rib.getDisplayOrProjectionOrRotate();
        ribList.add(jaxbNode);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = null;
        Document doc = null;
        db = dbf.newDocumentBuilder();
        doc = db.newDocument();
        m.marshal(rib, doc);
       
        return doc;

    }

    public Document getDOMDocument(String documentFragment) throws ParserConfigurationException, IOException, SAXException {
        /* Create empty xml document */
        DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
        ribDoc = docBuilder.newDocument();

        root = ribDoc.createElement("rib");
        root.setAttribute("version", "3.03");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document d = factory.newDocumentBuilder().parse(
                new InputSource(new StringReader(xmlFragment)));

        // Import the nodes of the new document into doc so that they
        // will be compatible with doc
        Node node = ribDoc.importNode(d.getDocumentElement(), true);

        // Create the document fragment node to hold the new nodes
        DocumentFragment docfrag = ribDoc.createDocumentFragment();

        // Move the nodes into the fragment
        while (node.hasChildNodes()) {
            docfrag.appendChild(node.removeChild(node.getFirstChild()));
        }

        root.appendChild(docfrag);

        return ribDoc;
    }

    protected void addRibElement(Object ribElement) {
        ribList.add(ribElement);
    }

    protected void toSystemOut() throws JAXBException {
        m.marshal(rib, System.out);
    }

    public boolean compareDocuments(Document docLeft, Document docRight) {

        NodeList leftNodes = docLeft.getChildNodes();
        NodeList rightNodes = docRight.getChildNodes();

        Node leftNode = leftNodes.item(2);
        Node rightNode = rightNodes.item(2);

        return leftNode.isSameNode(rightNode);
        
    }
}
