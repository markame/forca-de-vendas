package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public interface INotaFiscal extends Serializable {

    Date getDataEmissao();

    void setDataEmissao(Date dataEmissao);

    Long getCnpjEmissor();

    Long getCnpjTransp();

    Long getCodigo();

    Long getCodigoPedido();

    String getDadosAdicionais();

    String getEnderecoEmissor();

    String getEnderecoTransp();

    short getFretePorConta();

    String getNomeEmissor();

    String getNomeTransp();

    String getTelefoneEmissor();

    String getTelefoneTransp();

    short getTipoNota();

    Double getValorImpostos();

    Double getValorProdutos();

    Double getValorServicos();

    Double getValorTotalNota();

    void setCnpjEmissor(Long cnpjEmissor);

    void setCnpjTransp(Long cnpjTransp);

    void setCodigo(Long codigo);

    void setCodigoPedido(Long codigoPedido);

    void setDadosAdicionais(String dadosAdicionais);

    void setEnderecoEmissor(String enderecoEmissor);

    void setEnderecoTransp(String enderecoTransp);

    void setFretePorConta(short fretePorConta);

    void setNomeEmissor(String NomeEmissor);

    void setNomeTransp(String NomeTransp);

    void setTelefoneEmissor(String telefoneEmissor);

    void setTelefoneTransp(String telefoneTransp);

    void setTipoNota(short tipoNota);

    void setValorImpostos(Double valorImpostos);

    void setValorProdutos(Double valorProdutos);

    void setValorServicos(Double valorServicos);

    void setValorTotalNota(Double valorTotalNota);

}
