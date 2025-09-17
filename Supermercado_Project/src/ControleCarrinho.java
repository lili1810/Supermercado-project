import java.util.Objects;

public class ControleCarrinho
{
    private Carrinho carrinho;

    public void acoesCarrinho(Produto produto,String nome, int quantidade,char sinal)
    {
        if(carrinho.Checar(nome))
        {
            if(sinal == '+')
            {
                produto.adicionarEstoque(quantidade);
                System.out.println("adicionado!");
            }
            else if (sinal == '-')
            {
                produto.reduzirEstoque(quantidade);
                System.out.println("adicionado!");
            }
            else
            {
                System.out.println("");
            }
        }

    }
}/*
carrinho
    adicionar produto (nome quantidade)
    retirar produto(nome quantidade)
*/
