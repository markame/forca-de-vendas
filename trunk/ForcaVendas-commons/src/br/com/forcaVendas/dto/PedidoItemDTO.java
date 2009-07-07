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

    private Long codigo;

    private ItemDTO item;

    private Float quantidade;

    private Long pedido;

    private Float comissao;

    public PedidoItemDTO() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(long pedido) {
        this.pedido = pedido;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public static PedidoItemDTO copy(IPedidoItem ped){
        PedidoItemDTO pedidoItemDTO = null;

        if(pedidoItemDTO != null){
            pedidoItemDTO = new PedidoItemDTO();

            pedidoItemDTO.setCodigo(ped.getCodigo());
            pedidoItemDTO.setComissao(ped.getComissao());
            ItemDTO item = ItemDTO.copy(ped.getItem());
            pedidoItemDTO.setItem(item);

            pedidoItemDTO.setPedido(ped.getPedido());
            pedidoItemDTO.setQuantidade(ped.getQuantidade());
        }
        return pedidoItemDTO;
    }
}
