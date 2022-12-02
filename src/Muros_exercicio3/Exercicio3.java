/* 3) Considere um vetor que armazena 10 números inteiros pares e 10 números inteiros ímpares todos embaralhados,
ou seja, sem qualquer ordem preestabelecida. Faça um algoritmo para ler este vetor do teclado e depois
organizá-lo de modo que os números pares fiquem nas posições ímpares do vetor e os números ímpares fiquem
nas posições pares do vetor.
Crie e utilize duas funções: uma para preencher o vetor pelo teclado e o outra para organizá-lo.
Obs.: Não é permitido utilizar qualquer estrutura de dados para auxiliar a organização. */

package Muros_exercicio3;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		int vetor[] = lerVetor(20);
		
		System.out.println("\nVetor lido do teclado: ");
		printVet(vetor);
		
		vetor = sortVector(vetor);
		System.out.println("\nVetor ordenado: ");
		printVet(vetor);
		
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
		//para visualização do usuário, os indices do vetor serão considerados
		//como iniciando em 1, e não 0 como é utilizado pelo Java
		//embora 0 seja um numero neutro, ele será considerado como par
		for (int i=0;i<vetor.length;i++) {
			if (i%2==0 && vetor[i]%2==0) {
				for (int j=i+1; j<vetor.length; j++) 
					if (vetor[j]%2!=0) {
						temp=vetor[i];
						vetor[i]=vetor[j];
						vetor[j]=temp;
						j=vetor.length;
					}			
			}
			if (i%2!=0 && vetor[i]%2!=0) {
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
	
	public static void printVet(int[] vetor) {
		for (int i=0; i<vetor.length; i++) {
			if (i == vetor.length+1)
				System.out.print("[" + (i+1) +"- "+vetor[i]+"]");
			else System.out.print("["+ (i+1) +"- "+vetor[i]+"], ");
		}
	}

}
