/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;


import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.Solicitacao;
import fornecedor.interfaces.remote.IFornecedorMgt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
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
 * @author Nelson Alves
 */
public class IFornecedorMgtTest {

    public IFornecedorMgtTest() {
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
     * Test of getFornecedor method, of class IFornecedorMgt.
     */
    @Test
    public void testGetFornecedor() {
        System.out.println("getFornecedor");
        Integer id = null;
        IFornecedorMgt instance = lookupFornecedorMgt();
        Fornecedor expResult = null;
        Fornecedor result = instance.getFornecedor(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarItem method, of class IFornecedorMgt.
     */
    @Test
    public void testSolicitarItem() {
        System.out.println("solicitarItem");
        List<Integer> itens = null;
        EmpresaDTO empresa = null;
        Fornecedor fornecedor = null;
        IFornecedorMgt instance = lookupFornecedorMgt();
        Solicitacao expResult = null;
        Solicitacao result = instance.solicitarItem(itens, empresa, fornecedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFornecedor method, of class IFornecedorMgt.
     */
    @Test
    public void testCreateFornecedor() {
        System.out.println("createFornecedor");
        Fornecedor fornecedor = null;
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.createFornecedor(fornecedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFornecedor method, of class IFornecedorMgt.
     */
    @Test
    public void testDeleteFornecedor() {
        System.out.println("deleteFornecedor");
        Integer id = null;
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.deleteFornecedor(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFornecedor method, of class IFornecedorMgt.
     */
    @Test
    public void testUpdateFornecedor() {
        System.out.println("updateFornecedor");
        Fornecedor fornecedor = null;
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.updateFornecedor(fornecedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private IFornecedorMgt lookupFornecedorMgt() {
        try {
            Context c = new InitialContext();
            return (IFornecedorMgt) c.lookup("java:comp/env/FornecedorMgt");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}