/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import cliente.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author André
 */
@Stateless
public class ClienteMgr implements IClienteMgtRemote{

    @PersistenceContext
    private EntityManager em;

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone) {
        try{
            if(buscarCliente(cpf) == null){
                Cliente cliente = new Cliente(nome, endereco, cpf, telefone);
                em.persist(cliente);
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    public ClienteDTO buscarCliente(String cpf) {
        List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

        if(retorno.isEmpty())
            return null;
        return ClienteDTO.copy((Cliente)retorno.get(0));

    }

    public boolean editarCliente(ClienteDTO cliente) {
        try{
            em.merge(cliente);
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    public boolean deletarCliente(String cpf) {
        try{
            List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();
            em.remove((Cliente)retorno.get(0));
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    public List<ClienteDTO> getClientes() {
        List<Cliente> clientes = em.createNamedQuery("Cliente.findAll").getResultList();

        List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

        for(Cliente cliente : clientes){
            clientesDTO.add(ClienteDTO.copy(cliente));
        }

        return clientesDTO;
    }
}