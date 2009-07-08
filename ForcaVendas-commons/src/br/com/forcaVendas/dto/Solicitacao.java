/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;


import br.com.forcaVendas.dto.interfaces.ISolicitacao;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pblve
 */
@Entity
public class Solicitacao implements Serializable, ISolicitacao {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idFornecedor;
    private Integer idEmpresa;

    /**
     * Get the value of idEmpresa
     *
     * @return the value of idEmpresa
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Set the value of idEmpresa
     *
     * @param idEmpresa new value of idEmpresa
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    /**
     * Get the value of idFornecedor
     *
     * @return the value of idFornecedor
     */
    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * Set the value of idFornecedor
     *
     * @param idFornecedor new value of idFornecedor
     */
    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
 
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    public String toString() {
        return "fornecedor.Solicitacao[id=" + id + "]";
    }

}
