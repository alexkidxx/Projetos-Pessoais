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
Razão social:
<input type="text" name="razaoSocial">
Endereço:
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
<option value="AP">Amapá</option>
<option value="AM">Amazonas</option>
<option value="BA">Bahia</option>
<option value="CE">Ceará</option>
<option value="DF">Distrito Federal</option>
<option value="ES">Espírito Santo</option>
<option value="GO">Goiás</option>
<option value="MA">Maranhão</option>
<option value="MT">Mato Grosso</option>
<option value="MS">Mato Grosso do Sul</option>
<option value="MG">Minas Gerais</option>
<option value="PA">Pará</option>
<option value="PB">Paraíba</option>
<option value="PR">Paraná</option>
<option value="PE">Pernanbuco</option>
<option value="PI">Piauí</option>
<option value="RJ">Rio de Janeiro</option>
<option value="RN">Rio Grande do Norte</option>
<option value="RS">Rio Grande do Sul</option>
<option value="RO">Rondônia</option>
<option value="RR">Roraima</option>
<option value="SC">Santa Catarina</option>
<option value="SP">São Paulo</option>
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