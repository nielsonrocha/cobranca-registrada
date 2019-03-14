package br.com.nsistemas.cobranca.test;

import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.github.nielsonrocha.cobranca.caixa.core.Body;
import com.github.nielsonrocha.cobranca.caixa.core.ConsultaBoleto;
import com.github.nielsonrocha.cobranca.caixa.core.Dados;
import com.github.nielsonrocha.cobranca.caixa.core.Endereco;
import com.github.nielsonrocha.cobranca.caixa.core.Envelope;
import com.github.nielsonrocha.cobranca.caixa.core.FichaCompensacao;
import com.github.nielsonrocha.cobranca.caixa.core.Header;
import com.github.nielsonrocha.cobranca.caixa.core.IncluiBoleto;
import com.github.nielsonrocha.cobranca.caixa.core.JurosMora;
import com.github.nielsonrocha.cobranca.caixa.core.Mensagem;
import com.github.nielsonrocha.cobranca.caixa.core.PagadorAvalista;
import com.github.nielsonrocha.cobranca.caixa.core.Pagamento;
import com.github.nielsonrocha.cobranca.caixa.core.PosVencimento;
import com.github.nielsonrocha.cobranca.caixa.core.ServicoEntrada;
import com.github.nielsonrocha.cobranca.caixa.core.Titulo;
import com.github.nielsonrocha.cobranca.caixa.core.enums.Acao;
import com.github.nielsonrocha.cobranca.caixa.core.enums.TipoPagamento;
import com.github.nielsonrocha.cobranca.caixa.soap.Operacao;
import com.github.nielsonrocha.cobranca.caixa.soap.TipoRequisicao;
import com.github.nielsonrocha.cobranca.caixa.soap.WebServiceCaixa;
import com.github.nielsonrocha.cobranca.caixa.utils.BoletoUtils;

public class Test {
	
	static final String BENEFICIARIO="0781772"; // 359034
	static final String NOSSO_NUMERO="14000000000000001";
	static final String VENICMENTO = "15042018";
	static final String VALOR = "000000000000124";
	static final String CNPJ = "06400592000115";
	
	public static void main(String[] args) {
		//consultaBoleto();
		registrarBoleto();
	}
	
	static void consultaBoleto() {
		ServicoEntrada boleto = new ServicoEntrada();
		
		// Criando header
		Header header = new Header();
		header.setAutenticacao(BoletoUtils.encryptBase64(BENEFICIARIO+NOSSO_NUMERO+"00000000"+"000000000000000"+CNPJ));
		header.setVersao("1");
		header.setOperacao(Operacao.CONSULTA_BOLETO.toString());
		header.setSistemaOrigem("SIGCB");
		header.setDataHora(BoletoUtils.formataDataHora(new Date()));
		header.setUsuarioServico("SGCBS02P");
		//header.setUnidade("1521"); 
		header.setUnidade("1739");
		
		// Criando dados
		Dados dados = new Dados();
		
		ConsultaBoleto consulta = new ConsultaBoleto();
		consulta.setCodigoBeneficiario(Integer.parseInt(BENEFICIARIO));
		consulta.setNossoNumero(Long.parseLong(NOSSO_NUMERO));
		
		dados.setConsultaBoleto(consulta);
		
		boleto.setHeader(header);
		boleto.setDados(dados);
		
		try {

			// Envelopar
			Envelope env = new Envelope();
			Body body = new Body();
			body.setServicoEntradaConsulta(boleto);
			//body.setServicoSaida(boleto);
			env.setBody(body);
			
			// File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");

			// jaxbMarshaller.marshal(boleto, file);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(env, sw);
			//System.out.println(sw.toString());
			WebServiceCaixa.enviarRequisicao(TipoRequisicao.CONSULTA, Operacao.CONSULTA_BOLETO,sw.toString());

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Falha ao gerar SOAP");
			e.printStackTrace();
		}
	}
	
	static void registrarBoleto() {
		ServicoEntrada boleto = new ServicoEntrada();
		
		// Criando header
		Header header = new Header();
		
		header.setAutenticacao(BoletoUtils.encryptBase64(BENEFICIARIO+NOSSO_NUMERO+VENICMENTO+VALOR+CNPJ));
		header.setVersao("1");
		header.setOperacao("INCLUI_BOLETO");
		header.setSistemaOrigem("SIGCB");
		header.setDataHora(BoletoUtils.formataDataHora(new Date()));
		header.setUsuarioServico("SGCBS02P");
		header.setUnidade("1521"); 
		//header.setUnidade("1739");
		
		// Criando dados
		Dados dados = new Dados();
		
		// Incluindo Boleto
		IncluiBoleto incBoleto = new IncluiBoleto();
		incBoleto.setCodigoBeneficiario(Integer.parseInt(BENEFICIARIO));
		
		// setando titulo
		Titulo titulo = new Titulo();
		titulo.setNossoNumero(Long.valueOf(NOSSO_NUMERO));
		titulo.setNumeroDocumento("130.107716");
		titulo.setDataVencimento("2018-04-15");
		titulo.setValor("1.24");
		titulo.setTipoEspecie("02");
		titulo.setFlagAceite("S");
		titulo.setDataEmissao("2018-03-20");
		// juros e mora
		titulo.setJurosMora(new JurosMora("TAXA_MENSAL","2018-04-20", null, "2.00"));
		titulo.setValorAbatimento("0");
		// pos vencimento
		titulo.setPosVencimento(new PosVencimento(Acao.DEVOLVER, "60"));
		titulo.setCodigoMoeda("09");
		// pagador
		PagadorAvalista pagador = new PagadorAvalista();
		pagador.setCpf("50881566349");
		pagador.setNome("WANCLAUJEJANE ARAUJO SAMPAIO");
		// endereco do pagador
		Endereco endereco = new Endereco();
		endereco.setBairro("JARDIM TURU");
		endereco.setCep("65110000");
		endereco.setCidade("SAO LUIS / MA");
		endereco.setLogradouro("RUA E N 34");
		endereco.setUf("MA");
		pagador.setEndereco(endereco);
		titulo.setPagador(pagador);
		
		// pagamento
		Pagamento pagamento = new Pagamento();
		pagamento.setQuantidadePermitida(1);
		pagamento.setTipo(TipoPagamento.NAO_ACEITA_VALOR_DIVERGENTE);
		pagamento.setValorMinimo("0.00");
		pagamento.setValorMaximo("0.00");
		titulo.setPagamento(pagamento);
		
		Mensagem mensagens = new Mensagem("COBRAR JUROS SOMENTE APOS 5 DIAS VENCID","FONE:3235-3092");
		
		FichaCompensacao fichaComp = new FichaCompensacao();
		fichaComp.setMensagens(mensagens);
		
		titulo.setFichaCompensacao(fichaComp);
		
		incBoleto.setTitulo(titulo);
		
		dados.setIncluiBoleto(incBoleto);
		
		boleto.setHeader(header);
		boleto.setDados(dados);
		try {

			// Envelopar
			Envelope env = new Envelope();
			Body body = new Body();
			body.setServicoEntrada(boleto);
			env.setBody(body);
			
			// File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");

			// jaxbMarshaller.marshal(boleto, file);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(env, sw);
			
			System.out.println(sw.toString());
			Envelope saida = WebServiceCaixa.enviarRequisicao(TipoRequisicao.REGISTRO, Operacao.INCLUI_BOLETO,sw.toString());

			System.out.println(saida);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Falha ao gerar SOAP");
			e.printStackTrace();
		}

	}
}
