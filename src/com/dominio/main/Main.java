package com.dominio.main;

import com.dominio.lista.Lista;
import com.dominio.produto.Produto;

public class Main {

	public static void main(String[] args) throws Exception {

		Lista controleEstoque = new Lista();

		// Tema: Padaria.
		Produto produto1 = new Produto
				(101, "Pão de Queijo", "Padaria", 4.99, 6.00, 30);
		Produto produto2 = new Produto
				(202, "Bolo de Chocolate", "Padaria", 12.99, 16.00, 20);
		Produto produto3 = new Produto
				(303, "Sonho Recheado ", "Padaria", 5.00, 6.99, 20);

		controleEstoque.add(produto1);
        controleEstoque.add(produto2);
        controleEstoque.add(produto3);
		
		System.out.println(controleEstoque.mostrar());
		
		controleEstoque.ordenarProduto();

		System.out.println("\nProdutos após a ordenação por nome:");
		controleEstoque.relatorioProdutos();

		controleEstoque.reporEstoque(101, 10);
		controleEstoque.vender(202, 5);

		System.out.println("\nEstoque atualizado:");
		controleEstoque.relatorioProdutos();

		System.out.println("\nRelatorio de Vendas:");
		controleEstoque.relatorioVendas();

		controleEstoque.alterarPreco(4.50);

		System.out.println("\nProdutos após aumento de preços:");
		System.out.println(controleEstoque.mostrar());
	}
}
