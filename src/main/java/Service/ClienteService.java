package Service;

import Entidades.Cliente;

public class ClienteService {
    public void validarCliente(Cliente c) {
        if (c.getNome().isEmpty() || c.getCpf().isEmpty() || 
            c.getEndereco().isEmpty() || c.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios!");
        }
        
        // Exemplo de regra de negócio: validação de tamanho de CPF
        if (c.getCpf().length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos!");
        }
    }
}