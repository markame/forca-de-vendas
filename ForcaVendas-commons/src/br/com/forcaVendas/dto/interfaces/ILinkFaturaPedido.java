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
public interface ILinkFaturaPedido extends Serializable {

    public abstract Integer getIdPedido();

    public abstract Integer getIdFatura();

    public abstract void setIdPedido(Integer idPedido);

    public abstract void setIdFatura(Integer idFatura);
}
