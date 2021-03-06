package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidade.Pedidos;

public class Principal {

	public static void main(String[] args) {

		int qtd1, resp = 0;
		String sep = "------------------------------------------------";

		Scanner qtd = new Scanner(System.in);

		do {

			menu();
			resp = qtd.nextInt();

			switch (resp) {
			case 1:
				System.out.println("Informe a quantidade de sorvetes: ");
				qtd1 = qtd.nextInt();

				Pedidos.inserir(qtd1);

				System.out.println("Os sorvetes foram inseridos com sucesso!" + "\n");

				break;

			case 2:
				int ped;

				if (!(Pedidos.getPedido().isEmpty())) {
					System.out.println("Informe o c?digo que deseja remover: ");
					ped = qtd.nextInt();
					Pedidos.remover(ped);
					System.out.println("Sorvete removido com sucesso!");
				} else {
					System.out.println("N?o existe sorvete para remover!");
				}
				break;

			case 3:
				
				if (!(Pedidos.getPedido().isEmpty())) {
					
				Pedidos.listarTodos();
				System.out.println(sep);
				
				} else {
					
					System.out.println("N?o existe sorvete para listar!");
					
				}
				break;

			case 4:
				System.out.println("Programa finalizado!");
				break;

			default:

				System.out.println("Op??o inv?lida!");
				break;
			}
		} while (resp != 4);

	}

	static void menu() {

		System.out.println("\n");
		System.out.println("*************************");
		System.out.println("*                       *");
		System.out.println("*     SORVETERIA MV     *");
		System.out.println("*                       *");
		System.out.println("*************************");
		System.out.println(
				"1 - Inserir Sorvete" + "\n" + "2 - Remover Sorvete" + "\n" + "3 - Listar todos" + "\n" + "4 - Sair");
		System.out.println("Selecione a op??o desejada: ");
	}

}
