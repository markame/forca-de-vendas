package br.com.forcaVendas.empresa.util;

import br.com.forcaVendas.empresa.entidade.Empresa;
import br.com.forcaVendas.empresa.entidade.Item;
import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.entidade.Pedido;
import br.com.forcaVendas.empresa.entidade.PedidoItem;
import br.com.forcaVendas.empresa.entidade.Vendedor;
import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Henrique
 */
public class HibernateUtil {

    /* para hibernate.cfg.xml */
    /*public void gerarBanco(){
        Configuration cfg = new AnnotationConfiguration();

        cfg.configure();
        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);

    }*/


    /* para hibernate.cfg.xml */
    public void gerarBanco(){
        Ejb3Configuration cfg = new Ejb3Configuration();

        // OBS: eh o nome de meu persistence-unit no persistence.xml.
        // O configure vai procurar o persistence.xml dentro da pasta META-INF que tem que estar no classpath
        //cfg.configure("EmpresaEJBPU", null);
        cfg.configure("RESOURCE_LOCAL");


        /*
         * Propriedades do Hibernate
         *
         * Caso existam alterações no persistence.xml srão necessárias
         * alterações nestas propriedades.
         */
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/ForcaDeVendas");
        properties.setProperty("hibernate.connection.username", "empresa");
        properties.setProperty("hibernate.connection.password", "empresa");
        cfg.addProperties(properties);


        cfg.addAnnotatedClass(Empresa.class);
        cfg.addAnnotatedClass(Item.class);
        cfg.addAnnotatedClass(NotaFiscal.class);
        cfg.addAnnotatedClass(Pedido.class);
        cfg.addAnnotatedClass(PedidoItem.class);
        cfg.addAnnotatedClass(Vendedor.class);

        Configuration hbmcfg = cfg.getHibernateConfiguration();
        

        SchemaExport schemaExport = new SchemaExport(hbmcfg);
        schemaExport.create(true, true);
    }

}
