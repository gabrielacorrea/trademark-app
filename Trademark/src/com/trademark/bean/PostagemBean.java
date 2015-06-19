package com.trademark.bean;

import java.sql.Timestamp;

public class PostagemBean {
    private int id;
    private Timestamp dataInicial;
    private String dataFormatada;
    private String descricao;
    private int idLoja;
    private int idMarca;
    private String imgPath;
    private String tipoVestuario;
    private String postadoPor;
    private String marca;
    private String loja;
    private double preco;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Timestamp getDataInicial() {
        return dataInicial;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getTipoVestuario() {
        return tipoVestuario;
    }

    public void setTipoVestuario(String tipoVestuario) {
        this.tipoVestuario = tipoVestuario;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public String getPostadoPor() {
        return postadoPor;
    }

    public void setPostadoPor(String postadoPor) {
        this.postadoPor = postadoPor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
