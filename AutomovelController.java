package controller;

import model.Automovel;
import model.AutomovelRepository;

import java.util.*;

public class AutomovelController implements IAutomovelController {
    private List<Automovel> lista;
    private AutomovelRepository repo;

    public AutomovelController() {
        repo = new AutomovelRepository();
        lista = new ArrayList<>(repo.carregar());
    }

    @Override
    public void incluirAutomovel(Automovel a) {
        if (consultarPorPlaca(a.getPlaca()) == null) {
            lista.add(a);
            repo.salvar(lista);
        } else {
            System.out.println("Placa já cadastrada.");
        }
    }

    @Override
    public boolean alterarAutomovel(String placa, Automovel novo) {
        Automovel existente = consultarPorPlaca(placa);
        if (existente != null) {
            existente.setModelo(novo.getModelo());
            existente.setMarca(novo.getMarca());
            existente.setAno(novo.getAno());
            existente.setValor(novo.getValor());
            repo.salvar(lista);
            return true;
        }
        return false;
    }

    @Override
    public boolean removerAutomovel(String placa) {
        Automovel a = consultarPorPlaca(placa);
        if (a != null) {
            lista.remove(a);
            repo.salvar(lista);
            return true;
        }
        return false;
    }

    @Override
    public Automovel consultarPorPlaca(String placa) {
        return lista.stream()
            .filter(a -> a.getPlaca().equalsIgnoreCase(placa))
            .findFirst().orElse(null);
    }

    @Override
    public List<Automovel> listarOrdenado(String criterio) {
        List<Automovel> copia = new ArrayList<>(lista);
        switch (criterio.toLowerCase()) {
            case "placa" -> copia.sort(Comparator.comparing(Automovel::getPlaca));
            case "modelo" -> copia.sort(Comparator.comparing(Automovel::getModelo));
            case "marca" -> copia.sort(Comparator.comparing(Automovel::getMarca));
        }
        return copia;
    }
}
