/*2) Considere uma matriz M de ordem 4 de n�meros inteiros gerados aleatoriamente de 0 at� 29. Fa�a um
algoritmo para gerar esta matriz e imprimir na tela se ela � ou n�o uma Matriz Ortogonal.
Crie e utilize quatro fun��es: uma para gerar a matriz M, outra para calcular a sua Matriz Transposta
(MT ), outra calcular a multiplica��o M MT e a quarta para retornar se a matriz M � Ortogonal ou n�o. A
impress�o desta informa��o tem que ser na fun��o main.
Obs.: Se uma matriz quadrada M � uma matriz ortogonal, ent�o M  MT = I, onde MT � a Matriz
Transposta de M e I a Matriz Identidade. */
package Muros_exercicio2;

import java.util.Random;

public class Exercicio2 {

		public static void main(String[] args) {
		int m[][] = new int[4][4];
		//gerar a matriz M
		m = fillMat(m.length, m[0].length);	
		//calcular a sua Matriz Transposta
		int matrizTransposta[][] = transpose(m);
		//multiplicar as duas matrizes
		int matrizResultado[][] = multiplicaMatriz(m, matrizTransposta);
		//verificar se ela eh ortogonal
		if (checkIfOrthogonal(matrizResultado)) 
			System.out.println("\nA matriz eh ortogonal");
		else System.out.println("\nA matriz nao eh ortogonal");
	}
	
	public static int[][] fillMat(int linhas, int colunas){
		int matriz[][] = new int[linhas][colunas];
		Random gerador = new Random();
		for (int i=0; i<linhas ;i++)
			for (int j=0; j<colunas; j++) {
				//gerar 30 numeros aleatorios
				matriz[i][j] = gerador.nextInt(30);
			}				
		return matriz;
	}
	
	public static int[][] transpose(int[][] matriz){
		int transposta[][] = new int[matriz[0].length][matriz.length];
		for (int i=0;i<matriz.length;i++)
			for (int j=0;j<matriz[0].length;j++) {
				//gerar uma matriz transposta(linha vira coluna e coluna vira linha)
				transposta[j][i] = matriz [i][j];
			}
		return transposta;
	}

	public static int[][] multiplicaMatriz(int[][] A, int[][] B) {
		int n = A[0].length; //A.columns = B.rows        
        if(n != B.length) //condi��o b�sica para multiplica��o de matrizes. Verfica se A.columns = B.rows
            throw new IllegalArgumentException("A.columns != B.rows");        
        int rows = A.length, cols = B[0].length;      
        int[][] C = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
				C[i][j] = 0;
                for(int k = 0; k < n; k++){
					//multiplicar cada linha da matriz A linha por todas as colunas da matriz B
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
		return C; 	    
	}
	
    public static boolean checkIfOrthogonal(int[][] C){        
        int rows = C.length, cols = C[0].length;      
        boolean ortogonal = true;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
				//verificar se a diagonal eh 1 e se o resto eh zero(matriz identidade)
                if ((i==j && C[i][j] != 1) || (i!=j && C[i][j] != 0))
					ortogonal = false;	
            }
        }
		return ortogonal;        
    }
}
