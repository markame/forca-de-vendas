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
    private Long codigo;

    private Long cliente; //ou objeto

    private Date dataSolicitacao;

    private Date dataEntrega;

    private Double valorTotal;

    private VendedorDTO vendedor;

    public PedidoDTO() {
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public IVendedor getVendedor() {
        return (IVendedor) vendedor;
    }

    public void setVendedor(IVendedor vendedor) {
        this.vendedor =  (VendedorDTO) vendedor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
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

    public static PedidoDTO copy(IPedido ped){
        PedidoDTO pedidoDTO = null;

        if(pedidoDTO != null){
            pedidoDTO = new PedidoDTO();

            pedidoDTO.setCliente(ped.getCliente());
            pedidoDTO.setCodigo(ped.getCodigo());
            pedidoDTO.setDataEntrega(ped.getDataEntrega());
            pedidoDTO.setDataSolicitacao(ped.getDataSolicitacao());
            pedidoDTO.setValorTotal(ped.getValorTotal());
            IVendedor vendedor = (IVendedor) VendedorDTO.copy(ped.getVendedor());
            pedidoDTO.setVendedor(vendedor);
        }
        return pedidoDTO;
    }
}
