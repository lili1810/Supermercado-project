import java.util.ArrayList;
import java.util.Objects;

public class ControleProduto
{
    private ArrayList <Produto> produtos = new ArrayList <Produto>();
    Historico historicoVendas = new Historico();

    public void cadastraProduto(String nome, int quantidade, double preco)
    {
        if (produtos.size() == 10)//ve se tem espaco
        {
            System.out.println("Espaço cheio!");
            return;
        }
    //toda vez que cadastraproduto for chamada, e se tiver espaco na lista, um novo objeto sera instanciado
        Produto novoProduto = new Produto(nome, quantidade, preco);//instancia um novo produto(objeto)

        if(produtos.size() <= 10)
        {
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado!");
        }
    }

    public void atualizaEstoque(String nome, int quantidade)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.getNome(), nome))//ve se o objeto esta na lista
            {
                produto.adicionarEstoque(quantidade);//chama o metodo de produto
                System.out.println("Estoque atualizado!");
            }
            else
            {
                System.out.println("Produto não encontrado : " + nome);
            }
        }
    }

    public void efetuaVenda(String nome, int quantidade)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.getNome(), nome))//se o objeto estiver no array...
            {
                if(produto.getQuantidade() >= quantidade) {
                    produto.reduzirEstoque(quantidade);

                    Produto produtoVendido = new Produto(produto.getNome(), quantidade, produto.getPreco());//instancia um novo produto
                    historicoVendas.adicionarProdutoVendido(produtoVendido);
                    System.out.println("Venda efetuada!");
                    return;
                }
                else
                {
                    System.out.println("Quantidade não disponivel: ");
                }
            }
            else
            {
                System.out.println("Produto não encontrado : " + nome);
            }
        }
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
    }

    public void exibirHistoricoVenda() {
        historicoVendas.exibeHistorico();
    }
}
