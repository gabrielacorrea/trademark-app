package com.trademark.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.trademark.bean.MarcaBean;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File file;
	private String contentType;
	private String filename;
	private final static String PATH_USER = "/opt/Trademark/user";
	private List<MarcaBean> listaMarcas;
	private String marcaSelecionada;
	private boolean saved = false;

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.setContentType(contentType);
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}
	
	public void setUp(){
		List<MarcaBean> marcas = new ArrayList<MarcaBean>();
		setListaMarcas(recuperarListaMarcas(marcas));
	}
	
	public String open(){
		setUp();
				
		return SUCCESS;
	}
	private List<MarcaBean> recuperarListaMarcas(List<MarcaBean> list) {
		
		for(int i=0;i<5;i++){
			MarcaBean mb = new MarcaBean();
			mb.setNome("Marca - "+i);
			list.add(mb);
		}
		return list;
	}

	public String save() {
		String path = "";
		int idUsuario = 1;
		
		if(!existeDiretorioParaUsuario()){
			 path = criarDiretorio(idUsuario);
		}else{
			path = PATH_USER+"/"+idUsuario;
		}
		
		File dest = new File(path, filename);
		file.renameTo(dest);
		
		setUp();
		setSaved(true);
		return SUCCESS;
	}

	private String criarDiretorio(int idUser) {
		File f = new File("/opt/Trademark/user/"+idUser);
		f.mkdirs();
		return f.getPath();
	}

	private boolean existeDiretorioParaUsuario() {
		File f = new File("/opt/Trademark/user");
		if(f.isDirectory()){
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
	
	

}