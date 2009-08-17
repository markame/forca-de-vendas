/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forcaVendas.empresa;

import com.bm.testsuite.BaseSessionBeanFixture;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class BaseSessionBeanFixtureTest extends BaseSessionBeanFixture<BaseSessionBeanFixtureTest> {

    private static final Class[] usedBeans = {EmpresaMgr.class};

//    private static final CSVInitialDataSet CSV_SET =
//            new CSVInitialDataSet<EmpresaMgr>(
//            EmpresaMgr.class, "initialDataSet.csv",
//            "wkn", "stockName", "isin");
    /**
     * Constructor.
     */
    public BaseSessionBeanFixtureTest() {
        super(BaseSessionBeanFixtureTest.class, usedBeans);
    }

    /**
     * Testmethod.
     */
    public void testBean() {
        BaseSessionBeanFixtureTest toTest = this.getBeanToTest();

        assertNotNull(toTest);
        //assertNotNull(toTest.getBeanToTest());
        toTest.run();
    }

    public static void main(String[] args) {
        BaseSessionBeanFixtureTest eet = new BaseSessionBeanFixtureTest();
        eet.testBean();
    }
}
