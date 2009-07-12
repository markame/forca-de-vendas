package br.com.forcaVendas.empresa;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.NotaFiscalDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.empresa.entidade.Empresa;
import br.com.forcaVendas.empresa.entidade.Item;
import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.entidade.Pedido;
import br.com.forcaVendas.empresa.entidade.Vendedor;
import br.com.forcaVendas.empresa.persistencia.EmpresaJpaController;
import br.com.forcaVendas.empresa.persistencia.ItemJpaController;
import br.com.forcaVendas.empresa.persistencia.NotaFiscalJpaController;
import br.com.forcaVendas.empresa.persistencia.PedidoJpaController;
import br.com.forcaVendas.empresa.persistencia.VendedorJpaController;
import br.com.forcaVendas.dto.interfaces.IPedido;
import br.com.forcaVendas.empresa.entidade.PedidoItem;
import br.com.forcaVendas.empresa.persistencia.PedidoItemJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Henrique
 */
@Stateless
public class EmpresaMgr implements IEmpresaMgtRemote {

    public EmpresaDTO getEmpresa() {
        Empresa empresa = null;

        try{
            empresa = findEmpresa();
        }catch(Exception ex){
            System.err.println(ex);
        }

        return EmpresaDTO.copy(empresa);
    }

    public boolean setEmpresa(EmpresaDTO empresaDTO) {
        try{
            EmpresaJpaController empresaJpa = new EmpresaJpaController();
            Empresa emp = findEmpresa();

            Empresa empresa = Empresa.copy(empresaDTO);
            if(emp == null){
                empresaJpa.create(empresa);
            }else{
                empresa.setId(Long.valueOf(1));
                empresaJpa.edit(empresa);
            }

        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) {
        Vendedor vendedor = new Vendedor(nome, endereco, telefone, cpf, salario);

        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.create(vendedor);

        }catch(Exception ex){
            System.err.println(ex);
            vendedor = null;
        }

        return VendedorDTO.copy(vendedor);
    }

