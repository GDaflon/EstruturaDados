package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovelRepository {
    private final String ARQUIVO = "automoveis.txt";

    public void salvar(List<Automovel> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Automovel a : lista) {
                writer.write(a.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar automóveis: " + e.getMessage());
        }
    }

    public List<Automovel> carregar() {
        List<Automovel> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(Automovel.fromFileString(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar automóveis: " + e.getMessage());
        }
        return lista;
    }
}
