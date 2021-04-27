package ProjetoMV.ProjetoMV;

import java.util.List;
import java.util.Scanner;

import dao.SorveteDao;
import dao.Impl.SorveteDaoImpl;

import entidade.Sorvete;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int resp = 0;
		
		@SuppressWarnings("resource")
		Scanner svt = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner svString = new Scanner(System.in);
		String nome, fabricante, ingredientes;
		SorveteDao sorveteDao = new SorveteDaoImpl();

		do {

			menu();
			resp = svt.nextInt();

			switch (resp) {
			case 1:

				
				Sorvete sv = new Sorvete();
				System.out.println("Informe o nome: ");
				nome = svString.nextLine();
				sv.setNome(nome);
				System.out.println("Informe o fabricante: ");
				fabricante = svString.nextLine();
				sv.setFabricante(fabricante);
				System.out.println("Informe os ingredientes: ");
				ingredientes = svString.nextLine();
				sv.setIngredientes(ingredientes);

				sorveteDao.inserir(sv);

				System.out.println("Sorvete inserido com sucesso!" + "\n");

				break;

			case 2:

				System.out.println("Informe o nome que deseja remover: ");
				nome = svt.next();
				sorveteDao.remover(nome);
				System.out.println("Sorvete removido com sucesso!");

				break;

			case 3:

				List<Sorvete> listaSorvete = sorveteDao.listarTodos();
				for (Sorvete s : listaSorvete) {
					System.out.println(s.toString());
				}
				
				break;

			case 4:
				
				System.out.println("Programa finalizado!");
				
				break;

			default:

				System.out.println("Opção inválida!");
				
				break;
			}
		} while (resp != 4);
		
		System.exit(0);

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
		System.out.println("Selecione a opção desejada: ");
	}
}
