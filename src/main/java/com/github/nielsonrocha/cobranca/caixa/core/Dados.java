package com.github.nielsonrocha.cobranca.caixa.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class Dados implements Serializable {

	private static final long serialVersionUID = 5780606368112755108L;

	@XmlElement(namespace="", name="INCLUI_BOLETO")
	private IncluiBoleto incluiBoleto;
	
	@XmlElement(namespace="", name="BAIXA_BOLETO")
	private BaixaBoleto baixaBoleto;
	
	@XmlElement(namespace="", name="ALTERA_BOLETO")
	private AlteraBoleto alteraBoleto;
	
	@XmlElement(namespace="", name="CONSULTA_BOLETO")
	private ConsultaBoleto consultaBoleto;
	
	@XmlElement(namespace="", name="CONTROLE_NEGOCIAL")
	private ControleNegocial controleNeogical;
	
	@XmlElement(namespace="", name="COMPROVANTE")
	private Comprovante comprovante;
	
	@XmlElement(namespace="", name="EXCECAO")
	private String excecao;
}
