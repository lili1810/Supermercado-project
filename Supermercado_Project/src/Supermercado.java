import java.util.Objects;
import java.util.Scanner;

public class Supermercado
{
    public static ControleProduto seed()
    {//adiciona automaticamente os produtos
        ControleProduto controleProduto = new ControleProduto();
        Historico historico = new Historico();

        controleProduto.cadastraProduto("mesa", 10, 100);
        controleProduto.cadastraProduto("cadeira", 4, 10);
        controleProduto.cadastraProduto("mouse",    15, 1000);
        controleProduto.cadastraProduto("tv", 1, 50);
        controleProduto.cadastraProduto("lapis", 16, 15);
        return controleProduto;
    }

    public static void main(String[] args)
    {
        ControleProduto controleProduto = seed();
        ControleCliente controleCliente = new ControleCliente();


        Scanner sc = new Scanner(System.in);

        String nome;
        int quantidade;
        double preco;

        System.out.println("------------------------Bem vindo ao Supermercado!-----------------------");

        while(true) //f ou c
        {
            System.out.println("Selecione :\n" +
                "1. Funcionário\n" +
                "2. Cliente\n" +
                "3. sair");
            String m1 = sc.nextLine();

            if (Objects.equals(m1, "2"))
            {
                while(true)
                {
                    System.out.print("Deseja fazer cadastro no supermercado?\n" +
                        "1. sim\n" +
                        "2. não\n" +
                        "3. já tenho cadastro\n");
                    String m2 = sc.nextLine();

                    if (Objects.equals(m2, "1"))
                    {
                        sc.nextLine();

                        System.out.print("Digite seu nome: ");
                        String nomecliente = sc.nextLine();

                        System.out.print("Digite seu credito: ");
                        double credito = sc.nextDouble();

                        controleCliente.cadastrarCliente(nomecliente, credito);
                        System.out.println();

                    }
                    if (Objects.equals(m2, "1") || Objects.equals(m2, "3"))//tem cadastro
                    {
                        sc.nextLine();
                        System.out.print("Digite seu nome : ");
                        String ncliente = sc.nextLine();

                        if (controleCliente.confereCadastro(ncliente)) {
                            System.out.println("cadastro encontrado!");
                            //carrinho
                            //adicionar/excluir/ver
                            System.out.println();
                            System.out.println("O que deseja fazer ?\n" +
                                "1. Comprar um produto\n" +
                                "2. atualizar o credito\n" +
                                "3. Sair do supermercado");
                            String ac = sc.nextLine();//acao cliente

                            if (Objects.equals(ac, "1"))//comprar
                            {
                                System.out.println("Deseja comprar no credito?\n" +
                                    "1. sim\n" +
                                    "2. não");
                                String c = sc.nextLine();

                                System.out.println("Produots disponiveis: \n");
                                controleProduto.listarProdutos();
                                System.out.println();

                                sc.nextLine();
                                System.out.print("Digite o nome do produto : ");
                                nome = sc.nextLine();

                                System.out.print("Digite a quantidade do produto: ");
                                quantidade = sc.nextInt();

                                if (Objects.equals(c, "1"))
                                {
                                    controleCliente.comprarnoCredito(ncliente);
                                    controleProduto.efetuaVenda(nome, quantidade);
                                }
                                else if (Objects.equals(c, "2"))
                                {
                                    sc.nextLine();
                                    System.out.println("Produots disponiveis: ");
                                    controleProduto.listarProdutos();

                                    System.out.println("O que deseja comprar?");
                                    nome = sc.nextLine();

                                    System.out.print("Digite a quantidade do produto: ");
                                    sc.nextLine();
                                    quantidade = sc.nextInt();

                                    controleProduto.efetuaVenda(nome, quantidade);
                                    System.out.println();
                                }
                                else
                                {
                                    System.out.println("opcao invalida");
                                }
                            }
                            else if (Objects.equals(ac, "2")) //atualizar o credito
                            {
                                System.out.print("digite quanto quer adicionar: ");
                                double credito = sc.nextDouble();
                                controleCliente.atualizaCredito(ncliente, credito);
                            }
                            else if (Objects.equals(ac, "3"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("opcao invalida");
                            }
                        }
                        else
                        {
                            System.out.println("Cadastro nao encontrado");
                        }
                    }
                    else if (Objects.equals(m2, "2"))//compra sem cadastro
                    {
                        System.out.println("O que deseja fazer :\n" +
                                "1. Comprar um produto\n" +
                                "2. Sair do supermercado");
                        String ac = sc.nextLine();
                        if (Objects.equals(ac, "1"))
                        {
                            sc.nextLine();
                            System.out.println("Produots disponiveis : ");
                            controleProduto.listarProdutos();

                            System.out.print("Digite o que deseja comprar : ");
                            nome = sc.nextLine();

                            System.out.print("Digite a quantidade do produto : ");
                            quantidade = sc.nextInt();

                            controleProduto.efetuaVenda(nome, quantidade);
                            System.out.println();
                        }
                        else if (Objects.equals(ac, "2"))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("opcao invalida");
                        }
                    }
                }
            }
            else if (Objects.equals(m1, "1"))
            {
                while(true)
                {
                    System.out.println("O que deseja fazer?\n" +
                        "1. Cadastrar um produto\n" +
                        "2. Vender um produto\n" +
                        "3. Atualizar o estoque\n" +
                        "4. Ver produtos disponíveis\n" +
                        "5. Ver historico de vendas\n" +
                        "6. Ver cadastros\n" +//pessoas cadastradas
                        "7. Sair do supermercado");
                    String af = sc.nextLine();;//acao funcionario

                    if (Objects.equals(af, "1"))
                    {
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();

                        System.out.print("Digite o preço do produto: ");
                        preco = sc.nextDouble();

                        controleProduto.cadastraProduto(nome, quantidade, preco);
                        System.out.println();
                    }
                    else if (Objects.equals(af, "2"))
                    {
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();

                        controleProduto.efetuaVenda(nome, quantidade);
                        System.out.println();
                    }
                    else if (Objects.equals(af, "3"))
                    {
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();

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
                        controleProduto.exibeHistorico();
                        System.out.println();
                    }
                    else if (Objects.equals(af, "6"))
                    {
                        controleCliente.mostraCliente();
                        System.out.println();
                    }
                    else if (Objects.equals(af, "7"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("opcao invalida");
                        System.out.println();
                    }
                }
            }
            else if(Objects.equals(m1, "3"))
            {
                break;
            }
            else
            {
                System.out.println("opcao invalida");
                System.out.println();
            }
        }
    }
}
