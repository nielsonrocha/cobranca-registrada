package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class IncluiBoleto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(namespace="", name="CODIGO_BENEFICIARIO")
	private Integer codigoBeneficiario;
	
	@XmlElement(namespace="", name="TITULO")
	private Titulo titulo;
	
	@XmlElement(namespace="", name="CODIGO_BARRAS")
	private String codigoBarras;
	
	@XmlElement(namespace="", name="LINHA_DIGITAVEL")
	private String linhaDigitavel;
	
	@XmlElement(namespace="", name="URL")
	private String url;
	
	@XmlElement(namespace="", name="NOSSO_NUMERO")
	private Long nossoNumero;

}
