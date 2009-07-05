package br.com.forcaVendas.empresa.entidades;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class PedidoItem implements Serializable{

    private Item item;

    private int quantidade;

    //private int pedido;
    
    private float comissao;

    public PedidoItem() {
    }

    public PedidoItem(Item item, int quantidade, float comissao) {
        this.item = item;
        this.quantidade = quantidade;
        this.comissao = comissao;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    

}
