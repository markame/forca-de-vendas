/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.LinkFaturaPedidoDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import cliente.entidades.Cliente;
import cliente.entidades.Fatura;
import cliente.entidades.LinkFaturaPedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author André
 */
@Stateless
public class ClienteMgr implements IClienteMgtRemote {

    @PersistenceContext
    private EntityManager em;

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException {
        try {
            Cliente cliente = new Cliente(nome, endereco, cpf, telefone);

            if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
                throw new ClienteException("CPF inválido");
            }
            if (cliente.getEndereco() == null || cliente.getEndereco().isEmpty()) {
                throw new ClienteException("Endereço inválido");
            }
            if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                throw new ClienteException("Nome inválido");
            }
            if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
                throw new ClienteException("Telefone inválido");
            }


            if (buscarCliente(cpf) == null) {
                em.persist(cliente);
            } else {
                throw new ClienteException("Já existe cliente cadastrado com o CPF indicado.");
            }
        } catch (Exception e) {
            throw new ClienteException(e);
        }
        return true;
    }

    public ClienteDTO buscarCliente(String cpf) throws ClienteException {
        if (cpf == null || cpf.isEmpty()) {
            throw new ClienteException("CPF inválido");
        }

        List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

        if (retorno.isEmpty()) {
            return null;
            //throw new ClienteException("Não existe cliente cadastrado com o CPF indicado.");
        }
        return ClienteDTO.copy((Cliente) retorno.get(0));

    }

    public boolean editarCliente(ClienteDTO cliente) throws ClienteException {

        if(cliente == null){
            throw new ClienteException("Cliente inválido");
        }

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new ClienteException("CPF inválido");
        }
        if (cliente.getEndereco() == null || cliente.getEndereco().isEmpty()) {
            throw new ClienteException("Endereço inválido");
        }
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new ClienteException("Nome inválido");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new ClienteException("Telefone inválido");
        }
        try {
            if (buscarCliente(cliente.getCpf()) != null) {

                em.merge(cliente);
            } else {
                throw new ClienteException("Cliente não cadastrado.");
            }
        } catch (Exception e) {
            throw new ClienteException(e);
        }
        return true;
    }

    public boolean deletarCliente(String cpf) throws ClienteException {
        try {
            List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

            if (retorno.isEmpty()) {
                throw new ClienteException("Não existe cliente cadastrado com o CPF indicado.");
            }
            em.remove((Cliente) retorno.get(0));
        } catch (Exception e) {
            throw new ClienteException(e);
        }
        return true;
    }

    public List<ClienteDTO> getClientes() throws ClienteException {
        List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

        try {
            List<Cliente> clientes = em.createNamedQuery("Cliente.findAll").getResultList();

            if (clientes.isEmpty()) {
                throw new ClienteException("Não existem clientes cadastrados.");
            }

            for (Cliente cliente : clientes) {
                clientesDTO.add(ClienteDTO.copy(cliente));
            }
        } catch (Exception e) {
            throw new ClienteException(e);
        }

        return clientesDTO;
    }

    public boolean criarFatura(List<PedidoDTO> pedidos, String cpfCliente) throws ClienteException {

        if (pedidos == null) {
            throw new ClienteException("Lista de pedidos nada contém.");
        }
        if (cpfCliente == null || cpfCliente.isEmpty()) {
            throw new ClienteException("CPF inválido");
        }

        try {
            ClienteDTO client = buscarCliente(cpfCliente);

            if (client == null) {
                throw new ClienteException("Cliente não cadastrado.");
            }
            for (PedidoDTO pedido : pedidos) {
                if (!(pedido.getCodigo() > 0)) {
                    throw new ClienteException("Existem pedido(s) inválido(s).");
                }
            }

            int mes = new Date().getMonth() + 1;
            int codFatura = 0;
            Fatura fatura = new Fatura(client.getCpf(), mes);
            em.persist(fatura);

            /*List<Fatura> retorno = em.createNamedQuery("Fatura.findByCliente_Mes").
                    setParameter("cpf_cliente", client.getCpf()).
                    setParameter("mes", mes).getResultList();*/
            List<Fatura> retorno2 = em.createNamedQuery("Fatura.findAll").getResultList();

            if (retorno2 == null || retorno2.isEmpty()) {
                throw new ClienteException("Não existe fatura cadastrada com o CPF de cliente para o respectivo mês indicados.");
            }

            List<Fatura> retorno = new Vector<Fatura>();

            for(Fatura i : retorno2){
                if(i.getCpfCliente().equalsIgnoreCase(cpfCliente) &&
                   i.getMes() == mes){
                    retorno.add(i);
                }
            }

            if(retorno == null){
                throw new ClienteException("Problemas na geração da Fatura!!!");
            }

            if (!retorno.isEmpty()) {
                if (retorno.size() > 1) {
                    throw new ClienteException("Fatura para o mês " + mes + " " +
                            "do cliente de CPF: " + client.getCpf() + " já foi gerada.");
                } else {
                    codFatura = retorno.get(0).getId();
                }
            } else {
                throw new ClienteException("Problemas na geração da Fatura!!!");
            }


            for (PedidoDTO pedido : pedidos) {
                //Fatura fatura = new Fatura(pedido.getCodigo().intValue(), client.getCpf(), pedido.getDataSolicitacao());
                LinkFaturaPedido link = new LinkFaturaPedido(pedido.getCodigo(), codFatura);
                em.persist(link);
            }
            return true;
        } catch (Exception e) {
            throw new ClienteException(e);
        }
    }

    public List<LinkFaturaPedidoDTO> buscarFatura(String cpfCliente, int mes) throws ClienteException {

        if (cpfCliente == null || cpfCliente.isEmpty()) {
            throw new ClienteException("CPF inválido");
        }
        if (!(mes >= 1 && mes <= 12)) {
            throw new ClienteException("Mês inválido");
        }

        //LinkFaturaPedido faturaPedido = null;
        List<LinkFaturaPedidoDTO> faturaPedidoDTO = new Vector<LinkFaturaPedidoDTO>();
        try {

            /*List<Fatura> retorno = em.createNamedQuery("Fatura.findByCliente_Mes").
                    setParameter("cpf_cliente", cpfCliente).
                    setParameter("mes", mes).getResultList();*/
            List<Fatura> retorno2 = em.createNamedQuery("Fatura.findAll").getResultList();

            if (retorno2 == null || retorno2.isEmpty()) {
                throw new ClienteException("Não existe fatura cadastrada com o CPF de cliente para o respectivo mês indicados.");
            }

            List<Fatura> retorno = new Vector<Fatura>();

            for(Fatura i : retorno2){
                if(i.getCpfCliente().equalsIgnoreCase(cpfCliente) &&
                   i.getMes() == mes){
                    retorno.add(i);
                }
            }

            if (retorno == null || retorno.isEmpty()) {
                throw new ClienteException("Não existe fatura cadastrada com o CPF de cliente para o respectivo mês indicados.");
            }

            //faturaPedido = em.find(LinkFaturaPedido.class, id);

            /*List<LinkFaturaPedido> pedidos = em.createNamedQuery("LinkFaturaPedido.findById_Fatura").
                    setParameter("id_fatura", retorno.get(0).getId()).getResultList();*/
            List<LinkFaturaPedido> retorno4 = em.createNamedQuery("LinkFaturaPedido.findAll").getResultList();

            if (retorno4 == null || retorno4.isEmpty()) {
                throw new ClienteException("Não existe fatura cadastrada com o CPF de cliente para o respectivo mês indicados.");
            }

            List<LinkFaturaPedido> pedidos = new Vector<LinkFaturaPedido>();

            for(LinkFaturaPedido i : retorno4){
                if(i.getIdFatura() == retorno.get(0).getId()){
                    pedidos.add(i);
                }
            }

            for (LinkFaturaPedido i : pedidos) {

                LinkFaturaPedidoDTO dto = new LinkFaturaPedidoDTO();

                //faturaPedidoDTO = new LinkFaturaPedidoDTO();

                dto.setIdFatura(i.getIdFatura());
                dto.setIdPedido(i.getIdPedido());
                faturaPedidoDTO.add(dto);
            }
        } catch (Exception e) {
            throw new ClienteException(e);
        }
        return faturaPedidoDTO;
    }
}
