package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.IItem;
import java.io.Serializable;
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
@Table(name = "item")
public class Item implements IItem, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(unique=true)
    private String nome;

    @Column
    private Float preco;

    @Column
    private Float estoque;

    @Column
    private Integer fornecedor;

    @Column
    private Float estoqueMinimo;


    public Item() {
        this.estoque = (float) 0;
    }

    public Item(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = (float) 0;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Float getEstoque() {
        return this.estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    public Integer getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(int codFornecedor) {
        this.fornecedor = codFornecedor;
    }

    public Float getEstoqueMinimo() {
        return this.estoqueMinimo;
    }

    public void setEstoqueMinimo(float estoqueMinimo) {
        this.estoqueMinimo = estoque;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.Item[codigo=" + codigo + "]";
    }

    public static Item copy(IItem i){
        Item copy = null;

        if(i != null){
            copy = new Item();

            copy.codigo = i.getCodigo();
            copy.nome = i.getNome();
            copy.preco = i.getPreco();
            copy.estoque = i.getEstoque();
            copy.estoqueMinimo = i.getEstoqueMinimo();
            copy.fornecedor = i.getFornecedor();
        }
        return copy;
    }
}
