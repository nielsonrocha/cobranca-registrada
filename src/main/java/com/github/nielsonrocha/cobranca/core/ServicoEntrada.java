package com.github.nielsonrocha.cobranca.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name="SERVICO_ENTRADA")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class ServicoEntrada implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="HEADER")
	private Header header;
	
	@XmlElement(namespace="", name="DADOS")
	private Dados dados;

}