/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;

import br.com.forcaVendas.dto.Fornecedor;
import junit.framework.TestCase;

/**
 *
 * @author pblve
 */
public class FornecedorDAOTest extends TestCase {
    
    public FornecedorDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getEntityManager method, of class FornecedorDAO.
     */
    public void testGetEntityManager() {
        /*System.out.println("getEntityManager");
        FornecedorDAO instance = new FornecedorDAO();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of createFornecedor method, of class FornecedorDAO.
     */
    public void testCreateFornecedor() {
        /*System.out.println("createFornecedor");
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("fulero");
        fornecedor.setCnpj(123543);
        fornecedor.setEndereco("1asdf");
        fornecedor.setTelefone("123asdf");
        FornecedorDAO instance = new FornecedorDAO();
        
        instance.createFornecedor(fornecedor);
        assertNotNull(instance.retrieveByName("fulero"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of updateFornecedor method, of class FornecedorDAO.
     */
    public void testUpdateFornecedor() {
        System.out.println("updateFornecedor");
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(201);
        fornecedor.setNome("fulerudo");
        fornecedor.setCnpj(123543);
        fornecedor.setEndereco("1asdf");
        fornecedor.setTelefone("oioioioio");
        FornecedorDAO instance = new FornecedorDAO();
        instance.updateFornecedor(fornecedor);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.getFornecedor(201).getNome());
    }
/**
     * Test of getFornecedor method, of class FornecedorDAO.
     */
    public void testGetFornecedor() {
        /*System.out.println("getFornecedor");
        Integer id = 151;
        FornecedorDAO instance = new FornecedorDAO();
        //Fornecedor expResult = null;
        Fornecedor result = instance.getFornecedor(id);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }
    /**
     * Test of deleteFornecedor method, of class FornecedorDAO.
     */
    public void testDeleteFornecedor() {
        /*System.out.println("deleteFornecedor");
        Integer id = 151;
        FornecedorDAO instance = new FornecedorDAO();
        instance.deleteFornecedor(id);
        // TODO review the generated test code and remove the default call to fail.
        assertNull(instance.getFornecedor(id));*/
    }

    public void testGetFornecedores(){
        System.out.println("getFornecedores");
        
        FornecedorDAO instance = new FornecedorDAO();

        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.getFornecedores().get(0));
    }

}
