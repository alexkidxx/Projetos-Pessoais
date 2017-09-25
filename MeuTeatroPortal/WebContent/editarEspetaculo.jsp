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
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  $( ".selector" ).datepicker({
	  altFormat: "dd-mm-yy"
	});
  
  </script>


<title>Editar espetáculo</title>
</head>
<body>

<form method="get" action="EditarEspetaculoServlet">


<input type="hidden" name="idAntes" value = "${es.idEspetaculo}">
Nome do espetáculo:
<input type="text" name="nomed" value="${es.nomeEspetaculo}" >
Descrição:
<input type="text" name="descricaod" value="${es.descricao }" >
Preço:
<input type="text" name="precod" value="${es.preco}">

<p>Data do evento: <input type="text" id="datepicker" name="dataEventod" value="${es.dataEvento }"></p>

Hora:

<select size="1" name=horad >

<option selected value="${es.horaEvento}">${es.horaEvento}</option>

<option value="00:00">00:00</option>
<option value="00:30">00:30</option>
<option value="01:00">01:00</option>
<option value="01:30">01:30</option>
<option value="02:00">02:00</option>
<option value="02:30">02:30</option>
<option value="03:00">03:00</option>
<option value="03:30">03:30</option>
<option value="04:00">04:00</option>
<option value="04:30">04:30</option>
<option value="05:00">05:00</option>
<option value="05:30">05:30</option>
<option value="06:00">06:00</option>
<option value="06:30">06:30</option>
<option value="07:00">07:00</option>
<option value="07:30">07:30</option>
<option value="08:00">08:00</option>
<option value="08:30">08:30</option>
<option value="09:00">09:00</option>
<option value="09:30">09:30</option>
<option value="10:00">10:00</option>
<option value="10:30">10:30</option>
<option value="11:00">11:00</option>
<option value="11:30">11:30</option>
<option value="12:00">12:00</option>
<option value="12:30">12:30</option>
<option value="13:00">13:00</option>
<option value="13:30">13:30</option>
<option value="14:00">14:00</option>
<option value="14:30">14:30</option>
<option value="15:00">15:00</option>
<option value="15:30">15:30</option>
<option value="16:00">16:00</option>
<option value="16:30">16:30</option>
<option value="17:00">17:00</option>
<option value="17:30">17:30</option>
<option value="18:00">18:00</option>
<option value="18:30">18:30</option>
<option value="19:00">19:00</option>
<option value="19:30">19:30</option>
<option value="20:00">20:00</option>
<option value="20:30">20:30</option>
<option value="21:00">21:00</option>
<option value="21:30">21:30</option>
<option value="22:00">22:00</option>
<option value="22:30">22:30</option>
<option value="23:00">23:00</option>
<option value="23:30">23:30</option>

</select>

Companhia teatral:
<input type="text" name="ciad" value="${es.cia}" >

Classificação:

Livre:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 0}">
<input type="radio" name="classificacaod" value="0" id="0" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="0" id="0">
</c:otherwise>
</c:choose>

10 anos:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 10}">
<input type="radio" name="classificacaod" value="10" id="10" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="10" id="10">
</c:otherwise>
</c:choose>

12 anos:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 12}">
<input type="radio" name="classificacaod" value="12" id="12" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="12" id="12">
</c:otherwise>
</c:choose>

14 anos:
<c:choose>
<c:when test="${es.classificacaoIndicativa eq 14}">
<input type="radio" name="classificacaod" value="14" id="14" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="14" id="14">
</c:otherwise>
</c:choose>

16 anos:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 16}">
<input type="radio" name="classificacaod" value="16" id="16" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="16" id="16">
</c:otherwise>
</c:choose>

18 anos:

<c:choose>
<c:when test="${es.classificacaoIndicativa eq 18}">
<input type="radio" name="classificacaod" value="18" id="18" checked>
</c:when>
<c:otherwise>
<input type="radio" name="classificacaod" value="18" id="18">
</c:otherwise>
</c:choose>


Link externo:
<input type="text" name="linkd" value="${es.link}" >

Imagem:
<img  src="${pageContext.request.contextPath}/img/${es.imagemId}" alt=""/>
<input type="file" name="imgCapad"/>



<input type="submit" value="Submeter edição">

</form>

</body>
</html>