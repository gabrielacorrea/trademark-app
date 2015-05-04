<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"></s:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            if ($('#isSaved').val() == "true") {
                alert("Imagem salva com sucesso!");
            }
        });

        $(document).submit(function () {
            var validate = true;
            if (!$('#upload').val()) {
                alert("Escolha uma imagem!");
                return false;
            } else if (invalidExtension($('#upload').val())) {
                alert("Ops!... tipo de arquivo invalido.");
                $('#upload').val("");
                return false;
            } else if ($('#upload')[0].files[0].size > 2097152) {
                alert("Excedeu tamanho maximo permitido(2mb).");
                $('#upload').val("");
                return false;
            }

            if(!$('#tipoProduto').val()) {
                alert("O campo tipo de produto é obrigatório e deve ser preenchido.");
                return false;
            } else if (!$('#loja').val()) {
                alert("O campo loja é obrigatório e deve ser preenchido");
                return false;
            } else if (!$('#marca').val()) {
                alert("O campo marca é obrigatório e deve ser preenchido");
                return false;
            }
        });

        function invalidExtension(file) {
            var ext = file.replace(/^.*\./, '');
            var valid = true;
            console.log(ext);
            switch (ext) {
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

        $(function () {
            $("#headerContent").load("header.html");
        });
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<div id="headerContent"></div>

<div class="container">

    <div class="universal-template postagem">
        <input type="hidden" value="<s:property value='saved'/>" id="isSaved">

        <s:form action="save_postagem" enctype="multipart/form-data" namespace="/">
            <h2 class="form-contact-heading">Postar uma oferta</h2>

            <div>
                <h4 class="form-postagem">Escolha uma imagem:</h4>
                <input type="file" class="form-postagem" name="upload" id="upload"/>
            </div>
            <br/>
            <div>
                <h4 class="form-postagem">Tipo de produto:</h4>
                <s:textarea name="tipoProduto" id="tipoProduto"/>
            </div>
            <br>
            <div>
                <h4 class="form-postagem">Descrição:</h4>
                <s:textarea name="descricao"/>
            </div>
            <br>
            <div>
                <h4 class="form-postagem">Loja:</h4>
                <s:select list="lojas" name="lojaSelecionada" id="loja"/>
            </div>
            <br/>
            <div>
                <h4 class="form-postagem">Marca:</h4>
                <s:select list="marcas" name="marcaSelecionada" id="marca"/>
            </div>
            <br/>
            <input type="submit" name="sendFile" value="Enviar">
        </s:form>
    </div>

</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>