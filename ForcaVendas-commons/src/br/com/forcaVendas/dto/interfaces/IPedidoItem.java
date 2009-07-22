package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IPedidoItem extends Serializable {

    Integer getCodigo();

    Float getComissao();

    IItem getItem();

    Integer getPedido();

    Float getQuantidade();

    void setCodigo(int codigo);

    void setComissao(float comissao);

    void setItem(IItem item);

    void setPedido(int pedido);

    void setQuantidade(float quantidade);

}
