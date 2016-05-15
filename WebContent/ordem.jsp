<%@page import="br.com.broker.Ordem"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="start.css">
</head>
<body>

<h2>Pagina de Ordem de <%= session.getAttribute("nome") %></h2>

<% Ordem ordem = new Ordem(); %>

<% ServletContext context = session.getServletContext(); %>

<a id="menu" href="menu.jsp">Menu</a>


<form id="logout" action="<%= response.encodeURL("logout") %>" method="post">
	<input type="submit" value="Logout">
</form>


<form action="<%= response.encodeURL("emitir") %>" method="post">
	<input type="radio" name="tipo" value="venda">Venda<br>
	<input type="radio" name="tipo" value="compra">Compra<br>
	<input type="number" step="any" name="preco" placeholder="Digite o Preco da acao"/></br>
	<input type="text" name="codigo_empresa" placeholder="Empresa que quer operar"/></br>
	<input type="number" name="quantidade" placeholder="Quantas acoes"/></br>
	<input type="hidden" name="nome" value="<%= session.getAttribute("nome") %>"><br>
	<input type="submit" value="Submit">
	
</form>



</body>
</html>