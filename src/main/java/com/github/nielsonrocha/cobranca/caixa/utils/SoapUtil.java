package com.github.nielsonrocha.cobranca.caixa.utils;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.github.nielsonrocha.cobranca.caixa.soap.Operacao;

public class SoapUtil {

	public static Object soapRequest(String url, Operacao operacao, String xml) throws Exception{
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapResponse = soapConnection.call(createSoapMessage(operacao.toString(),operacao.getAction(),xml), url);
            soapConnection.close();
            return getSoapResponse(soapResponse);
        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception("Falha de comunicação com o Servidor");
        } 
    }
 
    public static SOAPMessage createSoapMessage(String op, String action, String xml) throws Exception {
    	MimeHeaders headers = new MimeHeaders();
        headers.addHeader("Content-Type", "text/xml");
        headers.setHeader("SOAPAction", action);
        headers.addHeader("Operation", op);
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(headers, (new ByteArrayInputStream(xml.getBytes())));
        
        return soapMessage;
    }
    
    private static String getSoapResponse(SOAPMessage soapResponse) throws Exception {
        Document xmlRespostaARequisicao=soapResponse.getSOAPBody().getOwnerDocument();
        return passarXMLParaString(xmlRespostaARequisicao, 4);
    }
    
    public static String passarXMLParaString(Document xml, int espacosIdentacao){
        try {
            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            transfac.setAttribute("indent-number", new Integer(espacosIdentacao));
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
 
            //create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(xml);
            trans.transform(source, result);
            String xmlString = sw.toString();
            return xmlString;
        }
        catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
