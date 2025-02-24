class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    // Adicionar um nome à lista
    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    // Remover um nome pelo índice
    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    // Imprimir todos os nomes na lista
    public void imprimirLista() {
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Buscar um nome na lista
    public boolean buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equals(nome)) {
                return true;  // Nome encontrado
            }
        }
        return false;  // Nome não encontrado
    }
}

public class TesteListaString {
    public static void main(String[] args) {
        ListaArrayString lista = new ListaArrayString(5); // Capacidade aumentada para 5 nomes

        lista.adicionar("Ana");
        lista.adicionar("Bruno");
        lista.adicionar("Carlos");
        lista.adicionar("Maria");

        lista.imprimirLista();  // Imprime a lista de nomes

        // Busca por um nome
        String nomeBusca = "Bruno";
        if (lista.buscar(nomeBusca)) {
            System.out.println(nomeBusca + " encontrado na lista.");
        } else {
            System.out.println(nomeBusca + " não encontrado na lista.");
        }

        // Remover nome pela posição
        lista.remover(1);  // Remove "Bruno"
        lista.imprimirLista();  // Imprime a lista após a remoção

        // Outra busca por nome
        nomeBusca = "Carlos";
        if (lista.buscar(nomeBusca)) {
            System.out.println(nomeBusca + " encontrado na lista.");
        } else {
            System.out.println(nomeBusca + " não encontrado na lista.");
        }
    }
}
