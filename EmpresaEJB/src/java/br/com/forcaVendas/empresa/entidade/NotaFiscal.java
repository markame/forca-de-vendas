package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.INotaFiscal;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author João Luiz
 */
@Entity
public class NotaFiscal implements INotaFiscal, Serializable {
    private static final long serialVersionUID = 1L;

    //Valores default de referência para o tipo de nota fiscal
    public static final short NOTA_FISCAL_ENTRADA = 0;
    public static final short NOTA_FISCAL_SAIDA = 1;

    //Valores default de referência para a responsabilidade do frete (CIF/FOB)
    public static final short FRETE_CONTA_EMITENTE = 1;
    public static final short FRETE_CONTA_DESTINATARIO = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    //Tipo de nota fiscal: saída/entrada
    @Column
    private short tipoNota;

    //Tipo de frete: CIF/FOB
    @Column
    private short fretePorConta;
    
    //Informações sobre a empresa que emite a nota Fiscal
    @Column
    private String NomeEmissor;
    @Column
    private String enderecoEmissor;
    @Column
    private Long cnpjEmissor;
    @Column
    private String telefoneEmissor;


    //Informações sobre o transportador
    @Column
    private String NomeTransp;
    @Column
    private String enderecoTransp;
    @Column
    private Long cnpjTransp;
    @Column
    private String telefoneTransp;

    //Data de emissão da nota
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;

    //Chave estrangeira para o pedido
    @Column
    private Integer codigoPedido;


    //Valores Totais da Nota Fiscal
    @Column
    private Double valorProdutos;
    @Column
    private Double valorServicos;
    @Column
    private Double valorImpostos;
    @Column
    private Double valorTotalNota;


    //Iformações Adicionais
    @Column
    private String dadosAdicionais;

    public NotaFiscal() {
    }

    public NotaFiscal(  short tipoNota,
                        short fretePorConta,
                        String NomeEmissor,
                        String enderecoEmissor,
                        Long cnpjEmissor,
                        String telefoneEmissor,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Date dataEmissao,
                        Integer codigoPedido,
                        Double valorProdutos,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais)
    {
        this.tipoNota = tipoNota;
        this.fretePorConta = fretePorConta;
        this.NomeEmissor = NomeEmissor;
        this.enderecoEmissor = enderecoEmissor;
        this.cnpjEmissor = cnpjEmissor;
        this.telefoneEmissor = telefoneEmissor;
        this.NomeTransp = NomeTransp;
        this.enderecoTransp = enderecoTransp;
        this.cnpjTransp = cnpjTransp;
        this.telefoneTransp = telefoneTransp;
        this.dataEmissao = dataEmissao;
        this.codigoPedido = codigoPedido;
        this.valorProdutos = valorProdutos;
        this.valorServicos = valorServicos;
        this.valorImpostos = valorImpostos;
        this.dadosAdicionais = dadosAdicionais;

        this.valorTotalNota = valorProdutos + valorImpostos + valorServicos;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeEmissor() {
        return NomeEmissor;
    }

    public void setNomeEmissor(String NomeEmissor) {
        this.NomeEmissor = NomeEmissor;
    }

    public String getNomeTransp() {
        return NomeTransp;
    }

    public void setNomeTransp(String NomeTransp) {
        this.NomeTransp = NomeTransp;
    }

    public Long getCnpjEmissor() {
        return cnpjEmissor;
    }

    public void setCnpjEmissor(Long cnpjEmissor) {
        this.cnpjEmissor = cnpjEmissor;
    }

    public Long getCnpjTransp() {
        return cnpjTransp;
    }

    public void setCnpjTransp(Long cnpjTransp) {
        this.cnpjTransp = cnpjTransp;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(String dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

    public Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getEnderecoEmissor() {
        return enderecoEmissor;
    }

    public void setEnderecoEmissor(String enderecoEmissor) {
        this.enderecoEmissor = enderecoEmissor;
    }

    public String getEnderecoTransp() {
        return enderecoTransp;
    }

    public void setEnderecoTransp(String enderecoTransp) {
        this.enderecoTransp = enderecoTransp;
    }

    public short getFretePorConta() {
        return fretePorConta;
    }

    public void setFretePorConta(short fretePorConta) {
        this.fretePorConta = fretePorConta;
    }

    public String getTelefoneEmissor() {
        return telefoneEmissor;
    }

    public void setTelefoneEmissor(String telefoneEmissor) {
        this.telefoneEmissor = telefoneEmissor;
    }

    public String getTelefoneTransp() {
        return telefoneTransp;
    }

    public void setTelefoneTransp(String telefoneTransp) {
        this.telefoneTransp = telefoneTransp;
    }

    public short getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(short tipoNota) {
        this.tipoNota = tipoNota;
    }

    public Double getValorImpostos() {
        return valorImpostos;
    }

    public void setValorImpostos(Double valorImpostos) {
        this.valorImpostos = valorImpostos;
    }

    public Double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Double getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(Double valorServicos) {
        this.valorServicos = valorServicos;
    }

    public Double getValorTotalNota() {
        return valorTotalNota;
    }

    public void setValorTotalNota(Double valorTotalNota) {
        this.valorTotalNota = valorTotalNota;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaFiscal)) {
            return false;
        }
        NotaFiscal other = (NotaFiscal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.NotaFiscal[codigo=" + codigo + "]";
    }

}
