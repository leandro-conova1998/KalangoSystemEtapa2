package Entidades; // Refatoração: Padronização de pacotes

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor") // Boa prática: separar definição de tabela da entidade
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(length = 150) // Refatoração: adicionado limite para o endereço
    private String endereco;
    
    @Column(unique = true, length = 18) // Refatoração: CNPJ deve ser único no sistema
    private String cnpj;

    // Necessário para o JPA
    public Fornecedor() {
    }

    public Fornecedor(String nome, String endereco, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public int getId() { return id; }
    // Removido setId para o ID (deixar o banco gerenciar) aumenta a segurança do objeto

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
