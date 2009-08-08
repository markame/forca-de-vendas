/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IPedido;
import br.com.forcaVendas.dto.interfaces.IVendedor;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public class PedidoDTO implements IPedido{
    private Integer codigo;

    private Integer cliente; //ou objeto

    private Date dataSolicitacao;

    private Date dataEntrega;

    private Double valorTotal;

    private VendedorDTO vendedor;

    public PedidoDTO() {
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public IVendedor getVendedor() {
        return (IVendedor) vendedor;
    }

    public void setVendedor(IVendedor vendedor) {
        this.vendedor =  (VendedorDTO) vendedor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static PedidoDTO copy(IPedido p){
        PedidoDTO copy = null;

        if(p != null){
            copy = new PedidoDTO();

            copy.cliente = p.getCliente();
            copy.codigo = p.getCodigo();
            copy.dataEntrega = p.getDataEntrega();
            copy.dataSolicitacao = p.getDataSolicitacao();
            copy.valorTotal = p.getValorTotal();
            copy.vendedor = VendedorDTO.copy(p.getVendedor());
        }
        return copy;
    }
}
