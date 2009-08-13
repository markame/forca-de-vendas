/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.ILinkFaturaPedido;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "cliente_schema.link_fatura_pedido")
@NamedQueries({
    @NamedQuery(name = "LinkFaturaPedido.findAll", query = "SELECT f FROM LinkFaturaPedido f"),
    @NamedQuery(name = "LinkFaturaPedido.findById_Pedido", query = "SELECT f FROM LinkFaturaPedido f WHERE f.id_pedido = :id_pedido"),
    @NamedQuery(name = "LinkFaturaPedido.findById_Fatura", query = "SELECT f FROM LinkFaturaPedido f WHERE f.id_fatura = :id_fatura")
})
public class LinkFaturaPedidoDTO implements ILinkFaturaPedido {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_pedido", nullable=false)
    private Integer idPedido;

    @Id
    @Column(name = "id_fatura", nullable=false)
    private Integer idFatura;

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public static LinkFaturaPedidoDTO copy(ILinkFaturaPedido link){
        LinkFaturaPedidoDTO copy = null;

        if(link != null){
            copy = new LinkFaturaPedidoDTO();

            copy.setIdFatura(link.getIdFatura());
            copy.setIdPedido(link.getIdPedido());            
        }
        return copy;
    }    
}
