/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;


import br.com.forcaVendas.dto.EmpresaDTO;
import java.util.List;
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
public class FornecedorMgtTest {

    public FornecedorMgtTest() {
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
     * Test of getFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testGetFornecedor() {
        System.out.println("getFornecedor");
        Integer id = null;
        FornecedorMgt instance = new FornecedorMgt();
        Fornecedor expResult = null;
        Fornecedor result = instance.getFornecedor(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarItem method, of class FornecedorMgt.
     */
    @Test
    public void testSolicitarItem() {
        System.out.println("solicitarItem");
        List<Integer> itens = null;
        EmpresaDTO empresa = null;
        Fornecedor fornecedor = null;
        FornecedorMgt instance = new FornecedorMgt();
        Solicitacao expResult = null;
        Solicitacao result = instance.solicitarItem(itens, empresa, fornecedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testCreateFornecedor() {
        System.out.println("createFornecedor");
        Fornecedor fornecedor = null;
        FornecedorMgt instance = new FornecedorMgt();
        instance.createFornecedor(fornecedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testDeleteFornecedor() {
        System.out.println("deleteFornecedor");
        Integer id = null;
        FornecedorMgt instance = new FornecedorMgt();
        instance.deleteFornecedor(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testUpdateFornecedor() {
        System.out.println("updateFornecedor");
        Fornecedor fornecedor = null;
        FornecedorMgt instance = new FornecedorMgt();
        instance.updateFornecedor(fornecedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}