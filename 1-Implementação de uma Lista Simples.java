class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    // Adicionar um elemento ao final da lista
    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    // Adicionar um elemento em uma posição específica
    public void adicionarNaPosicao(int elemento, int posicao) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }

        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }

        // Move os elementos à direita para abrir espaço
        for (int i = tamanho; i > posicao; i--) {
            array[i] = array[i - 1];
        }

        // Insere o novo elemento
        array[posicao] = elemento;
        tamanho++;
    }

    // Remover um elemento de uma posição específica
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

    // Imprimir todos os elementos da lista
    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class TesteLista {
    public static void main(String[] args) {
        ListaArray lista = new ListaArray(5);

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.imprimirLista(); // Deve imprimir: 10 20 30

        lista.adicionarNaPosicao(15, 1); // Adiciona o 15 na posição 1
        lista.imprimirLista(); // Deve imprimir: 10 15 20 30

        lista.remover(2); // Remove o elemento na posição 2 (20)
        lista.imprimirLista(); // Deve imprimir: 10 15 30
    }
}
