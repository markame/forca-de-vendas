/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.entidades;

import br.com.forcaVendas.dto.interfaces.ICliente;
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
 * @author André
 */
@Entity
@Table(name = "cliente_schema.cliente_table")
@SequenceGenerator(name="sequence_cliente", sequenceName="cliente_schema.cliente_sequence")
@NamedQueries({
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
@NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
@NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
@NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco"),
@NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
@NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")})
public class Cliente implements ICliente, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="sequence_cliente", strategy=GenerationType.AUTO)
    @Column(name = "id", nullable=false)
    private Integer id;

    @Column(name = "nome", nullable=false)
    private String nome;

    @Column(name = "endereco", nullable=false)
    private String endereco;

    @Column(name = "cpf", nullable=false, unique=true)
    private String cpf;

    @Column(name = "telefone", nullable=false)
    private String telefone;

    public Cliente() {
    }

    
    public Cliente(String nome, String endereco, String cpf, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cliente.entidades.Cliente[id=" + id + "]";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Cliente copy(ICliente client){
        Cliente copy = null;

        if(client != null){
            copy = new Cliente();

            copy.setCpf(client.getCpf());
            copy.setEndereco(client.getEndereco());
            copy.setId(client.getId());
            copy.setNome(client.getNome());
            copy.setTelefone(client.getTelefone());
        }
        return copy;
    }

}
