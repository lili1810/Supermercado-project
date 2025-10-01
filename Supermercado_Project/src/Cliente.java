public class Cliente extends Pessoa
{
    private String nome;
    private double credito;

    public Cliente(String nome, double credito)
    {
        super(nome);
        this.credito = credito;

    }

    public double getCredito()
    {
        return this.credito;
    }

    public void aumentaCredito(double credito)
    {
        this.credito += credito;
    }

    public void reduzCredito(double preco)
    {
        this.credito -= preco;
    }
}
