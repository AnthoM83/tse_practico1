<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.ionicframework.com/1.0.0/css/ionic.css" />
	<script src="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js"></script>
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
			<h1>Alta de Proceso Participativo</h1>
		</div>
		<div data-role="content">
		
		<h3>${msg}</h3>

			<form name="ProcesoParticipativoData" id="form-1" action="AddProcesoParticipativo" method="post">
				<label for="text-1">Nombre:</label>
				<input name="name" id="name" data-clear-btn="true" value="" required="true" type="text"/>
				<label for="fechaInicio">Fecha inicio:</label>
				<input name="fechaInicio" id="fechaInicio" data-clear-btn="true" value="" required="true" type="date"/>
				<label for="fechaFin">Fecha Fin:</label>
				<input name="fechaFin" id="fechaFin" data-clear-btn="true" value="" required="true" type="date"/>
				<div class="ui-input-btn ui-btn ui-corner-all">
					Enviar
					<input data-enhanced="true" type="submit" value="Enviar" id="button-1"/>
				</div>
			</form>
		</div>
		<div data-role="footer">
			<h4>Anthony Mallada - TSE - Práctico 1</h4>
		</div>
	</div>

</body>
</html>