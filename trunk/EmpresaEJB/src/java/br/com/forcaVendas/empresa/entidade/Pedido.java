package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.IPedido;
import br.com.forcaVendas.dto.interfaces.IVendedor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Henrique
 */
@Entity
public class Pedido implements IPedido, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column
    private Integer cliente; //ou objeto

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSolicitacao;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrega;

    @Column
    private Double valorTotal;

    @ManyToOne
    private Vendedor vendedor;

    public Pedido() {
    }

    public Pedido(Integer cliente, Date dataSolicitacao, Date dataEntrega, double valorTotal, Vendedor vendedor) {
        this.cliente = cliente;
        this.dataSolicitacao = dataSolicitacao;
        this.dataEntrega = dataEntrega;
        this.valorTotal = valorTotal;
        this.vendedor = vendedor;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public IVendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(IVendedor vendedor) {
        this.vendedor = (Vendedor) vendedor; //TODO ver se essa é a melhor opção
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.Pedido[codigo=" + codigo + "]";
    }

    public static Pedido copy(IPedido p){
        Pedido copy = null;

        if(p != null){
            copy = new Pedido();

            copy.cliente = p.getCliente();
            copy.codigo = p.getCodigo();
            copy.dataEntrega = p.getDataEntrega();
            copy.dataSolicitacao = p.getDataSolicitacao();
            copy.valorTotal = p.getValorTotal();
            copy.vendedor = Vendedor.copy(p.getVendedor());
        }
        return copy;
    }

}
