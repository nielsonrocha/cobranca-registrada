package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.nielsonrocha.cobranca.caixa.core.enums.Acao;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class PosVencimento implements Serializable {
	
	private static final long serialVersionUID = -4464300212111149305L;
	
	public PosVencimento() {
	}

	public PosVencimento(Acao acao, String numeroDias) {
		this.acao = acao.toString();
		this.numeroDias = numeroDias;
	}

	@XmlElement(namespace="", name="ACAO")
	private String acao;
	
	@XmlElement(namespace="", name="NUMERO_DIAS")
	private String numeroDias;
}
