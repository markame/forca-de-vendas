package br.com.forcaVendas.empresa.entidades;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Item implements Serializable{

    private int codigo;
    
    private String nome;
    
    private float preco;

    public Item() {
    }

    public Item(int codigo, String nome, float preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
