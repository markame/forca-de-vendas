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


    public EmpresaDTO getEmpresa() throws EmpresaException;

    public boolean setEmpresa(EmpresaDTO empresa) throws EmpresaException;

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException;

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException;

    public boolean deleteVendedor(int codigo) throws EmpresaException;

    public VendedorDTO getVendedor(int codigo) throws EmpresaException;

    public List<VendedorDTO> getVendedores() throws EmpresaException;

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

    public ItemDTO createItem(String nome, float preco) throws EmpresaException;

    public ItemDTO getItem(int codigo) throws EmpresaException;

    public List<ItemDTO> getItens() throws EmpresaException;

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException;

    public boolean deleteItem(int codigo) throws EmpresaException;

}
