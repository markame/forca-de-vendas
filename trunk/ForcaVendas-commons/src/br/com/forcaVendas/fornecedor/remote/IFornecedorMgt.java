/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.fornecedor.remote;


import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.Solicitacao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nelson Alves
 */
@Local
public interface IFornecedorMgt {
    public Fornecedor getFornecedor(Integer id);

    /**
     * Cria uma solicitação de uma lista de Itens
     * @param itens, lista de itens (code)
     * @param empresa
     * @param fornecedor
     * @return solicitacao
     */
    public Solicitacao solicitarItem(List<Integer> itens, EmpresaDTO empresa, Fornecedor fornecedor);

    /**
     * Cria uma Fornecedor
     * @param fornecedor
     */
    public void createFornecedor(Fornecedor fornecedor);


    /**
     * Deleta um Fornecedor
     * @param id
     */
    public void deleteFornecedor(Integer id);


    /**
     * Atualiza um Fornecedor
     * @param fornecedor
     */
    public void updateFornecedor(Fornecedor fornecedor);
}
