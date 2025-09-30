package lojaCalcados;

import java.util.InputMismatchException;
import java.util.Scanner;

import lojaCalcados.controller.ProdutosController;
import lojaCalcados.model.Bolsas;
import lojaCalcados.model.Calcados;
import lojaCalcados.model.Produto;
import lojaCalcados.util.Cores;

public class Menu {

	// Objeto para ler dados digitados pelo usuário
	private static final Scanner leia = new Scanner(System.in);

	private static final ProdutosController produtoController = new ProdutosController();

	public static void main(String[] args) {
		
        criarProdutosTeste();
  
		int opcao;

		Calcados c1 = new Calcados(1, "Anabela Prata", 1, 250.00f, "Anabela");
		c1.visualizar();

		Bolsas b1 = new Bolsas(2, "Bolsa Preta", 2, 150.00f, "Bolsa");
		b1.visualizar();

		// Laço de repetição que mantém o menu rodando até a opção sair ser acionada
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                CINDERELA MODERNA                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			// Tenta capturar a opção digitada
			// Caso o usuário digite algo inválido, mostra mensagem de erro
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}

			// Se a opção for 0, o sistema será finalizado (System.exit(0))
			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nCinderela Moderna - Seu salto é um sonho!");
				sobre();
				leia.close();
				System.exit(0);
			}

			// Verifica qual opção do menu o usuário escolheu e executa a ação
			// correspondente
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");
				cadastrarProduto();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");
				listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados do Produto - por ID\n\n");
				procurarProdutoPorId();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produto\n\n");
				atualizarProduto();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar o Produto\n\n");
				deletarProduto();
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}

	}

	// Exibe informações sobre o projeto e a pessoa desenvolvedora
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Thuany Silva ");
		System.out.println("Thuany Silva - thuany.aline@hotmail.com");
		System.out.println("github.com/ThuanyAline");
		System.out.println("*********************************************************");
	}

	// Método responsável por aguardar o usuário pressionar a tecla Enter para
	// continuar
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	// Método responsável por criar algumas produtos de teste automaticamente ao
	// iniciar o programa
	private static void criarProdutosTeste() {
		produtoController.cadastrar(new Calcados(produtoController.gerarId(), "Sapatilha Rosa", 1, 99.00f, "Sapatilha"));
		produtoController.cadastrar(new Bolsas(produtoController.gerarId(), "Mochila", 2, 180.00f, "Mochila Escolar"));
	}

	// Método responsável por listar todas as produtos
	private static void listarProdutos() {
		produtoController.listarTodas();
	}

	// Método responsável por criar uma nova produto com os dados digitados pelo
	// usuário
	private static void cadastrarProduto() {

		System.out.print("Digite o nome do Produto: ");
		leia.skip("\\R");
		String nome = leia.nextLine();

		System.out.print("Digite o Categoria da produto (1 - C | 2 - B): ");
		int categoria = leia.nextInt();

		System.out.print("Digite o Preco inicial: ");
		float preco = leia.nextFloat();

		switch (categoria) {
		case 1 -> {
			System.out.print("Digite o modelo do Calçado: ");
			String calcados = leia.nextLine();
			leia.nextLine();

			// Automatiza o id da produto através do método gerarId()
			produtoController.cadastrar(new Calcados(produtoController.gerarId(), nome, categoria, preco, calcados));
		}
		case 2 -> {
			System.out.print("Digite o modelo da Bolsa: ");
			String bolsas = leia.nextLine();
			leia.nextLine();
			produtoController.cadastrar(new Bolsas(produtoController.gerarId(), nome, categoria, preco, bolsas));
		}
		default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
		}
	}

	// Método responsável por procurar uma produto já cadastrada pelo número
	private static void procurarProdutoPorId() {

		System.out.print("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);
	}

	// Método responsável por excluir uma produto existente pelo id
	private static void deletarProduto() {

		System.out.print("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		// Busca a produto pelo número
		Produto produto = produtoController.buscarNaCollection(id);

		// Verifica se a produto existe
		if (produto != null) {

			// Confirmação da exclusão
			System.out.print("\nTem certeza que deseja excluir este produto? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nO produto número %d não foi encontrado!", id);
		}
	}

	private static void atualizarProduto() {

		System.out.print("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		// Busca a produto pelo número
		Produto produto = produtoController.buscarNaCollection(id);

		// Se a produto existir
		if (produto != null) {

			// Obtém os dados atuais
			String nome = produto.getNome();
			int categoria = produto.getCategoria();
			float preco = produto.getPreco();

			// Atualiza o nome do nome (ou mantém valor atual se apertar Enter)
			System.out.printf("Nome atual: %s\nDigite o novo Nome (Pressione ENTER para manter o nome atual): ", nome);
			String entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			// Atualiza preco (ou mantém valor atual se apertar Enter)
			System.out.printf("Preco atual: %.2f\nDigite o novo Preco (Pressione ENTER para manter o valor atual): ",
					preco);
			entrada = leia.nextLine();

			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

			// Se a produto for do categoria Produto Corrente
			switch (categoria) {
			case 1 -> {

				String calcados = ((Calcados) produto).getCalcados();

				System.out.printf(
						"Calçado atual é: %.2f\nDigite o novo Calçado (Pressione ENTER para manter o valor atual): ",
						calcados);
				entrada = leia.nextLine();
				calcados = entrada.isEmpty() ? calcados : entrada;

				produtoController.atualizar(new Calcados(id, nome, categoria, preco, calcados));

			}

			case 2 -> {

				String bolsas = ((Bolsas) produto).getFragrancia();

				System.out.printf("Produto atual é: %d\nDigite o modelo da bolsa (Pressione ENTER para manter o valor atual): ",bolsas);
				entrada = leia.nextLine();
				bolsas = entrada.isEmpty() ? bolsas : entrada;
				produtoController.atualizar(new Bolsas(id, nome, categoria, preco, bolsas));
			}
			// Se o categoria da produto for inválido
			default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
			}

		} else {
			// Caso a produto não exista
			System.out.printf("\nO produto número %d não foi encontrado!", id);
		}
	}

}
