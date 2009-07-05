package br.com.forcaVendas.empresa.entidades;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Empresa implements Serializable{

    private String nome;

    private String endereco;
    
    private long cnpj;

    private String telefone;

    public Empresa() {
    }

    public Empresa(String nome, String endereco, int cnpj, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
