/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientecomponente;

import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import cliente.session.ClienteRemote;
import cliente.entidades.Cliente;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

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
    public static void main(String[] args) throws NamingException {
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


        boolean resp = clienteMgr.criarCliente(
                //cliente.getId(),
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getCpf(),
                cliente.getTelefone());
        JOptionPane.showMessageDialog(null, resp);
        //clienteMgr.buscarCliente("12345");
        //clienteMgr.editarCliente(cliente);
        //clienteMgr.deletarCliente("12345");

        //JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " inserido no banco com sucesso!");
    }

}
