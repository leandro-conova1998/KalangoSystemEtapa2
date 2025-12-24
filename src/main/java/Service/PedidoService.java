package Service;

import Entidades.Cliente;
import Entidades.Produto;
import Entidades.ClienteJPA;
import Entidades.ProdutoJPA;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PedidoService {
    private EntityManager em;

    public PedidoService(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> buscarClientesParaPedido(String nome) {
        ClienteJPA clienteDAO = new ClienteJPA(em);
        return (nome == null || nome.isEmpty()) ? clienteDAO.listarTodos() : clienteDAO.buscarPorNome(nome);
    }

    public List<Produto> buscarProdutosParaPedido(String nome) {
        ProdutoJPA produtoDAO = new ProdutoJPA(em);
        return (nome == null || nome.isEmpty()) ? produtoDAO.listar() : produtoDAO.buscarPorNome(nome);
    }
}