    public boolean updateVendedor(VendedorDTO vendedorDTO) {
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            Vendedor vendedor = Vendedor.copy(vendedorDTO);
            vendedorJpa.edit(vendedor);


        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public boolean deleteVendedor(long codigo) {
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.destroy(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public VendedorDTO getVendedor(long codigo) {
        Vendedor vendedor = null;
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedor = vendedorJpa.findVendedor(codigo);

        }catch(Exception ex){
            System.err.println(ex);

        }

        return VendedorDTO.copy(vendedor);
    }

    public List<VendedorDTO> getVendedores() {
        List<Vendedor> vendedores = null;
        try{
            VendedorJpaController jpaController = new VendedorJpaController();

            vendedores = jpaController.findVendedorEntities();

        }catch(Exception ex){
            System.err.println(ex);

        }

        if(vendedores == null)
            vendedores = new ArrayList<Vendedor>();


        List<VendedorDTO> vendedoresDTO = new ArrayList<VendedorDTO>();
        for(Vendedor vendedor: vendedores){
            vendedoresDTO.add(VendedorDTO.copy(vendedor));
        }

        return vendedoresDTO;
    }

    public PedidoDTO fazerPedido(long cliente, VendedorDTO vendedor, List<PedidoItemDTO> itensDTO) {


        double valorTotal = 0;
        Pedido pedido = new Pedido(cliente, new Date(), null, valorTotal, Vendedor.copy(vendedor));

        List<PedidoItem> itens = new ArrayList<PedidoItem>();
        PedidoItem pedidoItem;
        for(PedidoItemDTO pItemDTO : itensDTO){
            pedidoItem = PedidoItem.copy(pItemDTO);
            pedidoItem.setPedido(pedido.getCodigo());

            itens.add(pedidoItem);

            valorTotal += (pedidoItem.getQuantidade() * pedidoItem.getItem().getPreco());
        }

        pedido.setValorTotal(valorTotal);

        try{
            PedidoJpaController pedidoJpa = new PedidoJpaController();

            pedidoJpa.create(pedido);

            //salvando itens do pedido
            PedidoItemJpaController pedidoItemJpa = new PedidoItemJpaController();
            for(PedidoItem pItem : itens){
                pedidoItemJpa.create(pItem);
            }

        }catch(Exception ex){
            System.err.println(ex);
            pedido = null;
        }

        //Gera a nota fiscal do pedido
        //De acordo com a especificação "6.1.4 Sequence Diagram - FazerPedido"
        createNota(
                pedido,                                         //Objeto Pedido
                NotaFiscal.NOTA_FISCAL_SAIDA,                   //Tipo de Nota Fiscal
                NotaFiscal.FRETE_CONTA_DESTINATARIO,            //Tipo de Frete
                null, null, null, null,                         //Informações sobre o transportador
                new Double(0),                                  //Valor dos Serviços (Frete + outros)
                new Double(0),                                  //Valor impostos
                "Vendedor: "+pedido.getVendedor()+
                "\nData Entrega: "+pedido.getDataEntrega());    //Dados Adicionais

        return PedidoDTO.copy(pedido);
    }

    public PedidoDTO getPedido(long codigo) {
        Pedido pedido = null;
        try{
            PedidoJpaController jpaController = new PedidoJpaController();

            pedido = jpaController.findPedido(codigo);

        }catch(Exception ex){
            System.err.println(ex);
        }
        
        return PedidoDTO.copy(pedido);
    }

    public List<PedidoDTO> getPedidos() {
        List<Pedido> pedidos = null;

        try{
            PedidoJpaController jpaControler = new PedidoJpaController();

            pedidos = jpaControler.findPedidoEntities();

        }catch(Exception ex){
            System.err.println(ex);
        }

        if(pedidos == null)
            pedidos = new ArrayList<Pedido>();

        List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
        for(Pedido p: pedidos){
            pedidosDTO.add(PedidoDTO.copy(p));
        }

        return pedidosDTO;
    }

    public NotaFiscalDTO gerarNota(PedidoDTO pedido, short tipoNota,
                        short fretePorConta,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais)
    {

        //Instancia a entidade NotaFiscal
        NotaFiscal nota = createNota(pedido, tipoNota, fretePorConta, NomeTransp,
                                    enderecoTransp, cnpjTransp, telefoneTransp,
                                    valorServicos, valorImpostos, dadosAdicionais);

        //Persiste a Nota Fiscal
        try {
            NotaFiscalJpaController notaJpa = new NotaFiscalJpaController();
            notaJpa.create(nota);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        return NotaFiscalDTO.copy(nota);
    }

    public ItemDTO createItem(String nome, float preco) {
        Item item = new Item(nome, preco);

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            jpaControler.create(item);

        }catch(Exception ex){
            System.err.println(ex);
            item = null;
        }

        return ItemDTO.copy(item);
    }

    public ItemDTO getItem(long codigo) {
        Item item = null;

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            item = jpaControler.findItem(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            item = null;
        }

        return ItemDTO.copy(item);
    }

    public List<ItemDTO> getItens() {
        List<Item> itens = null;

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            itens = jpaControler.findItemEntities();

        }catch(Exception ex){
            System.err.println(ex);
        }

        if(itens == null)
            itens = new ArrayList<Item>();

        List<ItemDTO> itensDTO = new ArrayList<ItemDTO>();
        for(Item p: itens){
            itensDTO.add(ItemDTO.copy(p));
        }

        return itensDTO;
    }

    public boolean updateItem(ItemDTO itemDTO) {
        try{
            ItemJpaController jpaControler = new ItemJpaController();

            Item item = Item.copy(itemDTO);
            jpaControler.create(item);

        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public boolean deleteItem(long codigo) {
        try{
            ItemJpaController jpaControler = new ItemJpaController();

            jpaControler.destroy(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    private NotaFiscal createNota(IPedido pedido, short tipoNota,
                        short fretePorConta,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais){
                        
        Empresa e = findEmpresa();
        //Instancia a entidade NotaFiscal
        NotaFiscal nota = new NotaFiscal(tipoNota, fretePorConta, e.getNome(), e.getEndereco(), e.getCnpj(), e.getTelefone(), NomeTransp, enderecoTransp, cnpjTransp, telefoneTransp, pedido.getDataSolicitacao(), pedido.getCodigo(), pedido.getValorTotal(), valorServicos, valorImpostos, dadosAdicionais);
        return nota;
    }

    private Empresa findEmpresa() {
        //Coleta informações da empresa (emitente da nota fiscal)
        EmpresaJpaController empresaJpa = new EmpresaJpaController();
        Empresa e = empresaJpa.findEmpresa(Long.valueOf(1));
        return e;
    }
 
}
