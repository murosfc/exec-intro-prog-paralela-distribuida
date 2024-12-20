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
		int vetor[] = lerVetor(20);
		//int vetor[] = Exercicio4.fillVector(4); //para facilitar o preenchimento para testes		
		System.out.println("Vetor gerado");
		printVet(vetor);
		vetor = quickSort(vetor, 0, vetor.length-1);
		System.out.println("\n\nVetor ordenado");
		printVet(vetor);
	}
	
	public static int[] lerVetor(int size) {
		int vetor[] = new int[size];		
		Scanner elemento = new Scanner(System.in);
		System.out.println("Digite "+size+" numeros maiores que 1 para compor o vetor.");
		for (int i=0; i<size; i++) {
			int num = 0;
			while (num <= 1){
				System.out.print(i+"- ");
				vetor[i] = elemento.nextInt();
				num = vetor[i];
			}					
		}	
		elemento.close();
		return vetor;
	}
	
	public static int [] quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	    return arr;
	}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (isComposto(arr[j]) == 1  && isComposto(pivot) == 0) { //adaptação do quicksort para trocar composto por não composto
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	private static int isComposto(int num) {
		int contDivisores= 0;
		for (int i=1; i<=num; i++) {
			if (num%i == 0)
				contDivisores++;
		}
		if (contDivisores > 2)
			return 1;
		return 0;
	}	
	
	public static void printVet(int[] vetor) {
		for (int i=0; i<vetor.length; i++) {
			if (i == vetor.length -1)
				System.out.print(vetor[i]);
			else System.out.print(vetor[i]+", ");
		}
	}
		
}
