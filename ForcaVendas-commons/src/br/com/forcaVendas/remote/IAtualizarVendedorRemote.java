/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.remote;

import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import java.util.List;

/**
 *
 * @author Henrique
 */
public interface IAtualizarVendedorRemote {

    public VendedorDTO createVendedor(String nome, String endereco, String telefone, long cpf, float salario) throws EmpresaException;

    public boolean updateVendedor(VendedorDTO vendedor) throws EmpresaException;

    public boolean deleteVendedor(int codigo) throws EmpresaException;

    public VendedorDTO getVendedor(int codigo) throws EmpresaException;

    public List<VendedorDTO> getVendedores() throws EmpresaException;

}
