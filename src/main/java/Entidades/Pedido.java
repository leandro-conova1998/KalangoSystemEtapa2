package Entidades;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP) // Garante data e hora exatas para a Web
    private Date data;
    
    private double valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Cascade ALL garante que ao salvar o pedido, os itens sejam salvos juntos
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
        this.data = new Date(); // Define a data atual no momento da criação
    }

    // SRP: Responsabilidade única de calcular o total do pedido
    // Evita que a interface (Swing ou Web) precise fazer cálculos matemáticos
    public void calcularValorTotal() {
        this.valor = itens.stream()
                          .mapToDouble(item -> item.getPrecoUnico() * item.getQuantidade())
                          .sum();
    }

    // Getters e Setters
    
    public int getId() { return id; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { 
        this.itens = itens; 
        calcularValorTotal(); // Recalcula se a lista for alterada
    }
}