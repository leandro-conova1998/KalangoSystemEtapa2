package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    // CORREÇÃO: Adicionado o atributo senha para persistência no banco
    @Column(nullable = false, length = 20)
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String cpf, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    // CORREÇÃO: Implementação real dos métodos de senha
    public String getSenha() { 
        return senha; 
    }

    public void setSenha(String senha) { 
        this.senha = senha; 
    }
}