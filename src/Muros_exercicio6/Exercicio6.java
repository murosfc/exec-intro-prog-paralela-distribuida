/*
Considere um vetor com 20 n�meros naturais maiores do que 1 lidos pelo teclado. Fa�a um algoritmo
recursivo que organize este vetor de modo que os n�meros compostos fiquem nas primeiras posi��es e os
n�meros que n�o s�o compostos nas �ltimas posi��es.
Crie e utilize duas fun��es: uma para preencher o vetor e outra recursivo para realizar a organiza��o do
mesmo. Crie e utilize tamb�m outra fun��o para retornar 1, se um n�mero natural for composto, ou retornar
0, caso contr�rio.
Obs. 1: Um n�mero natural C � composto se ele tem mais de dois divisores naturais distintos;
Obs. 2: N�o � permitido utilizar qualquer estrutura de dados para auxiliar a organiza��o;
Obs. 3: N�o � permitido utilizar qualquer estrutura de repeti��o na fun��o recursiva. 
 */
package Muros_exercicio6;

import java.util.Scanner;

import Muros_exercicio4.Exercicio4;

public class Exercicio6 {

	public static void main(String[] args) {
		//int vetor[] = lerVetor(20);
		int vetor[] = Exercicio4.fillVector(20);
		System.out.println("Vetor gerado");
		printVet(vetor);
		ordenar(vetor, 0);
		System.out.println("\n\nVetor ordenado");	
	}
	
	public static int[] lerVetor(int size) {
		int vetor[] = new int[size];		
		Scanner elemento = new Scanner(System.in);
		System.out.println("Digite "+size+" numeros maiores que zero para compor o vetor.");
		for (int i=0; i<size; i++) {
			int num = 0;
			while (num <= 0){
				System.out.print(i+"- ");
				vetor[i] = elemento.nextInt();
				num = vetor[i];
			}					
		}	
		elemento.close();
		return vetor;
	}
	
	private static boolean isComposto(int num) {
		int contDivisores= 0;
		for (int i=1; i<=num; i++) {
			if (num%i == 0)
				contDivisores++;
		}
		if (contDivisores > 2)
			return true;
		return false;
	}
	
	//esta fun��o est� incorreta.
	private static int ordenar(int[] vetor, int indice) {
		int valorAtual = vetor[indice];
		if (indice >= vetor.length) {
			return - 1; //controle para n�o estourar o limite do vetor
		}
		if (indice == 0 && isComposto(vetor[indice])) 
			ordenar(vetor, indice+1);
			else if(isComposto(vetor[indice]))
				return indice;
			else {
				int nextComposto = ordenar(vetor, indice+1);  
				if(nextComposto > 0) {
					int aux = 0;
					aux = vetor[indice];
					vetor[indice] = vetor[nextComposto];
					vetor[nextComposto] = aux;
				}			
			}
		if (indice != 0)
			return ordenar(vetor, indice+1);
		else return 0;
	}
	
	public static void printVet(int[] vetor) {
		for (int i=0; i<vetor.length; i++) {
			if (i == vetor.length -1)
				System.out.print(vetor[i]);
			else System.out.print(vetor[i]+", ");
		}
	}
		
}
