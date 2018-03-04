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
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 2696785082633484495L;

	@XmlElement(namespace="", name="QUANTIDADE_PERMITIDA")
	private Integer quantidadePermitida;
	
	@XmlElement(namespace="", name="TIPO")
	private String tipo;
	
	@XmlElement(namespace="", name="VALOR_MINIMO")
	private String valorMinimo;
	
	@XmlElement(namespace="", name="VALOR_MAXIMO")
	private String valorMaximo;
	
	@XmlElement(namespace="", name="PERCENTUAL_MINIMO")
	private String percentualMinimo;
	
	@XmlElement(namespace="", name="PERCENTUAL_MAXIMO")
	private String percentualMaximo;
}
