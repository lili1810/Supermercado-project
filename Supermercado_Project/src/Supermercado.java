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
        ControlePessoa controlePessoa = new ControlePessoa();


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
            int m1 = sc.nextInt();

            if (m1 == 2)
            {
                while(true)
                {
                    System.out.print("Deseja fazer cadastro no supermercado?\n" +
                        "1. sim\n" +
                        "2. não\n" +
                        "3. já tenho cadastro\n");
                    int m2 = sc.nextInt();

                    if (m2 == 1)
                    {
                        sc.nextLine();

                        System.out.print("Digite seu nome: ");
                        String nomepessoa = sc.nextLine();

                        System.out.print("Digite seu credito: ");
                        double credito = sc.nextDouble();

                        controlePessoa.cadastrarPessoa(nomepessoa, credito);
                        System.out.println();

                    }
                    if (m2 == 1 || m2 == 3)//tem cadastro
                    {
                        sc.nextLine();
                        System.out.print("Digite seu nome : ");
                        String npessoa = sc.nextLine();

                        if (controlePessoa.confereCadastro(npessoa)) {
                            System.out.println("cadastro encontrado!");
                            System.out.println();
                            System.out.println("O que deseja fazer ?\n" +
                                "1. Comprar um produto\n" +
                                "2. atualizar o credito\n" +
                                "3. Sair do supermercado");
                            int ac = sc.nextInt();//acao cliente

                            if (ac == 1)//comprar
                            {
                                System.out.println("Deseja comprar no credito?\n" +
                                    "1. sim\n" +
                                    "2. não");
                                int c = sc.nextInt();

                                System.out.println("Produots disponiveis: \n");
                                controleProduto.listarProdutos();
                                System.out.println();

                                sc.nextLine();
                                System.out.print("Digite o nome do produto : ");
                                nome = sc.nextLine();

                                System.out.print("Digite a quantidade do produto: ");
                                quantidade = sc.nextInt();

                                if (c == 1)
                                {
                                    //controlePessoa.comprarnoCredito(npessoa);
                                    controleProduto.efetuaVenda(nome, quantidade);
                                }
                                else if (c == 2)
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
                            else if (ac == 2) //atualizar o credito
                            {
                                System.out.print("digite quanto quer adicionar: ");
                                double credito = sc.nextDouble();
                                controlePessoa.atualizaCredito(npessoa, credito);
                            }
                            else if (ac == 3)
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
                    else if (m2 == 2)//compra sem cadastro
                    {
                        System.out.println("O que deseja fazer :\n" +
                                "1. Comprar um produto\n" +
                                "2. Sair do supermercado");
                        int ac = sc.nextInt();
                        if (ac == 1)
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
                        else if (ac == 2)
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
            else if (m1 == 1)
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
                    int af = sc.nextInt();//acao funcionario

                    if (af == 1)
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
                    else if (af == 2)
                    {
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();

                        controleProduto.efetuaVenda(nome, quantidade);
                        System.out.println();
                    }
                    else if (af == 3)
                    {
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade do produto: ");
                        quantidade = sc.nextInt();

                        controleProduto.atualizaEstoque(nome, quantidade);
                        System.out.println();
                    }
                    else if (af == 4)
                    {
                        controleProduto.listarProdutos();
                        System.out.println();
                    }
                    else if (af == 5)
                    {
                        controleProduto.exibeHistorico();
                        System.out.println();
                    }
                    else if (af == 6)
                    {
                        controlePessoa.mostraPessoa();
                        System.out.println();
                    }
                    else if (af == 7)
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
            else if(m1 == 3)
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
