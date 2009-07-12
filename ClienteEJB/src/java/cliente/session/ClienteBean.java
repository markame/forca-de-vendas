/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.session;

import cliente.entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
@Stateless
public class ClienteBean implements ClienteRemote {

    @PersistenceContext
    private EntityManager em;
    
    public void criarCliente(String nome, String endereco, String cpf, String telefone) {
        try{
            Cliente cliente = new Cliente(nome, endereco, cpf, telefone);
            em.persist(cliente);
            em.flush();
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " salvo com sucesso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cliente com o mesmo CPF já cadastrado!");
        }
    }

    public void buscarCliente(String cpf) {
        List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

        if(retorno.isEmpty())
            JOptionPane.showMessageDialog(null, "EMPTY");
        
    }

    public void editarCliente(Cliente cliente) {
        em.merge(cliente);
        
    }

    public void deletarCliente(String cpf) {
        List retorno = em.createNamedQuery("Cliente.findByCpf").setParameter("cpf", cpf).getResultList();

        em.remove((Cliente)retorno.get(0));
    }

}
