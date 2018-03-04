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
public class PagadorAvalista implements Serializable {

	private static final long serialVersionUID = -5569108687165474537L;

	@XmlElement(namespace="", name="CPF")
	private String cpf;
	
	@XmlElement(namespace="", name="NOME")
	private String nome;
	
	@XmlElement(namespace="", name="CNPJ")
	private String cnpj;
	
	@XmlElement(namespace="", name="RAZAO_SOCIAL")
	private String razaoSocial;
	
	@XmlElement(namespace="", name="ENDERECO")
	private Endereco endereco;
}
