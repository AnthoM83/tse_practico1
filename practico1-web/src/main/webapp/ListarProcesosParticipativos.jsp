    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Gestor de Procesos Participativos</title>
</head>
<body>
	<div data-role="page" id="page-1">
		<div data-role="header" id="header-1">
			<a href="index.jsp" class="ui-btn ui-mini ui-btn-inline ui-btn-left ui-corner-all ui-icon-home ui-btn-icon-left">Inicio</a>
			<h1>Listado de Procesos Participativos</h1>
		</div>
		<div data-role="content">
		<c:set var="listNames" value='${requestScope["listNames"] }'/>
		<c:forEach items="${listNames }" var="name">
		<h4>${name }</h4>
		</c:forEach>
		</div>
		<div data-role="footer">
			<h4>Anthony Mallada - TSE - Práctico 1</h4>
		</div>
	</div>
</body>
</html>