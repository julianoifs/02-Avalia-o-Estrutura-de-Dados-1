package com.dominio.venda;

import com.dominio.produto.Produto;

public class Venda {

	 // Classe que armazenará todas as informações de vendas de Produtos
	private Produto produto;
	private int qtdVenda;
	private double valorTotal;

	// Cria um novo objeto Venda, associado a um produto e sua quantidade.
	public Venda(Produto produto, int quantidade) {
		this.produto = produto;
		this.qtdVenda = quantidade;
		this.valorTotal = quantidade * produto.getValorSaida();
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidadeVendida() {
		return qtdVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	@Override
	public String toString() {
		return produto.getDescricao() + "\nQuantidade Vendida: " + qtdVenda
				+ "\nValor Total: R$ " + valorTotal;
	}

}
