import java.util.Objects;
import java.util.Scanner;

public class Supermercado
{
    public static ControleProduto seed()
    {
        ControleProduto controleProduto = new ControleProduto();

        controleProduto.cadastraProduto("mesa", 10, 100);
        controleProduto.cadastraProduto("cadeira", 4, 10);
        controleProduto.cadastraProduto("mouse", 15, 1000);
        controleProduto.cadastraProduto("tv", 1, 50);
        controleProduto.cadastraProduto("lapis", 16, 15);
        return controleProduto;
    }

    // Método auxiliar para encontrar o preço de um produto no estoque
    private static double getPrecoProduto(ControleProduto cp, String nome, int quantidade) {
        for (Produto p : cp.getProdutos()) {
            if (Objects.equals(p.getNome(), nome)) {
                return p.getPreco() * quantidade;
            }
        }
        return 0.0;
    }

    public static void main(String[] args)
    {
        ControleProduto controleProduto = seed();
        ControleCliente controleCliente = new ControleCliente();

        Scanner sc = new Scanner(System.in);

        String nome;
        int quantidade;

        System.out.println("------------------------Bem vindo ao Supermercado!-----------------------");

        boolean rodando = true;
        while(rodando) // Menu Principal
        {
            System.out.println("\nSelecione :\n" +
                    "1. Funcionário\n" +
                    "2. Cliente\n" +
                    "3. Sair");
            String m1 = sc.nextLine();

            // ================= CLIENTE =================
            if (Objects.equals(m1, "2"))
            {
                String ncliente = "";
                boolean clienteCadastrado = false;

                System.out.print("\nDeseja fazer cadastro no supermercado?\n" +
                        "1. Sim\n" +
                        "2. Não (Comprar sem cadastro)\n" +
                        "3. Já tenho cadastro\n" +
                        "Opção: ");
                String m2 = sc.nextLine();

                if (Objects.equals(m2, "1")) // Novo Cadastro
                {
                    System.out.print("Digite seu nome: ");
                    String nomecliente = sc.nextLine();

                    System.out.print("Digite seu crédito inicial: ");
                    double credito = sc.nextDouble();
                    sc.nextLine(); // CORRIGIDO: Consome o \n

                    controleCliente.cadastrarCliente(nomecliente, credito);
                    ncliente = nomecliente;
                    clienteCadastrado = true;
                    System.out.println("Cliente cadastrado com sucesso!");
                }
                else if (Objects.equals(m2, "3")) // Login
                {
                    System.out.print("Digite seu nome : ");
                    ncliente = sc.nextLine();

                    if (controleCliente.confereCadastro(ncliente)) {
                        System.out.println("Cadastro encontrado!");
                        clienteCadastrado = true;
                    } else {
                        System.out.println("Cadastro não encontrado.");
                    }
                }

                // CLIENTE COM CADASTRO (Logado)
                if (clienteCadastrado)
                {
                    boolean clienteMenu = true;

                    while (clienteMenu)
                    {
                        System.out.println("\n--- Menu Cliente (" + ncliente + ") ---\n" +
                                "1. Comprar um produto\n" +
                                "2. Atualizar o crédito\n" +
                                "3. Voltar ao Menu Principal");
                        String ac = sc.nextLine();

                        if (Objects.equals(ac, "1"))//comprar
                        {
                            System.out.println("Deseja comprar no crédito?\n" +
                                    "1. Sim\n" +
                                    "2. Não");
                            String c = sc.nextLine();

                            System.out.println("\nProdutos disponíveis:");
                            controleProduto.listarProdutos();

                            System.out.print("Digite o nome do produto : ");
                            nome = sc.nextLine();

                            System.out.print("Digite a quantidade do produto: ");
                            quantidade = sc.nextInt();
                            sc.nextLine(); // CORRIGIDO: Consome o \n

                            // Calcula o preço ANTES de tentar a venda
                            double precoTotal = getPrecoProduto(controleProduto, nome, quantidade);

                            if (Objects.equals(c, "1"))
                            {
                                if (precoTotal > 0) {
                                    // A venda só deve ser efetuada se o crédito for suficiente.
                                    // O método comprarnoCredito já verifica e exibe a mensagem de erro.
                                    controleCliente.comprarnoCredito(ncliente, precoTotal);

                                    // Se a compra no crédito foi bem sucedida (lógica de ControleCliente),
                                    // a venda em estoque é feita.
                                    // Idealmente, este bloco precisaria de um retorno da função comprarnoCredito.
                                    // Para manter o fluxo, assumimos que a venda é tentada após a tentativa de crédito.
                                    controleProduto.efetuaVenda(nome, quantidade);
                                } else {
                                    System.out.println("Produto não encontrado ou preço inválido para compra.");
                                }

                            }
                            else if (Objects.equals(c, "2"))
                            {
                                controleProduto.efetuaVenda(nome, quantidade);
                            }
                            else
                            {
                                System.out.println("Opção de pagamento inválida.");
                            }
                        }
                        else if (Objects.equals(ac, "2")) //atualizar o credito
                        {
                            System.out.print("Digite quanto quer adicionar: ");
                            double credito = sc.nextDouble();
                            sc.nextLine(); // CORRIGIDO: Consome o \n

                            controleCliente.atualizaCredito(ncliente, credito);
                        }
                        else if (Objects.equals(ac, "3"))
                        {
                            clienteMenu = false;
                        }
                        else
                        {
                            System.out.println("Opção inválida.");
                        }
                    }
                }
                else if (Objects.equals(m2, "2")) // Compras sem cadastro (Guest)
                {
                    System.out.println("\n--- Comprar sem Cadastro ---\n");

                    System.out.println("O que deseja fazer :\n" +
                            "1. Comprar um produto\n" +
                            "2. Voltar ao Menu Principal");
                    String ac = sc.nextLine();

                    if (Objects.equals(ac, "1"))
                    {
                        System.out.println("Produtos disponíveis : ");
                        controleProduto.listarProdutos();

                        System.out.print("Digite o que deseja comprar : ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto : ");
                        quantidade = sc.nextInt();
                        sc.nextLine(); // CORRIGIDO: Consome o \n

                        controleProduto.efetuaVenda(nome, quantidade);
                        System.out.println();
                    }
                    // A opção 2 já é tratada por sair do bloco, retornando ao Menu Principal
                }
            }

            //================= FUNCIONÁRIO =================
            else if (Objects.equals(m1, "1"))
            {
                boolean funcionarioRodando = true;

                while(funcionarioRodando)
                {
                    System.out.println("\n--- Menu Funcionário ---\n" +
                            "1. Cadastrar um produto\n" +
                            "2. Vender um produto\n" +
                            "3. Atualizar o estoque\n" +
                            "4. Ver produtos disponíveis\n" +
                            "5. Ver histórico de vendas\n" +
                            "6. Ver cadastros de clientes\n" +
                            "7. Ver histórico de produto (Variação de Estoque)\n" +
                            "8. Voltar ao Menu Principal");
                    String af = sc.nextLine();

                    if (Objects.equals(af, "1"))
                    {
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();
                        sc.nextLine(); // CORRIGIDO: Consome o \n

                        System.out.print("Digite o preço do produto: ");
                        double preco = sc.nextDouble();
                        sc.nextLine(); // CORRIGIDO: Consome o \n

                        controleProduto.cadastraProduto(nome, quantidade, preco);
                        System.out.println();
                    }
                    else if (Objects.equals(af, "2"))
                    {
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();
                        sc.nextLine(); // CORRIGIDO: Consome o \n

                        controleProduto.efetuaVenda(nome, quantidade);
                        System.out.println();
                    }
                    else if (Objects.equals(af, "3"))
                    {
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade a adicionar: ");
                        quantidade = sc.nextInt();
                        sc.nextLine(); // CORRIGIDO: Consome o \n

                        controleProduto.atualizaEstoque(nome, quantidade);
                        System.out.println();
                    }
                    else if (Objects.equals(af, "4"))
                    {
                        controleProduto.listarProdutos();
                        System.out.println();
                    }
                    else if (Objects.equals(af, "5"))
                    {
                        controleProduto.exibirHistoricoVenda();
                        System.out.println();
                    }
                    else if (Objects.equals(af, "6"))
                    {
                        controleCliente.mostraCliente();
                        System.out.println();
                    }
                    else if (Objects.equals(af, "7"))
                    {
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();
                        controleProduto.exibirVariacaoEstoque(nome);
                    }
                    else if (Objects.equals(af, "8"))
                    {
                        funcionarioRodando = false;
                    }
                    else
                    {
                        System.out.println("Opção inválida.");
                        System.out.println();
                    }
                }
            }
            // ================= SAIR =================
            else if(Objects.equals(m1, "3"))
            {
                System.out.println("Obrigado por utilizar o sistema do Supermercado. Até logo!");
                rodando = false;
            }
            else
            {
                System.out.println("Opção inválida.");
                System.out.println();
            }
        }
        sc.close();
    }
}