/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.client;

import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.remote.IForcaVendasMgtRemote;
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
    public static void main(String[] args) throws NamingException {
        //Context initCtx = new InitialContext();
        //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
        //ClienteRemote clienteMgr = (ClienteRemote) EJBUtil.getFacade("cliente.session.ClienteRemote");
        IForcaVendasMgtRemote forcaVendasMgr = (IForcaVendasMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.remote.IForcaVendasMgtRemote");

        ClienteDTO cliente = new ClienteDTO();
        //cliente.setId(1);
        cliente.setNome("Cliente ForcaVendasEJB");
        cliente.setEndereco("Soft Componentes");
        cliente.setTelefone("8888-8888");
        cliente.setCpf("12345678901");

        forcaVendasMgr.createCliente(cliente.getNome(), cliente.getEndereco(), cliente.getCpf(),
                cliente.getTelefone());
    }

}
