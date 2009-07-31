/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.Solicitacao;
import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.fornecedor.remote.IFornecedorMgt;
import br.com.forcaVendas.remote.IForcaVendasMgtRemote;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author André
 */
@Stateless
public class ForcaVendasMgr implements IForcaVendasMgtRemote{

    @EJB
    public IClienteMgtRemote clienteMgtRemote = null;

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;

    @EJB
    public IFornecedorMgt fornecedorMgtRemote = null;

    //IAtualizarCliente
    public boolean createCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException {
        return clienteMgtRemote.criarCliente(nome, endereco, cpf, telefone);
    }

    public ClienteDTO getCliente(String cpf) throws ClienteException {
        return clienteMgtRemote.buscarCliente(cpf);
    }

    public List<ClienteDTO> getClientes() throws ClienteException {
        return clienteMgtRemote.getClientes();
    }

    public boolean deleteCliente(String cpf) throws ClienteException {
        return clienteMgtRemote.deletarCliente(cpf);
    }

    public boolean updateCliente(ClienteDTO cliente) throws ClienteException {
        return clienteMgtRemote.editarCliente(cliente);
    }

    public boolean criarFatura(List<PedidoDTO> pedidos, String cpfCliente) throws ClienteException {
        return clienteMgtRemote.criarFatura(pedidos, cpfCliente);
    }

    public FaturaDTO buscarFatura(Integer id) throws ClienteException {
        return clienteMgtRemote.buscarFatura(id);
    }
    //Fim de IAtualizarCliente

    //IAtualizarVendedor
    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException {
        return empresaMgtRemote.createVendedor(nome, endereco, telefone, cpf, salario);
    }

    public VendedorDTO getVendedor(long codigo) throws EmpresaException {
        return empresaMgtRemote.getVendedor(codigo);
    }

    public List<VendedorDTO> getVendedores() throws EmpresaException {
        return empresaMgtRemote.getVendedores();
    }

    public boolean deleteVendedor(long codigo) throws EmpresaException {
        return empresaMgtRemote.deleteVendedor(codigo);
    }

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException {
        return empresaMgtRemote.updateVendedor(vendedor);
    }
    //Fim de IAtualizarVendedor

    //IAtualizarItem
    public ItemDTO createItem(String nome, float preco) throws EmpresaException {
        return empresaMgtRemote.createItem(nome, preco);
    }

    public ItemDTO getItem(long codigo) throws EmpresaException {
        return empresaMgtRemote.getItem(codigo);
    }

    public List<ItemDTO> getItens() throws EmpresaException {
        return empresaMgtRemote.getItens();
    }

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException {
        return empresaMgtRemote.updateItem(itemDTO);
    }

    public boolean deleteItem(long codigo) throws EmpresaException {
        return empresaMgtRemote.deleteItem(codigo);
    }
    //Fim de IAtualizarItem

    //ISolicitarItem
    public Solicitacao solicitarItem(List<Integer> itens, EmpresaDTO empresa, Fornecedor fornecedor) {
        return fornecedorMgtRemote.solicitarItem(itens, empresa, fornecedor);
    }

    public Fornecedor getFornecedor(Integer id) {
        return fornecedorMgtRemote.getFornecedor(id);
    }

    public EmpresaDTO getEmpresa() throws EmpresaException {
        return empresaMgtRemote.getEmpresa();
    }
    //Fim de ISolicitarItem

    //Fazer pedido não foi definido em nenhuma interface
    public PedidoDTO fazerPedido(long cliente, VendedorDTO vendedor, List<PedidoItemDTO> itens) throws EmpresaException {
        Vector<Integer> itensFaltaEstoque = new Vector<Integer>();

        for(PedidoItemDTO item : itens){
            ItemDTO itemEstoque = empresaMgtRemote.getItem(item.getCodigo());
            if(itemEstoque == null){
                itensFaltaEstoque.add(new Integer(itemEstoque.getCodigo().toString()));
            }
        }
        if(!itensFaltaEstoque.isEmpty()){
            fornecedorMgtRemote.solicitarItem(itensFaltaEstoque, empresaMgtRemote.getEmpresa(), fornecedorMgtRemote.getFornecedor(Integer.SIZE));
        }

        return empresaMgtRemote.fazerPedido(cliente, vendedor, itens);
    }

}
