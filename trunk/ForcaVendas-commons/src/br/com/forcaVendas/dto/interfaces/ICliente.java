/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author André
 */
public interface ICliente extends Serializable{

    public abstract String getCpf();

    public abstract String getEndereco();

    public abstract Integer getId();

    public abstract String getNome();

    public abstract String getTelefone();

    public abstract void setId(Integer id);

    public abstract void setCpf(String cpf);

    public abstract void setEndereco(String endereco);

    public abstract void setNome(String nome);

    public abstract void setTelefone(String telefone);

}
