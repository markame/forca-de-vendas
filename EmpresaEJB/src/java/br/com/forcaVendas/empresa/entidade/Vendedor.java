package br.com.forcaVendas.empresa.entidade;

import br.com.forcaVendas.dto.interfaces.IVendedor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Henrique
 */
@Entity
public class Vendedor implements IVendedor, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column
    private String nome;

    @Column
    private String endereco;

    //telefone foi substituido de int para String
    @Column
    private String telefone;

    @Column(unique=true)
    private Long cpf;

    @Column
    private Float salario;

    public Vendedor() {
    }

    public Vendedor(String nome, String endereco, String telefone, long cpf, float salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forcaVendas.empresa.entidade.Vendedor[codigo=" + codigo + "]";
    }

    public static Vendedor copy(IVendedor vend){
        Vendedor vendedor = null;

        if(vendedor != null){
            vendedor = new Vendedor();

            vendedor.setCodigo(vend.getCodigo());
            vendedor.setCpf(vend.getCpf());
            vendedor.setEndereco(vend.getEndereco());
            vendedor.setNome(vend.getNome());
            vendedor.setSalario(vend.getSalario());
            vendedor.setTelefone(vend.getTelefone());
        }
        return vendedor;
    }
}
