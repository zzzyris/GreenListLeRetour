<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="tableau-clients">
	<tr>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Mail</th>
	</tr>
	<c:forEach var="unClient" items="${clients }">
		<tr>
			<td>${unClient.nom}</td>
			<td>${unClient.prenom}</td>
			<td>${unClient.mail}</td>
		</tr>
	</c:forEach>
</table>