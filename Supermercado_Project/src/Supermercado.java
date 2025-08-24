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

        Scanner sc = new Scanner(System.in);

        String nome;
        int quantidade;
        double preco;

        System.out.println("------------------------Bem vindo ao Supermercado!-----------------------");

        while(true) {
            System.out.println("Selecione :\n" +
                    "1. Funcionário\n" +
                    "2. Cliente");
            int m1 = sc.nextInt();

            if (m1 == 2) {
                System.out.println("Deseja fazer cadastro no supermercado?" +
                        "1. sim" +
                        "2. não" +
                        "3. já tenho cadastro");
                int m2 = sc.nextInt();

                if (m2 == 1) {
                    System.out.println("Digite seu nome");
                    String nomepessoa = sc.nextLine();

                    System.out.println("Digite seu credito");
                    double credito = sc.nextDouble();

                    //ControlePessoas.cadastrarPessoas(nomepessoa, credito);
                }
                System.out.println("O que deseja fazer :\n" +
                        "1. Comprar um produto\n" +
                        "2. Ver produtos disponiveis\n" +
                        "3. Sair do supermercado");
                int ac = sc.nextInt();

                if (m2 == 1 && ac == 1 || m2 == 3)
                {
                    System.out.println("Deseja comprar no credito?" +
                            "1. sim" +
                            "2. não");
                    //if
                }
                else if (ac == 2)
                {
                    controleProduto.listarProdutos();
                    System.out.println();
                }
                else if (ac == 3)
                {
                    break;
                }
                else
                {
                    System.out.println("Opcao invalida");
                }
            }
            else if (m1 == 1)
            {
                System.out.println("O que deseja fazer?\n" +
                        "1. Cadastrar um produto\n" +
                        "2. Vender um produto\n" +
                        "3. Atualizar o estoque\n" +
                        "4. Ver produtos disponíveis\n" +
                        "5. Ver historico de vendas\n" +
                        "6. Sair do supermercado");
                int af = sc.nextInt();

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
                    break;
                }
                else
                {
                    System.out.println("opcao invalida");
                    System.out.println();
                }
            } else {
                System.out.println("opcao invalida");
                System.out.println();
            }
        }
            sc.close();
    }
}
