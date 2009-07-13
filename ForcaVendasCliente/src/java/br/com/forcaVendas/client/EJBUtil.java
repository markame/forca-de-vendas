 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forcaVendas.client;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import com.sun.enterprise.naming.SerialInitContextFactory;

/**
 *
 * @author Henrique
 */
public class EJBUtil {

    private static Properties getProperties() {
        //Propriedades do initial context.  
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        //props.setProperty("java.naming.provider.url", "ecompjrserver.uefs.br:3306");
        props.setProperty("java.naming.provider.url", "localhost:3700");  
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");

        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        return props;
    }

    public static Object getFacade(String facadeClass) {
        Object facade = null;

        try {
            InitialContext ctx = new InitialContext(getProperties());
            //InitialContext ctx = new InitialContext();

            //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
            facade = ctx.lookup(facadeClass);

        } catch (NamingException ex) {
            Logger.getLogger("ForcaVendasCliente").log(Level.SEVERE, "Conexão EJB falhou: " + facadeClass + " \n" +
                    ex.toString());
        }

        return facade;
    }
}
