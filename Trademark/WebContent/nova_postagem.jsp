<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"></s:include>

<html>
<head>
    <script src="resources/js/sdk_facebook.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trademark</title>
    <script type="text/javascript">
        $(document).ready(function () {

            if ($('#isSaved').val() == "true") {
                alert("Imagem salva com sucesso!");
            }

        });

        $(document).submit(function () {
            $('#usuarioNome').val($('#nome').val());
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

            if (!$('#tipo').val()) {
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
            switch (ext) {
                case "jpeg" :
                    valid = false;
                    break;
                case "JPEG" :
                    valid = false;
                    break;
                case "jpg" :
                    valid = false;
                    break;
                case "JPG" :
                    valid = false;
                    break;
                case "png" :
                    valid = false;
                    break;
                case "PNG" :
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
</head>
<body style="margin: 35px 15px;">

<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                <small>Adicionar uma postagem</small>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <s:form action="save_postagem" enctype="multipart/form-data" namespace="/" class="form-horizontal">
                <input type="hidden" value="<s:property value='saved'/>" id="isSaved">

                <input type="hidden" name="usuarioNome" id="usuarioNome" value="">
                <input type="hidden" name="usuarioEmail" id="usuarioEmail" value="">

                <div class="form-group">
                    <label for="upload">Escolha uma imagem:</label>
                    <input type="file" name="upload" id="upload">
                </div>

                <div class="form-group">
                    <label for="tipo">Tipo de produto:</label>
                    <select name="tipoSelecionado" id="tipo" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="tipos">
                            <option value="<s:property value="id" />"><s:property value="tipo"/></option>
                        </s:iterator>
                    </select>
                </div>

                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea class="form-control" rows="3" name="descricao" id="descricao"></textarea>
                </div>
                
                <div class="form-group">
                    <label for="preco">Preço:</label>
                    <input class="form-control" type="text" name="preco" id="preco" onkeyup='if (isNaN(this.value)) {this.value = ""}'/>
                </div>

                <div class="form-group">
                    <label for="loja">Loja:</label>
                    <select name="lojaSelecionada" id="loja" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="lojas">
                            <option value="<s:property value="id" />"><s:property value="nome"/></option>
                        </s:iterator>
                    </select>
                </div>

                <div class="form-group">
                    <label for="marca">Marca</label>
                    <select name="marcaSelecionada" id="marca" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="marcas">
                            <option value="<s:property value="id" />"><s:property value="nome"/></option>
                        </s:iterator>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Enviar</button>
            </s:form>
        </div>
    </div>

    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Trademark 2015</p>
            </div>
        </div>
    </footer>

</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>