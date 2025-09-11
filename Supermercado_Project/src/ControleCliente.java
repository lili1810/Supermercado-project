import java.util.ArrayList;
import java.util.Objects;

public class ControleCliente
{
    public static ArrayList<Cliente> clientecadastrado = new ArrayList<Cliente>();
    private Cliente cliente;
    private Produto produto;

    public void cadastrarCliente(String nome, double credito)
    {
        Cliente cliente = new Cliente(nome, credito);
        clientecadastrado.add(cliente);
    }

    public void mostraCliente()
    {
        for (Cliente cliente : clientecadastrado)
        {
            System.out.println(cliente.getNome() + " : " + cliente.getCredito());
        }
    }

    public boolean confereCadastro(String nome)
    {
        for (Cliente cliente : clientecadastrado)
        {
            if (Objects.equals(cliente.getNome(), nome))
            {
                return true;
            }
        }
        return false;
    }

    public void comprarnoCredito(String nome)
    {
        for(Cliente cliente : clientecadastrado)
        {
            if (Objects.equals(cliente.getNome(), nome))
            {
                if (cliente.getCredito() >= produto.getPreco()) {
                    cliente.reduzCredito(produto.getPreco());
                    return;
                }
            }
        }
    }
    public void atualizaCredito(String nome,double credito)
    {
        for(Cliente cliente : clientecadastrado)
        {
            if (Objects.equals(cliente.getNome(), nome))
            {
                cliente.aumentaCredito(credito);
                System.out.println("Credito atualizado : " + cliente.getCredito());
                return;
            }
        }
    }
}
