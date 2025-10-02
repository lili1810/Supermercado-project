import java.util.ArrayList;
import java.util.Objects;

public class ControleCliente
{
    private static ArrayList<Cliente> clientecadastrado = new ArrayList<Cliente>();

    public void cadastrarCliente(String nome, double credito)
    {
        Cliente cliente = new Cliente(nome, credito);
        clientecadastrado.add(cliente);
    }

    public void mostraCliente()
    {
        if (clientecadastrado.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("-------------------------Clientes Cadastrados-------------------------");
        for (Cliente cliente : clientecadastrado)
        {
            System.out.println(cliente.getNome() + " : R$" + String.format("%.2f", cliente.getCredito()));
        }
        System.out.println("----------------------------------------------------------------------");
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

    public void comprarnoCredito(String nome, double valor)
    {
        for (Cliente cliente : clientecadastrado) {
            if (Objects.equals(cliente.getNome(), nome)) {
                if (cliente.getCredito() >= valor) {
                    cliente.reduzCredito(valor);
                    System.out.println("Compra no crédito de R$" + String.format("%.2f", valor) + " realizada!");
                    System.out.println("Novo crédito: R$" + String.format("%.2f", cliente.getCredito()));
                    return;
                }
                else
                {
                    System.out.println("Crédito insuficiente. Crédito disponível: R$" + String.format("%.2f", cliente.getCredito()));
                    return;
                }
            }
        }
        System.out.println("Erro: Cliente não encontrado.");
    }

    public void atualizaCredito(String nome,double credito)
    {
        for(Cliente cliente : clientecadastrado)
        {
            if (Objects.equals(cliente.getNome(), nome))
            {
                cliente.aumentaCredito(credito);
                System.out.println("Crédito atualizado: R$" + String.format("%.2f", cliente.getCredito()));
                return;
            }
        }
        System.out.println("Cliente não encontrado para atualização de crédito.");
    }
}