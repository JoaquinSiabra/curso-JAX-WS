/*
 * ServicioReversoProviders.java
 */
package pservicioreverso;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import org.w3c.dom.*;

@ServiceMode(value = javax.xml.ws.Service.Mode.PAYLOAD)
@WebServiceProvider(serviceName = "ServicioReversoCService", portName = "ServicioReversoCPort", targetNamespace = "http://pservicioreverso/", wsdlLocation = "WEB-INF/wsdl/ServicioReverso/ServicioReverso.wsdl")
public class ServicioReverso implements javax.xml.ws.Provider<javax.xml.transform.Source> {
	
	private static final String REQ_NS = "http://pservicioreverso/";
	private static final String TAG_ARG0 = "arg0";

	public Source invoke(Source oPayload) {
		
		ByteArrayOutputStream oByteArrayOS = null;
		
		try {

			Document oPayloadDoc = convertirADOMSource(oPayload);

			String sCadRetorno = comprobarValidezPeticionRespectoWSDL(oPayloadDoc);

			oByteArrayOS = generarRespuesta(oPayload, oPayloadDoc, sCadRetorno);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return new StreamSource(new StringReader(oByteArrayOS.toString()));
	}

	private Document convertirADOMSource(Source oPayload) throws ParserConfigurationException,TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory oDocBuldFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder oDocBuilder = oDocBuldFact.newDocumentBuilder();
		Document oPayloadDoc = oDocBuilder.newDocument();
		
		Transformer oTransformer = TransformerFactory.newInstance().newTransformer();
		oTransformer.transform(oPayload, new DOMResult(oPayloadDoc));
		
		return oPayloadDoc;
	}

	private ByteArrayOutputStream generarRespuesta(Source oPayload,Document oPayloadDoc, String sCadRetorno) throws TransformerException, ParserConfigurationException {
		
		DocumentBuilderFactory oDocBuldFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder oDocBuilder = oDocBuldFact.newDocumentBuilder();
		oPayload = new DOMSource(oPayloadDoc);
		
		Document oRespDoc = oDocBuilder.newDocument();
		Element oResponseElem = oRespDoc.createElementNS(REQ_NS,"ns0:getReversoResponse");
		Element oRetElem = oRespDoc.createElement("return");
		oResponseElem.appendChild(oRetElem);
		Text oTexto = oRespDoc.createTextNode(sCadRetorno);
		oRetElem.appendChild(oTexto);
		
		ByteArrayOutputStream oByteArrayOS = new ByteArrayOutputStream();
		Transformer oTransformer = TransformerFactory.newInstance().newTransformer();
		oTransformer.transform(new DOMSource(oResponseElem), new StreamResult(oByteArrayOS));

		return oByteArrayOS;
	}
	

	/**
	 * Devuelve el hijo con el nombre (sin Namespace) que se indica; el primero
	 * si hay más de uno; null si no hay
	 */
	protected static final Element getHijo(Element oElemento, String sTag) {
		
		NodeList oHijos = oElemento.getChildNodes();
		for (int i = 0; i < oHijos.getLength(); i++) {
			
			Node oHijo = oHijos.item(i);
			if (oHijo.getNodeType() == Node.ELEMENT_NODE) {
				Element oElmHijo = (Element) oHijo;
				if (getTag(oElmHijo).equals(sTag))
					return oElmHijo;
			}
		}
		return null;
	}

	private String comprobarValidezPeticionRespectoWSDL(Document oPayloadDoc) throws Exception {
		
		Element oElement = getHijo(oPayloadDoc.getDocumentElement(), TAG_ARG0);
		String sCadena = oElement.getTextContent();
		if (sCadena == null || sCadena.equals(""))
			throw new Exception("La cadena no puede estar vacia");
		
		String sCadRetorno = "";
		for (int i = sCadena.length(); i > 0; i--) {
			sCadRetorno = sCadRetorno + sCadena.charAt(i - 1);
		}
		return sCadRetorno;
	}

	
	/**
	 * Devuelve el tag del elemento que se proporciona, sin el prefijo (si lo
	 * lleva) de namespace
	 */
	protected static final String getTag(Element oElemento) {
		final String SEPARADORPREFIJO = ":";
		String sTag = oElemento.getTagName();
		String sPrefijo = oElemento.getPrefix();
		if (sPrefijo != null) {
			if (!sPrefijo.endsWith(SEPARADORPREFIJO))
				sPrefijo += SEPARADORPREFIJO;
			if (sTag.startsWith(sPrefijo))
				return sTag.substring(sPrefijo.length());
		}
		return sTag;
	}

}