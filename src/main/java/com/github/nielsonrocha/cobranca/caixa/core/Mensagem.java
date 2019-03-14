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
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 3993973813921883890L;
	
	public Mensagem() {
	}
	
	public Mensagem(String mensagem1, String mensagem2) {
		this.mensagem1 = mensagem1;
		this.mensagem2 = mensagem2;
	}



	@XmlElement(namespace="", name="MENSAGEM")
	private String mensagem1;
	
	@XmlElement(namespace="", name="MENSAGEM")
	private String mensagem2;
}
