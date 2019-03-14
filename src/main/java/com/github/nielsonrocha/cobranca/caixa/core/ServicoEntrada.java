package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name="SERVICO_ENTRADA")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ServicoEntrada implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="HEADER")
	private Header header;
	
	@XmlElement(namespace="", name="DADOS")
	private Dados dados;

}
