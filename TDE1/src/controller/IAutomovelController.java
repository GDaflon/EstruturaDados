package controller;

import java.util.List;

import model.Automovel;

public interface IAutomovelController {
    void incluirAutomovel(Automovel a);
    boolean alterarAutomovel(String placa, Automovel novo);
    boolean removerAutomovel(String placa);
    Automovel consultarPorPlaca(String placa);
    List<Automovel> listarOrdenado(String criterio);
}
