/* 
Considere dois n�meros inteiros a (a 6= 0) e b (b  0) lidos pelo teclado. Fa�a um algoritmo recursivo para
calcular o valor de ab.
Crie e utilize uma fun��o recursiva para calcular ab. Esta informa��o tem que ser impressa na fun��o main.
Obs.: N�o � permitido utilizar qualquer estrutura de repeti��o na fun��o recursiva.*/
package Muros_exercicio5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = 0, b = 0;
		System.out.println("Digite um n�mero inteiro diferente de zero");
		while(a == 0) {
			a = scan.nextInt();
			if (a == 0)
				System.out.println("Digite um n�mero inteiro diferente de zero");
		}
		System.out.println("Digite um n�mero inteiro maior que zero");
		while (b <= 0) {
			b = scan.nextInt();
			if (b <= 0)
				System.out.println("Digite um n�mero inteiro maior que zero");
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
