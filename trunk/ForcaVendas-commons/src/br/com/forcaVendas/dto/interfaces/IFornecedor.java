/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.dto.interfaces;

/**
 *
 * @author Nelson Alves
 */
public interface IFornecedor {

    /**
     * Get the value of telefone
     *
     * @return the value of telefone
     */
    public String getTelefone();

    /**
     * Set the value of telefone
     *
     * @param telefone new value of telefone
     */
    public void setTelefone(String telefone);

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome();

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome);


    /**
     * Get the value of endereco
     *
     * @return the value of endereco
     */
    public String getEndereco();

    /**
     * Set the value of endereco
     *
     * @param endereco new value of endereco
     */
    public void setEndereco(String endereco);

    /**
     * Get the value of cnpj
     *
     * @return the value of cnpj
     */
    public int getCnpj();

    /**
     * Set the value of cnpj
     *
     * @param cnpj new value of cnpj
     */
    public void setCnpj(int cnpj);


    public Integer getId();

    public void setId(Integer id);


    public int hashCode();


    public boolean equals(Object object);


    public String toString();
}
