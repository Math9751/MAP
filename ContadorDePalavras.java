import java.util.HashMap;
import java.util.Map;

public class ContadorDePalavras {
    public static void main(String[] args) {
        // Texto com 200 palavras (um exemplo simples)
        String texto = "Java é uma linguagem de programação orientada a objetos. " +
                        "Ela é amplamente usada em desenvolvimento de software. " +
                        "Java é conhecida por sua portabilidade e versatilidade.";

        // Criando um mapa para contar a quantidade de palavras
        Map<String, Integer> contadorPalavras = new HashMap<>();

        // Dividindo o texto em palavras usando espaços e pontuações
        String[] palavras = texto.split("\\s+|\\p{Punct}");

        // Contando a quantidade de vezes que cada palavra aparece
        for (String palavra : palavras) {
            // Convertendo para minúsculas para ignorar maiúsculas/minúsculas
            palavra = palavra.toLowerCase();

            // Verificando se a palavra já está no mapa
            if (contadorPalavras.containsKey(palavra)) {
                // Incrementando a contagem
                contadorPalavras.put(palavra, contadorPalavras.get(palavra) + 1);
            } else {
                // Adicionando a palavra ao mapa com contagem 1
                contadorPalavras.put(palavra, 1);
            }
        }

        // Exibindo as palavras e a quantidade de repetições
        System.out.println("Palavras e quantidade de repetições:");
        for (Map.Entry<String, Integer> entry : contadorPalavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
