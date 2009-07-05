package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.entidade.Empresa;
import br.com.forcaVendas.empresa.entidade.Item;
import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.entidade.Pedido;
import br.com.forcaVendas.empresa.entidade.PedidoItem;
import br.com.forcaVendas.empresa.entidade.Vendedor;
import br.com.forcaVendas.empresa.persistencia.EmpresaJpaController;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Henrique
 */
@Stateless
public class EmpresaMgr implements IEmpresaMgtRemote {

    public Empresa getEmpresa() {
        EmpresaJpaController empresaJpa = new EmpresaJpaController();

        Empresa empresa = empresaJpa.findEmpresa(Long.valueOf(1));

        return empresa;
    }

    public void createVendedor(String nome, String endereco, String telefone, long cpf, float salario) {
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
