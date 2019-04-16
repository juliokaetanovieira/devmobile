package br.edu.unifcv.faculdade.model;

public class Carro {

    private int id;
    private String modelo;
    private int potencia;
    private Double preco;

    public Carro(int id, String modelo, int potencia, Double preco) {
        this.id = id;
        this.modelo = modelo;
        this.potencia = potencia;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
