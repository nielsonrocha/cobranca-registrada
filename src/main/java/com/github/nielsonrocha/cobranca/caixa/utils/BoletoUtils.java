package com.github.nielsonrocha.cobranca.caixa.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.codec.binary.Base64;
import org.xml.sax.SAXException;

public class BoletoUtils {

	private static Locale BRAZIL = new Locale("pt", "BR");

	public static String formataDataHora(Date data) {
		try {
			if (data != null) {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss", BRAZIL);
				return df.format(data);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static String formataData(Date data) {
		try {
			if (data != null) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", BRAZIL);
				return df.format(data);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static String encryptBase64(String string) {
		try {
			return Base64.encodeBase64String(encriptar(string));
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	private static byte[] encriptar(String valor) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(valor.getBytes());
		return md.digest();
	}

	public static boolean validateXMLSchema(String xsdPath, String xml) {
		try {
			ClassLoader classLoader = new BoletoUtils().getClass().getClassLoader();
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(classLoader.getResource(xsdPath).getFile()));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new StringReader(xml)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}
