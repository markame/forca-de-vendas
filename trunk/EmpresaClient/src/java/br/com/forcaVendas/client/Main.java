/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.client;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;

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

        EmpresaDTO empresa = empresaMgr.getEmpresa();
        System.out.println(empresa);

        if(empresa == null)
            empresa = new EmpresaDTO();

        empresa.setCnpj(1234);
        empresa.setEndereco("Rua A");
        empresa.setNome("Força de Vendas");

        empresaMgr.setEmpresa(empresa);

        empresa = empresaMgr.getEmpresa();

        System.out.println(empresa);
    }

}
