import java.util.Scanner;

public class Supermercado
{
    public static ControleProduto seed()
    {//adiciona automaticamente os produtos
        ControleProduto controleProduto = new ControleProduto();

        controleProduto.cadastraProduto("mesa", 10, 100);
        controleProduto.cadastraProduto("cadeira", 4, 10);
        controleProduto.cadastraProduto("mouse",    15, 1000);
        controleProduto.cadastraProduto("tv", 1, 50);
        controleProduto.cadastraProduto("lapia", 16, 15);
        return controleProduto;
    }

    public static void main(String[] args)
    {
        ControleProduto controleProduto = seed();
        Scanner sc = new Scanner(System.in);

        String nome;
        int quantidade;
        double preco;
        int c = 0;


        System.out.println("------------------------Bem vindo ao Supermercado!-----------------------");
        while(true)
        {
            System.out.println("O que deseja fazer?\n" +
                    "1. Cadastrar um produto\n" +
                    "2. Vender um produto\n" +
                    "3. Atualizar o estoque\n" +
                    "4. Ver produtos disponíveis\n" +
                    "5. Ver historico de vendas\n" +
                    "6. Sair do supermercado");
            c = sc.nextInt();

            if(c == 1)
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
            else if(c == 2)
            {
                sc.nextLine();
                System.out.print("Digite o nome do produto: ");
                nome = sc.nextLine();

                System.out.print("Digite a quantidade do produto: ");
                quantidade = sc.nextInt();

                controleProduto.efetuaVenda(nome, quantidade);
                System.out.println();
            }
            else if(c == 3)
            {
                sc.nextLine();
                System.out.print("Digite o nome do produto: ");
                nome = sc.nextLine();

                System.out.print("Digite a quantidade do produto: ");
                quantidade = sc.nextInt();

                controleProduto.atualizaEstoque(nome, quantidade);
                System.out.println();
            }
            else if(c == 4)
            {
                controleProduto.listarProdutos();
                System.out.println();

            }else if(c == 5)
            {
                controleProduto.exibeHistorico();
                System.out.println();
            }
            else if(c == 6)
            {
                break;
            }
            else
            {
                System.out.println("opcao invalida");
                System.out.println();
            }
        }
        sc.close();
    }
}
