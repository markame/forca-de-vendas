/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.ICliente;
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
public class ClienteDTO implements ICliente{
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

    public ClienteDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static ClienteDTO copy(ICliente cliente){
        ClienteDTO clienteDTO = null;

        if(cliente != null){
            clienteDTO = new ClienteDTO();

            clienteDTO.setCpf(cliente.getCpf());
            clienteDTO.setEndereco(cliente.getEndereco());
            clienteDTO.setId(cliente.getId());
            clienteDTO.setNome(cliente.getNome());
            clienteDTO.setTelefone(cliente.getTelefone());
        }
        return clienteDTO;
    }

}
