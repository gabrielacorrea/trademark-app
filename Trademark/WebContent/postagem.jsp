<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src='scripts/jquery-1.11.2.min.js'></script>
<script type="text/javascript">
	$(document).ready(function(){
		if($('#isSaved').val() == "true"){
			alert("Imagem salva com sucesso!");
		}
	});

	$(document).submit(function(){
		var validate = true;
		if(!$('#upload').val()){
			validate = false;
			alert("Escolha uma imagem!");
		}else if(invalidExtension($('#upload').val())){
			validate = false;
			alert("Ops!... tipo de arquivo invalido.");
			$('#upload').val("");
		}else if($('#upload')[0].files[0].size > 2097152){
			validate = false;
			alert("Excedeu tamanho maximo permitido(2mb).");
			$('#upload').val("");
		}
		
		return validate;
	});
	
	
function invalidExtension(file){
	var ext = file.replace(/^.*\./, '');
	var valid = true;
	console.log(ext);
	switch(ext){
		case "jpeg" :
			valid = false;
		break;
		case "jpg" :
			valid = false;
		break;
		case "png" :
			valid = false;
		break;
		default:
			valid = true;
		
	}
	return valid;	
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" value="<s:property value='saved'/>" id="isSaved">
	<s:form action="save_postagem" enctype="multipart/form-data">
		<label>Escolha uma imagem:</label>
		<br />
		<input type="file" name="upload" id="upload">
		<br />
		<br />
		<label>Escolha uma marca:</label>
		<br />
		<select name="marcaSelecionada">
			<option>Selecione...</option>
			<s:iterator value="listaMarcas">
				<option><s:property value="nome" /></option>
			</s:iterator>
		</select>
		<br />
		<br />
		<input type="submit" name="sendFile" value="Enviar">
	</s:form>
</body>
</html>