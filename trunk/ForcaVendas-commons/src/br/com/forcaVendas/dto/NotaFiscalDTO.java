/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.INotaFiscal;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public class NotaFiscalDTO implements INotaFiscal{
    private Long codigo;

    //Tipo de nota fiscal: saída/entrada
    private short tipoNota;

    //Tipo de frete: CIF/FOB
    private short fretePorConta;

    //Informações sobre a empresa que emite a nota Fiscal
    private String NomeEmissor;
    private String enderecoEmissor;
    private Long cnpjEmissor;
    private String telefoneEmissor;


    //Informações sobre o transportador
    private String NomeTransp;
    private String enderecoTransp;
    private Long cnpjTransp;
    private String telefoneTransp;

    //Data de emissão da nota
    private Date dataEmissao;

    //Chave estrangeira para o pedido
    private Long codigoPedido;


    //Valores Totais da Nota Fiscal
    private Double valorProdutos;
    private Double valorServicos;
    private Double valorImpostos;
    private Double valorTotalNota;


    //Iformações Adicionais
    private String dadosAdicionais;

    public NotaFiscalDTO(){
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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(String dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

    public Date getDataEmissao() {
        return dataEmissao;
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

    public static NotaFiscalDTO copy(INotaFiscal notaFiscal){
        NotaFiscalDTO notaFiscalDTO = null;

        if(notaFiscalDTO != null){
            notaFiscalDTO = new NotaFiscalDTO();

            notaFiscalDTO.setCnpjEmissor(notaFiscal.getCnpjEmissor());
            notaFiscalDTO.setCnpjTransp(notaFiscal.getCnpjTransp());
            notaFiscalDTO.setCodigo(notaFiscal.getCodigo());
            notaFiscalDTO.setCodigoPedido(notaFiscal.getCodigoPedido());

            notaFiscalDTO.setDadosAdicionais(notaFiscal.getDadosAdicionais());
            notaFiscalDTO.setDataEmissao(notaFiscal.getDataEmissao());
            notaFiscalDTO.setEnderecoEmissor(notaFiscal.getEnderecoEmissor());
            notaFiscalDTO.setEnderecoTransp(notaFiscal.getEnderecoTransp());

            notaFiscalDTO.setFretePorConta(notaFiscal.getFretePorConta());
            notaFiscalDTO.setNomeEmissor(notaFiscal.getNomeEmissor());
            notaFiscalDTO.setNomeTransp(notaFiscal.getNomeTransp());
            notaFiscalDTO.setTelefoneEmissor(notaFiscal.getTelefoneEmissor());
            notaFiscalDTO.setTelefoneTransp(notaFiscal.getTelefoneTransp());

            notaFiscalDTO.setTipoNota(notaFiscal.getTipoNota());
            notaFiscalDTO.setValorImpostos(notaFiscal.getValorImpostos());
            notaFiscalDTO.setValorProdutos(notaFiscal.getValorProdutos());
            notaFiscalDTO.setValorServicos(notaFiscal.getValorServicos());
            notaFiscalDTO.setValorTotalNota(notaFiscal.getValorTotalNota());
        }
        return notaFiscalDTO;
    }
}
