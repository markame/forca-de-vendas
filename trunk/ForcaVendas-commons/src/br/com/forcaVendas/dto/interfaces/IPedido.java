package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public interface IPedido extends Serializable {

    Long getCliente();

    Long getCodigo();

    Date getDataEntrega();

    Date getDataSolicitacao();

    Double getValorTotal();

    IVendedor getVendedor();

    void setCliente(Long cliente);

    void setCodigo(Long codigo);

    void setDataEntrega(Date dataEntrega);

    void setDataSolicitacao(Date dataSolicitacao);

    void setValorTotal(double valorTotal);

    void setVendedor(IVendedor vendedor);

}
