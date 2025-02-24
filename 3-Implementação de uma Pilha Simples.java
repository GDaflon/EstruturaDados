class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Indica pilha vazia
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    // Empilhar um elemento
    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    // Desempilhar um elemento
    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    // Exibir o topo da pilha
    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    // Imprimir todos os elementos da pilha
    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5); // Tamanho da pilha é 5

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.imprimirPilha(); // Imprime os elementos empilhados

        System.out.println("Topo da pilha: " + pilha.peek()); // Mostra o topo

        System.out.println("Removendo: " + pilha.pop()); // Desempilha um elemento
        pilha.imprimirPilha(); // Imprime a pilha após desempilhar

        System.out.println("Topo da pilha: " + pilha.peek()); // Mostra o novo topo
    }
}
