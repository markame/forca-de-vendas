/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import clientecomponente.EJBUtil;
import java.util.List;
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

    private static IClienteMgtRemote clienteMgr;
    public ClienteMgrTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        clienteMgr = (IClienteMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.cliente.remote.IClienteMgtRemote");
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
        System.out.println("criarCliente");
        String nome = "";
        String endereco = "";
        String cpf = "";
        String telefone = "";
        clienteMgr = (IClienteMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.cliente.remote.IClienteMgtRemote");
        boolean expResult = false;
        boolean result = clienteMgr.criarCliente(nome, endereco, cpf, telefone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class ClienteMgr.
     */
    @Test
    public void testBuscarCliente() throws Exception {
        System.out.println("buscarCliente");
        String cpf = "";        
        ClienteDTO expResult = null;
        ClienteDTO result = clienteMgr.buscarCliente(cpf);
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
        boolean result = clienteMgr.editarCliente(cliente);
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
        boolean result = clienteMgr.deletarCliente(cpf);
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
        List result = clienteMgr.getClientes();
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
        boolean result = clienteMgr.criarFatura(pedidos, cliente);
        assertEquals(expResult, result);
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
        FaturaDTO result = clienteMgr.buscarFatura(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}