//João Manuel Oliveira e Matheus Pietro do Carmo Silva, INI3

package calculadoraMatriz;

import java.util.Scanner;

public class App {

	public static void saudacao() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║         BEM-VINDO AO PROGRAMA DE           ║");
		System.out.println("║             OPERAÇÕES COM MATRIZES         ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║  Aqui você poderá visualizar, somar,       ║");
		System.out.println("║  subtrair, transpor e multiplicar          ║");
		System.out.println("║  matrizes de forma prática e rápida!       ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║     Selecione a opção desejada no menu     ║");
		System.out.println("║            e veja a mágica acontecer!      ║");
		System.out.println("╚════════════════════════════════════════════╝");
		System.out.println("          Desenvolvido com ☕ e coragem!      ");
		System.out.println("");

	}

	public static void menu() {
		System.out.println("\n╔══════════════════════════════════════════════╗");
		System.out.println("║         MENU DE OPERAÇÕES COM MATRIZES       ║");
		System.out.println("╠══════════════════════════════════════════════╣");
		System.out.println("║ 1 - Visualizar Matrizes                      ║");
		System.out.println("║ 2 - Soma de Matrizes                         ║");
		System.out.println("║ 3 - Subtração de Matrizes                    ║");
		System.out.println("║ 4 - Transposição de Matriz                   ║");
		System.out.println("║ 5 - Multiplicação por N                      ║");
		System.out.println("║ 6 - Multiplicação por outra Matriz           ║");
		System.out.println("║ 7 - Sair                                     ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.print("Escolha uma opção: ");
	}

	public static void encerrar() {
		System.out.println("\n╔════════════════════════════════════════════╗");
		System.out.println("║        PROGRAMA FINALIZADO COM SUCESSO     ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║             Desenvolvido por:              ║");
		System.out.println("║                 João Manuel                ║");
		System.out.println("║                      &                     ║ ");
		System.out.println("║               Matheus Pietro               ║");
		System.out.println("║              Linguagem: Java               ║");
		System.out.println("║       Curso: INI3 - Professor Gilberto     ║");
		System.out.println("║            Projeto de Matrizes             ║");
		System.out.println("╚════════════════════════════════════════════╝");
		System.out.println("        Obrigado por utilizar o programa!     ");
		System.out.println("              Até a próxima :)                ");
		System.out.println();

	}

	public static void printarMatriz(double[][] matrizLocal) {
		for (int i = 0; i < matrizLocal.length; i++) {
			for (int j = 0; j < matrizLocal[i].length; j++) {
				System.out.printf("[%5.2f] ", matrizLocal[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
	}

	public static double[][] somarMatrizes(double[][] matrizLocal1, double[][] matrizLocal2) {
		int linhas = matrizLocal1.length;
		int colunas = matrizLocal1[0].length;
		double[][] matrizSomada = new double[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matrizSomada[i][j] = matrizLocal1[i][j] + matrizLocal2[i][j];
			}
		}
		return matrizSomada;
	}

	public static double[][] subtrairMatrizes(double[][] matrizLocal1, double[][] matrizLocal2) {
		int linhas = matrizLocal1.length;
		int colunas = matrizLocal1[0].length;
		double[][] matrizSubtraida = new double[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matrizSubtraida[i][j] = matrizLocal1[i][j] - matrizLocal2[i][j];
			}
		}
		return matrizSubtraida;
	}

	public static double[][] transporMatrizes(double[][] matrizLocal) {
		int linhas = matrizLocal.length;
		int colunas = matrizLocal[0].length;
		double[][] matrizTransposta = new double[colunas][linhas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matrizTransposta[j][i] = matrizLocal[i][j];
			}
		}
		return matrizTransposta;
	}

	public static double[][] escolherMatriz(Scanner in, double[][] m1, double[][] m2, double[][] m3,
			boolean terceiraOpcional) {
		System.out.print("Digite o número da matriz (1 ou 2" + (terceiraOpcional && m3 != null ? " ou 3" : "") + "): ");
		int escolha = in.nextInt();
		if (escolha == 1)
			return m1;
		if (escolha == 2)
			return m2;
		if (terceiraOpcional && m3 != null && escolha == 3)
			return m3;
		System.out.println("Opção inválida, usando matriz 1 por padrão.");
		return m1;
	}

	public static double[][] multiplicacaoPorN(double[][] matrizLocal) {
		Scanner numero = new Scanner(System.in);
		double n;
		System.out.println("Digite N:");
		System.out.println("(Valor que a matriz será multiplicada)");
		n = numero.nextDouble();
		int linhas = matrizLocal.length;
		int colunas = matrizLocal[0].length;
		double[][] matrizMultiplicadaPorN = new double[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matrizMultiplicadaPorN[i][j] = n * matrizLocal[i][j];
			}
		}
		System.out.println("");
		return matrizMultiplicadaPorN;
	}

	public static double[][] multiplicacaoDeMatrizes(double[][] matrizLocal1, double[][] matrizLocal2) {
		int linhas = matrizLocal1.length;
		int colunas = matrizLocal2[0].length;
		double[][] matrizMultiplicada = new double[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				for (int k = 0; k < matrizLocal1[0].length; k++) {
					matrizMultiplicada[i][j] += matrizLocal1[i][k] * matrizLocal2[k][j];

				}
			}
		}
		System.out.println("Multiplicação Feita!");
		System.out.println("");
		return matrizMultiplicada;
	}

	public static void main(String[] args) {
		saudacao();
		Scanner in = new Scanner(System.in);
		int n, n2;
		double[][] matrizOperada = null;
		System.out.print("Digite a dimensão das linhas da matriz 1: ");
		n = in.nextInt();
		System.out.println("");
		System.out.print("Digite a dimensão das colunas da matriz 1: ");
		n2 = in.nextInt();
		System.out.println("");
		double[][] matrizGlobal1 = new double[n][n2];

		System.out.println("Digite os valores da matriz 1:");
		for (int i = 0; i < matrizGlobal1.length; i++) {
			for (int j = 0; j < matrizGlobal1[i].length; j++) {
				matrizGlobal1[i][j] = in.nextDouble();
			}
		}

		System.out.print("Digite a dimensão das linhas da matriz 2: ");
		n = in.nextInt();
		System.out.println("");
		System.out.print("Digite a dimensão das colunas da matriz 2: ");
		n2 = in.nextInt();
		System.out.println("");
		double[][] matrizGlobal2 = new double[n][n2];

		System.out.println("Digite os valores da matriz 2:");
		for (int i = 0; i < matrizGlobal2.length; i++) {
			for (int j = 0; j < matrizGlobal2[i].length; j++) {
				matrizGlobal2[i][j] = in.nextDouble();
			}
		}
		int opcao = 0;

		while (opcao != 7) {
			menu();
			System.out.println("");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Matriz 1:");
				printarMatriz(matrizGlobal1);
				System.out.println("Matriz 2:");
				printarMatriz(matrizGlobal2);
				if (matrizOperada != null) {
					System.out.println("Matriz Operada:");
					printarMatriz(matrizOperada);
				}
				break;

			case 2:
				double[][] somaA = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				double[][] somaB = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				if (somaA.length == somaB.length && somaA[0].length == somaB[0].length) {
					matrizOperada = somarMatrizes(somaA, somaB);
					System.out.println("Resultado da soma:");
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As matrizes não possuem as mesmas dimensões.");
				}
				break;

			case 3:
				double[][] subtracaoA = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				double[][] subtracaobB = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				if (matrizGlobal1.length == matrizGlobal2.length
						&& matrizGlobal1[0].length == matrizGlobal2[0].length) {
					matrizOperada = subtrairMatrizes(subtracaoA, subtracaobB);
					System.out.println("Resultado da subtração:");
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As matrizes não possuem as mesmas dimensões.");
					System.out.println("(Só é possível subtrair matrizes que possuem as mesmas dimensões)");
					System.out.println("");
				}
				break;

			case 4:
				double[][] transposta = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				matrizOperada = transporMatrizes(transposta);
				System.out.println("Resultado da transposição:");
				printarMatriz(matrizOperada);
				break;

			case 5:
				double[][] multN = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				matrizOperada = multiplicacaoPorN(multN);
				System.out.println("Resultado da multiplicação por N:");
				printarMatriz(matrizOperada);
				break;

			case 6:
				double[][] multA = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				double[][] multB = escolherMatriz(in, matrizGlobal1, matrizGlobal2, matrizOperada, true);
				if (multA[0].length == multB.length) {
					matrizOperada = multiplicacaoDeMatrizes(multA, multB);
					System.out.println("Resultado da multiplicação:");
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As dimensões não são compatíveis para multiplicação.");
				}
				break;

			case 7:
				System.out.println("Encerrando Programa...");
				encerrar();
				break;

			default:
				System.out.println("Dígito inválido.");
				System.out.println("");
			}
		}
	}
}
