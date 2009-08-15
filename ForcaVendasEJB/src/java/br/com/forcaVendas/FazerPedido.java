/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.EmpresaDTO;
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
 * Interface Externa para realização de pedidos (a idéia é que para realizar um pedido seja utilizada apenas esta interface)
 *
 * Seqüência:
 * 1.Selecionar Cliente
 * 2.Selecionar Vendedor
 * 3.Adicionar um item de cada vez até que todos sejam adicionados
 * 4.Realizar pedido (utilizando o resultado das etapas anteriores)
 *
 *
 * @author Henrique
 */
public class FazerPedido implements IFazerPedidoRemote{

    @EJB
    public IClienteMgtRemote clienteMgtRemote = null;

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;

    private SolicitarItem solicitarItem;

    public FazerPedido() {
        solicitarItem = new SolicitarItem();
    }


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

        /*if(! PERMITIDO_PEDIDO_COM_ESTOQUE_NEGATIVO){
            if(item.getEstoque() < quantidade){
                throw new EmpresaException(this.getClass().getName() + ": " +
                        "Não é permitido venda de produtos com estoque negativo." +
                        " Item: " + item.getNome() + " Quantidade: " + quantidade);
            }
        }*/

        PedidoItemDTO pedidoItem = new PedidoItemDTO();
        pedidoItem.setItem(item);
        pedidoItem.setQuantidade(quantidade);

        pedidoItens.add(pedidoItem);

        return pedidoItens;
    }

    public PedidoDTO fazerPedido(ClienteDTO cliente, VendedorDTO vendedor, List<PedidoItemDTO> pedidoItens) throws EmpresaException {
        List<ItemDTO> itensEstoqueAbaixoMinimo = new ArrayList<ItemDTO>();

        for(PedidoItemDTO pedidoItem : pedidoItens){
            ItemDTO item = empresaMgtRemote.getItem(pedidoItem.getItem().getCodigo());

            //calcula o novo estoque
            //estas alterações não serão persistidas no banco
            float estoque = item.getEstoque();
            item.setEstoque(estoque - pedidoItem.getQuantidade());

            //se o estoque vai ficar menor que o estoque mínimo
            if(item.getEstoque() < item.getEstoqueMinimo()){
                itensEstoqueAbaixoMinimo.add(item);
            }
        }
        
        if(!itensEstoqueAbaixoMinimo.isEmpty()){
            //faz a solicitação
            EmpresaDTO empresa = empresaMgtRemote.getEmpresa();

            solicitarItem.solicitarItem(itensEstoqueAbaixoMinimo, empresa);
        }

        //Só pode fazer o pedido depois de solicitar os itens faltantes
        return empresaMgtRemote.fazerPedido(cliente.getId(), vendedor, pedidoItens);
    }

}
