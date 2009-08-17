/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André
 */
public class ClienteMgrTest {


    public ClienteMgrTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of criarCliente method, of class ClienteMgr.
     */
    @Test
    public void testCriarCliente() throws Exception {
        System.out.println("<---- criarCliente ---->");
        String nome = "joao";
        String endereco = "sim";
        String cpf = "2424";
        String telefone = "88118811";
        ClienteMgr instance = new ClienteMgr();
        boolean expResult = true;
        boolean result = instance.criarCliente(nome, endereco, cpf, telefone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class ClienteMgr.
     */
    @Test
    public void testBuscarCliente() throws Exception {
        System.out.println("buscarCliente");
        String cpf = "";        
        ClienteDTO expResult = null;
        ClienteMgr instance = new ClienteMgr();
        ClienteDTO result = instance.buscarCliente(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarCliente method, of class ClienteMgr.
     */
    @Test
    public void testEditarCliente() throws Exception {
        System.out.println("editarCliente");
        ClienteDTO cliente = null;        
        boolean expResult = false;
        ClienteMgr instance = new ClienteMgr();
        boolean result = instance.editarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarCliente method, of class ClienteMgr.
     */
    @Test
    public void testDeletarCliente() throws Exception {
        System.out.println("deletarCliente");
        String cpf = "";        
        boolean expResult = false;
        ClienteMgr instance = new ClienteMgr();
        boolean result = instance.deletarCliente(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientes method, of class ClienteMgr.
     */
    @Test
    public void testGetClientes() throws Exception {
        System.out.println("getClientes");        
        List expResult = null;
        ClienteMgr instance = new ClienteMgr();
        List result = instance.getClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarFatura method, of class ClienteMgr.
     */
    @Test
    public void testCriarFatura() throws Exception {
        System.out.println("criarFatura");
        List<PedidoDTO> pedidos = null;
        ClienteDTO cliente = null;        
        boolean expResult = false;
        ClienteMgr instance = new ClienteMgr();
//        boolean result = instance.criarFatura(pedidos, cliente);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarFatura method, of class ClienteMgr.
     */
    @Test
    public void testBuscarFatura() throws Exception {
        System.out.println("buscarFatura");
        Integer id = null;        
        FaturaDTO expResult = null;
        ClienteMgr instance = new ClienteMgr();
//        FaturaDTO result = instance.buscarFatura(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static Properties getProperties() {
        //Propriedades do initial context.
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        //props.setProperty("java.naming.provider.url", "ecompjrserver.uefs.br:3306");
        props.setProperty("java.naming.provider.url", "localhost:3700");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");

        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        return props;
    }

    public static Object getFacade(String facadeClass) {
        Object facade = null;

        try {
            InitialContext ctx = new InitialContext(getProperties());
            //InitialContext ctx = new InitialContext();

            //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
            facade = ctx.lookup(facadeClass);

        } catch (NamingException ex) {
            Logger.getLogger("ComponenteCliente").log(Level.SEVERE, "Conexão EJB falhou: " + facadeClass + " \n" +
                    ex.toString());
        }

        return facade;
    }

}