package br.com.forcaVendas.empresa;

import br.com.forcaVendas.empresa.util.HibernateUtil;

/**
 *
 * @author Henrique
 */
public class GeradorBanco {
    
    public static void main(String args[]){
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.gerarBanco();
    }
}
