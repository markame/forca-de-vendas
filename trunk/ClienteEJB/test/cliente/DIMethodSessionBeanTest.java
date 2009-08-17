/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.cliente.remote.ClienteException;
import com.bm.testsuite.BaseSessionBeanFixture;

/**
 *
 * @author João
 */
public class DIMethodSessionBeanTest extends BaseSessionBeanFixture<ClienteMgr>{


    private static final Class[] usedBeans = { ClienteMgr.class };

    /**
     * Construtor
     */
    public DIMethodSessionBeanTest() {
		super(ClienteMgr.class, usedBeans);
	}


    /**
	 * Test the dpendency injection.
	 */
	public void testDependencyInjection() {

        try {
            final ClienteMgr toTest = this.getBeanToTest();
            assertNotNull(toTest);
            assertNotNull(toTest.getClientes());
            //assertNotNull(toTest.getItens());
            //assertNotNull(toTest.getPedidos());
        } catch (ClienteException ex) {
               fail(ex.getMessage());
        }
            //assertNotNull(toTest.getItens());
            //assertNotNull(toTest.getPedidos());

	}

}
