<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			<h1>Gestor de Procesos Participativos</h1>
		</div>
		<div data-role="content">
			<div data-role="controlgroup" id="buttons-1">
				<a href="AltaProcesoParticipativo.jsp" class="ui-btn ui-corner-all">Crear Proceso Participativo</a>
			</div>
			<form name="listProcesos" id="form-2" action="ListProcesosParticipativos">
			<input type="submit" value="Listar Procesos Participativos" id="button-1" formaction="ListProcesosParticipativos"/>
			</form>
			<label for="search-1"></label>
			<form name="getProceso" id="form-1" action="GetProcesoParticipativo">
				<input name="search-1" id="search-1" data-clear-btn="true" value="" placeholder="Buscar Proceso Participativo" type="search"/>
			</form>
		</div>
		<div data-role="footer">
			<h4>Anthony Mallada - TSE - Práctico 1</h4>
		</div>
	</div>
</body>
</html>