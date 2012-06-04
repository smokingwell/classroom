/*************************************************************
 *         BTAF - BBA Test Automation Framework              *
 *                                                           *
 *        Copyright (c) 2008 Nokia Siemens Network           *
 *                                                           *
 *                 All  Right  Reserved                      *
 *************************************************************/
package com.nsn.bba.btaf.docmgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.nsn.bba.btaf.util.SimpleLogger;

/**
 * Class XmlFileManger provide some service for common operation on XML file.
 * 
 * @author Li Jia
 * @version 1.01, 05/26/08
 * @since JDK1.5
 */
public class XmlFileManager {
	/** SCHEMA Language attribute name */
	private static final String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	/** SCHEMA Language attribute value */
	private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	/** SCHEMA Language attribute name */
	private static final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

	/**
	 * Protected method to get XML root node object from XML file, using the
	 * default schema file specified in the XML file to be validated.
	 * 
	 * @param strFilePathName
	 *            Path and name of XML file to be opened.
	 * @return Root node object of XML file to be opened.
	 */
	public Node getRootFromXmlFile(String strFilePathName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		factory.setAttribute(SCHEMA_LANGUAGE, XML_SCHEMA);

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new SchemaErrorHandler());
		} catch (ParserConfigurationException e) {
			SimpleLogger.devLog(e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		}

		/* Document Object for the DOM-Tree */
		Document doc = null;
		if (builder != null) {
			try {
				/* Try to build the DOM-Tree */
				doc = builder.parse(new File(strFilePathName));
			} catch (Exception e) {
				return null;
			}
		}

		if (doc != null) {
			Node root = doc.getDocumentElement();
			return root;
		} else {
			return null;
		}
	}

	/**
	 * Protected method to get XML root node object from XML file, with format
	 * validation by input schema file.
	 * 
	 * @param strFilePathName
	 *            Path and name of XML file to be opened.
	 * @param strSchema
	 *            Path and name of schema file. If <b>null</b> is input
	 * @return Root node object of XML file to be opened.
	 */
	public Node getRootFromXmlFileWithSchema(String strFilePathName,
			String strSchema) {
		assert strFilePathName != null;
		SimpleLogger.devLog(
				"Entrance [XmlFileManager.getRootFromXmlFileWithSchema("
						+ strFilePathName + ", " + strSchema + ")]",
				SimpleLogger.DOC_DEV_LOG_FILE);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		if (strSchema != null) {
			factory.setNamespaceAware(true);
			factory.setValidating(true);
			factory.setAttribute(SCHEMA_LANGUAGE, XML_SCHEMA);

			/*
			 * Specify our own schema - this overrides the schemaLocation in the
			 * XML file
			 */
			factory.setAttribute(SCHEMA_SOURCE, strSchema);
		}
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new SchemaErrorHandler());
		} catch (ParserConfigurationException e) {
			SimpleLogger.devLog(e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		}

		/* Document Object for the DOM-Tree */
		Document doc = null;
		if (builder != null) {
			/* Try to build the DOM-Tree */
			try {
				doc = builder.parse(new File(strFilePathName));
			} catch (SAXException e) {
				SimpleLogger.devLog(e.getMessage(),
						SimpleLogger.DOC_DEV_LOG_FILE);
				SimpleLogger.userLog("Failed to open " + strFilePathName);
				SimpleLogger
						.devLog(
								"Exit [XmlFileManager.getRootFromXmlFileWithSchema() with return value: null",
								SimpleLogger.DOC_DEV_LOG_FILE);
				return null;
			} catch (IOException e) {
				SimpleLogger.devLog(e.getMessage(),
						SimpleLogger.DOC_DEV_LOG_FILE);
				SimpleLogger.userLog("Failed to open " + strFilePathName);
				SimpleLogger
						.devLog(
								"Exit [XmlFileManager.getRootFromXmlFileWithSchema() with return value: null",
								SimpleLogger.DOC_DEV_LOG_FILE);
				return null;
			}
		}

		if (doc != null) {
			Node root = doc.getDocumentElement();
			SimpleLogger.devLog(
					"Exit [XmlFileManager.getRootFromXmlFileWithSchema() with return root value: "
							+ root.toString(), SimpleLogger.DOC_DEV_LOG_FILE);
			return root;
		} else {
			SimpleLogger
					.devLog(
							"Exit [XmlFileManager.getRootFromXmlFileWithSchema() with return value: null",
							SimpleLogger.DOC_DEV_LOG_FILE);
			return null;
		}
	}

	/**
	 * Protected method to get Document object from DocumentBuilderFactory
	 * 
	 * @return Derived Document object.
	 */
	public static Document getDocument() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {

			return null;
		}
	}

	/**
	 * Protected method to create XML file with Document object and file path
	 * name.
	 * 
	 * @param doc
	 *            Document object containing
	 * @param filePathName
	 *            File path name to be created.
	 */
	public static void createXmlFile(Document doc, String filePathName) {
		try {
			// Settings for the file output
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);

			// Save DOM-Tree to file
			FileOutputStream os = new FileOutputStream(new File(filePathName));
			StreamResult result = new StreamResult(os);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			SimpleLogger.devLog(
					"TransformerConfigurationException in createXmlFile --- "
							+ e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		} catch (TransformerFactoryConfigurationError e) {
			SimpleLogger.devLog(
					"TransformerFactoryConfigurationError in createXmlFile --- "
							+ e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		} catch (FileNotFoundException e) {
			SimpleLogger.devLog("FileNotFoundException in createXmlFile --- "
					+ e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		} catch (TransformerException e) {
			SimpleLogger.devLog("TransformerException in createXmlFile --- "
					+ e.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
		}
	}

	/**
	 * 
	 * Protected method to create text node in XML file.
	 * 
	 * @param doc
	 *            Document object on which the XML file is created.
	 * @param name
	 *            Name of the text element.
	 * @param value
	 *            Value of the text elemnt.
	 * @return Node object newly created.
	 */
	public static Node createTextNode(Document doc, String name, String value) {
		Node tmpNode = doc.createElement(name);
		Text tmpValue = doc.createTextNode(value);
		tmpNode.appendChild(tmpValue);

		return tmpNode;
	}

	/**
	 * Protected method to create an attribute for XML element
	 * 
	 * @param name
	 *            The name of the attribute to be created.
	 * @param value
	 *            The value of the attribute to be created.
	 * @param node
	 *            The node object of element to create attribute on.
	 */
	protected void createAttribute(String name, String value, Node node) {
		Document doc = node.getOwnerDocument();
		Attr attr = doc.createAttribute(name);
		attr.setTextContent(value);
		node.getAttributes().setNamedItem(attr);
	}

	/**
	 * 
	 * Class SchemaErrorHandler is the handler for error handling if there is
	 * any error comes when doing XML validation with schema file.
	 * 
	 * @author Li Jia
	 * @version 1.0.1
	 * @since JDK 1.5
	 */
	static class SchemaErrorHandler implements ErrorHandler {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
		 */
		public void error(final SAXParseException exception)
				throws SAXParseException {
			SimpleLogger.devLog(
					exception.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
			SimpleLogger.userLog(exception.getMessage());
			throw exception;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.ErrorHandler#fatalError(org.xml.sax.SAXParseException)
		 */
		public void fatalError(final SAXParseException exception)
				throws SAXParseException {
			SimpleLogger.devLog(
					exception.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
			SimpleLogger.userLog(exception.getMessage());
			throw exception;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
		 */
		public void warning(final SAXParseException exception)
				throws SAXParseException {
			SimpleLogger.devLog(
					exception.getMessage(), SimpleLogger.DOC_DEV_LOG_FILE);
			SimpleLogger.userLog(exception.getMessage());
			throw exception;
		}
	}
}
