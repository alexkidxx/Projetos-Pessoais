<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu Teatro Portal</title>
</head>
<body>
Bem vindo ao Meu teatro <a href="editarDadosPessoais.jsp">${usuarioLogado.nome}</a></br>,
<a href="Logoff">Logoff</a><br>
Que tal adicionar um usuário?

<a href="cadastrarUsuario.jsp">Cadastrar Usuario</a></br>

<a href="cadastrarEspetaculo.jsp">Cadastrar Espetáculo</a></br>

<c:forEach items="${listaEspetaculo}" var="espetaculo">
<a href="verEspetaculoServlet?id=${espetaculo.idEspetaculo}">${espetaculo.nomeEspetaculo}</a>|${espetaculo.dataEvento}|${espetaculo.horaEvento}|${espetaculo.cia}|${espetaculo.classificacaoIndicativa}|${espetaculo.status} <br>
</c:forEach>


______________________________________________________________________________________________
Usuarios ativos desse teatro:</br>

<c:forEach items="${listaUsuario}" var="user">
	<c:set var="tp" value="${user.teatroPertencente}"/>
	<c:set var="ts" value="${usuario.teatroPertencente}"/>
	<c:set var="emaillogado" value="${usuario.email}"/>
	<c:set var="emaileach"	value="${user.email}"/>
	<c:set var="isativo"	value="${user.ativo}"/>	
	<c:set var="logadoAtivo" value = "${usuario.ativo}"/>
	
	
    <c:if test = "${tp eq ts}">
    <c:if test = "${emaileach ne emaillogado}">
    <c:if test ="${isativo eq logadoAtivo}">
    ${user.nome}|${user.email}|${user.ativo}|${user.telefone}| <a href="mudaStatusServlet?id=${user.id}&status=${user.ativo}">Inativar/Ativar</a></br>
    </c:if>
    </c:if>
    </c:if>
    </c:forEach>




Usuarios inativos desse teatro:</br>
<c:forEach items="${listaUsuario}" var="user">
	<c:set var="tp" value="${user.teatroPertencente}"/>
	<c:set var="ts" value="${usuario.teatroPertencente}"/>
	<c:set var="emaillogado" value="${usuario.email}"/>
	<c:set var="emaileach"	value="${user.email}"/>
	
	
	
    <c:if test = "${tp eq ts}">
    <c:if test = "${emaileach ne emaillogado}">
    
    ${user.nome}|${user.email}|${user.ativo}|${user.telefone}| <a href="mudaStatusServlet?id=${user.id}&status=${user.ativo}">Inativar/Ativar</a></br>
    </c:if>
    </c:if>
   
    </c:forEach>





</body>
</html>