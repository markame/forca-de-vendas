/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.entidades;

import br.com.forcaVendas.dto.interfaces.IFatura;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "cliente_schema.fatura")
@SequenceGenerator(name = "sequence_fatura", sequenceName = "cliente_schema.fatura_sequence")
/*@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findById", query = "SELECT f FROM Fatura f WHERE f.id = :id"),
    @NamedQuery(name = "Fatura.findById_Pedido", query = "SELECT f FROM Fatura f WHERE f.id_pedido = :id_pedido"),
    @NamedQuery(name = "Fatura.findByCpf_Cliente", query = "SELECT f FROM Fatura f WHERE f.cpf_cliente = :cpf_cliente")
})*/
public class Fatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="sequence_fatura", strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "id_pedido", nullable=false)
    private Integer idPedido;
    
    @Column(name = "cpf_cliente", nullable=false)
    private String cpfCliente;

    public Fatura() {
    }

    public Fatura(Integer idPedido, String cpfCliente) {
        this.idPedido = idPedido;
        this.cpfCliente = cpfCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fatura other = (Fatura) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "fatura.entidades.Fatura[id=" + id + "]";
    }

    public static Fatura copy(IFatura fat){
        Fatura fatura = null;

        if(fat != null){
            fatura = new Fatura();

            fatura.setId(fatura.getId());
            fatura.setCpfCliente(fatura.getCpfCliente());
            fatura.setIdPedido(fatura.getIdPedido());
        }
        return fatura;
    }
}
