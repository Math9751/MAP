public class Main {
    public static void main(String[] args) {
        // Criando um carrinho de compras
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Criando produtos
        Produto produto1 = new Produto(1, "Camiseta", 29.99);
        Produto produto2 = new Produto(2, "Calça Jeans", 59.99);
        Produto produto3 = new Produto(3, "Tênis", 99.99);

        // Adicionando produtos ao carrinho
        carrinho.adicionarItem(produto1, 2);
        carrinho.adicionarItem(produto2, 1);
        carrinho.adicionarItem(produto3, 3);

        // Listando produtos no carrinho
        System.out.println("Produtos no carrinho:");
        carrinho.listarItens();
        System.out.println("Total a pagar: R$" + carrinho.calcularTotalAPagar());

        // Removendo alguns produtos
        carrinho.removerItem(produto1, 1);
        carrinho.removerItem(produto3, 2);

        // Listando produtos no carrinho após remoção
        System.out.println("\nProdutos no carrinho após remoção:");
        carrinho.listarItens();
        System.out.println("Total a pagar: R$" + carrinho.calcularTotalAPagar());
    }
}
