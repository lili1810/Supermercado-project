import java.util.ArrayList;

public class Produto
{
    private String nome;
    private int quantidade;
    private double preco;
    private ArrayList<Integer> variacaoEstoque = new ArrayList<Integer>();

   public Produto(String nome, int quantidade, double preco)
   {
       this.nome = nome;
       this.quantidade = quantidade;
       this.preco = preco;
   }

   public String getNome()
   {
       return this.nome;
   }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade (int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(int quantidade)
    {
        this.quantidade += quantidade;
        variacaoEstoque.add(quantidade);
    }

    public void reduzirEstoque(int quantidade)
    {
        if (this.quantidade - quantidade >= 0) {
            this.quantidade -= quantidade;
            variacaoEstoque.add(-1 * quantidade);
        }
    }
    public void exibirInfo()
    {
        System.out.println("Nome do produto : " + this.nome);
        System.out.println("quantidade disponivel: " + this.quantidade);
        System.out.println("Preço: " + this.preco);
    }
    public void exibirInfoVendida()
    {
        System.out.println("Nome do produto : " + this.nome);
        System.out.println("quantidade vendida: " + this.quantidade);
        System.out.println("Preço: " + this.preco);
    }

    public void exibirVaricaoEstoque ()
    {
       for (int i = 0; i < variacaoEstoque.size(); i++)
       {
           if (i == variacaoEstoque.size() - 1)
           {
               System.out.println(variacaoEstoque.get(i));
               continue;
           }
           System.out.print(variacaoEstoque.get(i) + ", ");
       }
    }
}
