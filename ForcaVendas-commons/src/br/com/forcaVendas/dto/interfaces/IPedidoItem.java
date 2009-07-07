package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IPedidoItem extends Serializable {

    Long getCodigo();

    Float getComissao();

    IItem getItem();

    Long getPedido();

    Float getQuantidade();

    void setCodigo(long codigo);

    void setComissao(float comissao);

    void setItem(IItem item);

    void setPedido(long pedido);

    void setQuantidade(float quantidade);

}
