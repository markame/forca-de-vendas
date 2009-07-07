package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IVendedor extends Serializable {

    Long getCodigo();

    long getCpf();

    String getEndereco();

    String getNome();

    float getSalario();

    String getTelefone();

    void setCodigo(long codigo);

    void setCpf(long cpf);

    void setEndereco(String endereco);

    void setNome(String nome);

    void setSalario(float salario);

    void setTelefone(String telefone);

}
