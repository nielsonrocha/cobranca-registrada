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
public class Descontos implements Serializable {

	private static final long serialVersionUID = 8345660378017925342L;

	@XmlElement(namespace="", name="DESCONTO")
	private List<Desconto> desconto;
}
