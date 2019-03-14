package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.nielsonrocha.cobranca.caixa.core.enums.TipoPagamento;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 2696785082633484495L;

	@XmlElement(namespace="", name="QUANTIDADE_PERMITIDA")
	private Integer quantidadePermitida;
	
	@XmlElement(namespace="", name="TIPO")
	private TipoPagamento tipo;
	
	@XmlElement(namespace="", name="VALOR_MINIMO")
	private String valorMinimo;
	
	@XmlElement(namespace="", name="VALOR_MAXIMO")
	private String valorMaximo;
	
	@XmlElement(namespace="", name="PERCENTUAL_MINIMO")
	private String percentualMinimo;
	
	@XmlElement(namespace="", name="PERCENTUAL_MAXIMO")
	private String percentualMaximo;
}
