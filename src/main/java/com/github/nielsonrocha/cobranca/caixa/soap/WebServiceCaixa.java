package com.github.nielsonrocha.cobranca.caixa.soap;

import static com.github.nielsonrocha.cobranca.caixa.utils.SoapUtil.soapRequest;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.github.nielsonrocha.cobranca.caixa.core.Envelope;

public class WebServiceCaixa {
	
	static final String URL_CONSULTA  = "http://barramento.caixa.gov.br/sibar/ConsultaCobrancaBancaria/Boleto";
	static final String URL_REGISTRO  = "http://barramento.caixa.gov.br/sibar/ManutencaoCobrancaBancaria/Boleto/Externo";
	

	public static Envelope enviarRequisicao(TipoRequisicao tipoReq, Operacao operacao, String xml) throws Exception {
		String url = null;
		switch (tipoReq) {
			case REGISTRO:
				url = URL_REGISTRO;
				break;
			case CONSULTA:
				url = URL_CONSULTA;
		}
		String ret = (String)soapRequest(url, operacao , xml);
        
		JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(ret);
		return (Envelope) unmarshaller.unmarshal(reader);		
	}
}
