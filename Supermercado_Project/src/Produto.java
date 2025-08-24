public class Produto
{
    private String nome;
    private int quantidade;
    private double preco;

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
    }

    public void reduzirEstoque(int quantidade)
    {
        if (this.quantidade - quantidade >= 0) {
            this.quantidade -= quantidade;
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
}
