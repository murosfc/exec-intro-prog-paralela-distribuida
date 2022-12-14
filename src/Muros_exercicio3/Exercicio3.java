/* 3) Considere um vetor que armazena 10 n�meros inteiros pares e 10 n�meros inteiros �mpares todos embaralhados,
ou seja, sem qualquer ordem preestabelecida. Fa�a um algoritmo para ler este vetor do teclado e depois
organiz�-lo de modo que os n�meros pares fiquem nas posi��es �mpares do vetor e os n�meros �mpares fiquem
nas posi��es pares do vetor.
Crie e utilize duas fun��es: uma para preencher o vetor pelo teclado e o outra para organiz�-lo.
Obs.: N�o � permitido utilizar qualquer estrutura de dados para auxiliar a organiza��o. */

package Muros_exercicio3;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		int vetor[] = lerVetor(20);
		
		/*System.out.println("\nVetor lido do teclado: ");
		printVet(vetor);*/
		vetor = sortVector(vetor);
		/*System.out.println("\nVetor ordenado: ");
		printVet(vetor);*/
		
	}
	
	public static int[] lerVetor(int size) {
		int vetor[] = new int[size];		
		Scanner elemento = new Scanner(System.in);
		System.out.println("Digite "+size+" elementos para compor o vetor.\nSendo metade par e metade impar");
		for (int i=1; i<size; i++) {
			System.out.print(i+"- ");
			vetor[i] = elemento.nextInt();			
		}	
		elemento.close();
		return vetor;
	}
	
	public static int[] sortVector(int[] vetor) {
		int temp;
		//para visualiza��o do usu�rio, os indices do vetor ser�o considerados
		//como iniciando em 1, e n�o 0 como � utilizado pelo Java
		//embora 0 seja um numero neutro, ele ser� considerado como par
		for (int i=0;i<vetor.length;i++) {
			// se o numero atual for par e ele tiver em uma posicao par, altera ele.
			if (i%2==0 && vetor[i]%2==0) {
				//tentar encontrar um numero impar para alterar
				for (int j=i+1; j<vetor.length; j++) 
					if (vetor[j]%2!=0) {
						temp=vetor[i];
						vetor[i]=vetor[j];
						vetor[j]=temp;
						j=vetor.length;
					}			
			}
			// se o numero atual for impar e ele tiver em uma posicao impar, altera ele.
			if (i%2!=0 && vetor[i]%2!=0) {
				//tentar encontrar um numero par para alterar
				for (int j=i+1; j<vetor.length; j++) 
					if (vetor[j]%2==0) {
						temp=vetor[i];
						vetor[i]=vetor[j];
						vetor[j]=temp;
						j=vetor.length;
					}
			}
		}
		return vetor;
	}
	
}
