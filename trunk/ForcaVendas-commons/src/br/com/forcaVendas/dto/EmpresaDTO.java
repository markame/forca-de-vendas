/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto;

import br.com.forcaVendas.dto.interfaces.IEmpresa;

/**
 *
 * @author Henrique
 */
public class EmpresaDTO implements IEmpresa{
    
    private Integer id;

    private String nome;

    private String endereco;

    private Long cnpj;

    private String telefone;

    public EmpresaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static EmpresaDTO copy(IEmpresa empresa){
        EmpresaDTO empresaDTO = null;
        
        if(empresa != null){
            empresaDTO = new EmpresaDTO();

            empresaDTO.setCnpj(empresa.getCnpj());
            empresaDTO.setEndereco(empresa.getEndereco());
            empresaDTO.setId(empresa.getId());
            empresaDTO.setNome(empresa.getNome());
            empresaDTO.setTelefone(empresa.getTelefone());
        }
        return empresaDTO;
    }
}
