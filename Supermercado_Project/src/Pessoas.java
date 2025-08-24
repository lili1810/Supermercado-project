public class Pessoas
{
    private String nome;
    private double credito;
//    private int pontos = 0;
    private Produto produto;

    public Pessoas(String nome, double credito)
    {
        this.nome = nome;
        this.credito = credito;
    }
    public void ComprarnoCredito(double saldo)
    {
        if(this.credito >= produto.getPreco())
        {
            this.credito -= produto.getPreco();
        }
    }
    public void AtualizaSaldo(double saldo)
    {
        this.credito += saldo;
    }
//    public void AdicionaPontos(int pontos);
//    {
//        this.pontos += pontos;
//    }
}

