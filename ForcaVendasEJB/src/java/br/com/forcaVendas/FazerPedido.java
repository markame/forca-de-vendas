/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.remote.IFazerPedidoRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Henrique
 */
public class FazerPedido implements IFazerPedidoRemote{

    //Definir aqui se posível ou não vender com estoque negativo
    public static final boolean PERMITIDO_PEDIDO_COM_ESTOQUE_NEGATIVO = false;

    @EJB
    public IClienteMgtRemote clienteMgtRemote = null;

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;

    public ClienteDTO getCliente(String cpf) throws ClienteException {
        return clienteMgtRemote.buscarCliente(cpf);
    }

    public VendedorDTO getVendedor(int id) throws EmpresaException {
        return empresaMgtRemote.getVendedor(id);
    }

    public List<PedidoItemDTO> addItem(List<PedidoItemDTO> pedidoItens, int itemId, float quantidade) throws EmpresaException {
        if(pedidoItens == null)
            pedidoItens = new ArrayList<PedidoItemDTO>();

        ItemDTO item = empresaMgtRemote.getItem(itemId);

        if(item == null){
            throw new EmpresaException(this.getClass().getName() + ": " +
                        "Item inválido");
        }

        if(quantidade < 0){
            throw new EmpresaException(this.getClass().getName() + ": " +
                        "Quantidade não pode ser negativa");
        }

        if(! PERMITIDO_PEDIDO_COM_ESTOQUE_NEGATIVO){
            if(item.getEstoque() < quantidade){
                throw new EmpresaException(this.getClass().getName() + ": " +
                        "Não é permitido venda de produtos com estoque negativo." +
                        " Item: " + item.getNome() + " Quantidade: " + quantidade);
            }
        }

        PedidoItemDTO pedidoItem = new PedidoItemDTO();
        pedidoItem.setItem(item);
        pedidoItem.setQuantidade(quantidade);

        pedidoItens.add(pedidoItem);

        return pedidoItens;
    }

    public PedidoDTO fazerPedido(ClienteDTO cliente, VendedorDTO vendedor, List<PedidoItemDTO> pedidoItens) throws EmpresaException {
        List<ItemDTO> itensFaltaEstoque = new ArrayList<ItemDTO>();

        for(PedidoItemDTO pedidoItem : pedidoItens){
            ItemDTO item = empresaMgtRemote.getItem(pedidoItem.getItem().getCodigo());

            //se tem menos em estoque do que foi pedido
            if(item.getEstoque() < pedidoItem.getQuantidade()){
                itensFaltaEstoque.add(item);
            }
        }
        
        if(!itensFaltaEstoque.isEmpty()){
            if(PERMITIDO_PEDIDO_COM_ESTOQUE_NEGATIVO){
                /*TODO solicitar item
                 * porém necessita especificar:
                 *        o fornecedor
                 *        a quantidade (que não necessariamente é a mesma do pedido)
                 */

                throw new UnsupportedOperationException("Not yet implemented");
                
            }else{
                StringBuilder itensFaltantes = new StringBuilder();
                for(ItemDTO item : itensFaltaEstoque){
                    itensFaltantes.append(item.getNome() + ", ");
                }

                throw new EmpresaException(this.getClass().getName() + ": " +
                        "Não é permitido venda de produtos com estoque negativo." +
                        " Itens: " + itensFaltantes.substring(0, itensFaltantes.length()-3));
            }
        }

        return empresaMgtRemote.fazerPedido(cliente.getId(), vendedor, pedidoItens);
    }

}
