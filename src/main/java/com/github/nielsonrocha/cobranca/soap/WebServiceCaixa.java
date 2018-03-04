package com.github.nielsonrocha.cobranca.soap;

import static com.github.nielsonrocha.cobranca.utils.SoapUtil.*;

public class WebServiceCaixa {
	
	static final String URL_CONSULTA  = "http://barramento.caixa.gov.br/sibar/ConsultaCobrancaBancaria/Boleto";
	static final String URL_REGISTRO  = "http://barramento.caixa.gov.br/sibar/ManutencaoCobrancaBancaria/Boleto/Externo";
	
	public static void enviarRequisicao(TipoRequisicao tipoReq, Operacao operacao, String xml) throws Exception {
		String url = null;
		switch (tipoReq) {
			case REGISTRO:
				url = URL_REGISTRO;
				break;
			case CONSULTA:
				url = URL_CONSULTA;
		}
		String ret = (String)soapRequest(url, operacao , xml);
        System.out.println(ret);
	}
}
