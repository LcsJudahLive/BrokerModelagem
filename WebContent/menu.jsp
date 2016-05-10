<html>
<body>
<% 
   String user = null;
   Cookie[] cookies = request.getCookies();
   for(Cookie cookie : cookies){
	   if(cookie.getName().equals("user")) user = cookie.getValue();
   }
%>

<h1>Bem vindo! <%= user%></h1>


<a href="ordem.jsp">Ordem Nova</a>
<a href="relatorio.jsp">Relatório</a>
<a href="conta.jsp">Consultar Conta Corrente</a>


<form action="<%= response.encodeURL("logout") %>" method="post">
	<input type="submit" value="Logout">
</form>





</body>
</html>