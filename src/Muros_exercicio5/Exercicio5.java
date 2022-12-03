/* 
Considere dois números inteiros a (a 6= 0) e b (b  0) lidos pelo teclado. Faça um algoritmo recursivo para
calcular o valor de ab.
Crie e utilize uma função recursiva para calcular ab. Esta informação tem que ser impressa na função main.
Obs.: Não é permitido utilizar qualquer estrutura de repetição na função recursiva.*/
package Muros_exercicio5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = 0, b = 0;
		System.out.println("Digite um número inteiro diferente de zero");
		while(a == 0) {
			a = scan.nextInt();
			if (a == 0)
				System.out.println("Digite um número inteiro diferente de zero");
		}
		System.out.println("Digite um número inteiro maior que zero");
		while (b <= 0) {
			b = scan.nextInt();
			if (b <= 0)
				System.out.println("Digite um número inteiro maior que zero");
		}
		DecimalFormat formatter = new DecimalFormat("#0");
		System.out.println("a^b = " + formatter.format(pow(a,b)));
		}
	
	private static double pow(int a, int b) {
		if (b == 1)
			return a;
		if (b == 0)
			return 1;
		return a + pow(a, b-1);
	}


}
