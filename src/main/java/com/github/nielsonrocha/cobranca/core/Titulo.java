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
public class Titulo implements Serializable {

	private static final long serialVersionUID = 6356290471571509661L;

	/**
	 * Caso o BENEFICIÁRIO venha a controlar a geração do Nosso Número, 
	 * deverá informá-lo no campo em questão; 
	 * Caso contrário, se a CAIXA for gerá-lo preencher o campo com zeros. 
	 */
	@XmlElement(namespace="", name="NOSSO_NUMERO")
	private Long nossoNumero;
	
	@XmlElement(namespace="", name="NUMERO_DOCUMENTO")
	private String numeroDocumento;
	
	@XmlElement(namespace="", name="DATA_VENCIMENTO")
	private String dataVencimento;
	
	@XmlElement(namespace="", name="VALOR")
	private String valor;
	
	@XmlElement(namespace="", name="TIPO_ESPECIE")
	private String tipoEspecie;
	
	@XmlElement(namespace="", name="FLAG_ACEITE")
	private String flagAceite;
	
	@XmlElement(namespace="", name="DATA_EMISSAO")
	private String dataEmissao;
	
	@XmlElement(namespace="", name="JUROS_MORA")
	private JurosMora jurosMora; 

	@XmlElement(namespace="", name="VALOR_ABATIMENTO")
	private String valorAbatimento;
	
	@XmlElement(namespace="", name="POS_VENCIMENTO")
	private PosVencimento posVencimento;
	
	@XmlElement(namespace="", name="CODIGO_MOEDA")
	private String codigoMoeda;
	
	@XmlElement(namespace="", name="PAGADOR")
	private PagadorAvalista pagador;
	
	@XmlElement(namespace="", name="SACADOR_AVALISTA")
	private PagadorAvalista sacadorAvalista;
	
	@XmlElement(namespace="", name="MULTA")
	private Multa multa;
	
	@XmlElement(namespace="", name="DESCONTOS")
	private Descontos descontos;
	
	@XmlElement(namespace="", name="VALOR_IOF")
	private String valorIOF;
	
	@XmlElement(namespace="", name="IDENTIFICACAO_EMPRESA")
	private String identificacaoEmpresa;
	
	@XmlElement(namespace="", name="FICHA_COMPENSACAO")
	private FichaCompensacao fichaCompensacao;
	
	@XmlElement(namespace="", name="RECIBO_PAGADOR")
	private ReciboPagador reciboPagador;
	
	@XmlElement(namespace="", name="PAGAMENTO")
	private Pagamento pagamento;
}
