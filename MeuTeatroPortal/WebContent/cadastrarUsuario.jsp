<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>
</head>
<body>

Dados do Usuario:
<form method="post" action="CadastrarUsuarioServlet">


Nome:
<input type="text" name="nome">
Email:
<input type="text" name="email">


Telefone:
<input type="text" name="telefone">//se o nível de acesso for 0 ou 1, telefone obrigatório// js verifica se o email que será cadastrado já existe



<input type="submit" value="Cadastrar">

</form>



</body>
</html>