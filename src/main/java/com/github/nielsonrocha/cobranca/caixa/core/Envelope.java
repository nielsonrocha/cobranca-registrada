package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name="Envelope",namespace="http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class Envelope implements Serializable {

	private static final long serialVersionUID = -3821619287386781295L;

	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	private Body body;
}
