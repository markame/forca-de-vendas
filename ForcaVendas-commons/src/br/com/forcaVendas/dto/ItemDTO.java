/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

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
public class ItemDTO implements IItem, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(unique=true)
    private String nome;

    @Column
    private Float preco;

    @Column
    private Float estoque;

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



    public static ItemDTO copy(IItem item){
        ItemDTO itemDTO = null;

        if(item != null){
            itemDTO = new ItemDTO();

            itemDTO.setCodigo(item.getCodigo());
            itemDTO.setNome(item.getNome());
            itemDTO.setPreco(item.getPreco());
            itemDTO.setEstoque(item.getEstoque());
        }
        return itemDTO;
    }
    
}
