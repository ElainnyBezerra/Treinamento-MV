package teste;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		int i = 1, numero, soma = 0, ant = 0;

		Scanner num = new Scanner(System.in);

		System.out.println("Informe um n�mero: ");
		numero = num.nextInt();

		while (numero >= soma) {

			System.out.println(soma);
			soma = ant + i;
			ant = i;
			i = soma;

		}
		if (ant == numero) {
			System.out.println("\n" + numero + " " + "� um n�mero da sequ�ncia de Fibonacci! O pr�ximo n�mero da sequ�ncia �  " + soma + "!");
		} else {
			System.out.println("\n" + numero + " " + "N�o � um n�mero da sequ�ncia de Fibonacci!");
		}

	}

}
