package com.dominio.produto;

import java.util.*;

public class Produto {

	private int codigo;
	private String descricao;
	private String marca;
	private double valorEntrada;
	private double valorSaida;
	private int quantidade;

	public Produto(int codigo, String descricao, String marca, double valorEntrada, double valorSaida, int quantidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.valorEntrada = valorEntrada;
		this.valorSaida = valorSaida;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMarca() {
		return marca;
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public double getValorSaida() {
		return valorSaida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public void setValorSaida(double valorSaida) {
		this.valorSaida = valorSaida;
	}

	@Override
	public String toString() {
		return "\nProduto: " + getDescricao() + "\nCódigo: " + codigo + "\nDescricao: " + descricao + "\nMarca: " + marca
				+ "\nValor de Entrada: " + valorEntrada + "\nValor de Saida: " + valorSaida + "\nQuantidade: "
				+ quantidade + "\n";
	}

}
