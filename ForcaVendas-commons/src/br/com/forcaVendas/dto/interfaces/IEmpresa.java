package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IEmpresa extends Serializable{

    public abstract long getCnpj();

    public abstract String getEndereco();

    public abstract Long getId();

    public abstract String getNome();

    public abstract String getTelefone();

    public abstract void setCnpj(long cnpj);

    public abstract void setEndereco(String endereco);

    public abstract void setId(Long id);

    public abstract void setNome(String nome);

    public abstract void setTelefone(String telefone);

}
