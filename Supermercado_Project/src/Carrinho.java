import java.util.ArrayList;
import java.util.Objects;

public class Carrinho
{
    private Produto produto;
    private double total = 0;
    private ArrayList<Produto> carrinhocompras = new ArrayList<>();

    public Carrinho(){};

    public boolean Checar(String nome)
    {
        for(Produto p : carrinhocompras)
        {
            if(Objects.equals(p.GetNome(), nome))
            {
                return true;
            }
        }
        return false;
    }

    public void adicionarnoCarrinho(Produto produto)
    {
        carrinhocompras.add(produto);
    }

    public void retirardoCarrinho(Produto produto)
    {
        carrinhocompras.remove(produto);
    }

    public double Total(Produto produto)
    {
        for(Produto p : carrinhocompras)
        {
            total += p.getPreco();
        }
        return total;
    }
}
