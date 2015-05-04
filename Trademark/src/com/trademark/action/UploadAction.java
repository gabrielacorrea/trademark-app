package com.trademark.action;

import com.opensymphony.xwork2.ActionSupport;
import com.trademark.bean.MarcaBean;
import dao.LojaBean;
import dao.PostagemDao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private File file;
    private String contentType;
    private String filename;
    private final static String PATH_USER = "/Users/gcorrea/Faculdade/projeto-desenvolvimento/trademark-app/Trademark/WebContent/imagens";
    private List<MarcaBean> listaMarcas;
    private String marcaSelecionada;
    private boolean saved = false;
    private Map<Integer, String> lojas = new HashMap<>();
    private String loja;

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadContentType(String contentType) {
        this.setContentType(contentType);
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public void setUp() {
        List<MarcaBean> marcas = new ArrayList<MarcaBean>();
        setListaMarcas(recuperarListaMarcas(marcas));

        setLojas();
    }

    public String open() {
        setUp();

        return SUCCESS;
    }

    private List<MarcaBean> recuperarListaMarcas(List<MarcaBean> list) {

        for (int i = 0; i < 5; i++) {
            MarcaBean mb = new MarcaBean();
            mb.setNome("Marca - " + i);
            list.add(mb);
        }
        return list;
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
        System.out.println("caminho do arquivo: " + dest);

        //dao.inserePostagem();
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

    public List<MarcaBean> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<MarcaBean> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public String getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(String marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getLoja() {
        return loja;
    }

    public Map<Integer, String> getLojas() {
        return lojas;
    }

    public void setLojas() {
        PostagemDao dao = new PostagemDao();

        for (LojaBean loja : dao.selecaoLojas()) {
            System.out.println("loja: " + loja);
            System.out.println("nome: " + loja.getNome());

            this.lojas.put(loja.getId(), loja.getNome());

        }
    }
}
