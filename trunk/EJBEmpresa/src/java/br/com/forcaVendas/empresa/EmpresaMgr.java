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
import javax.ejb.Stateless;

/**
 *
 * @author Henrique
 */
@Stateless
public class EmpresaMgr implements IEmpresaMgtRemote {

    public Empresa getEmpresa() {
        //Fazer busca
        Empresa empresa = new Empresa();
        empresa.setNome("Força de Vendas");

        return empresa;
    }

    public void createVendedor(String nome, String endereco, String telefone, int cpf, float salario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Vendedor getVendedor(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Vendedor> getVendedores() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido fazerPedido(int cliente, Vendedor vendedor, List<PedidoItem> itens) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NotaFiscal gerarNota() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Item createItem(String nome, float preco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Item getItem(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Item> getItens() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Item updateItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteItem(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
 
}
