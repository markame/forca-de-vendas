/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thiago
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
        System.out.println("criarCliente");
        String nome = "";
        String endereco = "";
        String cpf = "";
        String telefone = "";
        ClienteMgr instance = new ClienteMgr();
        boolean expResult = false;
        boolean result = instance.criarCliente(nome, endereco, cpf, telefone);
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
        ClienteMgr instance = new ClienteMgr();
        ClienteDTO expResult = null;
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
        ClienteMgr instance = new ClienteMgr();
        boolean expResult = false;
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
        ClienteMgr instance = new ClienteMgr();
        boolean expResult = false;
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
        ClienteMgr instance = new ClienteMgr();
        List expResult = null;
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
        ClienteMgr instance = new ClienteMgr();
        boolean expResult = false;
        boolean result = instance.criarFatura(pedidos, cliente);
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
        ClienteMgr instance = new ClienteMgr();
        FaturaDTO expResult = null;
        FaturaDTO result = instance.buscarFatura(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}