/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.entidades;

import br.com.forcaVendas.dto.interfaces.IFatura;
import java.io.Serializable;
import java.util.Vector;
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
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f")
})
public class Fatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="sequence_fatura", strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cpf_cliente", nullable=false)
    private String cpfCliente;

    @Column(name = "mes", nullable=false)
    private Integer mes;

    @Column(name = "pedidos", nullable=false)
    private String pedidos;

    public Fatura() {
    }

    public Fatura(String cpfCliente, Integer mes, String pedidos) {
        this.cpfCliente = cpfCliente;
        this.mes = mes;
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public String getPedidos() {
        return pedidos;
    }

    public void setPedidos(String pedidos) {
        this.pedidos = pedidos;
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

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mesFatura) {
        this.mes = mesFatura;
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
        Fatura copy = null;

        if(fat != null){
            copy = new Fatura();

            copy.setId(fat.getId());
            copy.setCpfCliente(fat.getCpfCliente());
            copy.setMes(fat.getMes());
        }
        return copy;
    }
}
