import java.util.ArrayList;
import java.util.Objects;

public class Historico {
    private ArrayList<Produto> historicoVendas = new ArrayList<>();

    public Historico () {}

    public void adicionarProdutoVendido(Produto produtoVendido) {
        // Encontra o produto na lista se ele já existir
        for (Produto p : historicoVendas) {
            if (Objects.equals(p.getNome(), produtoVendido.getNome())) {
                p.setQuantidade(p.getQuantidade() + produtoVendido.getQuantidade()); // Adiciona a quantidade vendida
                return;
            }
        }
        // Se o produto não foi encontrado, adiciona um novo coisa noa array
        historicoVendas.add(produtoVendido);
    }

    public void exibeHistorico()
    {
        System.out.println("-----------------------------Histórico de Vendas-------------------------------");
        System.out.println();

        for(Produto p : historicoVendas)
        {
            p.exibirInfoVendida();
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

}
