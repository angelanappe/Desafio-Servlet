<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Calculadora</title>
</head>
<body>
	<main>
	<div class="container">
		<h1>Calculadora</h1>
		<div class="grid">
			<form name="formulario" action="CalculadoraServlet" method="post">
				<div class="field">
					<label for="numero1">Número 1</label>
					<input autocomplete="off" autofocus type="text" id="numero1" name="numero1" required>
				</div>
				<div class="field">
					<label for="numero2">Número 2</label>
					<input autocomplete="off" autofocus type="text" id="numero2" name="numero2" required>
				</div>
				<div class="field">
					<label for="operacion">Operación</label>
					<select id="operacion" name="operacion">
						<option disabled selected value="seleccioneOperacion">Seleccione operación</option>
						<option value="sumar">Sumar</option>
						<option value="restar">Restar</option>
						<option value="dividir">Dividir</option>
						<option value="multiplicar">Multiplicar</option>
						<option value="ordenar">Ordenar</option>
						<option value="parImpar">Par/Impar</option>
					</select>
				</div>
				<div class="actions">
					<input type="submit" value="Calcular">
				</div>
				
				<% if (request.getAttribute("resultado") != null) { %>	
				<div class="field">
					<label id="resultado">
						<h4>Resultado = <%= request.getAttribute("resultado") != null ? request.getAttribute("resultado") : "" %></h4>
					</label>
				</div>
				<% } %>
			</form>
					
		</div>
	</div>
	</main>
</body>
</html>