package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IItem extends Serializable {

    Integer getCodigo();

    String getNome();

    Float getPreco();

    Float getEstoque();

    void setCodigo(int codigo);

    void setNome(String nome);

    void setPreco(float preco);

    void setEstoque(float estoque);

    Integer getFornecedor();

    void setFornecedor(int codFornecedor);

    Float getEstoqueMinimo();

    void setEstoqueMinimo(float estoqueMinimo);

}
