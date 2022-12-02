/*2) Considere uma matriz M de ordem 4 de números inteiros gerados aleatoriamente de 0 até 29. Faça um
algoritmo para gerar esta matriz e imprimir na tela se ela é ou não uma Matriz Ortogonal.
Crie e utilize quatro funções: uma para gerar a matriz M, outra para calcular a sua Matriz Transposta
(MT ), outra calcular a multiplicação M MT e a quarta para retornar se a matriz M é Ortogonal ou não. A
impressão desta informação tem que ser na função main.
Obs.: Se uma matriz quadrada M é uma matriz ortogonal, então M  MT = I, onde MT é a Matriz
Transposta de M e I a Matriz Identidade. */
package Muros_exercicio2;

import java.util.Random;

public class Exercicio2 {

	public static void main(String[] args) {
		int matriz[][] = new int[4][4];
		matriz = fillMat(matriz.length, matriz[0].length);
		
		System.out.print("Matriz gerada: ");
		printMat(matriz);
		
		int matrizTransposta[][] = transpose(matriz);
		System.out.print("Matriz transposta: ");
		printMat(matrizTransposta);		
		
		if (checkIfOrthogonal(matriz, matrizTransposta)) 
			System.out.println("\nA matriz eh ortogonal");
		else System.out.println("\nA matriz nao eh ortogonal");
	}
	
	public static int[][] fillMat(int linhas, int colunas){
		int matriz[][] = new int[linhas][colunas];
		Random gerador = new Random();
		for (int i=0; i<linhas ;i++)
			for (int j=0; j<colunas; j++) {
				matriz[i][j] = gerador.nextInt(30);
			}				
		return matriz;
	}
	
	public static int[][] transpose(int[][] matriz){
		int transposta[][] = new int[matriz[0].length][matriz.length];
		for (int i=0;i<matriz.length;i++)
			for (int j=0;j<matriz[0].length;j++) {
				transposta[j][i] = matriz [i][j];
			}
		return transposta;
	}
	
    public static boolean checkIfOrthogonal(int[][] A, int[][] B){        
        int n = A[0].length; //A.columns = B.rows        
        if(n != B.length) //condição básica para multiplicação de matrizes. Verfica se A.columns = B.rows
            throw new IllegalArgumentException("A.columns != B.rows");        
        int rows = A.length, cols = B[0].length;      
        int[][] C = new int[rows][cols];
        boolean ortogonal = true;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
                if (i==j && C[i][j] != 1 || i!=j && C[i][j] != 0)
					ortogonal = false;	
            }
        }
        System.out.print("Matriz resultante da multiplicacao: ");
		printMat(C);
		return ortogonal;        
    }
	
	public static void printMat(int[][] matriz) {
		for (int i=0;i<matriz.length;i++) {
			System.out.println("");
			for (int j=0; j<matriz[0].length;j++) {
				System.out.print(matriz[i][j]);
				if (j!=matriz[0].length-1)
					System.out.print(",\t");
			}
		}
		System.out.println("\n");
	}

}
