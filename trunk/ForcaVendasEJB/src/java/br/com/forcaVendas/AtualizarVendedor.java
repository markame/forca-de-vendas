/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.remote.IAtualizarVendedorRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Henrique
 */
@Stateless
public class AtualizarVendedor implements IAtualizarVendedorRemote{

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;

    public AtualizarVendedor() {
    }

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException {
        return empresaMgtRemote.createVendedor(nome, endereco, telefone, cpf, salario);
    }

    public VendedorDTO getVendedor(int codigo) throws EmpresaException {
        return empresaMgtRemote.getVendedor(codigo);
    }

    public List<VendedorDTO> getVendedores() throws EmpresaException {
        return empresaMgtRemote.getVendedores();
    }

    public boolean deleteVendedor(int codigo) throws EmpresaException {
        return empresaMgtRemote.deleteVendedor(codigo);
    }

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException {
        return empresaMgtRemote.updateVendedor(vendedor);
    }

}
