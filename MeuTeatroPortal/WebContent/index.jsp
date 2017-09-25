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
<body>
   <div><h2>Meu Teatro Portal</h2></div>
        

        
        <form method="post" action="LoginServlet">
            <h5>Email: </h5><input type="text"  name="email" />
            
            <h5> Senha: </h5><input type="password" name="senha"/>
            
            <input type="submit" value="Login" />
        </form>
        <a href="perguntaSecreta.jsp">Esqueceu sua senha?</a>
</body>
</body>
</html>