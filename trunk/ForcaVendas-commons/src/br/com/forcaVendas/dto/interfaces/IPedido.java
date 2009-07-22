package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public interface IPedido extends Serializable {

    Integer getCliente();

    Integer getCodigo();

    Date getDataEntrega();

    Date getDataSolicitacao();

    Double getValorTotal();

    IVendedor getVendedor();

    void setCliente(int cliente);

    void setCodigo(int codigo);

    void setDataEntrega(Date dataEntrega);

    void setDataSolicitacao(Date dataSolicitacao);

    void setValorTotal(double valorTotal);

    void setVendedor(IVendedor vendedor);

}
