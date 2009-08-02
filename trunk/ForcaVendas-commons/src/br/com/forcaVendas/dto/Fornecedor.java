/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;


import br.com.forcaVendas.dto.interfaces.IFornecedor;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pblve
 */
@Entity
@Table(name="fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByName", query = "SELECT f FROM Fornecedor f WHERE f.nome = :name")
})
public class Fornecedor implements Serializable, IFornecedor{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int cnpj;
    private String nome;
    private String endereco;
    private String telefone;
    @OneToMany
	private List<ItemDTO> itens;

    public Fornecedor(){
        itens=new Vector<ItemDTO>();
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }

    /**
     * Get the value of telefone
     *
     * @return the value of telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Set the value of telefone
     *
     * @param telefone new value of telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    /**
     * Get the value of endereco
     *
     * @return the value of endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Set the value of endereco
     *
     * @param endereco new value of endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Get the value of cnpj
     *
     * @return the value of cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * Set the value of cnpj
     *
     * @param cnpj new value of cnpj
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    public String toString() {
        return "fornecedor.Fornecedor[id=" + id + "]";
    }



}
