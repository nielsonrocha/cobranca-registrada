package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;
import java.util.Date;

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
public class Comprovante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(namespace="", name="DATA")
	private Date data;
	
	@XmlElement(namespace="", name="HORA")
	private String hora;

}
