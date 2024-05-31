package edu.cristian.eds.models;

import java.util.ArrayList;
import java.util.List;

import edu.cristian.eds.models.interfaces.IConta;

public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected Integer agencia;
	protected Integer numero;
	protected Double saldo;
	
	protected Cliente cliente;
	
	protected List<Movimentacao> movimentacoes;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0d;
		this.movimentacoes = new ArrayList<Movimentacao>();
		novaMovimentacao("CRIACAO",0d);
		
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	private void novaMovimentacao(String tipoMovimentacao, Double valor) {
		movimentacoes.add(new Movimentacao(tipoMovimentacao, valor));
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public void sacar(double valor) {
		if(valor <= this.saldo) {
			saldo -= valor;
			novaMovimentacao("SAQUE", valor);
		}
		
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		novaMovimentacao("DEPOSITO", valor);
		
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if(valor <= this.saldo) {
			saldo -= valor;
			contaDestino.depositar(valor);
		}
		novaMovimentacao("TRANSFERENCIA", valor);
		
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}
	
	

}
