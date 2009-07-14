/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor.interfaces;

/**
 *
 * @author Nelson Alves
 */
public interface ISolicitacao {

        /**
     * Get the value of idFornecedor
     *
     * @return the value of idFornecedor
     */
    public Integer getIdFornecedor();

    /**
     * Set the value of idFornecedor
     *
     * @param idFornecedor new value of idFornecedor
     */
    public void setIdFornecedor(Integer idFornecedor);


    public Integer getId();

    public void setId(Integer id);



    public int hashCode();


    public boolean equals(Object object);


    public String toString();
}
