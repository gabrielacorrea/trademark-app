<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"></s:include>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="resources/js/sdk_facebook.js"></script>
    <title>Trademark</title>
</head>

<body style="margin: 35px 15px;">

<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                <small>Pesquisa de postagens</small>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <s:form action="search_postagens" method="teste" class="form-inline">
                <div class="form-group">
                    <label name="marcaSelecionada" for="marcaSelecionada">Marca</label>
                    <select name="marcaSelecionada" id="marcaSelecionada" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="listaMarcas">
                            <option value="<s:property value="id" />"><s:property value="nome"/></option>
                        </s:iterator>
                    </select>
                </div>
                <div class="form-group">
                    <label name="tipoSelecionado" for="tipoSelecionado">Tipo:</label>
                    <select name="tipoSelecionado" id="tipoSelecionado" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="listaTipoVestuario">
                            <option value="<s:property value="id" />"><s:property value="tipo"/></option>
                        </s:iterator>
                    </select>
                </div>
                <div class="form-group">
                    <label name="lojaSelecionada" for="lojaSelecionada">Loja:</label>
                    <select name="lojaSelecionada" id="lojaSelecionada" class="form-control">
                        <option value="-1">Selecione...</option>
                        <s:iterator value="listaLojas">
                            <option value="<s:property value="id" />"><s:property value="nome"/></option>
                        </s:iterator>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Pesquisar</button>
            </s:form>
        </div>
    </div>

    <div class="row">
        <s:iterator value="postagens">
            <div class="col-md-7">
                <a href="#" class="thumbnail">
                    <img class="img-responsive img-rounded" src="<s:url action="ImageAction">
            <s:param name="imagePath">
            <s:property value="imgPath"/>
            </s:param></s:url>"/>
                </a>
            </div>
            <div class="col-md-5">
                <h3><s:property value="tipoVestuario"/> - <s:property value="marca"/></h3>
                <h4>Pode ser encontrado em <s:property value="loja"/></h4>
                <p>Postado em <s:property value="dataFormatada"/> por <s:property value="postadoPor"/></p>
                <p><s:property value="descricao"/></p>
                <div class="fb-like"
                     data-href="http://www.netshoes.com.br/produto/tenis-asics-gel-nimbus-16-020-0730-978?lid=78%3Arulebanner%3Arc78%3Ac01%3At05%3Ap01%3Ag02%3A7&ppc=1"
                     data-layout="button_count"
                     data-action="like"
                     data-show-faces="true"
                     data-share="true"></div>
            </div>
        </s:iterator>
    </div>

    <div class="row text-center">
        <div class="col-lg-12">
            <ul class="pagination">
                <li>
                    <a href="#">&laquo;</a>
                </li>
                <li class="active">
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>
    <hr>

    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Trademark 2015</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>