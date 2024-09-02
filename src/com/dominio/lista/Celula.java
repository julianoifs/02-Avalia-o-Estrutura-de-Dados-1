package com.dominio.lista;

public class Celula<T> {

	private T produto; // valor
	private Celula<T> proximo;

	public Celula(T infor) {
		this.produto = infor;
		this.proximo = null;
	}

	public Celula() {
	}

	public T getProduto() {
		return produto;
	}

	public void setProduto(T produto) {
		this.produto = produto;
	}

	public Celula<T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<T> proximo) {
		this.proximo = proximo;
	}

}
