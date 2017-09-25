<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty perguntaSecreta}">
Esqueceu sua senha?</br>
Informe seu email para ter acesso a sua pergunta secreta.
<form method="post" action="RedefinirSenhaServlet">
<input type="text" name="email">
<input type="submit"  value="Enviar">
</form>
</c:if>
<a href="index.jsp">Home</a>
</br>
<c:if test="${not empty perguntaSecreta}">
<form method = "post" action="ResponderPerguntaSecretaServlet">
Responda a pergunta:
${perguntaSecreta}
<input type="hidden" name="email" value="${email}"> 

<input type="text" name="respostaSecretaDoUser">
<input type="submit"  value="Enviar resposta">
</form>
</c:if>


</body>
</html>