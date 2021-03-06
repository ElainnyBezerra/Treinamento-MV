package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedidos {

	private String sabor;
	private String recipiente;
	private String cobertura;
	private String adicionais;
	private int quantidade;
	static String sep = "------------------------------------------------";
	private static List<Pedidos> pedido = new ArrayList<Pedidos>();

	public static void inserir(int valor) {

		String sabor, recipiente, resposta, cobertura, adicionais;
		int i = 1;
		Scanner qtd = new Scanner(System.in);

		do {

			Pedidos pd = new Pedidos();
			System.out.println("Informe o sabor: ");
			sabor = qtd.nextLine();
			pd.setSabor(sabor);
			System.out.println("Informe o recipiente(copo ou casquinho): ");
			recipiente = qtd.nextLine();
			pd.setRecipiente(recipiente);
			System.out.println("Informe a cobertura: ");
			cobertura = qtd.nextLine();
			pd.setCobertura(cobertura);
			System.out.println("Informe os adicionais(granulado/pa?oca/chocolate): ");
			adicionais = qtd.nextLine();
			pd.setAdicionais(adicionais);
			adicionais.equalsIgnoreCase(" ");
			pd.setQuantidade(i);
			pedido.add(pd);
			valor--;
			i++;

		} while (valor != 0);

	}

	public static void listarTodos() {
		int cont = 1;
		System.out.println(sep);
		System.out.println("|Codigo|" + "|Sabor|" + "|Recipiente|" + "|Cobertura|" + "|Adicionais|");
		System.out.println(sep);
		for (Pedidos pedidos : pedido) {
			System.out.println(cont + " " + "-" + " " + pedidos.getSabor() + "  " + pedidos.getRecipiente() + "  "
					+ pedidos.getCobertura() + "  " + pedidos.getAdicionais());
			cont++;
		}
	}

	public static void remover(int valor) {

		for (Pedidos pedidos : pedido) {
			if (pedidos.getQuantidade() == valor) {
				pedido.remove(pedidos);
			}
		}
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getRecipiente() {
		return recipiente;
	}

	public void setRecipiente(String recipiente) {
		this.recipiente = recipiente;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static List<Pedidos> getPedido() {
		return pedido;
	}

}
