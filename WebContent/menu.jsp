<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="start.css">
</head>

<body>


<h1>Bem vindo! <%= session.getAttribute("nome")%></h1>
<form id="logout" action="<%= response.encodeURL("logout") %>" method="post">
	<input type="submit" value="Logout">
</form>



<a href="ordem.jsp">Ordem Nova</a>
<a href="relatorio.jsp">Relatório Individual</a>
<a href="consolidado.jsp">Relatório Consolidado</a>
<a href="saldo_conta.jsp">Consultar Conta Corrente</a>



</body>
</html>