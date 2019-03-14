package com.github.nielsonrocha.cobranca.caixa.soap;

public enum Operacao {

	INCLUI_BOLETO("IncluiBoleto"), 
	BAIXA_BOLETO("BaixaBoleto"), 
	ALTERA_BOLETO("AlteraBoleto"),
	CONSULTA_BOLETO("http://caixa.gov.br/sibar/consulta_cobranca_bancaria/boleto/NewOperation");
	
	private String action;
	
	Operacao(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}

