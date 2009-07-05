/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.entidade.Empresa;
import br.com.forcaVendas.empresa.entidade.Item;
import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.entidade.Pedido;
import br.com.forcaVendas.empresa.entidade.PedidoItem;
import br.com.forcaVendas.empresa.entidade.Vendedor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Henrique
 */
@Remote
public interface IEmpresaMgtRemote {


    public Empresa getEmpresa();

    public Vendedor createVendedor(String nome, String endereco, String telefone, long cpf, float salario);

    public boolean updateVendedor(Vendedor vendedor);

    public boolean deleteVendedor(Vendedor vendedor);

    public Vendedor getVendedor(long codigo);

    public List<Vendedor> getVendedores();

    public Pedido fazerPedido(long cliente, Vendedor vendedor, List<PedidoItem> itens);

    public Pedido getPedido(long codigo);

    public List<Pedido> getPedidos();

    //Refatorado: gerarNota() agora recebe como parametro o pedido
    public NotaFiscal gerarNota(Pedido pedido, short tipoNota,
                        short fretePorConta,
                        String NomeTransp,
                        String enderecoTransp,
                        Long cnpjTransp,
                        String telefoneTransp,
                        Double valorServicos,
                        Double valorImpostos,
                        String dadosAdicionais);//TODO debulhar

    public Item createItem(String nome, float preco);

    public Item getItem(long codigo);

    public List<Item> getItens();

    public boolean updateItem(Item item);

    public boolean deleteItem(long codigo);
}
