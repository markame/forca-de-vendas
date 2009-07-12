/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.NotaFiscalDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.VendedorDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique
 */
public class EmpresaMgrTest {

    private EmpresaMgr instance;

    //backup
    private static EmpresaDTO empresaBackup;

    public EmpresaMgrTest() {
        instance = new EmpresaMgr();
    }

    @BeforeClass
    public static void beforeClass(){
        EmpresaMgr instance = new EmpresaMgr();
        empresaBackup = instance.getEmpresa();
    }

    @AfterClass
    public static void afterClass(){
        EmpresaMgr instance = new EmpresaMgr();
        if(empresaBackup != null)
            instance.setEmpresa(empresaBackup);
    }

    /**
     * Test of getEmpresa method, of class EmpresaMgr.
     */
    @Test
    public void testGetEmpresa() {
        System.out.println("getEmpresa");

        try{
            instance.getEmpresa();
        }catch(Exception ex){
            fail(ex.toString());
        }
    }

    /**
     * Test of setEmpresa method, of class EmpresaMgr.
     */
    @Test
    public void testSetEmpresa() {
        System.out.println("setEmpresa");

        EmpresaDTO empresa = instance.getEmpresa();

        if(empresa == null){
            empresa = new EmpresaDTO();
            empresa.setNome("EmpresAAAAAAAA");
        }
        
        boolean result = instance.setEmpresa(empresa);
        //assertTrue(result);

        assertEquals(empresa, instance.getEmpresa());

    }

    /**
     * Test of createVendedor method, of class EmpresaMgr.
     */
    @Test
    public void testCreateVendedor() {
        System.out.println("createVendedor");
        String nome = "Teste";
        String endereco = "Rua A";
        String telefone = "123";
        long cpf = 11;
        float salario = (float) 850.0;
        
        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);
        assertNotNull(vendedor);

        instance.deleteVendedor(vendedor.getCodigo());
    }

    /**
     * Test of updateVendedor method, of class EmpresaMgr.
     */
    @Test
    public void testUpdateVendedor() {
        System.out.println("updateVendedor");

        String nome = "Teste 2";
        String endereco = "Rua A2";
        String telefone = "123";
        long cpf = 13;
        float salario = (float) 850.0;

        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);

        boolean result = false;
        if(vendedor != null){
            result = instance.updateVendedor(vendedor);
        }
        assertTrue(result);
        
        instance.deleteVendedor(vendedor.getCodigo());
    }

    /**
     * Test of deleteVendedor method, of class EmpresaMgr.
     */
    @Test
    public void testDeleteVendedor() {
        System.out.println("deleteVendedor");

        System.out.println("createVendedor");
        String nome = "Teste";
        String endereco = "Rua A";
        String telefone = "123";
        long cpf = 11;
        float salario = (float) 850.0;

        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);
        assertNotNull(vendedor);
        
        Long codigo = vendedor.getCodigo();
        boolean result = instance.deleteVendedor(codigo);
        assertTrue(result);

        vendedor = instance.getVendedor(codigo);
        assertNull(vendedor);
    }

    /**
     * Test of getVendedores method, of class EmpresaMgr.
     */
    @Test
    public void testGetVendedores() {
        System.out.println("getVendedores");

        List<VendedorDTO> vendedores = instance.getVendedores();
        assertNotNull(vendedores);

        String nome = "Teste";
        String endereco = "Rua A";
        String telefone = "123";
        long cpf = 11;
        float salario = (float) 850.0;

        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);

        vendedores = instance.getVendedores();
        assertTrue(vendedores.contains(vendedor));

        instance.deleteVendedor(vendedor.getCodigo());
    }

    /**
     * Test of fazerPedido method, of class EmpresaMgr.
     */
    @Test
    public void testFazerPedido() {
        System.out.println("fazerPedido");
        long cliente = 1;

        String nome = "Teste";
        String endereco = "Rua A";
        String telefone = "123";
        long cpf = 11;
        float salario = (float) 850.0;

        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);

        List<PedidoItemDTO> itensDTO = new ArrayList<PedidoItemDTO>();
        
        PedidoDTO pedido = instance.fazerPedido(cliente, vendedor, itensDTO);
        assertNotNull(pedido);

        //remover pedido
        instance.deleteVendedor(vendedor.getCodigo());
    }

    /**
     * Test of getPedido method, of class EmpresaMgr.
     */
    @Test
    public void testGetPedido() {
        System.out.println("getPedido");

        System.out.println("fazerPedido");
        long cliente = 1;

        String nome = "Teste";
        String endereco = "Rua A";
        String telefone = "123";
        long cpf = 11;
        float salario = (float) 850.0;

        VendedorDTO vendedor = instance.createVendedor(nome, endereco, telefone, cpf, salario);

        List<PedidoItemDTO> itensDTO = new ArrayList<PedidoItemDTO>();
        
        PedidoDTO pedido = instance.fazerPedido(cliente, vendedor, itensDTO);

        long codigo = pedido.getCodigo();
        
        PedidoDTO result = instance.getPedido(codigo);
        assertNotNull(result);

        //remover pedido
        instance.deleteVendedor(vendedor.getCodigo());
    }

    /**
     * Test of getPedidos method, of class EmpresaMgr.
     */
    @org.junit.Test
    public void testGetPedidos() {
        System.out.println("getPedidos");
        
        List<PedidoDTO> pedidos = instance.getPedidos();
        assertNotNull(pedidos);

    }

    /**
     * Test of gerarNota method, of class EmpresaMgr.
     */
    @Test
    public void testGerarNota() {
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class EmpresaMgr.
     */
    @Test
    public void testCreateItem() {
        System.out.println("createItem");
        String nome = "sal";
        float preco = 0.25F;
        
        ItemDTO item = instance.createItem(nome, preco);
        assertNotNull(item);

        instance.deleteItem(item.getCodigo());
        
    }

    /**
     * Test of getItem method, of class EmpresaMgr.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String nome = "sal";
        float preco = 0.25F;

        ItemDTO item = instance.createItem(nome, preco);
        assertNotNull(item);


        ItemDTO result = instance.getItem(item.getCodigo());
        assertEquals(item, result);

        instance.deleteItem(item.getCodigo());
    }

    /**
     * Test of getItens method, of class EmpresaMgr.
     */
    @Test
    public void testGetItens() {
        System.out.println("getItens");
        
        List<ItemDTO> result = instance.getItens();
        assertNotNull(result);
    }

    /**
     * Test of updateItem method, of class EmpresaMgr.
     */
    @Test
    public void testUpdateItem() {
        System.out.println("updateItem");
        System.out.println("createItem");
        String nome = "sal";
        float preco = 0.25F;

        ItemDTO item = instance.createItem(nome, preco);
        assertNotNull(item);

        item.setNome("sal2");

        instance.updateItem(item);
        
        instance.deleteItem(item.getCodigo());
    }
}