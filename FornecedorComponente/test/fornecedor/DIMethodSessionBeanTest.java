/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;

import br.com.forcaVendas.cliente.remote.ClienteException;
import com.bm.testsuite.BaseSessionBeanFixture;

/**
 *
 * @author João
 */
public class DIMethodSessionBeanTest extends BaseSessionBeanFixture<FornecedorMgt>{


    private static final Class[] usedBeans = { FornecedorMgt.class };

    /**
     * Construtor
     */
    public DIMethodSessionBeanTest() {
		super(FornecedorMgt.class, usedBeans);
	}


    /**
	 * Test the dpendency injection.
	 */
	public void testDependencyInjection() {

            final FornecedorMgt toTest = this.getBeanToTest();
            assertNotNull(toTest);
            assertNotNull(toTest.getFornecedor(0));

	}

}
