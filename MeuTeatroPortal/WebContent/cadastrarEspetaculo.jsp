<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function() {
    var date = new Date();
    var currentMonth = date.getMonth();
    var currentDate = date.getDate();
    var currentYear = date.getFullYear();
    $('#datepicker').datepicker({
    	dateFormat: 'dd/mm/yy',
    minDate: new Date(currentYear, currentMonth, currentDate)
    });
})
  
 
  </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo espetáculo</title>
</head>
<body>
Cadastro de espetáculo
<form method="post" action="BuscarModeloDeEspetaculoServlet">
Id do espetáculo antigo:
<input type="text" name="idEspetaculo">
<input type="submit" value="Buscar modelo">
</form>

________________________________________________
<form method="post" action="CadastrarEspetaculoServlet" enctype="multipart/form-data">
Nome do espetáculo:
<input type="text" name="nome">
Descrição:
<input type="text" name="descricao">
Preço:
<input type="text" name="preco">

<p>Data do evento: <input type="text" id="datepicker" name="dataEvento"></p>

Hora:
<select size="1" name=hora>

<option selected value="Selecione">Selecione a hora do espetáculo</option>

<option value="00:00:00">00:00</option>
<option value="00:30:00">00:30</option>
<option value="01:00:00">01:00</option>
<option value="01:30:00">01:30</option>
<option value="02:00:00">02:00</option>
<option value="02:30:00">02:30</option>
<option value="03:00:00">03:00</option>
<option value="03:30:00">03:30</option>
<option value="04:00:00">04:00</option>
<option value="04:30:00">04:30</option>
<option value="05:00:00">05:00</option>
<option value="05:30:00">05:30</option>
<option value="06:00:00">06:00</option>
<option value="06:30:00">06:30</option>
<option value="07:00:00">07:00</option>
<option value="07:30:00">07:30</option>
<option value="08:00:00">08:00</option>
<option value="08:30:00">08:30</option>
<option value="09:00:00">09:00</option>
<option value="09:30:00">09:30</option>
<option value="10:00:00">10:00</option>
<option value="10:30:00">10:30</option>
<option value="11:00:00">11:00</option>
<option value="11:30:00">11:30</option>
<option value="12:00:00">12:00</option>
<option value="12:30:00">12:30</option>
<option value="13:00:00">13:00</option>
<option value="13:30:00">13:30</option>
<option value="14:00:00">14:00</option>
<option value="14:30:00">14:30</option>
<option value="15:00:00">15:00</option>
<option value="15:30:00">15:30</option>
<option value="16:00:00">16:00</option>
<option value="16:30:00">16:30</option>
<option value="17:00:00">17:00</option>
<option value="17:30:00">17:30</option>
<option value="18:00:00">18:00</option>
<option value="18:30:00">18:30</option>
<option value="19:00:00">19:00</option>
<option value="19:30:00">19:30</option>
<option value="20:00:00">20:00</option>
<option value="20:30:00">20:30</option>
<option value="21:00:00">21:00</option>
<option value="21:30:00">21:30</option>
<option value="22:00:00">22:00</option>
<option value="22:30:00">22:30</option>
<option value="23:00:00">23:00</option>
<option value="23:30:00">23:30</option>

</select>

Companhia teatral:
<input type="text" name="cia">
Classificação:
Livre:
<input type="radio" name="classificacao" value="0">
10 anos:
<input type="radio" name="classificacao" value="10">
12 anos:
<input type="radio" name="classificacao" value="12">
14 anos:
<input type="radio" name="classificacao" value="14">
16 anos:
<input type="radio" name="classificacao" value="16">
18 anos:
<input type="radio" name="classificacao" value="18">

Link externo:
<input type="text" name="link">

Imagem:
<input type="file" name="imgCapa"/>
<input type="submit" value="Cadastrar">

</form>
</body>
</html>