package view;

import controller.IAutomovelController;
import controller.AutomovelController;
import model.Automovel;

import java.util.Scanner;

public class AutomovelView {
    private final IAutomovelController controller = new AutomovelController();
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir automóvel");
            System.out.println("2 - Alterar automóvel");
            System.out.println("3 - Remover automóvel");
            System.out.println("4 - Consultar automóvel por placa");
            System.out.println("5 - Listar automóveis (ordenado)");
            System.out.println("0 - Sair");
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> incluir();
                case 2 -> alterar();
                case 3 -> remover();
                case 4 -> consultar();
                case 5 -> listar();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void incluir() {
        System.out.println("\nIncluir novo automóvel:");
        Automovel a = lerAutomovel();
        controller.incluirAutomovel(a);
    }

    private void alterar() {
        String placa = lerString("Placa do automóvel a alterar: ");
        Automovel novo = lerAutomovel();
        if (controller.alterarAutomovel(placa, novo)) {
            System.out.println("Automóvel alterado.");
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    private void remover() {
        String placa = lerString("Placa do automóvel a remover: ");
        if (controller.removerAutomovel(placa)) {
            System.out.println("Removido com sucesso.");
        } else {
            System.out.println("Placa não encontrada.");
        }
    }

    private void consultar() {
        String placa = lerString("Placa a consultar: ");
        Automovel a = controller.consultarPorPlaca(placa);
        if (a != null) {
            exibirAutomovel(a);
        } else {
            System.out.println("Não encontrado.");
        }
    }

    private void listar() {
        System.out.print("Ordenar por (placa, modelo, marca): ");
        String criterio = scanner.next();
        controller.listarOrdenado(criterio).forEach(this::exibirAutomovel);
    }

    private Automovel lerAutomovel() {
        String placa = lerString("Placa: ");
        String modelo = lerString("Modelo: ");
        String marca = lerString("Marca: ");
        int ano = lerInt("Ano: ");
        double valor = lerDouble("Valor: ");
        return new Automovel(placa, modelo, marca, ano, valor);
    }

    private void exibirAutomovel(Automovel a) {
        System.out.println("Placa: " + a.getPlaca() +
                " | Modelo: " + a.getModelo() +
                " | Marca: " + a.getMarca() +
                " | Ano: " + a.getAno() +
                " | Valor: R$ " + a.getValor());
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    private double lerDouble(String msg) {
        System.out.print(msg);
        return scanner.nextDouble();
    }

    private String lerString(String msg) {
        System.out.print(msg);
        return scanner.next();
    }
}
