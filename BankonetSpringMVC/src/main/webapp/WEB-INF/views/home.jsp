<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ page session="false" %>


<html>
	<head>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
		<link rel="stylesheet" type="text/css" href="/BankonetSpringMVC/resources/css/styles.css">
		
		<title><spring:message code="page.home.title"/></title>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<span class="navbar-brand text-uppercase">Bankonet Spring MVC</span>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/BankonetSpringMVC/?lang=fr">FR</a></li>
						<li><a href="/BankonetSpringMVC/?lang=en">EN</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container" style="margin-top:40px">
			<h1>
				Bankonet Spring MVC : <spring:message code="page.home.subtitle"/>  
			</h1>			
			
			<spring:message code="page.home.delete" var="deleteMessage"/>
			<spring:message code="page.home.edit" var="editMessage"/>
			
			
			<div class="container" style="border:1px dotted black;padding:15px; margin-bottom:15px">
				<f:form method="POST" action="/BankonetSpringMVC/addClient" modelAttribute="newClient">
					<div class="form-group">
						<label>ID client :</label>
						<f:hidden path="id"/>${newClient.id}
					</div>
					<div class="form-group">
						<label><spring:message code="page.home.name"/> :</label>
						<f:input path="nom" type="text" value="${newClient.nom}"/>
						<f:errors path="nom" class="alert alert-danger" style="padding:5px"/>
					</div>
					<div class="form-group">
						<label><spring:message code="page.home.firstname"/> :</label>
						<f:input path="prenom" type="text"/>
						<f:errors path="prenom" class="alert alert-danger" style="padding:5px"/>
			    	</div>
					<div class="form-group">
						<label><spring:message code="page.home.login"/> :</label>
						<f:input path="login" type="text"/>
						<f:errors path="login" class="alert alert-danger" style="padding:5px"/>
			    	</div>
					<div class="form-group">
						<label><spring:message code="page.home.password"/> :</label>
						<f:input path="mdp" type="text"/>
						<f:errors path="mdp" class="alert alert-danger" style="padding:5px"/>
			    	</div>
			    	<div>
						<input class="btn btn-primary" type="submit" value="Ajouter cet employé"></button>
					</div>
				</f:form>
			</div>
			
			
			<c:if test="${actionPerformed != 'none'}">
				<div class="container alert alert-success">
					<spring:message code="page.home.clientPrefix"/>
					${idClient}
					<c:if test="${actionPerformed == 'added'}">
						<spring:message code="page.home.clientAddedSuffix"/>
					</c:if>
					<c:if test="${actionPerformed == 'updated'}">
						<spring:message code="page.home.clientUpdatedSuffix"/>
					</c:if>
					<c:if test="${actionPerformed == 'deleted'}">
						<spring:message code="page.home.clientDeletedSuffix"/>
					</c:if>
				</div>
			</c:if>
			
			<div class="container" style="border:1px dotted black; padding:15px; margin-top:15px;">
				<table class="table table-bordered">
					<tr style="height:50px;background-color:LightGrey">
						<th>ID Client</th>
						<th><spring:message code="page.home.name"/></th>
						<th><spring:message code="page.home.firstname"/></th>
						<th><spring:message code="page.home.login"/></th>
						<th><spring:message code="page.home.password"/></th>
					</tr>
					<c:forEach var="client" items="${clients}">
						<tr>
							<td>${client.id}</td>
							<td>${client.nom}</td>
							<td>${client.prenom}</td>
							<td>${client.login}</td>
							<td>${client.mdp}</td>
							<td class="text-center"><a href="/BankonetSpringMVC/deleteClient/?idClient=${client.id}"><input class="btn btn-primary" type="button" value="${deleteMessage}"/></a></td>
							<td class="text-center"><a href="/BankonetSpringMVC/editClient/${client.id}"><input class="btn btn-primary" type="button" value="${editMessage}"/></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>
