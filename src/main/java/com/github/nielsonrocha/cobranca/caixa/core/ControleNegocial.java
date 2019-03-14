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
public class ControleNegocial implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(namespace="", name="ORIGEM_RETORNO")
	private String origemRetorno;
	
	@XmlElement(namespace="", name="COD_RETORNO")
	private String codigoRetorno;
	
	@XmlElement(namespace="", name="NSU")
	private String nsu;
	
	@XmlElement(namespace="", name="MENSAGENS")
	private Mensagens mensagens;
	
}
