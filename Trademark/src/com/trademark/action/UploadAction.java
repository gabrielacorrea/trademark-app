package com.trademark.action;

import com.opensymphony.xwork2.ActionSupport;
import com.trademark.bean.LojaBean;
import com.trademark.bean.MarcaBean;
import com.trademark.bean.TipoVestuarioBean;
import com.trademark.bean.UsuarioBean;
import com.trademark.dao.LojaDAO;
import com.trademark.dao.MarcaDAO;
import com.trademark.dao.PostagemDao;
import com.trademark.dao.TipoVestuarioDAO;

import java.io.File;
import java.util.List;

public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private PostagemDao dao = new PostagemDao();
    private File file;
    private String contentType;
    private String filename;
    private final static String PATH_USER = "/opt/Trademark/user";
    private List<LojaBean> lojas;
    private List<TipoVestuarioBean> tipos;
    private int marcaSelecionada;
    private int lojaSelecionada;
    private int tipoSelecionado;
    private boolean saved = false;
    private String descricao;
    private String tipoProduto;
    private String usuarioNome;
    private String usuarioEmail;

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public List<MarcaBean> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<MarcaBean> marcas) {
        this.marcas = marcas;
    }

    private List<MarcaBean> marcas;

    public List<LojaBean> getLojas() {
        return lojas;
    }

    public void setLojas(List<LojaBean> lojas) {
        this.lojas = lojas;
    }

    public String open() {
        montarSelects();
        return SUCCESS;
    }

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public String save() {
        UsuarioBean usuario = new UsuarioBean();
        usuario.setNome(this.usuarioNome);
        usuario.setEmail(this.usuarioEmail);

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
        dao.inserePostagem(this.descricao, dest.getPath(), this.tipoSelecionado, this.lojaSelecionada, this.marcaSelecionada, usuario);
        return SUCCESS;
    }

    public List<TipoVestuarioBean> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoVestuarioBean> tipos) {
        this.tipos = tipos;
    }

    public void montarSelects() {
        // Monta os combos de pesquisa da tela.
        setMarcas(new MarcaDAO().pesquisarMarcas());
        setTipos(new TipoVestuarioDAO().pesquisarTipoVestuario());
        setLojas(new LojaDAO().pesquisarLojas());
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

    public void setUploadContentType(String contentType) {
        this.setContentType(contentType);
    }

    public void setTipoSelecionado(int tipoSelecionado) {
        this.tipoSelecionado = tipoSelecionado;
    }

    public int getTipoSelecionado() {
        return tipoSelecionado;
    }


}
