package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.IItem;
import br.com.forcaVendas.dto.interfaces.IPedidoItem;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Henrique
 */
@Entity
public class PedidoItem implements IPedidoItem, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    
    @ManyToOne
    private Item item;

    @Column
    private Float quantidade;

    @Column
    private Long pedido;

    @Column
    private Float comissao;

    public PedidoItem() {
    }

    public PedidoItem(Item item, float quantidade, float comissao) {
        this.item = item;
        this.quantidade = quantidade;
        this.comissao = comissao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(long pedido) {
        this.pedido = pedido;
    }

    public Float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public IItem getItem() {
        return item;
    }

    public void setItem(IItem item) {
        this.item = (Item) item;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
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
        if (!(object instanceof PedidoItem)) {
            return false;
        }
        PedidoItem other = (PedidoItem) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.PedidoItem[codigo=" + codigo + "]";
    }

    public static PedidoItem copy(IPedidoItem ped){
        PedidoItem pedidoItem = null;

        if(pedidoItem != null){
            pedidoItem = new PedidoItem();

            pedidoItem.setCodigo(ped.getCodigo());
            pedidoItem.setComissao(ped.getComissao());
            Item item = Item.copy(ped.getItem());
            pedidoItem.setItem(item);

            pedidoItem.setPedido(ped.getPedido());
            pedidoItem.setQuantidade(ped.getQuantidade());
        }
        return pedidoItem;
    }
}
