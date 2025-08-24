import java.util.ArrayList;

public class ControlePessoas
{
    private ArrayList<Pessoas> pessoascadastradas= new ArrayList<Pessoas>();

    public void cadastrarPessoas(String nome, double saldo)
    {
        Pessoas pessoas = new Pessoas(nome, saldo);
        pessoascadastradas.add(pessoas);
    }
}
