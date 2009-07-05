package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.entidade.Empresa;
import br.com.forcaVendas.empresa.entidade.Item;
import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.entidade.Pedido;
import br.com.forcaVendas.empresa.entidade.PedidoItem;
import br.com.forcaVendas.empresa.entidade.Vendedor;
import br.com.forcaVendas.empresa.persistencia.EmpresaJpaController;
import br.com.forcaVendas.empresa.persistencia.ItemJpaController;
import br.com.forcaVendas.empresa.persistencia.PedidoJpaController;
import br.com.forcaVendas.empresa.persistencia.VendedorJpaController;
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

    public Empresa getEmpresa() {
        Empresa empresa = null;

        try{
            EmpresaJpaController empresaJpa = new EmpresaJpaController();

            empresa = empresaJpa.findEmpresa(Long.valueOf(1));
        }catch(Exception ex){
            System.err.println(ex);
        }

        return empresa;
    }

    public Vendedor createVendedor(String nome, String endereco, String telefone, long cpf, float salario) {
        Vendedor vendedor = new Vendedor(nome, endereco, telefone, cpf, salario);

        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.create(vendedor);

        }catch(Exception ex){
            System.err.println(ex);
            vendedor = null;
        }

        return vendedor;
    }

    public boolean updateVendedor(Vendedor vendedor) {
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.create(vendedor);


        }catch(Exception ex){
            System.err.println(ex);
            vendedor = null;
            return false;
        }

        return true;
    }

    public boolean deleteVendedor(Vendedor vendedor) {
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedorJpa.destroy(vendedor.getCodigo());

        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public Vendedor getVendedor(long codigo) {
        Vendedor vendedor = null;
        try{
            VendedorJpaController vendedorJpa = new VendedorJpaController();

            vendedor = vendedorJpa.findVendedor(codigo);

        }catch(Exception ex){
            System.err.println(ex);

        }

        return vendedor;
    }

    public List<Vendedor> getVendedores() {
        List<Vendedor> vendedores = null;
        try{
            VendedorJpaController jpaController = new VendedorJpaController();

            vendedores = jpaController.findVendedorEntities();

        }catch(Exception ex){
            System.err.println(ex);

        }

        if(vendedores == null)
            vendedores = new ArrayList<Vendedor>();

        return vendedores;
    }

    public Pedido fazerPedido(long cliente, Vendedor vendedor, List<PedidoItem> itens) {

        Pedido pedido = new Pedido(cliente, new Date(), null, cliente, vendedor);

        try{
            PedidoJpaController pedidoJpa = new PedidoJpaController();

            pedidoJpa.create(pedido);

        }catch(Exception ex){
            System.err.println(ex);
            pedido = null;
        }

        return pedido;
    }

    public Pedido getPedido(long codigo) {
        Pedido pedido = null;
        try{
            PedidoJpaController jpaController = new PedidoJpaController();

            pedido = jpaController.findPedido(codigo);

        }catch(Exception ex){
            System.err.println(ex);
        }
        
        return pedido;
    }

    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = null;

        try{
            PedidoJpaController jpaControler = new PedidoJpaController();

            pedidos = jpaControler.findPedidoEntities();

        }catch(Exception ex){
            System.err.println(ex);
        }

        if(pedidos == null)
            pedidos = new ArrayList<Pedido>();

        return pedidos;
    }

    public NotaFiscal gerarNota() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Item createItem(String nome, float preco) {
        Item item = new Item(nome, preco);

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            jpaControler.create(item);

        }catch(Exception ex){
            System.err.println(ex);
            item = null;
        }

        return item;
    }

    public Item getItem(long codigo) {
        Item item = null;

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            item = jpaControler.findItem(codigo);

        }catch(Exception ex){
            System.err.println(ex);
            item = null;
        }

        return item;
    }

    public List<Item> getItens() {
        List<Item> itens = null;

        try{
            ItemJpaController jpaControler = new ItemJpaController();

            itens = jpaControler.findItemEntities();

        }catch(Exception ex){
            System.err.println(ex);
        }

        if(itens == null)
            itens = new ArrayList<Item>();

        return itens;
    }

    public boolean updateItem(Item item) {
        try{
            ItemJpaController jpaControler = new ItemJpaController();

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
 
}
