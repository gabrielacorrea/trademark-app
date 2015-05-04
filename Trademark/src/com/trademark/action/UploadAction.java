package com.trademark.action;

import com.opensymphony.xwork2.ActionSupport;
import com.trademark.bean.LojaBean;
import com.trademark.bean.MarcaBean;
import com.trademark.dao.PostagemDao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private PostagemDao dao = new PostagemDao();
    private File file;
    private String contentType;
    private String filename;
    private final static String PATH_USER = "/Users/gcorrea/Faculdade/projeto-desenvolvimento/trademark-app/Trademark/WebContent/imagens";
    private Map<Integer, String> marcas = new HashMap<>();
    private Map<Integer, String> lojas = new HashMap<>();
    private int marcaSelecionada;
    private int lojaSelecionada;
    private boolean saved = false;
    private String descricao;
    private String tipoProduto;

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public void setUp() {
        setLojas();
        setMarcas();
    }

    public String open() {
        setUp();

        return SUCCESS;
    }

    public String save() {
        String path = "";
        int idUsuario = 1;

        if (!existeDiretorioParaUsuario()) {
            path = criarDiretorio(idUsuario);
        } else {
            path = PATH_USER + "/" + idUsuario;
        }

        File dest = new File(path, filename);
        file.renameTo(dest);

        setSaved(true);
        System.out.println(dest.getPath());
        dao.inserePostagem(this.descricao, dest.getPath(), this.tipoProduto, this.lojaSelecionada, this.marcaSelecionada);
        return SUCCESS;
    }

    private String criarDiretorio(int idUser) {
        File f = new File(PATH_USER + "/" + idUser);
        f.mkdirs();
        return f.getPath();
    }

    private boolean existeDiretorioParaUsuario() {
        File f = new File(PATH_USER);
        if (f.isDirectory()) {
            return true;
        }
        return false;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(int marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void setLojaSelecionada(int lojaSelecionada) {
        this.lojaSelecionada = lojaSelecionada;
    }

    public int getLojaSelecionada() {
        return lojaSelecionada;
    }

    public Map<Integer, String> getLojas() {
        return lojas;
    }

    private void setLojas() {
        for (LojaBean loja : dao.selecaoLojas()) {
            this.lojas.put(loja.getId(), loja.getNome());
        }
    }

    private void setMarcas() {
        for (MarcaBean marca : dao.selecaoMarcas()) {
            this.marcas.put(marca.getId(), marca.getNome());
        }
    }

    public Map<Integer, String> getMarcas() {
        return marcas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }
}
