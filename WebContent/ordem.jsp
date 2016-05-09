<%@page import="br.com.broker.Ordem"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<body>
<jsp:useBean id="dao" class="br.com.broker.Ordem"/>
<h2>Pagina de Ordem de <%= session.getAttribute("nome") %></h2>

<% Ordem ordem = new Ordem(); %>

<% ServletContext context = session.getServletContext(); %>


<form action="<%= response.encodeURL("emitir") %>" method="post">
	<input type="radio" name="tipo" value="venda">Venda<br>
	<input type="radio" name="tipo" value="compra">Compra<br>
	<input type="number" name="preco" placeholder="Digite o Preco da acao"/></br>
	<input type="text" name="codigo_empresa" placeholder="Empresa que quer operar"/></br>
	<input type="number" name="quantidade" placeholder="Quantas acoes"/></br>
	<input type="hidden" name="nome" value="<%= session.getAttribute("nome") %>"><br>
	<input type="submit" value="Submit">
	
</form>



</body>
</html>