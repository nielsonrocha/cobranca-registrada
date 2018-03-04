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
public class Endereco implements Serializable {

	private static final long serialVersionUID = -8966921607714896912L;

	@XmlElement(namespace="", name="LOGRADOURO")
	private String logradouro;
	
	@XmlElement(namespace="", name="BAIRRO")
	private String bairro;
	
	@XmlElement(namespace="", name="CIDADE")
	private String cidade;
	
	@XmlElement(namespace="", name="UF")
	private String uf;
	
	@XmlElement(namespace="", name="CEP")
	private String cep;
}
