package edu.cristian.eds.models;

import java.time.LocalDate;

import edu.cristian.eds.models.enums.TipoMovimentacao;

public class Movimentacao {
	
	private LocalDate data;
	private TipoMovimentacao tipo;
	private Double valor;
	
	
	
	public Movimentacao(String movimentacao, Double valor) {
		this.tipo = TipoMovimentacao.valueOf(movimentacao);
		this.data = LocalDate.now();
		this.valor = valor;
	}



	@Override
	public String toString() {
		return "Movimentacao [data=" + data + ", tipo=" + tipo + ", valor=" + valor + "]";
	}



}
