<%@page import="br.com.broker.Ordem"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<body>
<jsp:useBean id="dao" class="br.com.broker.Ordem"/>
<h2>Pagina de Ordem de <%= session.getAttribute("nome") %></h2>

<% Ordem ordem = new Ordem(); %>

<p><%= ordem.setpreco() %></p>

<form action="emitir" method="post">
	<input type="radio" name="tipo" value="venda">Venda<br>
	<input type="radio" name="tipo" value="compra">Compra<br>
	<input type="submit" value="Submit">
</form>


</body>
</html>