package model;

public class Automovel {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;

    public Automovel(String placa, String modelo, String marca, int ano, double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toFileString() {
        return placa + ";" + modelo + ";" + marca + ";" + ano + ";" + valor;
    }

    public static Automovel fromFileString(String linha) {
        String[] dados = linha.split(";");
        return new Automovel(
            dados[0],
            dados[1],
            dados[2],
            Integer.parseInt(dados[3]),
            Double.parseDouble(dados[4])
        );
    }
}
