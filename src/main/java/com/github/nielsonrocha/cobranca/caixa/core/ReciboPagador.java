package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ReciboPagador implements Serializable {

	private static final long serialVersionUID = 7339703223344200981L;

	@XmlElement(namespace="", name="MENSAGENS")
	private List<Mensagem> mensagens;
}
