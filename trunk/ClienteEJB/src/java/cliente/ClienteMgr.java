/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import cliente.entidades.Cliente;
import cliente.entidades.Fatura;
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

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone)  throws ClienteException{
        try{
            Cliente cliente = new Cliente(nome, endereco, cpf, telefone);

            if(cliente.getCpf().isEmpty() || cliente.getCpf() == null){
                throw new ClienteException("CPF inválido");
            }
            if(cliente.getEndereco().isEmpty() || cliente.getEndereco() == null){
                throw new ClienteException("Endereço inválido");
            }
            if(cliente.getNome().isEmpty() || cliente.getNome() == null){
                throw new ClienteException("Nome inválido");
            }
            if(cliente.getTelefone().isEmpty() || cliente.getTelefone() == null){
                throw new ClienteException("Telefone inválido");
            }
            

            if(buscarCliente(cpf) == null){
                
                em.persist(cliente);
            }
            else{
                throw new ClienteException("Já existe cliente cadastrado com o CPF indicado.");                
            }
        }
        catch(Exception e){
            System.err.println(e);
            throw new ClienteException(e);
        }
        return true;
    }

    public ClienteDTO buscarCliente(String cpf)  throws ClienteException{
        if(cpf == null || cpf.isEmpty()){
                throw new ClienteException("CPF inválido");
        }

        List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

        if(retorno.isEmpty())
            return null;
        return ClienteDTO.copy((Cliente)retorno.get(0));

    }

    public boolean editarCliente(ClienteDTO cliente)  throws ClienteException{

        if(cliente.getCpf().isEmpty() || cliente.getCpf() == null){
                throw new ClienteException("CPF inválido");
            }
            if(cliente.getEndereco().isEmpty() || cliente.getEndereco() == null){
                throw new ClienteException("Endereço inválido");
            }
            if(cliente.getNome().isEmpty() || cliente.getNome() == null){
                throw new ClienteException("Nome inválido");
            }
            if(cliente.getTelefone().isEmpty() || cliente.getTelefone() == null){
                throw new ClienteException("Telefone inválido");
            }
        try{
            if (buscarCliente(cliente.getCpf()) != null) {

                em.merge(cliente);
            } else {
                throw new ClienteException("Cliente não cadastrado.");
            }
        }
        catch(Exception e){
            System.err.println(e);
            throw new ClienteException(e);
        }
        return true;
    }

    public boolean deletarCliente(String cpf)  throws ClienteException{
        try{
            List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();
            em.remove((Cliente)retorno.get(0));
        }
        catch(Exception e){
            System.err.println(e);
            throw new ClienteException(e);
        }
        return true;
    }

    public List<ClienteDTO> getClientes()  throws ClienteException{
        List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
        
        try{
            List<Cliente> clientes = em.createNamedQuery("Cliente.findAll").getResultList();

            for(Cliente cliente : clientes){
                clientesDTO.add(ClienteDTO.copy(cliente));
            }
        }
        catch(Exception e){
            System.err.println(e);
            throw new ClienteException(e);
        }

        return clientesDTO;
    }

    public boolean criarFatura(List<PedidoDTO> pedidos, ClienteDTO cliente)  throws ClienteException{

        if(pedidos == null){
            throw new ClienteException("Lista de pedidos nada contém.");
        }
        if(cliente == null){
            throw new ClienteException("Cliente inválido");
        }

        try{
            ClienteDTO client = buscarCliente(cliente.getCpf());

            if(client == null){
                throw new ClienteException("Cliente não cadastrado.");                
            }
            for(PedidoDTO pedido : pedidos){
                if(!(pedido.getCodigo() > 0)){
                    throw new ClienteException("Existem pedido(s) inválido(s).");
                }
            }
            for(PedidoDTO pedido : pedidos){
                Fatura fatura = new Fatura(pedido.getCodigo().intValue(), client.getCpf());
                em.persist(fatura);
            }
            return true;
        }
        catch(Exception e){
            System.err.println(e);
            throw new ClienteException(e);
        }
    }

    public FaturaDTO buscarFatura(Integer id)  throws ClienteException{
        Fatura fatura = null;
        FaturaDTO faturaDTO;
        try{
            fatura = em.find(Fatura.class, id);

            if (fatura == null) {
                return null;
            } else {
                faturaDTO = new FaturaDTO();

                faturaDTO.setCpfCliente(fatura.getCpfCliente());
                faturaDTO.setId(fatura.getId());
                faturaDTO.setIdPedido(fatura.getIdPedido());
            }
        } catch (Exception e) {
            System.err.println(e);
            throw new ClienteException(e);
        }
        return faturaDTO;
    }
}