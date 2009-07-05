package br.com.forcaVendas.empresa.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pedido implements Serializable{

    private int codigo;

    private int cliente; //ou objeto

    private Date dataSolicitacao;

    private Date dataEntrega;

    private double valorTotal;

    public Pedido() {
    }

    public Pedido(int codigo, int cliente, Date dataSolicitacao, Date dataEntrega, double valorTotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.dataSolicitacao = dataSolicitacao;
        this.dataEntrega = dataEntrega;
        this.valorTotal = valorTotal;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
