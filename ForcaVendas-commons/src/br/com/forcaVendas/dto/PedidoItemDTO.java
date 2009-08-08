/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IItem;
import br.com.forcaVendas.dto.interfaces.IPedidoItem;

/**
 *
 * @author Henrique
 */
public class PedidoItemDTO implements IPedidoItem{

    private Integer codigo;

    private ItemDTO item;

    private Float quantidade;

    private Integer pedido;

    private Float comissao;

    public PedidoItemDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(IItem item) {
        this.item = (ItemDTO) item;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public static PedidoItemDTO copy(IPedidoItem p){
        PedidoItemDTO copy = null;

        if(p != null){
            copy = new PedidoItemDTO();

            copy.codigo = p.getCodigo();
            copy.comissao = p.getComissao();
            copy.item = ItemDTO.copy(p.getItem());
            copy.pedido = p.getPedido();
            copy.quantidade = p.getQuantidade();
        }
        return copy;
    }
}
