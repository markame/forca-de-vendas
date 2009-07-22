/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IItem;

/**
 *
 * @author Henrique
 */
public class ItemDTO implements IItem{

    private Integer codigo;

    private String nome;

    private Float preco;
    
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
