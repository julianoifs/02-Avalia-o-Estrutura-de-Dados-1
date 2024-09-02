package com.dominio.lista;

import com.dominio.produto.Produto;
import com.dominio.venda.Venda;

public class Lista { // Contole de Estoque

	private Celula primeiro;
	private Celula ultimo;
	private Celula venda;
	private int tamanho;

	public Lista() {
		this.primeiro = null;
		this.ultimo = null;
		this.venda = null;
		this.tamanho = 0;
	}

	// 1- método que adiciona um novo produto:
	public void add(Produto elemento) {
		Celula<Produto> cell = new Celula<Produto>(elemento);

		if (this.tamanho == 0) {
			this.primeiro = cell;
		} else {
			this.ultimo.setProximo(cell);
		}
		this.ultimo = cell;
		this.tamanho++;
	}

	// 2- Ordena a lista de produtos por nomes:
	/* 
	 * - Itera células da lista com o ponteiro atual.
	 * - Para cada célula, compara a descrição do produto com as descrições das células subsequentes (i).
	 * - Se a descrição do produto atual for maior que a descrição do próximo, eles trocam de posição.
	 */
	public void ordenarProduto() throws Exception {
		if (this.tamanho == 0) { // Verifica se a lista está vazia, se estiver, lança uma exceção.
			throw new Exception("[ ]");
		}

		Celula<Produto> atual = this.primeiro;
		
		while (atual != null) {
			Celula<Produto> i = atual.getProximo();
			while (i != null) {
				if (atual.getProduto().getDescricao().compareTo(i.getProduto().getDescricao()) > 0) {
					Produto prdutoAtual = atual.getProduto();
					atual.setProduto(i.getProduto());
					i.setProduto(prdutoAtual);
				}
				i = i.getProximo();
			}
			atual = atual.getProximo();
		}
	}

	// 3- Repor produto:
	/* 
	 * - Para cada célula, verifica se o código do produto (atual.getProduto().getCodigo()) é igual ao código fornecido (code).
	 * - Se for encontrado, aumenta a quantidade disponível do produto com atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() + qtd).
	 * - Caso o produto não for encontrado imprime "Produto não Localizado!"
	 */
	public void reporEstoque(int code, int qtd) {
		Celula<Produto> atual = this.primeiro;
		while (atual != null) {
			if (atual.getProduto().getCodigo() == (code)) {
				atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() + qtd);
				return;
			}
			atual = atual.getProximo();
		}
		System.out.println("Produto não Localizado!");
	}

	// 4- Vender produto:
	/*
	 * - Primeiro, verifica se a quantidade em estoque é suficiente (atual.getProduto().getQuantidade() >= qtd).
	 *   caso a quantidade seja insuficiente imprime "Quantidade insuficiente."
	 * - Se houver produto suficiente, diminui a quantidade do produto com atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() - qtd);
	 * - Registra a venda com o método registrarVenda(atual.getProduto(), qtd);
	 */
	public void vender(int code, int qtd) {
		Celula<Produto> atual = this.primeiro;
		while (atual != null) {
			if (atual.getProduto().getCodigo() == (code)) {
				if (atual.getProduto().getQuantidade() >= qtd) {
					atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() - qtd);
					this.registrarVenda(atual.getProduto(), qtd);
					System.out.println("venda realizada com secesso!");
				} else {
					System.out.println("Quantidade insuficiente.");
				}
				return;
			}
			atual = atual.getProximo();
		}
		System.out.println("Produto não Localizado!");
	}

	// registrar vendas de produtos: 
	/*
	 * - Cria um novo objeto Venda com o produto e a quantidade vendida.
	 * - Cria uma nova célula cellVenda que contém a venda.
	 * - Se a lista de vendas estiver vazia atualizar (this.venda == null), define this.venda = cellVenda;
	 * - Se a lista de vendas não estiver vazia, itera até a última célula da lista de vendas e adiciona a nova venda ao final.
	 * - O registro da venda será salvo como na estrutura de lista encadeada da mesma forma que os produtos.
	 * - Método privados diferente dos demais, esse método é apenas acessado pela propria classe Lista
	 */
	private void registrarVenda(Produto produto, int qtd) {
		Venda novaVenda = new Venda(produto, qtd);
		Celula<Venda> cellVenda = new Celula<>(novaVenda);

		if (this.venda == null) {
			this.venda = cellVenda;
		} else {
			Celula<Venda> atual = this.venda;
			while (atual.getProximo() != null) {
				atual = atual.getProximo();
			}
			atual.setProximo(cellVenda);
		}
	}

	// 5- Alteração de preço:
	/*
	 * - Todas as células de produto será iterado e seu valor será alterado de acordo com a pocentagem.
	 * - Para cada produto, calcula o novo valor de saída com base na porcentagem fornecida (novoValor = atual.getProduto().getValorSaida() + (atual.getProduto().getValorSaida() * porcentagem / 100)).
	 * - Novo valor de saída do produto, com: atual.getProduto().setValorSaida(novoValor);
	 */
	public void alterarPreco(double porcentagem) {
		Celula<Produto> atual = this.primeiro;
		while (atual != null) {
			double novoValor = atual.getProduto().getValorSaida()
					+ (atual.getProduto().getValorSaida() * porcentagem / 100);
			atual.getProduto().setValorSaida(novoValor);
			atual = atual.getProximo();
		}
	}

	// 6- relatório de vendas: 
	/*
	 * - Verifica se há vendas registradas (this.venda == null). Se não houver, imprime "Nenhuma venda registrada."
	 * - Para cada venda, imprime os detalhes System.out.println("Venda : " + venda);
	 * - Soma o valor total de todas as vendas e imprime o valor total System.out.println("Valor total das vendas: R$ " + totVendas);
	 */
	public void relatorioVendas() {
		if (this.venda == null) {
			System.out.println("Nenhuma venda registrada.");
			return; // parada do método, caso não haja venda realizada
		}
		Celula<Venda> atual = this.venda;
		double totVendas = 0;

		while (atual != null) {
			Venda venda = atual.getProduto();
			System.out.println("Venda : " + venda);
			totVendas += venda.getValorTotal();
			atual = atual.getProximo();
		}
		System.out.println("Valor total das vendas: R$ " + totVendas);
	}

	// 7- relatório de produtos: 
	/*
	 * - Para cada produto, imprime sua descrição e quantidade em estoque System.out.println(atual.getProduto().getDescricao() + " - " + atual.getProduto().getQuantidade() + " unidades em estoque.");
	 */
	public void relatorioProdutos() {
		Celula<Produto> atual = this.primeiro;
		while (atual != null) {
			System.out.println(atual.getProduto().getDescricao() + " - " + atual.getProduto().getQuantidade()
					+ " unidades em estoque.");
			atual = atual.getProximo();
		}
	}

	// 8- Retorna o tamanho:
	public int getTamanho() {
		return tamanho;
	}

	// 9- Exibir:
	/*
	 * - Usando um StringBuilder para construir a string que representa a lista.
	 * - Itera todas as células da lista, adicionando a representação textual de cada produto à string StringBuilder.
	 * - Retorna a string completa representando a lista.

	 */
	public String mostrar() {
		if (this.tamanho == 0) {
			return new String("[]");
		}
		StringBuilder sb = new StringBuilder();
		Celula atual = this.primeiro;

		for (int i = 0; i < this.tamanho - 1; i++) {
			sb.append(atual.getProduto());
			atual = atual.getProximo();
		}
		sb.append(atual.getProduto());

		return sb.toString();
	}

}
