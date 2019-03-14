package com.github.nielsonrocha.cobranca.caixa.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoletoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dataVencimento;
	
	private String valor;
	
	private String nossoNumero;
	
	private String numeroDocumento;
	
	private String sacado;
	
	private String sacadoCpfCnpj;
	
	private String sacadoEndereco;
	
	private String sacadoBairro;
	
	private String sacadoCidade;
	
	private String sacadoUf;
	
	private String sacadoCep;
}
