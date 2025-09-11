public class Cliente
{
    private String nome;
    private double credito;

    public Cliente(String nome, double credito)
    {
        this.nome = nome;
        this.credito = credito;
    }
    public String getNome()
    {
        return this.nome;
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
