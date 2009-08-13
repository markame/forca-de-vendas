/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.entidades;

import br.com.forcaVendas.dto.interfaces.ILinkFaturaPedido;
import java.io.Serializable;
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
    @NamedQuery(name = "LinkFaturaPedido.findAll", query = "SELECT f FROM LinkFaturaPedido f")    
})
public class LinkFaturaPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_pedido", nullable=false)
    @Id
    private Integer idPedido;

    @Column(name = "id_fatura", nullable=false)
    @Id
    private Integer idFatura;
    
    public LinkFaturaPedido() {
    }

    public LinkFaturaPedido(Integer idPedido, Integer idFatura) {
        this.idPedido = idPedido;
        this.idFatura = idFatura;
    }

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

    @Override
    public String toString() {
        return "fatura.entidades.LinkFaturaPedido[idPedido=" + idPedido + " idFatura=" + idFatura + "]";
    }

    public static LinkFaturaPedido copy(ILinkFaturaPedido link){
        LinkFaturaPedido copy = null;

        if(link != null){
            copy = new LinkFaturaPedido();

            copy.setIdFatura(link.getIdFatura());
            copy.setIdPedido(link.getIdPedido());
        }
        return copy;
    }
}
