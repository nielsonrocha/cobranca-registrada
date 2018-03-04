package com.github.nielsonrocha.cobranca.caixa.core;

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
public class Header implements Serializable {

	private static final long serialVersionUID = -4802892638191641783L;

	@XmlElement(namespace="", name="VERSAO")
	private String versao;
	
	@XmlElement(namespace="", name="AUTENTICACAO")
	private String autenticacao;
	
	/**
	 * Informar SGCBS02P 
	 */
	@XmlElement(namespace="", name="USUARIO_SERVICO")
	private String usuarioServico;
	
	/**
	 * INCLUI_BOLETO BAIXA_BOLETO ALTERA_BOLETO 
	 * Dados a serem usados. Uma informação para cada operação (Incluir, Baixar ou Alterar). 
	 */
	@XmlElement(namespace="", name="OPERACAO")
	private String operacao;
	
	@XmlElement(namespace="", name="INDICE")
	private String indice;
	
	/**
	 * Informar SIGCB 
	 */
	@XmlElement(namespace="", name="SISTEMA_ORIGEM")
	private String sistemaOrigem;
	
	/**
	 * NÚMERO DA AGÊNCIA DE RELACIONAMENTO, COM 4 POSIÇÕES, SEM DV 
	 */
	@XmlElement(namespace="", name="UNIDADE")
	private String unidade;
	
	/**
	 * IP DA MÁQUINA DO PAGADOR QUE REQUISITOU O REGISTRO DO BOLETO 
	 */
	@XmlElement(namespace="", name="IDENTIFICADOR_ORIGEM")
	private String identificadorOrigem;
	
	@XmlElement(namespace="", name="DATA_HORA")
	private String dataHora;
	
	/**
	 * Código do BENEFICIÁRIO, sem DV 
	 */
	@XmlElement(namespace="", name="ID_PROCESSO")
	private String idProcesso;
		
}
