/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IItem;
import java.io.Serializable;
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
@Table(name="item")
public class ItemDTO implements IItem, Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private String nome;

    private Float preco;

    private Float estoque;

    private Integer fornecedor;
    
    private Float estoqueMinimo;

    public ItemDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public static ItemDTO copy(IItem i){
        ItemDTO copy = null;

        if(i != null){
            copy = new ItemDTO();

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
