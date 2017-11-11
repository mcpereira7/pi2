/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;

import Model.Produto;
import Exceptions.productException;

/**
 *
 * @author Red
 */
public class MockValidarProduto {

    public static void validacao(Produto produto) throws productException {
        if (produto == null) {
            throw new productException("Não foi informado produto.");
        }
        if (produto.getCodProduto() <= 0) {
            throw new productException("Código do produto inválido.");
        }

        if (produto.getDescricao().equalsIgnoreCase(null)) {
            throw new productException("Descrição inválida.");
        }

        if (produto.getNome().equalsIgnoreCase(null)) {
            throw new productException("Nome inválido");
        }

        if (produto.getPlataforma().contentEquals("Escolha") && produto.getTipo().contentEquals("Jogo")) {
            throw new productException("Não foi informado uma plataforma para o produto. Escolha uma das opções.");
        }

        if (produto.getPreco() <= 5.00) {
            throw new productException("Preço inválido.");
        }

        if (produto.getQuantidadeEstoque() <= 0) {
            throw new productException("Quantidade inválida, informe a quantidade em estoque.");
        }

        if (produto.getTipo().contentEquals("Escolha")) {
            throw new productException("Tipo de produto inválido, selecione uma das opções");
        }

    }
}
