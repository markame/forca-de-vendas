package br.com.forcaVendas.empresa.util;

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

        // OBS: default eh o nome de meu persistence-unit no persistence.xml.
        // O configure vai procurar o persistence.xml dentro da pasta META-INF que tem que estar no classpath
        cfg.configure("EJBEmpresaPU", null);
        Configuration hbmcfg = cfg.getHibernateConfiguration();
        SchemaExport schemaExport = new SchemaExport(hbmcfg);
        schemaExport.create(true, true);

    }

}
