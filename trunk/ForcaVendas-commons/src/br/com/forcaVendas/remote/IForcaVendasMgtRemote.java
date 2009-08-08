/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.remote;

import br.com.forcaVendas.cliente.remote.ClienteException;
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
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author André
 */
@Remote
public interface IForcaVendasMgtRemote {

    /*//IAtualizarCliente
    public boolean createCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException;

    public ClienteDTO getCliente(String cpf)  throws ClienteException;

    public List<ClienteDTO> getClientes()  throws ClienteException;

    public boolean deleteCliente(String cpf)  throws ClienteException;

    public boolean updateCliente(ClienteDTO cliente)  throws ClienteException;

    public boolean  criarFatura(List<PedidoDTO> pedidos, String cpfCliente)  throws ClienteException;

    public FaturaDTO buscarFatura(Integer id)  throws ClienteException;

    //IAtualizarVendedor
    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException;

    public VendedorDTO getVendedor(long codigo) throws EmpresaException;

    public List<VendedorDTO> getVendedores() throws EmpresaException;

    public boolean deleteVendedor(long codigo) throws EmpresaException;

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException;

    //IAtualizarItem
    public ItemDTO createItem(String nome, float preco) throws EmpresaException;

    public ItemDTO getItem(long codigo) throws EmpresaException;

    public List<ItemDTO> getItens() throws EmpresaException;

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException;

    public boolean deleteItem(long codigo) throws EmpresaException;

    //ISolicitarItem
    public Solicitacao solicitarItem(List<ItemDTO> itens, EmpresaDTO empresa, Fornecedor fornecedor);

    //public List<ItemDTO> getItens() throws EmpresaException;

    public Fornecedor getFornecedor(Integer id);

    /**
     * Cria uma Fornecedor
     * @param fornecedor
     * /
    public void createFornecedor(Fornecedor fornecedor);


    /**
     * Deleta um Fornecedor
     * @param id
     * /
    public void deleteFornecedor(Integer id);


    /**
     * Atualiza um Fornecedor
     * @param fornecedor
     * /
    public void updateFornecedor(Fornecedor fornecedor);



    public EmpresaDTO getEmpresa() throws EmpresaException;

    //IFazerPedido
    //public ClienteDTO getCliente(String cpf);

    //public List<ItemDTO> getItens() throws EmpresaException;

    //public ItemDTO getItem(long codigo) throws EmpresaException; - seria o metodo addItem()

    //public VendedorDTO getVendedor(long codigo) throws EmpresaException;

    //orderItem();

    //Fazer pedido não foi definido em nenhuma interface
    public PedidoDTO fazerPedido(long cliente, VendedorDTO vendedor, List<PedidoItemDTO> itens) throws EmpresaException;*/
}
