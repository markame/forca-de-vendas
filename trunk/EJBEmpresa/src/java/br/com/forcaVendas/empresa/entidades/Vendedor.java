package br.com.forcaVendas.empresa.entidades;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Vendedor implements Serializable{

    private int codigo;

    private String nome;
    
    private String endereco;

    //telefone foi substituido de int para String
    private String telefone;

    private long cpf;

    private float salario;

    public Vendedor() {
    }

    public Vendedor(int codigo, String nome, String endereco, String telefone, int cpf, float salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}
