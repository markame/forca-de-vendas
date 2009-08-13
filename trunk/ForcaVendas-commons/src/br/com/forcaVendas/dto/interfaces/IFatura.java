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
public interface IFatura extends Serializable{

    public abstract String getCpfCliente();

    public abstract Integer getId();

    public abstract Integer getMes();

    public abstract void setId(Integer id);

    public abstract void setCpfCliente(String cpf);

    public abstract void setMes(Integer mes);

}
