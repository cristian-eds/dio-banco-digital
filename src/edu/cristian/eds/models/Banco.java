package edu.cristian.eds.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
	
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		super();
		this.nome = nome;
		this.contas = new ArrayList<Conta>();
	}
	
	public String getNome() {
		return nome;
	}

	public void adicionarNovaConta(Conta novaConta) {
		contas.add(novaConta);
	}
	
	public List<Conta> listaDeContas() {
		return contas;
	}
	
	public List<Cliente> listaDeClientes() {
		return contas.stream().map(conta -> conta.getCliente()).collect(Collectors.toList());
	}
	

}
