<%@page import="br.com.broker.Conta_Corrente"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="start.css">
</head>
<body>
<h2>Conta Corrente de <%=session.getAttribute("nome") %></h2>

<% Conta_Corrente conta = new Conta_Corrente(); %>


<p>Seu saldo é de R$ <%= conta.consultar_saldo(session.getAttribute("nome").toString())  %></p>

<a href="menu.jsp">Voltar para o menu</a>




</body>
</html>