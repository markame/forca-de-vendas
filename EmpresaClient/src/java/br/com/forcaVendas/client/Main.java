/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.client;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.util.EJBUtil;
import java.util.List;
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
        System.out.println("id: " + empresa.getId());
        System.out.println("nome: " + empresa.getNome());
        System.out.println("endereço: " + empresa.getEndereco());
        System.out.println("telefone: " + empresa.getTelefone());

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
        System.out.println("id: " + empresa.getId());
        System.out.println("nome: " + empresa.getNome());
        System.out.println("endereço: " + empresa.getEndereco());
        System.out.println("telefone: " + empresa.getTelefone());

        try {
            empresaMgr.createItem("café2", (float) 2.5);

            List<ItemDTO> itens = empresaMgr.getItens();

            for(ItemDTO item : itens){
                System.out.println(item);
                System.out.println("código: " + item.getCodigo());
                System.out.println("nome: " + item.getNome());
                System.out.println("preço: " + item.getPreco());
            }


        } catch (EmpresaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}
