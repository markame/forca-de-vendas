/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

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
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findById", query = "SELECT f FROM Fatura f WHERE f.id = :id"),
    @NamedQuery(name = "Fatura.findById_Pedido", query = "SELECT f FROM Fatura f WHERE f.id_pedido = :id_pedido"),
    @NamedQuery(name = "Fatura.findByCpf_Cliente", query = "SELECT f FROM Fatura f WHERE f.cpf_cliente = :cpf_cliente")
})
public class FaturaDTO implements IFatura {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="sequence_fatura", strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_pedido", nullable=false)
    private Integer idPedido;

    @Column(name = "cpf_cliente", nullable=false)
    private String cpfCliente;

    public FaturaDTO() {
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

    public static FaturaDTO copy(IFatura fatura){
        FaturaDTO faturaDTO = null;

        if(faturaDTO != null){
            faturaDTO = new FaturaDTO();

            faturaDTO.setCpfCliente(fatura.getCpfCliente());
            faturaDTO.setId(fatura.getId());
            faturaDTO.setIdPedido(fatura.getIdPedido());
            
        }
        return faturaDTO;
    }
}