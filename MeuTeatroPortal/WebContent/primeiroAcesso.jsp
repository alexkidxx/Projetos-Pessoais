<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem vindo</title>
</head>
<body>

teste:${email}</br>


<form method="post" action="SetaSenhaServlet">
<input type="hidden" value="${email}" name="email">

Escolha uma senha:</br>
<input type="password" name="senha"></br>
Repita essa senha:</br>
<input type="password" name="senha2"></br>


Ecolha uma pergunta secreta:</br>



<select size="1" name=perguntaSecreta>
<option selected value="Selecione">Selecione a hora do espetáculo</option>
<option value="Qual o nome da sua pré escola?">Qual o nome da sua pré escola?</option>
<option value="Qual o nome do seu primeiro bicho de estimação?">Qual o nome do seu primeiro bicho de estimação?</option>
<option value="Qual o nome do meio do seu pai?">Qual o nome do meio do seu pai?</option>
<option value="Qual o ultimo briquedo que ganhou de natal">Qual o ultimo briquedo que ganhou de natal?</option>
<option value="Qual o seu apelido quando criança?">Qual o seu apelido quando criança?</option>
<option value="Qual o nome de solteira da sua Mãe">Qual o nome de solteira da sua Mãe?</option>
</select>

</br>
Resposta:</br>
<input type="text" name="respostaSecreta">


<input type="submit" value="Enviar">

</form>




</body>
</html>