import java.util.ArrayList;
import java.util.Objects;

public class ControleProduto
{
    private ArrayList <Produto> produtos = new ArrayList <Produto>();
    Historico historicoVendas = new Historico(); // Usa a classe Historico funcional

    public void cadastraProduto(String nome, int quantidade, double preco)
    {
        if (produtos.size() >= 10)//ve se tem espaco (corrigido para >=)
        {
            System.out.println("Espaço cheio!");
            return;
        }

        Produto novoProduto = new Produto(nome, quantidade, preco);

        produtos.add(novoProduto);
        System.out.println("Produto cadastrado!");
    }

    public void atualizaEstoque(String nome, int quantidade)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.getNome(), nome))
            {
                produto.adicionarEstoque(quantidade);
                System.out.println("Estoque atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado : " + nome);
    }

    public void efetuaVenda(String nome, int quantidade)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.getNome(), nome))
            {
                if(produto.getQuantidade() >= quantidade) {
                    produto.reduzirEstoque(quantidade);

                    // Cria uma cópia do produto com a quantidade vendida para o histórico
                    Produto produtoVendido = new Produto(produto.getNome(), quantidade, produto.getPreco());
                    historicoVendas.adicionarProdutoVendido(produtoVendido);
                    System.out.println("Venda efetuada!");
                    return;
                }
                else
                {
                    System.out.println("Quantidade não disponivel: ");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado : " + nome);
    }

    public void listarProdutos()
    {
        System.out.println("-----------------------------Produtos-------------------------------");
        System.out.println();

        for(Produto produto : produtos)
        {
            produto.exibirInfo();
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    public void exibirHistoricoVenda() {
        historicoVendas.exibeHistorico();
    }

    public void exibirVariacaoEstoque(String nome)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.getNome(), nome))
            {
                System.out.println();
                System.out.println("------------------------Variação de Estoque-------------------------");
                System.out.print(produto.getNome()+": ");
                produto.exibirVaricaoEstoque();
                System.out.println("--------------------------------------------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("Produto não encontrado: " + nome);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}