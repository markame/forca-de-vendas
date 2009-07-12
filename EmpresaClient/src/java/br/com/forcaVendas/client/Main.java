/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.client;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        IEmpresaMgtRemote empresaMgr = (IEmpresaMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote");

        EmpresaDTO empresa = null;
        try {
            empresa = empresaMgr.getEmpresa();
        } catch (EmpresaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(empresa);

        if(empresa == null)
            empresa = new EmpresaDTO();

        empresa.setCnpj(1234);
        empresa.setEndereco("Rua A");
        empresa.setNome("Força de Vendas");

        try {
            empresaMgr.setEmpresa(empresa);
        } catch (EmpresaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            empresa = empresaMgr.getEmpresa();
        } catch (EmpresaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(empresa);
    }

}
