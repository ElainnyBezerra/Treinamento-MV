package teste;

import entidade.Conta;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;
import entidade.Pessoa;

public class Teste {

	public static void main(String[] args) {

		Pessoa p = new Pessoa();
		p.setCpf("123456789");
		p.setNome("Cleiton Aguiar");
		p.setIdade(36);
		p.setSexo("M");

		Pessoa pp = new Pessoa();
		pp.setCpf("123456789");
		pp.setNome("Guilherme");
		pp.setIdade(51);
		pp.setSexo("M");
		
		System.out.println(p.equals(pp));
		
//		int contador = 1;
//		while(contador <= 100){
//			contador++;
//			if(contador % 2 == 0)
//				System.out.println(contador + " - Cleiton Aguiar");
//				
//		}
		
		
//		int c = 0;
//		
//		while(true) {
//			if (c < 100) {
//				c++;
//				if(c % 2 == 0) {
//					System.out.println(c);
//				}
//			}else {
//				break;
//			}
//		}
		
		Conta conta = new Conta();
		ContaPoupanca cp = new ContaPoupanca();
		ContaCorrente cc = new ContaCorrente();
		
		conta.setNumero(111);
		conta.setSaldo(100);
		
		cp.setNumero(123);
		cp.setSaldo(100);
		
		cc.setNumero(222);
		cc.setSaldo(100);
		cc.setTaxa(7);
		
		conta.sacar(20);
		cc.sacar(20);
		cp.sacar(20);
		
		System.out.println("Conta:" + conta.getSaldo());
		System.out.println("Conta Corrente:" + cc.getSaldo());
		System.out.println("Conta Poupaça:" + cp.getSaldo());

		
		
	}

}
