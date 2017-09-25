<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>
</head>
<body>

Dados do Usuario:
<form method="post" action="CadastrarUsuarioAdmServlet">


Nome:
<input type="text" name="nome">
Email:
<input type="text" name="email">
Teatro pertencente:

<select size="1" name="teatro">
<option selected value="Selecione">Selecione o teatro</option>
<c:forEach items="${listaTeatro}" var="teatro">
<option value="${teatro.idTeatro}">${teatro.nomeTeatro}</option>
</c:forEach>
</select>



Nivel de acesso:

<select size="1" name="nivelDeAcesso">
<option selected value="Selecione">Selecione o nivel de acesso</option>
<option value="0">Administrador</option>
<option value="1">Key User</option>
</select>



Telefone:
<input type="text" name="telefone">//se o nível de acesso for 0 ou 1, telefone obrigatório// js verificar se o email já existe na base

Ativo:
<input type="radio" name="ativo" value="1" label="Ativo">
Inativo:
<input type="radio" name="ativo" value="0" label="Inativo">




<input type="submit" value="Cadastrar">

</form>



</body>
</html>