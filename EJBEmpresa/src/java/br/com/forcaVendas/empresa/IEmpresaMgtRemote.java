/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.entidades.Empresa;
import br.com.forcaVendas.empresa.entidades.Item;
import br.com.forcaVendas.empresa.entidades.NotaFiscal;
import br.com.forcaVendas.empresa.entidades.Pedido;
import br.com.forcaVendas.empresa.entidades.PedidoItem;
import br.com.forcaVendas.empresa.entidades.Vendedor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Henrique
 */
@Remote
public interface IEmpresaMgtRemote {


    public Empresa getEmpresa();

    public void createVendedor(String nome, String endereco, String telefone, int cpf, float salario);

    public void updateVendedor(Vendedor vendedor);

    public void deleteVendedor(Vendedor vendedor);

    public Vendedor getVendedor(int codigo);

    public List<Vendedor> getVendedores();

    public Pedido fazerPedido(int cliente, Vendedor vendedor, List<PedidoItem> itens);

    public NotaFiscal gerarNota();//TODO debulhar

    public Item createItem(String nome, float preco);

    public Item getItem(int codigo);

    public List<Item> getItens();

    public Item updateItem(Item item);

    public void deleteItem(int codigo);

}
