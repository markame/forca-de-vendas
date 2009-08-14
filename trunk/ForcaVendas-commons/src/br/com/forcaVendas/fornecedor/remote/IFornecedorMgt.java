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
import javax.ejb.Remote;

/**
 *
 * @author Nelson Alves
 */
@Remote
public interface IFornecedorMgt {
    public Fornecedor getFornecedor(Integer id);

    /**
     * Cria uma solicitação de uma lista de Itens
     * @param itens, lista de itens (code)
     * @param empresa
     * @param fornecedor
     * @return solicitacao
     */
    public List<Solicitacao> solicitarItem(List<Integer> itens, EmpresaDTO empresa);

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

    /**
     Obtem o fornecedor para um determinado item pelo codigo do item
     @param itemId id do item
     * @return fornecedor para aquele item
     */
    public Fornecedor getFornecedorByItemId(Integer itemId);
    /**
     Obtem o fornecedor para um determinado item
     @param item
     * @return fornecedor para aquele item
     */
    public Fornecedor getFornecedorByItem(ItemDTO item);
}
