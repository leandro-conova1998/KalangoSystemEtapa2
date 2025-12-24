package Service;

import Entidades.Produto;

public class EstoqueService {
    public void validarProduto(Produto p) {
        if (p.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero!");
        }
        if (p.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa!");
        }
    }
}