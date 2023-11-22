import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class CarrinhoDeCompras {
    private Map<Produto, Integer> itens;

    public CarrinhoDeCompras() {
        this.itens = new HashMap<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.put(produto, itens.getOrDefault(produto, 0) + quantidade);
    }

    public void removerItem(Produto produto, int quantidade) {
        int quantidadeAtual = itens.getOrDefault(produto, 0);
        if (quantidade > quantidadeAtual) {
            throw new IllegalArgumentException("Não há itens suficientes para remover.");
        }

        if (quantidadeAtual - quantidade > 0) {
            itens.put(produto, quantidadeAtual - quantidade);
        } else {
            itens.remove(produto);
        }
    }

    public void listarItens() {
        System.out.println("Itens no carrinho:");
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println("Produto: " + produto.getNome() + ", Quantidade: " + quantidade +
                    ", Preço unitário: R$" + produto.getPreco() +
                    ", Total: R$" + (produto.getPreco() * quantidade));
        }
    }

    public double calcularTotalAPagar() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            total += produto.getPreco() * quantidade;
        }
        return total;
    }
    class NomeProdutoComparator implements Comparator<Produto> {
    @Override
    public int compare(Produto produto1, Produto produto2) {
        return produto1.getNome().compareTo(produto2.getNome());
    }
}
}



// public class Main {
//     public static void main(String[] args) {
//         Produto produto1 = new Produto(1, "Camiseta", 29.99);
//         Produto produto2 = new Produto(2, "Calça Jeans", 59.99);

//         CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

//         carrinho.adicionarItem(produto1, 2);
//         carrinho.adicionarItem(produto2, 1);

//         carrinho.listarItens();
//         System.out.println("Total a pagar: R$" + carrinho.calcularTotalAPagar());

//         carrinho.removerItem(produto1, 1);

//         carrinho.listarItens();
//         System.out.println("Total a pagar: R$" + carrinho.calcularTotalAPagar());
//     }

