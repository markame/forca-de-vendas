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
import br.com.forcaVendas.empresa.remote.EmpresaException;
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

    public EmpresaDTO getEmpresa() throws EmpresaException{
        Empresa empresa = null;

        try{
            empresa = findEmpresa();
        }catch(Exception ex){
            System.err.println(ex);

            throw new EmpresaException(ex.toString());
        }

        return EmpresaDTO.copy(empresa);
    }

    public boolean setEmpresa(EmpresaDTO empresaDTO) throws EmpresaException{
        boolean r = false;

        if(empresaDTO.getNome() == null){
                throw new EmpresaException("Nome Inválido");
        }
        if(empresaDTO.getCnpj() == 0){
                throw new EmpresaException("CNPJ Inválido");
        }


        try{
            EmpresaJpaController empresaJpa = new EmpresaJpaController();

            Empresa emp = findEmpresa();

            Empresa empresa = Empresa.copy(empresaDTO);
            if(emp == null){
                empresaJpa.create(empresa);
                r = true;
            }else{
                empresa.setId(Long.valueOf(1));
                r = true;
            }

        }catch(Exception ex){
            System.err.println(ex);

            throw new EmpresaException(ex.toString());

        }

        return r;
    }

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException{
        Vendedor vendedor = new Vendedor(nome, endereco, telefone, cpf, salario);

        if(vendedor.getNome() == null){
                throw new EmpresaException("Nome Inválido");
        }
        if(vendedor.getCpf() < 0){
                throw new EmpresaException("CNPJ Inválido");
        }
        if(vendedor.getSalario() < 0){
                throw new EmpresaException("Salário Inválido");
        }

        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.create(vendedor);

        }catch(Exception ex){
            System.err.println(ex);

            throw new EmpresaException(ex);
        }

        return VendedorDTO.copy(vendedor);
    }

    public boolean updateVendedor(VendedorDTO vendedorDTO) throws EmpresaException{
        if(vendedorDTO.getNome() == null){
                throw new EmpresaException("Nome Inválido");
        }
        if(vendedorDTO.getCpf() < 0){
                throw new EmpresaException("CNPJ Inválido");
        }
        if(vendedorDTO.getSalario() < 0){
                throw new EmpresaException("Salário Inválido");
        }

        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            Vendedor vendedor = Vendedor.copy(vendedorDTO);
            vendedorJpa.edit(vendedor);


        }catch(Exception ex){
            System.err.println(ex);

            throw new EmpresaException(ex);
        }

        return true;
    }

    public boolean deleteVendedor(long codigo) throws EmpresaException{
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.destroy(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
        }

        return true;
    }

    public VendedorDTO getVendedor(long codigo) throws EmpresaException{
        Vendedor vendedor = null;
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedor = vendedorJpa.findVendedor(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
        }

        return VendedorDTO.copy(vendedor);
    }

    public List<VendedorDTO> getVendedores() throws EmpresaException{
        List<Vendedor> vendedores = null;
        try{
            VendedorJpaController jpaController = new VendedorJpaController();

            vendedores = jpaController.findVendedorEntities();

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
        }

        if(vendedores == null)
            vendedores = new ArrayList<Vendedor>();


        List<VendedorDTO> vendedoresDTO = new ArrayList<VendedorDTO>();
        for(Vendedor vendedor: vendedores){
            vendedoresDTO.add(VendedorDTO.copy(vendedor));
        }

        return vendedoresDTO;
    }

    public PedidoDTO fazerPedido(long cliente, VendedorDTO vendedor, List<PedidoItemDTO> itensDTO) throws EmpresaException{
        
        if(cliente < 0){
            throw new EmpresaException("Cliente Inválido");
        }
        if(vendedor == null){
            throw new EmpresaException("Vendedor Inválido");
        }
        if(itensDTO == null || itensDTO.isEmpty()){
            throw new EmpresaException("Pedido não possui itens");
        }

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
            throw new EmpresaException(ex);
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

    public PedidoDTO getPedido(long codigo) throws EmpresaException{
        Pedido pedido = null;
        try{
            PedidoJpaController jpaController = new PedidoJpaController();

            pedido = jpaController.findPedido(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
        }
        
        return PedidoDTO.copy(pedido);
    }

    public List<PedidoDTO> getPedidos() throws EmpresaException{
        List<Pedido> pedidos = null;

        try{
            PedidoJpaController jpaControler = new PedidoJpaController();

            pedidos = jpaControler.findPedidoEntities();

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
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
                        String dadosAdicionais) throws EmpresaException
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
            throw new EmpresaException(ex);
        }

        return NotaFiscalDTO.copy(nota);
    }

    public ItemDTO createItem(String nome, float preco) throws EmpresaException{
        Item item = new Item(nome, preco);

        if(item.getNome() == null){
            throw new EmpresaException("Nome Inválido");
        }
        if(preco < 0){
            throw new EmpresaException("Preço Inválido");
        }


        try{
            ItemJpaController jpaControler = new ItemJpaController();

            jpaControler.create(item);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
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

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException {
        if(itemDTO.getNome() == null){
            throw new EmpresaException("Nome Inválido");
        }
        if(itemDTO.getPreco() < 0){
            throw new EmpresaException("Preço Inválido");
        }

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            Item item = Item.copy(itemDTO);
            jpaControler.create(item);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
        }

        return true;
    }

    public boolean deleteItem(long codigo) throws EmpresaException {
        try{
            ItemJpaController jpaControler = new ItemJpaController();

            jpaControler.destroy(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            throw new EmpresaException(ex);
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
