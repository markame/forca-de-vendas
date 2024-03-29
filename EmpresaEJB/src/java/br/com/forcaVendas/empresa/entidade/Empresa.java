package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.IEmpresa;
import java.io.Serializable;
import java.lang.reflect.Method;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "empresa")
public class Empresa implements IEmpresa, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column(unique=true)
    private Long cnpj;

    @Column
    private String telefone;

    public Empresa() {
    }

    public Empresa(String nome, String endereco, long cnpj, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.Empresa[id=" + id + "]";
    }

    public static Empresa copy(IEmpresa e){
        Empresa copy = null;

        if(e != null){
            copy = new Empresa();

            copy.id = e.getId();
            copy.cnpj = e.getCnpj();
            copy.endereco = e.getEndereco();
            copy.nome = e.getNome();
            copy.telefone = e.getTelefone();

        }
        return copy;
    }

}
