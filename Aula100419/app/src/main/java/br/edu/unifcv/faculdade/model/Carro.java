package br.edu.unifcv.faculdade.model;

import android.graphics.drawable.Drawable;

/**
 * Entidade de carros
 */
public class Carro {

    private int id;
    private String modelo;
    private String fabricante;
    private int potecia;
    private Double preco;
    public Drawable picture;

    public Carro(int id, String modelo, String fabricante, int potecia, Double preco, Drawable picture) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potecia = potecia;
        this.preco = preco;
        this.picture = picture;

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

    public int getPotecia() {
        return potecia;
    }

    public void setPotecia(int potecia) {
        this.potecia = potecia;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
