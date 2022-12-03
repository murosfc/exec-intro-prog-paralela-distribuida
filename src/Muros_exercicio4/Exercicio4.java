/* 4) Considere um vetor com 30 n�meros inteiros gerados aleatoriamente de 1 at� 30. Fa�a um algoritmo para
gerar este vetor e depois orden�-lo de maneira n�o-crescente.
Crie e utilize tr�s fun��es: uma para preencher o vetor, outra para orden�-lo e uma terceira para imprimir
o vetor antes e depois da ordena��o.
Obs.: N�o � permitido utilizar qualquer estrutura de dados para auxiliar a ordena��o.
*/
package Muros_exercicio4;

import java.util.Random;

public class Exercicio4 {
	
	public static void main(String[] args) {
		int vetor[] = fillVector(30);
		System.out.println("Vetor gerado:");
		printVet(vetor);
		vetor = simpleSort(vetor);
		System.out.println("\n\nVetor ordenado:");
		printVet(vetor);		
	}
	
	public static int[] fillVector(int size){
    	int vetor[] = new int[size];
        Random gerador = new Random();
        for (int i=0; i<size; i++){
            vetor[i]= gerador.nextInt(30) +1;
        }
        return vetor;
    }
	
	public static int[] simpleSort(int[] vetor) {
		int aux = 0;
		for (int i=0; i<vetor.length; i++) 
			for (int j=i+1; j<vetor.length; j++) {
				if(vetor[i]<vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		return vetor;
	}
	
	public static void printVet(int[] vetor) {
		for (int i=0; i<vetor.length; i++) {
			if (i == vetor.length+1)
				System.out.print(vetor[i]);
			else System.out.print(vetor[i]+", ");
		}
	}

}
