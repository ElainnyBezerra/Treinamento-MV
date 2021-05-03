package DesafioMV.DesafioMV;

import java.util.List;
import java.util.Scanner;

import dao.CafeManhaDao;
import dao.PessoaDao;
import dao.impl.CafeManhaDaoImpl;
import dao.impl.PessoaDaoImpl;
import entidade.CafeManha;
import entidade.Pessoa;

public class App {
	public static void main(String[] args) {

		int resp = 0, resp1 = 0;
		String nome, cpf, opcao;

		Scanner cmInt = new Scanner(System.in);
		Scanner cmString = new Scanner(System.in);
		PessoaDao pessoaDao = new PessoaDaoImpl();
		CafeManhaDao cafeManhaDao = new CafeManhaDaoImpl();
		Pessoa ps = new Pessoa();
		CafeManha cf = new CafeManha();

		do {

			menu();
			resp = cmInt.nextInt();

			switch (resp) {
			case 1:

				System.out.println("Informe o Nome: ");
				nome = cmString.nextLine();
				ps.setNome(nome);
				System.out.println("Informe o Cpf: ");
				cpf = cmString.nextLine();
				ps.setCpf(cpf);
				System.out.println("Informe a Opção : ");
				opcao = cmString.nextLine();
				cf.setOpcao(opcao);

				pessoaDao.inserir(ps);
				cafeManhaDao.inserir(cf);

				do {
					System.out.println("Informe a Opção : ");
					opcao = cmString.nextLine();
					cf.setOpcao(opcao);

					cafeManhaDao.inserir(cf);

				} while (resp1 == 1);

				System.out.println("Sorvete inserido com sucesso!" + "\n");
				System.out.println("Deseja inserir mais 1 Opção ?(1 - Sim / 2 - Não)");
				resp1 = cmInt.nextInt();

				break;

			case 2:
				System.out.println("1 - Cpf\n" + "2 - Opção\n");
				System.out.println("Informe como deseja remover: ");
				int rem = cmInt.nextInt();
				if (rem == 1) {
					System.out.println("Informe o cpf que deseja remover: ");
					cpf = cmString.next();
					pessoaDao.remover(cpf);
					System.out.println("Cadastro removido com sucesso!");
				} else if (rem == 2) {
					System.out.println("Informe a Opção que deseja remover: ");
					opcao = cmString.next();
					cafeManhaDao.remover(opcao);
					System.out.println("Cadastro removido com sucesso!");
				}

				break;

			case 3:

				List<CafeManha> listaCafeManha = cafeManhaDao.listarTodos();
				for (CafeManha c : listaCafeManha) {
					System.out.println(c.toString());
				}

				break;

			case 4:
				System.out.println("1 - Cpf\n" + "2 - Opção\n");
				System.out.println("Informe como deseja consultar: ");
				int cons = cmInt.nextInt();
				if (cons == 1) {
					System.out.println("Informe o cpf que deseja consultar: ");
					cpf = cmString.next();
					Pessoa pes = pessoaDao.consultar(cpf);
					System.out.println(pes.toString());

				} else if (cons == 2) {
					System.out.println("Informe a Opção que deseja Consultar: ");
					opcao = cmString.next();
					CafeManha cfm = cafeManhaDao.consultar(opcao);
					System.out.println(cfm.toString());
				}

			case 5:

				System.out.println("1 - Cpf\n" + "2 - Opção\n");
				System.out.println("Informe como deseja atualizar: ");
				int atual = cmInt.nextInt();
				if (atual == 1) {
					System.out.println("Informe o Cpf que deseja atualizar: ");
					cpf = cmString.next();
					ps.setCpf(cpf);
					System.out.println("Informe o novo nome para o Cpf informado: ");
					nome = cmString.nextLine();
					ps.setCpf(nome);
					pessoaDao.atualizar(ps);
					System.out.println("Cpf atualizado com sucesso!");

				} else if (atual == 2) {
					System.out.println("Informe a Opção que deseja atualizar: ");
					opcao = cmString.nextLine();
					ps.setCpf(opcao);
					System.out.println("Informe o novo Cpf para a opção informada: ");
					nome = cmString.nextLine();
					ps.setCpf(nome);
					pessoaDao.atualizar(ps);
					System.out.println("Opção atualizada com sucesso!");
				}

			case 6:

				System.out.println("Programa finalizado!");

				break;

			default:

				System.out.println("Opção inválida!");

				break;
			}
		} while (resp != 6);

		System.exit(0);

	}

	static void menu() {

		System.out.println("\n");
		System.out.println("**************************");
		System.out.println("*                        *");
		System.out.println("* CADASTRO CAFÉ DA MANHÃ *");
		System.out.println("*                        *");
		System.out.println("**************************");
		System.out.println("1 - Inserir Cadastro\n" + "2 - Remover Cadastro\n" + "3 - Listar Cadastros\n"
				+ "4 - Consultar Cadastro\n" + "5 - Atualizar Cadastro\n" + "6 - Sair\n");
		System.out.println("Selecione a opção desejada: ");
	}

}
