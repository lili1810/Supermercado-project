import java.util.ArrayList;
import java.util.Objects;

public class ControlePessoa
{
    public static ArrayList<Pessoa> pessoacadastrada = new ArrayList<Pessoa>();
    private Pessoa pessoa;
    private Produto produto;

    public void cadastrarPessoa(String nome, double credito)
    {
        Pessoa pessoa = new Pessoa(nome, credito);
        pessoacadastrada.add(pessoa);
    }

    public void mostraPessoa()
    {
        for (Pessoa pessoa : pessoacadastrada)
        {
            System.out.println(pessoa.getNome() + " : " + pessoa.getCredito());
        }
    }

    public boolean confereCadastro(String nome)
    {
        for (Pessoa pessoa : pessoacadastrada)
        {
            if (Objects.equals(pessoa.getNome(), nome))
            {
                return true;
            }
        }
        return false;
    }

    public void comprarnoCredito(String nome)
    {
        for(Pessoa pessoa : pessoacadastrada)
        {
            if (Objects.equals(pessoa.getNome(), nome))
            {
                if (pessoa.getCredito() >= produto.getPreco()) {
                    pessoa.reduzCredito(produto.getPreco());
                    return;
                }
            }
        }
    }
    public void atualizaCredito(String nome,double credito)
    {
        for(Pessoa pessoa : pessoacadastrada)
        {
            if (Objects.equals(pessoa.getNome(), nome))
            {
                pessoa.aumentaCredito(credito);
                System.out.println("Credito atualizado : " + pessoa.getCredito());
                return;
            }
        }
    }
}
