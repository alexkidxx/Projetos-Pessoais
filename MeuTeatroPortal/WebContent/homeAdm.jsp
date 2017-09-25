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
Bem vindo a página de administração <a href="editarDadosPessoais.jsp">${usuarioLogado.nome}</a></br><br>
<a href="Logoff">Logoff</a><br>

<a href="cadastrarTeatro.jsp">Cadastro de Teatro:</a>
<a href="cadastrarUsuarioAdm.jsp">Cadastro de Usuarios:</a>


=============================================================</br>
Usuarios Administradores:</br>

<c:forEach items="${listaUsuario}" var="user">
	<c:set var="tp" value="${user.teatroPertencente}"/>
	<c:set var="ts" value="${usuarioLogado.teatroPertencente}"/>
	
	
	<c:if test="${tp eq ts}">  
    ${user.nome}|${user.email}|${user.ativo}|${user.telefone}| <a href="mudaStatusServlet?id=${user.id}&status="inativo">Inativar/Ativar</a><br>
  	 </c:if>
    
</c:forEach>



<c:forEach items="${listaTeatro}" var="t">
<a href="VerTeatroServlet?id=${t.idTeatro}">${t.nomeTeatro}</a>|${t.cidade}|${t.uf}|${t.telefone}</br>
</c:forEach>


</body>
</html>