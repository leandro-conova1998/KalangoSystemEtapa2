package Entidades;

// Imports corrigidos para JUnit 5 (Jupiter)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoTest {

    @Test
    public void testCalcularValorTotal() {
        Pedido instance = new Pedido();
        
        // Simulação de itens (certifique-se que ItemPedido tem esses métodos)
        ItemPedido item1 = new ItemPedido();
        item1.setPrecoUnico(10.0);
        item1.setQuantidade(2); 
        
        ItemPedido item2 = new ItemPedido();
        item2.setPrecoUnico(50.0);
        item2.setQuantidade(1);
        
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);
        
        instance.setItens(itens);
        instance.calcularValorTotal();
        
        // No JUnit 5, o delta (margem de erro) é opcional, mas útil em doubles
        assertEquals(70.0, instance.getValor(), 0.001);
    }
}