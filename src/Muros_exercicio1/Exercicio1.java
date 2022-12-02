
/* Considere a matriz A = [aij ]n×m, onde n = 4 e m = 5, com número inteiros gerados aleatoriamente de 1
até 20. Faça um algoritmo para gerar a matriz A e verificar se ela satisfaz a seguinte condição:
Crie e utilize uma função para gerar a matriz e outra para realizar a verificação. De acordo com o retorno
da função de verificação, deve-se imprimir na função main: “Condicao Satisfeita” ou “Condicao Nao Satisfeita”.
package exercicio1; */

package Muros_exercicio1;

import java.util.Random;

public class Exercicio1 {

	public static void main(String[] args) {
		int matriz[][] = new int[4][5];
		matriz = fillMat(matriz.length, matriz[0].length);
		if (matCheck(matriz))
			System.out.println("Condição satisfeita");
		else System.out.println("Condição não satisfeita");			
	}
	
	public static int[][] fillMat(int linhas, int colunas){
		int matriz[][] = new int[linhas][colunas];
		Random gerador = new Random();
		for (int i=0; i<linhas ;i++)
			for (int j=0; j<colunas; j++) {
				matriz[i][j] = gerador.nextInt(20) + 1;
			}				
		return matriz;
	}
	
	public static boolean matCheck(int[][] matriz) {
		int menorSoma=0, maiorProduto=0, aux=0, m = matriz.length, n = matriz[0].length;		
		//menor somatório linhas		
		for (int i=0; i<m ; i++) {
			aux=0;
			for (int j=0;j<n;j++)
				aux+=matriz[i][j];
			if (i==0 || menorSoma>aux)
				menorSoma=aux;    
		}
		//maior produtório das colunas
		for (int j=0;j<n;j++){
			aux=1;
			for (int i=0;i<m;i++)
				aux *= matriz[i][j];
			if (j == 0)
				maiorProduto = aux;
			else if (maiorProduto<aux)
				maiorProduto = aux;			
		}
		System.out.println("Menor somatório das linhas= "+menorSoma);
		System.out.println("Maior produtório das colunas= "+maiorProduto);
		if(menorSoma == maiorProduto)
			return true;
		else return false;
		
	}	

}
