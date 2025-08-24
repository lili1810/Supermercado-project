import java.util.ArrayList;
import java.util.Objects;

public class ControleProduto
{
    private ArrayList <Produto> produtos = new ArrayList <Produto>();
    private ArrayList<Produto> historico = new ArrayList<Produto>();
    private int totalProdutos = 0;//contador dos objetos

    public void cadastraProduto(String nome, int quantidade, double preco)
    {
        if (totalProdutos == 10)//ve se tem espaco
        {
            System.out.println("Espaço cheio!");
            return;
        }
    //toda vez que cadastraproduto for chamada, e se tiver espaco na lista, um novo objeto sera instanciado
        Produto novoProduto = new Produto(nome, quantidade, preco);//instancia um novo produto(objeto)

        if(totalProdutos <= 10)
        {
            produtos.add(novoProduto);
            totalProdutos++;
            System.out.println("Produto cadastrado!");
        }
    }

    public void atualizaEstoque(String nome, int quantidade)
    {
        for (Produto produto : produtos)
        {
            if (Objects.equals(produto.GetNome(), nome))//ve se o objeto esta na lista
            {
                produto.adicionarEstoque(quantidade);//chama o metodo de produto

                //historico(produto.GetNome(), quantidae, +)
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
            if (Objects.equals(produto.GetNome(), nome))//se o objeto estiver no array...
            {
                if(produto.getQuantidade() >= quantidade)
                {
                    produto.reduzirEstoque(quantidade);

                    //historico(nome, quantidade, -)

                    Produto produtoVendido = new Produto(produto.GetNome(), quantidade, produto.getPreco());//instancia um novo produto
                    historico.add(produtoVendido);
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

        for(Produto produto : produtos)
        {
            produto.exibirInfo();
            System.out.println();
        }
    }
    public void exibeHistorico()
    {
        System.out.println("-----------------------------Historico-------------------------------");

        for(Produto produto : historico)
        {
            produto.exibirInfo();
        }
    }
}
