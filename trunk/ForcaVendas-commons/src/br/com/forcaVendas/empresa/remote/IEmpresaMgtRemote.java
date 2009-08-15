package br.com.forcaVendas.empresa.remote;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.NotaFiscalDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.VendedorDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Henrique
 */
@Remote
public interface IEmpresaMgtRemote {

    /**
     * Retorna os dados da empresa que utiliza o sistema
     *
     * @return
     * @throws EmpresaException
     */
    public EmpresaDTO getEmpresa() throws EmpresaException;

    /**
     * Atualiza os dados da empresa que utiliza o sistema
     * 
     * @param empresa
     * @return
     * @throws EmpresaException
     */
    public boolean setEmpresa(EmpresaDTO empresa) throws EmpresaException;

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException;

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException;

    public boolean deleteVendedor(int codigo) throws EmpresaException;

    public VendedorDTO getVendedor(int codigo) throws EmpresaException;

    public List<VendedorDTO> getVendedores() throws EmpresaException;

    /**
     * Efetua o pedido de um cliente e atualiza as quantidades em estoque.
     *
     *
     * @param cliente
     * @param vendedor
     * @param itens
     * @return
     * @throws EmpresaException
     */
    public PedidoDTO fazerPedido(int cliente, VendedorDTO vendedor, List<PedidoItemDTO> itens) throws EmpresaException;

    public PedidoDTO getPedido(int codigo) throws EmpresaException;

    public List<PedidoDTO> getPedidos() throws EmpresaException;

    //Refatorado: gerarNota() agora recebe como parametro o pedido
    public NotaFiscalDTO gerarNota(PedidoDTO pedido, short tipoNota,
                        short fretePorConta,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais) throws EmpresaException;

    /**
     * cria um novo Item no banco
     *
     * @param nome
     * @param preco
     * @return
     * @throws EmpresaException
     */
    public ItemDTO createItem(String nome, float preco) throws EmpresaException;

    /**
     * Seleciona um item pelo seu código
     *
     * @param codigo
     * @return
     * @throws EmpresaException
     */
    public ItemDTO getItem(int codigo) throws EmpresaException;

    /**
     * Lista todos os itens
     *
     * @return
     * @throws EmpresaException
     */
    public List<ItemDTO> getItens() throws EmpresaException;

    /**
     * Atualiza o item na tabela.
     * 
     * OBS: não é recomendável alterar o estoque através deste método.
     *
     * @param itemDTO
     * @return
     * @throws EmpresaException
     */
    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException;

    /**
     * Remove itens do banco
     *
     * @param codigo
     * @return
     * @throws EmpresaException
     */
    public boolean deleteItem(int codigo) throws EmpresaException;

    
    /**
     * Adiciona itens ao estoque
     * criada para manter em um lugar só a alteração do estoque
     * 
     * @param codigo
     * @param quantidade
     * @return
     * @throws EmpresaException
     */
    public ItemDTO incrementarEstoqueItem(int codigo, float quantidade) throws EmpresaException;

    
    /**
     * Remove itens no estoque
     * criada para manter em um lugar só a alteração do estoque
     *  
     * @param codigo
     * @param quantidade
     * @return
     * @throws EmpresaException
     */
    public ItemDTO decrementarEstoqueItem(int codigo, float quantidade) throws EmpresaException;

}
