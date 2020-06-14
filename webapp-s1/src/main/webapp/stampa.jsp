<%@page import="it.dstech.formazione.model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stampa persona</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
<body>
	<br>
	<center>
	<table>
		<tr>
			<div style="text-align: center;">

				<th>id</th>
			<th>Cognome</th>
			<th>Nome</th>
			<th>Eta</th>

			</div>
		</tr>
		<tr>
			<%
				List<Persona> listaPersona = (List<Persona>) request.getAttribute("lista");
			%>
			<%
				for (Persona p : listaPersona) {
			%>
			<td><%=p.getId()%></td>
			<td><%=p.getCognome()%></td>
			<td><%=p.getNome()%></td>
			<td><%=p.getEta()%></td>

		</tr>

		<%
			}
		%>



	</table>
	</center>

	<br>
	<br>
	<form action="ordine">
	<div style="text-align: center;">
		<input type="submit" value="Torna in home">
		</div>
	</form>

</body>


</body>
</html>