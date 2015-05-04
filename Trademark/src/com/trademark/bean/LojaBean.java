package com.trademark.bean;

import com.opensymphony.xwork2.ActionSupport;

public class LojaBean extends ActionSupport {
    private int id;
    private String nome;
    private String descricao;
    private String endereco;
    private int numero;
    private String bairro;

    public String mostraLojas() {
        return NONE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }
}
