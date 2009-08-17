/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.remote.EmpresaException;
import com.bm.testsuite.BaseSessionBeanFixture;

/**
 *
 * @author João
 */
public class DIMethodSessionBeanTest extends BaseSessionBeanFixture<EmpresaMgr>{


    private static final Class[] usedBeans = { EmpresaMgr.class };

    /**
     * Construtor
     */
    public DIMethodSessionBeanTest() {
		super(EmpresaMgr.class, usedBeans);
	}


    /**
	 * Test the dpendency injection.
	 */
	public void testDependencyInjection() {
        try {
            final EmpresaMgr toTest = this.getBeanToTest();
            
            assertNotNull(toTest);
            assertNotNull(toTest.getEmpresa());
            assertNotNull(toTest.getItens());
            assertNotNull(toTest.getPedidos());
            assertNotNull(toTest.getVendedores());

        } catch (EmpresaException ex) {
            fail(ex.getMessage());
        }
	}

}
