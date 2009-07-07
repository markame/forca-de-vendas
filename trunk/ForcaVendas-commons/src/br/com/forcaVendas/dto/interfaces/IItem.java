package br.com.forcaVendas.dto.interfaces;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface IItem extends Serializable {

    Long getCodigo();

    String getNome();

    Float getPreco();

    void setCodigo(long codigo);

    void setNome(String nome);

    void setPreco(float preco);

}
