/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientecomponente;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import cliente.entidades.Cliente;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.naming.NamingException;

/**
 *
 * @author André
 */
public class Main {

    //@EJB
    //private static ClienteRemote clienteMgr;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException, ClienteException {
        //Context initCtx = new InitialContext();
        //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
        //ClienteRemote clienteMgr = (ClienteRemote) EJBUtil.getFacade("cliente.session.ClienteRemote");
        IClienteMgtRemote clienteMgr = (IClienteMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.cliente.remote.IClienteMgtRemote");

        Cliente cliente = new Cliente();
        //cliente.setId(1);
        cliente.setNome("Jose da Silva");
        cliente.setEndereco("Rua Z");
        cliente.setTelefone("3221-2222");
        cliente.setCpf("1234567");

        ClienteDTO clienteDTO;
        FaturaDTO faturaDTO;

        boolean resp;
        //resp = clienteMgr.criarCliente(cliente.getNome(), cliente.getEndereco(), cliente.getCpf(), cliente.getTelefone());

        //ClienteDTO clienteDTO = clienteMgr.buscarCliente(null);
        
        
        //clienteMgr.buscarCliente("12345");
        //clienteMgr.editarCliente(cliente);
        //clienteMgr.deletarCliente("12345");

        //JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " inserido no banco com sucesso!");

        //IFaturaMgtRemote faturaMgr = (IFaturaMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.cliente.remote.IFaturaMgtRemote");

        //cliente.setId(1);
        ItemDTO item1 = new ItemDTO();
        ItemDTO item2 = new ItemDTO();

        item1.setCodigo(1);
        item1.setNome("Pen drive Mininiiiiinho!");
        item1.setPreco(45);

        item1.setCodigo(2);
        item1.setNome("Memoria Mininiiiiinho!");
        item1.setPreco(135);

        Vector<ItemDTO> itens = new Vector<ItemDTO>();
        itens.add(item1);
        itens.add(item2);

        List<PedidoDTO> pedidos = new LinkedList<PedidoDTO>();
        for(int i = 1; i <= 3;i++){
            PedidoDTO pedido = new PedidoDTO();
            pedido.setCodigo(i);

            pedidos.add(pedido);
        }


        clienteDTO = ClienteDTO.copy(cliente);
        //resp = clienteMgr.criarFatura(pedidos, clienteDTO);
        faturaDTO = clienteMgr.buscarFatura(1);

        if(faturaDTO != null){
            System.out.println("Fatura buscada: " + faturaDTO.getIdPedido());
        }
    }

}
