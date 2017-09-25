<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu Teatro Portal</title>



</script>

</head>
<body>
Bem vindo ao teatro<a href="editarDadosPessoais.jsp">${usuarioLogado.nome}</a></br>
<a href="Logoff">Logoff</a></br>



vamos adicionar um espetáculo<p></p></br>




<a href="cadastrarEspetaculo.jsp">Cadastrar Espetáculo</a></br>



<c:forEach items="${listaEspetaculo}" var="espetaculo">
<a href="verEspetaculoServlet?id=${espetaculo.idEspetaculo}">${espetaculo.nomeEspetaculo}</a>|${espetaculo.dataEvento}|${espetaculo.horaEvento}|${espetaculo.cia}|${espetaculo.classificacaoIndicativa} <br>
</c:forEach>

 
</body>
</html>