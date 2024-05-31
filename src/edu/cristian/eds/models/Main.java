package edu.cristian.eds.models;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco("Banco Teste");
		
		Cliente cliente1 = new Cliente("Fulano Da Silsa", "321321321");
		Cliente cliente2 = new Cliente("Ciclano Dos Santos", "5534534543");
		
		Conta conta = new ContaCorrente(cliente1);
		Conta conta2 = new ContaPoupanca(cliente2);
		
		banco.adicionarNovaConta(conta2);
		banco.adicionarNovaConta(conta);
		
		conta.depositar(1000d);
		conta.transferir(250, conta2);
		
		System.out.println(conta.getMovimentacoes());
		//conta.imprimirExtrato();
		//conta2.imprimirExtrato();
		
		System.out.println(banco.listaDeContas());
		System.out.println(banco.listaDeClientes());

		

	}

}
