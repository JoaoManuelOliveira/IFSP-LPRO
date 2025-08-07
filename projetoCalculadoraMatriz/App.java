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
				if (matrizGlobal1.length == matrizGlobal2.length
						&& matrizGlobal1[0].length == matrizGlobal2[0].length) {
					matrizOperada = somarMatrizes(matrizGlobal1, matrizGlobal2);
					System.out.println("Resultado da soma:");
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As matrizes não possuem as mesmas dimensões.");
					System.out.println("(Só é possível somar matrizes que possuem as mesmas dimensões)");
					System.out.println("");
				}

				break;

			case 3:
				if (matrizGlobal1.length == matrizGlobal2.length
						&& matrizGlobal1[0].length == matrizGlobal2[0].length) {
					matrizOperada = subtrairMatrizes(matrizGlobal1, matrizGlobal2);
					System.out.println("Resultado da subtração:");
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As matrizes não possuem as mesmas dimensões.");
					System.out.println("(Só é possível subtrair matrizes que possuem as mesmas dimensões)");
					System.out.println("");
				}
				break;

			case 4:
				if (matrizOperada == null) {
					System.out.print("Digite qual matriz deseja transpor (1 ou 2): ");
					int opcaoMatrizTransposta = in.nextInt();
					if (opcaoMatrizTransposta == 1) {
						matrizGlobal1 = transporMatrizes(matrizGlobal1);
					} else if (opcaoMatrizTransposta == 2) {
						matrizGlobal2 = transporMatrizes(matrizGlobal2);

					} else {
						System.out.println("Digito Inválido");
						System.out.println("");
					}
				} else {
					System.out.println("Digite qual matriz deseja transpor (1, 2 ou 3): ");
					System.out.println("A 3° Matriz é a que você fez as operações");
					int opcaoMatrizTransposta = in.nextInt();

					if (opcaoMatrizTransposta == 1) {
						matrizGlobal1 = transporMatrizes(matrizGlobal1);
					} else if (opcaoMatrizTransposta == 2) {
						matrizGlobal2 = transporMatrizes(matrizGlobal2);

					} else if (opcaoMatrizTransposta == 3) {
						matrizOperada = transporMatrizes(matrizOperada);

					} else {
						System.out.println("Digito Inválido");
						System.out.println("");
					}
				}
				break;

			case 5:
				if (matrizOperada == null) {
					System.out.print("Digite qual matriz deseja multiplicar (1 ou 2): ");
					int opcaoMatrizMultiplicadaPorN = in.nextInt();
					if (opcaoMatrizMultiplicadaPorN == 1) {
						matrizGlobal1 = multiplicacaoPorN(matrizGlobal1);
					} else if (opcaoMatrizMultiplicadaPorN == 2) {
						matrizGlobal2 = multiplicacaoPorN(matrizGlobal2);

					} else {
						System.out.println("Digito Inválido");
						System.out.println("");
					}
				} else {
					System.out.println("Digite qual matriz deseja multiplicar (1, 2 ou 3): ");
					System.out.println("A 3° Matriz é a que você fez as operações");
					int opcaoMatrizMultiplicadaPorN = in.nextInt();

					if (opcaoMatrizMultiplicadaPorN == 1) {
						matrizGlobal1 = multiplicacaoPorN(matrizGlobal1);
					} else if (opcaoMatrizMultiplicadaPorN == 2) {
						matrizGlobal2 = multiplicacaoPorN(matrizGlobal2);

					} else if (opcaoMatrizMultiplicadaPorN == 3) {
						matrizOperada = multiplicacaoPorN(matrizOperada);

					} else {
						System.out.println("Digito Inválido");
						System.out.println("");
					}
				}

				break;

			case 6:
				if (matrizGlobal1[0].length == matrizGlobal2.length) {
					matrizOperada = multiplicacaoDeMatrizes(matrizGlobal1, matrizGlobal2);
					printarMatriz(matrizOperada);
				} else {
					System.out.println("ERRO! As matrizes não possuem as dimensões necessárias para a multiplicação.");
					System.out.println(
							"(Para multiplicar as matrizes, é necessário que o número de colunas da matriz 1 seja igual ao número de linhas da matriz 2)");
					System.out.println("");
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
