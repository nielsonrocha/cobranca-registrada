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
public class Body implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="SERVICO_ENTRADA", namespace="http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo")
	private ServicoEntrada servicoEntrada;
	
	@XmlElement(name="SERVICO_ENTRADA", namespace="http://caixa.gov.br/sibar/consulta_cobranca_bancaria/boleto")
	private ServicoEntrada servicoEntradaConsulta;
	
}