package Service;

import Entidades.Fornecedor;

public class FornecedorService {
    public void validarFornecedor(Fornecedor f) {
        if (f.getNome().isEmpty() || f.getEndereco().isEmpty() || f.getCnpj().isEmpty()) {
            throw new IllegalArgumentException("Todos os campos do fornecedor devem ser preenchidos!");
        }
        
        // Exemplo de regra adicional: CNPJ deve ter 14 dígitos
        if (f.getCnpj().length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido! Deve conter 14 dígitos.");
        }
    }
}