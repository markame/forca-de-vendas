/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;


import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.Solicitacao;
import fornecedor.interfaces.remote.IFornecedorMgt;
import java.util.ArrayList;
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

    private Fornecedor fornecedor1;
    private Fornecedor fornecedor2;
    private EmpresaDTO empresa;
    private Solicitacao solicitacao;

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
        //cria fornecedor 1
        this.fornecedor1 = new Fornecedor();
        fornecedor1.setCnpj(123456789);
        fornecedor1.setEndereco("Rua A");
        fornecedor1.setId(1);
        fornecedor1.setNome("UEFS");
        fornecedor1.setTelefone("91181703");

        //cria fornecedor 2
        this.fornecedor2 = new Fornecedor();
        fornecedor2.setCnpj(987654321);
        fornecedor2.setEndereco("Rua B");
        fornecedor2.setId(2);
        fornecedor2.setNome("SBC");
        fornecedor2.setTelefone("32352103");

        //cria uma empresa
        this.empresa = new EmpresaDTO();
        empresa.setCnpj(123098456);
        empresa.setEndereco("Rua abc");
        empresa.setId(1);
        empresa.setNome("blabla");
        empresa.setTelefone("1234566");

        //cria solicitação
        this.solicitacao = new Solicitacao();
        solicitacao.setId(1);
        solicitacao.setIdEmpresa(this.empresa.getId());
        solicitacao.setIdFornecedor(this.fornecedor1.getId());

    }

    @After
    public void tearDown() {
    }


    /**
     * Test of createFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testCreateFornecedor() {
        System.out.println("createFornecedor");
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.createFornecedor(this.fornecedor1);
        instance.createFornecedor(this.fornecedor2);

        int id = 1;
        Fornecedor result = instance.getFornecedor(id);
        assertEquals(this.fornecedor1, result);
    }


     /**
     * Test of updateFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testUpdateFornecedor() {
        System.out.println("updateFornecedor");
        fornecedor1.setEndereco("Rua AA BB DD");
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.updateFornecedor(fornecedor1);

        int id = 1;
        Fornecedor result = instance.getFornecedor(id);
        assertEquals(this.fornecedor1, result);
    }


    /**
     * Test of getFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testGetFornecedor() {
        System.out.println("getFornecedor");
        Integer id = 1;
        IFornecedorMgt instance = lookupFornecedorMgt();
        Fornecedor result = instance.getFornecedor(id);
        assertEquals(this.fornecedor1, result);
        id = 2;
        result = instance.getFornecedor(id);
        assertEquals(this.fornecedor2, result);
    }

    /**
     * Test of solicitarItem method, of class FornecedorMgt.
     */
    @Test
    public void testSolicitarItem() {
        System.out.println("solicitarItem");
        List<Integer> itens = new ArrayList<Integer>();
        itens.add(12); itens.add(32);
        IFornecedorMgt instance = lookupFornecedorMgt();
        Solicitacao result = instance.solicitarItem(itens, empresa, fornecedor1);
        assertEquals(solicitacao, result);

    }

    /**
     * Test of deleteFornecedor method, of class FornecedorMgt.
     */
    @Test
    public void testDeleteFornecedor() {
        System.out.println("deleteFornecedor");
        Integer id = 1;
        IFornecedorMgt instance = lookupFornecedorMgt();
        instance.deleteFornecedor(id);

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