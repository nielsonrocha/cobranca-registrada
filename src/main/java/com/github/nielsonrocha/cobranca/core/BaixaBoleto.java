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
public class BaixaBoleto implements Serializable {

	private static final long serialVersionUID = -2275698560231415364L;

	@XmlElement(namespace="", name="CODIGO_BENEFICIARIO")
	private Integer codigoBeneficiario;
	
	@XmlElement(namespace="", name="NOSSO_NUMERO")
	private Long nossoNumero;
}
