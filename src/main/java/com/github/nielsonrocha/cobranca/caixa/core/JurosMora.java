package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class JurosMora implements Serializable {

	private static final long serialVersionUID = 941361905518104264L;
	
	public JurosMora() {
	}

	public JurosMora(String tipo, String data, String valor, String percentual) {
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.percentual = percentual;
	}


	@XmlElement(namespace="", name="TIPO")
	private String tipo;
	
	@XmlElement(namespace="", name="DATA")
	private String data;
	
	@XmlElement(namespace="", name="VALOR")
	private String valor;
	
	@XmlElement(namespace="", name="PERCENTUAL")
	private String percentual;
}
