<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Teatro</title>
</head>
<body>
Dados do Teatro:
<form method="post" action="CadastrarTeatroServlet">
Nome:
<input type="text" name="nome"> 
Raz�o social:
<input type="text" name="razaoSocial">
Endere�o:
<input type="text" name="endereco">
cnpj:
<input type="text" name="cnpj">
Cidade:
<input type="text" name="cidade">
UF:
<select size="1" name=uf>

<option selected value="Selecione">Selecione o estado!</option>

<option value="AC">Acre</option>
<option value="AL">Alagoas</option>
<option value="AP">Amap�</option>
<option value="AM">Amazonas</option>
<option value="BA">Bahia</option>
<option value="CE">Cear�</option>
<option value="DF">Distrito Federal</option>
<option value="ES">Esp�rito Santo</option>
<option value="GO">Goi�s</option>
<option value="MA">Maranh�o</option>
<option value="MT">Mato Grosso</option>
<option value="MS">Mato Grosso do Sul</option>
<option value="MG">Minas Gerais</option>
<option value="PA">Par�</option>
<option value="PB">Para�ba</option>
<option value="PR">Paran�</option>
<option value="PE">Pernanbuco</option>
<option value="PI">Piau�</option>
<option value="RJ">Rio de Janeiro</option>
<option value="RN">Rio Grande do Norte</option>
<option value="RS">Rio Grande do Sul</option>
<option value="RO">Rond�nia</option>
<option value="RR">Roraima</option>
<option value="SC">Santa Catarina</option>
<option value="SP">S�o Paulo</option>
<option value="SE">Sergipe</option>
<option value="TO">Tocantins</option>

</select>

Cep:
<input type="text" name="cep">
Telefone:
<input type="text" name="telefone">
Ativo:
<input type="radio" name="ativo" value="ativo">
<input type="radio" name="ativo" value="inativo">
<input type="submit" value="Cadastrar">

</form>
</body>
</html>