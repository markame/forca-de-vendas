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


    public EmpresaDTO getEmpresa();

    public boolean setEmpresa(EmpresaDTO empresa);

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario);

    public boolean updateVendedor(VendedorDTO vendedor);

    public boolean deleteVendedor(long codigo);

    public VendedorDTO getVendedor(long codigo);

    public List<VendedorDTO> getVendedores();

    public PedidoDTO fazerPedido(long cliente, VendedorDTO vendedor, List<PedidoItemDTO> itens);

    public PedidoDTO getPedido(long codigo);

    public List<PedidoDTO> getPedidos();

    //Refatorado: gerarNota() agora recebe como parametro o pedido
    public NotaFiscalDTO gerarNota(PedidoDTO pedido, short tipoNota,
                        short fretePorConta,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais);

    public ItemDTO createItem(String nome, float preco);

    public ItemDTO getItem(long codigo);

    public List<ItemDTO> getItens();

    public boolean updateItem(ItemDTO itemDTO);

    public boolean deleteItem(long codigo);

}
