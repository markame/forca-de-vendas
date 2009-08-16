/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecomponente;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.LinkFaturaPedidoDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import cliente.entidades.Cliente;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class Main {

    //@EJB
    //private static ClienteRemote clienteMgr;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Context initCtx = new InitialContext();
        //Quando vc faz o lookup vc passa o caminho completo da interface local ou remote.
        //ClienteRemote clienteMgr = (ClienteRemote) EJBUtil.getFacade("cliente.session.ClienteRemote");
        IClienteMgtRemote clienteMgr = (IClienteMgtRemote) EJBUtil.getFacade("br.com.forcaVendas.cliente.remote.IClienteMgtRemote");
        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das opções abaixo: " +
                    "\n1 - Cadastrar um cliente." +
                    "\n2 - Buscar um cliente." +
                    "\n3 - Atualizar um cliente." +
                    "\n4 - Deletar um cliente." +
                    "\n5 - Gerar uma fatura de um cliente." +
                    "\n6 - Buscar uma fatura de um cliente." +
                    "\n7 - Listar todos os clientes cadastrados." +
                    "\n8 - Sair."));

            switch (opcao) {
                case 1: //Cadastrar um cliente
                    String nome = JOptionPane.showInputDialog(null, "Nome do cliente: ");
                    String endereco = JOptionPane.showInputDialog(null, "Endereço do cliente: ");
                    String telefone = JOptionPane.showInputDialog(null, "Telefone do cliente: ");
                    String cpf = JOptionPane.showInputDialog(null, "CPF do cliente: ");

                    Cliente cliente = new Cliente();
                    //cliente.setId(1);
                    cliente.setNome(nome);
                    cliente.setEndereco(endereco);
                    cliente.setTelefone(telefone);
                    cliente.setCpf(cpf);

                    try {
                        clienteMgr.criarCliente(cliente.getNome(), cliente.getEndereco(), cliente.getCpf(), cliente.getTelefone());
                        JOptionPane.showMessageDialog(null, "Cliente criado com sucesso");
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 2: //Buscar um cliente
                    try {
                        String cpf2 = JOptionPane.showInputDialog(null, "Informe o CPF do cliente: ");
                        ClienteDTO dto = clienteMgr.buscarCliente(cpf2);
                        JOptionPane.showMessageDialog(null, "Cliente buscado: " +
                                "\nNome: " + dto.getNome() +
                                "\nEndereco: " + dto.getEndereco() +
                                "\nTelefone: " + dto.getTelefone() +
                                "\nCPF: " + dto.getCpf());
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Não existe cliente cadastrado com o CPF indicado.");
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 3: //Atualizar um cliente
                    try {
                        String cpf2 = JOptionPane.showInputDialog(null, "Informe o CPF do cliente: ");
                        ClienteDTO dto = clienteMgr.buscarCliente(cpf2);
                        if (dto != null) {
                            String novoNome = JOptionPane.showInputDialog(null, "Cliente a atualizar: " +
                                    "\nNome atual: " + dto.getNome() +
                                    "\nNovo nome: ");
                            String novoEndereco = JOptionPane.showInputDialog(null, "Cliente a atualizar: " +
                                    "\nEndereco atual: " + dto.getEndereco() +
                                    "\nNovo endereço: ");
                            String novoTelefone = JOptionPane.showInputDialog(null, "Cliente a atualizar: " +
                                    "\nTelefone atual: " + dto.getTelefone() +
                                    "\nNovo telefone: ");
                            String novoCpf = JOptionPane.showInputDialog(null, "Cliente a atualizar: " +
                                    "\nCPF atual: " + dto.getCpf() +
                                    "\nNovo CPF: ");
                            dto.setNome(novoNome);
                            dto.setEndereco(novoEndereco);
                            dto.setCpf(novoCpf);
                            dto.setTelefone(novoTelefone);
                            clienteMgr.editarCliente(dto);
                            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
                        } else {
                            JOptionPane.showMessageDialog(null, "Não existe cliente cadastrado com o CPF indicado.");
                        }
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 4: //Deletar um cliente
                    try {
                        String cpf2 = JOptionPane.showInputDialog(null, "Informe o CPF do cliente: ");
                        clienteMgr.deletarCliente(cpf2);
                        JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 5: //Gerar fatura
                    try {
                        String cpf2 = JOptionPane.showInputDialog(null, "Informe o CPF do cliente: ");
                        String validos = JOptionPane.showInputDialog(null, "Testar com pedidos válidos? (S - Sim; N - Não): ");
                        if (validos.equalsIgnoreCase("S")) {

                            List<PedidoDTO> pedidos = new LinkedList<PedidoDTO>();
                            for (int i = 1; i <= 3; i++) {
                                PedidoDTO pedido = new PedidoDTO();
                                pedido.setCodigo(i);

                                pedidos.add(pedido);
                            }
                            clienteMgr.criarFatura(pedidos, cpf2);
                        } else {
                            clienteMgr.criarFatura(null, cpf2);
                        }
                        JOptionPane.showMessageDialog(null, "Fatura gerada com sucesso");
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 6: //Buscar fatura
                    try {
                        String cpf2 = JOptionPane.showInputDialog(null, "Informe o CPF do cliente: ");
                        int codFatura = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o mês da fatura: "));
                        List<String> faturaPedidos = clienteMgr.buscarFatura(cpf2, codFatura);
                        //for (LinkFaturaPedidoDTO i : faturaDTO) {
                            JOptionPane.showMessageDialog(null, "Fatura buscada: " +
                                    //"\nCódigo da fatura: " + i.getIdFatura() +
                                    "\nCódigos dos pedidos: " + faturaPedidos.toString());
                        //}
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Informe um número para o mês!");
                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 7: //listar todos os clientes
                    try {
                        List<ClienteDTO> clientes = clienteMgr.getClientes();
                        String c = "";

                        for (ClienteDTO clienteDTO : clientes) {
                            c = c.concat("Nome: " + clienteDTO.getNome() + " / CPF: " + clienteDTO.getCpf() + "\n");
                        }
                        JOptionPane.showMessageDialog(null, c);

                    } catch (ClienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
