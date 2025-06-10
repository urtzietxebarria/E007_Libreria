<%@page import="com.ipartek.modelo.V_Detalle_Libros"%>
<%@page import="com.ipartek.modelo.Autor"%>
<%@page import="com.ipartek.modelo.Nacionalidad"%>
<%@page import="com.ipartek.modelo.Categoria"%>
<%@page import="com.ipartek.modelo.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.modelo.IConstantes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	List<Autor> listaAutores = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_AUTORES) != null) {
		listaAutores = (List<Autor>) request.getAttribute(IConstantes.ATR_LISTA_AUTORES);
	}
	
	List<Categoria> listaCategorias = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_CATEGORIAS) != null) {
		listaCategorias = (List<Categoria>) request.getAttribute(IConstantes.ATR_LISTA_CATEGORIAS);
	}
	
	List<Nacionalidad> listaNacionalidades = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_NACIONALIDADES) != null) {
		listaNacionalidades = (List<Nacionalidad>) request.getAttribute(IConstantes.ATR_LISTA_NACIONALIDADES);
	}
	
	Libro libro = new Libro();
	if(request.getAttribute(IConstantes.ATR_LIBRO) != null){
		libro = (Libro)request.getAttribute(IConstantes.ATR_LIBRO);
	}		
%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>MODIFICAR LIBROS</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>

	<main>

		<%@include file="includes/cabecera.jsp"%>

		<%@include file="includes/menu.jsp"%>

		<section class="">

			<form method="get" action="ModificarLibro">
			
				<!-- ID_LIBRO -->
				<label for="p_id_libro">ID:</label> 
				<input type="number" name="p_id_libro" id="p_id_libro" value="<%=libro.getId_libro()%>" required readonly><br>

				<!-- ISBN -->
				<label for="p_isbn">ISBN:</label> 
				<input type="text" name="p_isbn" id="p_isbn" value="<%=libro.getISBN()%>" maxlength="13" pattern="\d{10}|\d{13}" required readonly><br> 
			
				<!-- NOM_LIBRO -->
				<label for="p_nom_libro">NOMBRE LIBRO:</label> 
				<input type="text" name="p_nom_libro" id="p_nom_libro" value="<%=libro.getNom_libro()%>" maxlength="45" required><br>
			
				<!-- STOCK -->
				<label for="p_stock">STOCK:</label> 
				<input type="number" name="p_stock" id="p_stock" value="<%=libro.getStock()%>" min="0" required><br>
			
				<!-- PRECIO -->
				<label for="p_precio">PRECIO:</label> 
				<input type="number" name="p_precio" id="p_precio" value="<%=libro.getPrecio()%>" min="0" step="0.01" required><br> 
			
				<!-- AUTOR -->
				<label for="p_fk_autor">AUTOR:</label>
				<select name="p_fk_autor" id="p_fk_autor">
					<% for (Autor autor : listaAutores) { %>
						<option value="<%=autor.getId_autor()%>" <%= (autor.getId_autor() == libro.getFK_autor()) ? "selected" : "" %>><%=autor.getNom_autor()%></option>
					<% } %>
				</select> 
				
				<!-- NACIONALIDAD-->
				<label for="p_fk_nacionalidad">NACIONALIDAD:</label>
				<select name="p_fk_nacionalidad" id="p_fk_nacionalidad">
					<% int fk_nacionalidad = 0; %>
					<% for (Nacionalidad nacionalidad : listaNacionalidades) { %>
						<option value="<%=nacionalidad.getId_nacionalidad()%>" <%= (nacionalidad.getId_nacionalidad() == fk_nacionalidad) ? "selected" : "" %>><%=nacionalidad.getNom_pais()%></option>
					<% } %>
				</select>
			
				<!-- CATEGORÍA -->
				<label for="p_fk_categoria">CATEGORÍA:</label> 
				<select name="p_fk_categoria" id="p_fk_categoria">
					<% for (Categoria categoria : listaCategorias) { %>
						<option value="<%=categoria.getId_categoria()%>" <%= (categoria.getId_categoria() == libro.getFK_Categoria()) ? "selected" : "" %>><%=categoria.getNom_categoria()%></option>
					<% } %>
				</select> 
				
				<input type="submit" value="Guardar">
				
			</form>

		</section>
		
	</main>

	<%@include file="includes/pie.jsp"%>

</body>
</html>