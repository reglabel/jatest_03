/* Código de Estoque de Produtos, com ações de cadastrar, atualizar, remover e exibir produtos e suas especificações. É composto pelas classes Main e Produto.

	Desenvolvido por: Regla Bel Cruz Lula
	Última alteralção em: 12.09.2020
*/

import java.util.Scanner;
import java.util.ArrayList;

class Produto{
	private String nome, marca;
	private int lote;
	private double precoCusto, precoVenda;
	Scanner leitura = new Scanner(System.in);

	public Produto(){

	}

	public Produto(String nome, String marca, int lote, double precoCusto, double precoVenda){
		this.nome = nome;
		this.marca = marca;
		this.lote = lote;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}

	private void setNome(String nome){
		this.nome = nome;	
	}

	private void setMarca(String marca){
		this.marca = marca;	
	}

	private void setLote(int lote){
		this.lote = lote;	
	}

	private void setPrecoCusto(double precoCusto){
		this.precoCusto = precoCusto;	
	}

	private void setPrecoVenda(double precoVenda){
		this.precoVenda = precoVenda;	
	}

	private String getNome(){
		return nome;
	}

	private String getMarca(){
		return marca;
	}

	private int getLote(){
		return lote;
	}

	private double getPrecoCusto(){
		return precoCusto;
	}

	private double getPrecoVenda(){
		return precoVenda;
	}

	public void cadastrarProdutos(){
		System.out.print("NOME do Produto: ");
		this.nome = leitura.nextLine();

		System.out.print("MARCA do Produto: ");
		this.marca = leitura.nextLine();

		System.out.print("LOTE do Produto: ");
		this.lote = Integer.parseInt(leitura.nextLine());

		System.out.print("PREÇO DE CUSTO do Produto: R$");
		this.precoCusto = Double.parseDouble(leitura.nextLine());

		System.out.print("PREÇO DE VENDA do Produto: R$");
		this.precoVenda = Double.parseDouble(leitura.nextLine());
	}

	public void remover(ArrayList<Produto> lista){
		int indice, intervalo = lista.size();
		for(Produto i: lista){
			System.out.println("\r\nÍNDICE: "+lista.indexOf(i)+"   ---   NOME: "+i.getNome());
		}

		System.out.print("\r\nDigite o índice do item que deseja remover: ");
		indice = Integer.parseInt(leitura.nextLine());
		while(indice < 0 || indice >= intervalo){
			System.out.print("Valor de índice inválido. Tente novamente: ");
			indice = Integer.parseInt(leitura.nextLine());
		}

		lista.remove(lista.get(indice));
	}
	
	public void atualizar(ArrayList<Produto> lista){
		int indice, intervalo = lista.size(), novoLote;
		String novoNome, novaMarca;
		double novoPrecoCusto, novoPrecoVenda;
		for(Produto i: lista){
			System.out.println("\r\nÍNDICE: "+lista.indexOf(i)+"   ---   NOME: "+i.getNome());
		}

		System.out.print("\r\nDigite o índice do item que deseja atualizar: ");
		indice = Integer.parseInt(leitura.nextLine());
		while(indice < 0 || indice >= intervalo){
			System.out.print("Valor de índice inválido. Tente novamente: ");
			indice = Integer.parseInt(leitura.nextLine());
		}

		System.out.print("Digite o novo NOME do item: ");
		novoNome = leitura.nextLine();
		System.out.print("Digite a nova MARCA do item: ");
		novaMarca = leitura.nextLine();
		System.out.print("Digite o novo LOTE do item: ");
		novoLote = Integer.parseInt(leitura.nextLine());
		System.out.print("Digite o novo PREÇO DE CUSTO do item: R$");
		novoPrecoCusto = Double.parseDouble(leitura.nextLine());
		System.out.print("Digite o novo PREÇO DE VENDA do item: R$");
		novoPrecoVenda = Double.parseDouble(leitura.nextLine());

		lista.get(indice).setNome(novoNome);
		lista.get(indice).setMarca(novaMarca);
		lista.get(indice).setLote(novoLote);
		lista.get(indice).setPrecoCusto(novoPrecoCusto);
		lista.get(indice).setPrecoVenda(novoPrecoVenda);
	}

	public static void listar(ArrayList<Produto> lista){
		for(Produto i: lista){
			System.out.println("\r\nNOME: "+i.getNome()+"\r\nMARCA: "+i.getMarca()+"\r\nLOTE: "+i.getLote()+"\r\nPREÇO DE CUSTO: R$"+i.getPrecoCusto()+"\r\nPREÇO DE VENDA: R$"+i.getPrecoVenda());
		}
	}

}