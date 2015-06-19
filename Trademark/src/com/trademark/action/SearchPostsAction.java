package com.trademark.action;

import com.opensymphony.xwork2.ActionSupport;
import com.trademark.bean.LojaBean;
import com.trademark.bean.MarcaBean;
import com.trademark.bean.PostagemBean;
import com.trademark.bean.TipoVestuarioBean;
import com.trademark.dao.LojaDAO;
import com.trademark.dao.MarcaDAO;
import com.trademark.dao.PostagemDao;
import com.trademark.dao.TipoVestuarioDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SearchPostsAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private ArrayList<PostagemBean> postagens;
    private List<MarcaBean> listaMarcas;
    private List<TipoVestuarioBean> listaTipoVestuario;
    private List<LojaBean> listaLojas;
    private int marcaSelecionada;
    private int tipoSelecionado;
    private int lojaSelecionada;
    private double preco;

    public String open() {
        // Pesquisa por todas as postagens.
        PostagemDao dao = new PostagemDao();
        ArrayList<PostagemBean> list = dao.pesquisarPostagens();
        setPostagens(formatarData(list));
        montarSelects();
        return SUCCESS;
    }

    public void montarSelects() {
        // Monta os combos de pesquisa da tela.
        setListaMarcas(new MarcaDAO().pesquisarMarcas());
        setListaTipoVestuario(new TipoVestuarioDAO().pesquisarTipoVestuario());
        setListaLojas(new LojaDAO().pesquisarLojas());
    }

    public String search() {
        PostagemDao dao = new PostagemDao();
        ArrayList<PostagemBean> list = dao.pesquisarComFiltros(marcaSelecionada, tipoSelecionado, lojaSelecionada, preco);
        setPostagens(formatarData(list));

        montarSelects();
        return SUCCESS;
    }

    private ArrayList<PostagemBean> formatarData(ArrayList<PostagemBean> list) {
        for (PostagemBean b : list) {
            String s = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(b
                    .getDataInicial());
            b.setDataFormatada(s);
        }
        return list;
    }

    public ArrayList<PostagemBean> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<PostagemBean> postagens) {
        this.postagens = postagens;
    }

    public List<MarcaBean> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<MarcaBean> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public List<LojaBean> getListaLojas() {
        return listaLojas;
    }

    public void setListaLojas(List<LojaBean> listaLojas) {
        this.listaLojas = listaLojas;
    }

    public List<TipoVestuarioBean> getListaTipoVestuario() {
        return listaTipoVestuario;
    }

    public void setListaTipoVestuario(List<TipoVestuarioBean> listaTipoVestuario) {
        this.listaTipoVestuario = listaTipoVestuario;
    }

    public int getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(int marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public int getTipoSelecionado() {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(int tipoSelecionado) {
        this.tipoSelecionado = tipoSelecionado;
    }

    public int getLojaSelecionada() {
        return lojaSelecionada;
    }

    public void setLojaSelecionada(int lojaSelecionada) {
        this.lojaSelecionada = lojaSelecionada;
    }

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
