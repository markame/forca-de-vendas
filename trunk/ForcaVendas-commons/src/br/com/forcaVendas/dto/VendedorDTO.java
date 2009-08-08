/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IVendedor;

/**
 *
 * @author Henrique
 */
public class VendedorDTO implements IVendedor{

    private Integer codigo;

    private String nome;

    private String endereco;

    //telefone foi substituido de int para String
    private String telefone;

    private long cpf;

    private float salario;

    public VendedorDTO() {
    }

    public Integer getCodigo() {
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

    public static VendedorDTO copy(IVendedor v){
        VendedorDTO copy = null;

        if(v != null){
            copy = new VendedorDTO();

            copy.codigo = v.getCodigo();
            copy.cpf = v.getCpf();
            copy.endereco = v.getEndereco();
            copy.nome = v.getNome();
            copy.salario = v.getSalario();
            copy.telefone = v.getTelefone();
        }
        return copy;
    }
}
