/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.client;

import br.com.forcaVendas.empresa.IEmpresaMgtRemote;
import br.com.forcaVendas.empresa.entidades.Empresa;
import javax.ejb.EJB;

/**
 *
 * @author Henrique
 */
public class Main {

    //@EJB
    //public IEmpresaMgtRemote empresaMgr;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
        IEmpresaMgtRemote empresaMgr = (IEmpresaMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.empresa.IEmpresaMgtRemote");

        Empresa empresa = empresaMgr.getEmpresa();

        System.out.println(empresa);
    }

}
