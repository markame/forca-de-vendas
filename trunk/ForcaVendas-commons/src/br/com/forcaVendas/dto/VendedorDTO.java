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

    private Long codigo;

    private String nome;

    private String endereco;

    //telefone foi substituido de int para String
    private String telefone;

    private long cpf;

    private float salario;

    public VendedorDTO() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public static VendedorDTO copy(IVendedor vend){
        VendedorDTO vendedorDTO = null;

        if(vendedorDTO != null){
            vendedorDTO = new VendedorDTO();

            vendedorDTO.setCodigo(vend.getCodigo());
            vendedorDTO.setCpf(vend.getCpf());
            vendedorDTO.setEndereco(vend.getEndereco());
            vendedorDTO.setNome(vend.getNome());
            vendedorDTO.setSalario(vend.getSalario());
            vendedorDTO.setTelefone(vend.getTelefone());
        }
        return vendedorDTO;
    }
}
