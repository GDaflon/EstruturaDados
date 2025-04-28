import java.util.Scanner;

public class OrdenaProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];
        double[] precos = new double[10];

        System.out.println("Cadastro de 10 produtos:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Nome do produto " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
            System.out.print("Preço do produto " + (i + 1) + ": R$ ");
            precos[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer
        }

        // Ordenação por preço (decrescente) com bubble sort
        for (int i = 0; i < precos.length - 1; i++) {
            for (int j = 0; j < precos.length - 1 - i; j++) {
                if (precos[j] < precos[j + 1]) {
                    // Trocar preços
                    double tempPreco = precos[j];
                    precos[j] = precos[j + 1];
                    precos[j + 1] = tempPreco;

                    // Trocar nomes também para manter a correspondência
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;
                }
            }
        }

        System.out.println("\nProdutos ordenados do mais caro ao mais barato:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("%s - R$ %.2f\n", nomes[i], precos[i]);
        }

        scanner.close();
    }
}
