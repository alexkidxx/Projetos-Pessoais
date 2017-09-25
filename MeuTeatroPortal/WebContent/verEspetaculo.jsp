<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exibir espetáculo</title>
</head>
<body>
</br>

 </br>
<form method="post" action="EditarEspetaculoServlet">

Nome do espetáculo:
<input type="text" name="nome" value="${es.nomeEspetaculo}" readonly="true">
Descrição:
<input type="text" name="descricao" value="${es.descricao}" readonly="true">
Preço:
<input type="text" name="preco" value="${es.preco}" readonly="true">

Data do evento: <input type="text" name="data" value="${es.dataEvento}" readonly="true">

Hora:
<input type="text" name="hora" value="${es.horaEvento}" readonly="true">

Companhia teatral:
<input type="text" name="cia" value="${es.cia}" readonly="true">

Classificação:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 0}">
<input type="text" name="classificacao" value="Livre" readonly="true">
</c:when>
<c:when test="${es.classificacaoIndicativa eq 10}">
<input type="text" name="classificacao" value="10 anos" readonly="true">
</c:when>
<c:when test="${es.classificacaoIndicativa eq 12}">
<input type="text" name="classificacao" value="12 anos" readonly="true">
</c:when>
<c:when test="${es.classificacaoIndicativa eq 14}">
<input type="text" name="classificacao" value="14 anos" readonly="true">
</c:when>
<c:when test="${es.classificacaoIndicativa eq 16}">
<input type="text" name="classificacao" value="16 anos" readonly="true">
</c:when>
<c:otherwise>
<input type="text" name="classificacao" value="18 anos" readonly="true">
</c:otherwise>

</c:choose>



Link externo:
<input type="text" name="link" value="${es.link}" readonly="true">

Imagem:
<img  src="${pageContext.request.contextPath}/img/${es.imagemId}" alt="""/>

<c:set var="ed" value="editado"/>
<c:set var="stats" value="novo"/>
<c:if test="${es.status eq stats or es.status eq ed}">

<input type="hidden" name="idEspetaculo" value="${es.idEspetaculo}">
<input type="submit" value="Editar">
</c:if>
</form>

<c:set var="stats" value="novo"/>
<c:set var="ed" value="editado"/>
<c:if  test="${usuario.nivelDeAcesso eq 1}">
<c:if test="${es.status eq stats or es.status eq ed}">
<form method="post" action="publicarEspetaculoServlet">
<input type="hidden" name="idEspetaculo" value="${es.idEspetaculo}">

<input type="submit" value ="Publicar espetáculo">
</form>
</c:if>
</c:if>

<c:set var="stats" value="novo"/>
<c:set var="ed" value="editado"/>
<c:if test="${es.status eq stats or es.status eq ed}">

<form method="post" action="ApagarEspetaculoServlet">
<input type="hidden" name="idEspetaculo" value="${es.idEspetaculo}">
<input type="submit" value="Deletar">
</form>
</c:if>


</body>
</html>