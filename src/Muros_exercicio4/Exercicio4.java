/* 4) Considere um vetor com 30 números inteiros gerados aleatoriamente de 1 até 30. Faça um algoritmo para
gerar este vetor e depois ordená-lo de maneira não-crescente.
Crie e utilize três funções: uma para preencher o vetor, outra para ordená-lo e uma terceira para imprimir
o vetor antes e depois da ordenação.
Obs.: Não é permitido utilizar qualquer estrutura de dados para auxiliar a ordenação.
*/
package Muros_exercicio4;

import java.util.Random;

public class Exercicio4 {
	
	public static void main(String[] args) {
		int vetor[] = fillVector(30);
		System.out.println("Vetor gerado:");
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
		//TODO
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
