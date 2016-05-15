<%@page import="br.com.broker.*,java.util.*"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="start.css">
</head>
</head>
<body>

<% Relatorio relatorio = new Relatorio(); %>
<% relatorio.setTipo("consolidado"); %>

<h2>P�gina de Relat�rio Consolidado de <%= session.getAttribute("nome") %></h2>
<a id="menu" href="menu.jsp" >Menu</a></br>

<div id="tables1">
<table id="tables">
	<thead><tr><th>CPF</th><th>Codigo da Empresa</th><th>Quantidade</th><th>Preco</th></tr></thead>
	<% 
	   List<Acao> acoes = relatorio.consultar(session);
	   for(Acao acao : acoes){
	%>
	<tr>
		<td><%= acao.getSigla()%></td>
		<td><%= acao.getCodigo_empresa()%></td>
		<td><%= acao.getQuantidade()%></td>
		<td><%= acao.getPreco() %></td>
		
	</tr>
	<% } %>	
</table>
</div>


</body>
</html>