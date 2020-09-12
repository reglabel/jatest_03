/* Código de Estoque de Produtos, com ações de cadastrar, atualizar, remover e exibir produtos e suas especificações. É composto pelas classes Main e Produto.

	Desenvolvido por: Regla Bel Cruz Lula
	Última alteralção em: 12.09.2020
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		boolean teste = true;
		int acao;

		System.out.println("\r\nSeja bem-vindo(a) Sistema de Estoque.");
		
		do {
			System.out.println("\r\n\r\n\t\t\tMENU\r\n1 - Adicionar Produto(s)\r\n2 - Remover Produto(s)\r\n3 - Atualizar Estoque\r\n4 - Listar/Exibir Estoque\r\n5 - Sair do Programa");
			Scanner ler1 = new Scanner(System.in);
			System.out.print("\r\nO que deseja fazer? Escolha sua opção: ");
			acao = Integer.parseInt(ler1.nextLine());
			switch(acao){
				case 1:
					while(true){
						Produto produtoDaVez = new Produto();
						produtoDaVez.cadastrarProdutos();
						produtos.add(produtoDaVez);
						if(!continuar()){
							break;
						}
					}
					break;

				case 2:
					while(true){
						if(produtos == null || produtos.isEmpty()){
							System.out.println("\r\nEstoque vazio, não há nada para remover...");
							break;
						}
						Produto produtoDaVez = new Produto();
						produtoDaVez.remover(produtos);
						if(!continuar()){
							break;
						}
					}
					break;

				case 3:
					while(true){
						if(produtos == null || produtos.isEmpty()){
							System.out.println("\r\nEstoque vazio, não há nada para atualizar...");
							break;
						}
						Produto produtoDaVez = new Produto();
						produtoDaVez.atualizar(produtos);
						if(!continuar()){
							break;
						}
					}
					break;

				case 4:
					if(produtos == null || produtos.isEmpty()){
						System.out.println("\r\nEstoque vazio, não há nada para listar...");
					} else{
						Produto.listar(produtos);
					}
					break;			

				case 5:
					teste = false;
					System.out.println("\t\t\tAté a próxima!");
					break;
				
				default:
					System.out.println("Por favor, digite somente valores entre 1 e 5.");
					break;
			}
		} while(teste);
	}

	public static boolean continuar(){
		Scanner ler = new Scanner(System.in);
		boolean vamos = false, naoValido = true;
		int resposta;
		while(naoValido){
			System.out.print("\r\nDeseja continuar? Digite 0 para NÂO e 1 para SIM: ");
			resposta = Integer.parseInt(ler.nextLine());
			switch(resposta){
				case 0:
					naoValido = false;
					vamos = false;
					break;

				case 1:
					naoValido = false;
					vamos = true;
					break;

				default:
					System.out.println("\r\nPor favor, digite valores válidos.");
					break;
			}
		}
		return vamos;
	}
}