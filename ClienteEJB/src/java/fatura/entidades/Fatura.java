/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fatura.entidades;

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
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findById", query = "SELECT f FROM Fatura f WHERE f.id = :id"),
    @NamedQuery(name = "Fatura.findByIdItem", query = "SELECT f FROM Fatura f WHERE f.idItem = :idItem"),
    @NamedQuery(name = "Fatura.findByQuantide", query = "SELECT f FROM Fatura f WHERE f.quantide = :quantide")
})
public class Fatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="sequence_fatura", strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "idItem", nullable=false)
    private Integer idItem;
    
    @Column(name = "quantide", nullable=false)
    private Integer quantide;

    public Fatura() {
    }

    public Fatura(Integer id) {
        this.id = id;
    }

    public Fatura(Integer idItem, Integer quantide) {
        this.idItem = idItem;
        this.quantide = quantide;
    }

    public Fatura(Integer id, Integer idItem, Integer quantide) {
        this.id = id;
        this.idItem = idItem;
        this.quantide = quantide;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getQuantide() {
        return quantide;
    }

    public void setQuantide(Integer quantide) {
        this.quantide = quantide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fatura.entidades.Fatura[id=" + id + "]";
    }

}
