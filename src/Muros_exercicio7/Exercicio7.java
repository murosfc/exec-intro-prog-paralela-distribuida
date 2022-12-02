/*7) Considere um vetor com 50 números inteiros gerados aleatoriamente de 1 até 100. Faça um algoritmo
recursivo para imprimir o maior valor deste vetor.
Crie e utilize uma função para preencher o vetor e uma função recursiva para encontrar o maior valor do
vetor. Esta informação tem que ser impressa na função main.
Obs. 1: Não é permitido utilizar qualquer estrutura de dados auxiliar;
Obs. 2: Não é permitido utilizar qualquer estrutura de repetição na função recursiva. */
package Muros_exercicio7;

import java.util.Random;

public class Exercicio7 {	
	    
	    public static void main(String[] args) {
	        int vetor[] = new int[50];
	        vetor = fillVector(vetor.length);	        
	        System.out.println("Maior valor do vetor = " + findLargest(vetor, 0));   
	    }
	    
	    public static int[] fillVector(int size){	    	
	    	int vetor[] = new int[size];
	        Random gerador = new Random();
	        for (int i=0; i<size; i++){
	            vetor[i]= gerador.nextInt(100) +1;
	        }
	        return vetor;
	    }
	    
	    public static int findLargest(int[] vetor, int index) {
	    	int maior = 0;
	    	if (index == (vetor.length))
	    		return 0;
	    	maior = findLargest(vetor, index+1);
	    	if (maior > vetor[index])
	    		return maior;
	    	else return vetor[index];    	
	    }
}


