package com.github.nielsonrocha.cobranca.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class PosVencimento implements Serializable {
	
	private static final long serialVersionUID = -4464300212111149305L;
	
	public PosVencimento() {
	}

	public PosVencimento(String acao, String numeroDias) {
		this.acao = acao;
		this.numeroDias = numeroDias;
	}

	@XmlElement(namespace="", name="ACAO")
	private String acao;
	
	@XmlElement(namespace="", name="NUMERO_DIAS")
	private String numeroDias;
}
