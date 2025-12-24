package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double precoUnico; // Refatoração: nome seguindo padrão Java camelCase
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public ItemPedido() {
    }

    // Refatoração: Construtor que facilita a criação de itens já com dados
    public ItemPedido(Produto produto, int quantidade, double precoUnico) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnico = precoUnico;
    }

    // SRP: Método utilitário para calcular o subtotal do item
    // Isso é regra de negócio básica que o próprio objeto pode conhecer
    public double getSubtotal() {
        return this.precoUnico * this.quantidade;
    }

    public int getId() { return id; }
    // setId removido (Responsabilidade do Banco/JPA)

    public double getPrecoUnico() { return precoUnico; }
    public void setPrecoUnico(double precoUnico) { this.precoUnico = precoUnico; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
}