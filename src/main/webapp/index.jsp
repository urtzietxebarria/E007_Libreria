<%@page import="java.util.Map"%>
<%@page import="com.ipartek.modelo.IConstantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.Autor"%>
<%@page import="com.ipartek.modelo.Libro"%>
<%@page import="com.ipartek.modelo.Categoria"%>
<%@page import="com.ipartek.modelo.Nacionalidad"%>
<%@page import="com.ipartek.modelo.V_Detalle_Libros"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<V_Detalle_Libros> listaLibros = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_LIBROS) != null) {
		listaLibros = (List<V_Detalle_Libros>) request.getAttribute(IConstantes.ATR_LISTA_LIBROS);
	}
	
	List<Autor> listaAutores = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_AUTORES) != null) {
		listaAutores = (List<Autor>) request.getAttribute(IConstantes.ATR_LISTA_AUTORES);
	}
	
	List<Nacionalidad> listaNacionalidades = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_NACIONALIDADES) != null) {
		listaNacionalidades = (List<Nacionalidad>) request.getAttribute(IConstantes.ATR_LISTA_NACIONALIDADES);
	}
	
	List<Categoria> listaCategorias = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_CATEGORIAS) != null) {
		listaCategorias = (List<Categoria>) request.getAttribute(IConstantes.ATR_LISTA_CATEGORIAS);
	}
	
	List<V_Detalle_Libros> listaDetalleLibros = new ArrayList<>();
	if (request.getAttribute(IConstantes.ATR_LISTA_DETALLE_LIBRO) != null) {
		listaDetalleLibros = (List<V_Detalle_Libros>) request.getAttribute(IConstantes.ATR_LISTA_DETALLE_LIBRO);
	}
	
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>LIBRERIA IPARTEK</title>
    <link rel="stylesheet" href="styles/style.css" >
</head>
<body>
    
    <%@include file="includes/cabecera.jsp" %>

   	<%@include file="includes/menu.jsp" %>

    <main>
       <section class="">
			
			<form method="get" action="InsertarLibro">
				
				<!-- ISBN -->
				<label for="p_isbn">ISBN:</label> 
					<input type="text" name="p_isbn" id="p_isbn" maxlength="13" pattern="\d{10}|\d{13}" required><br> 

				<!-- NOM_LIBRO -->					
				<label for="p_nom_libro">NOMBRE LIBRO:</label> 
					<input type="text" name="p_nom_libro" id="p_nom_libro" maxlength="45" pattern="^[a-zA-Z0-9 ;,.\:\-]{1,45}$" required><br>
				
				<!-- STOCK --> 	
				<label for="p_stock">STOCK:</label>
					<input type="text" name="p_stock" id="p_stock" min="0" required><br>
				
				<!-- PRECIO -->
				<label for="p_precio">PRECIO:</label>
					<input type="number" name="p_precio" id="p_precio" min="0" step="0.01" required><br>
					
				<!-- AUTOR -->				
				<label for="p_fk_autor">AUTOR:</label> 
					<select name="p_fk_autor">

						<%
						for (Autor autor : listaAutores) {
						%>
							<option value="<%= autor.getId_autor()%>"><%= autor.getNom_autor() %></option>
						<%
						}
						%>

					</select> 
					
				<!-- NACIONALIDADES -->
				<label for="p_fk_nacionalidad">NACIONALIDAD:</label>
					  	<select name="p_fk_nacionalidad">
						<%
						for (Nacionalidad nacionalidad : listaNacionalidades) {
						%>
							<option value="<%= nacionalidad.getId_nacionalidad()%>"><%= nacionalidad.getNom_pais() %></option>
						<%
						}
						%>

					</select>
					
				<!-- CATEGORIAS -->
				<label for="p_fk_categoria">CATEGORÍA:</label>
					  	<select name="p_fk_categoria">
						<%
						for (Categoria categoria : listaCategorias) {
						%>
							<option value="<%= categoria.getId_categoria()%>"><%= categoria.getNom_categoria() %></option>
						<%
						}
						%>

					</select>
					
				<input type="submit" value="Guardar">

			</form>
	
			<table>
	
				<thead>
	
					<tr>
						<th>ID</th>
						<th>ISBN</th>
						<th>NOMBRE</th>
						<th>AUTOR</th>
						<th>NACIONALIDAD</th>
						<th>CATEGORÍA</th>
						<th>STOCK</th>
						<th>PRECIO</th>
						<th>OPCIONES</th>
					</tr>
	
				</thead>
	
				<tbody>
	
					<%
					for (V_Detalle_Libros detalleLibro : listaDetalleLibros) {
					%>
	
					<tr>
						<th><%=detalleLibro.getId_libro()%></th>
						<th><%=detalleLibro.getISBN()%></th>
						<th><%=detalleLibro.getNom_libro()%></th>
						<th><%=detalleLibro.getNom_autor()%></th>						
						<th><%=detalleLibro.getNacionalidad()%></th>
						<th><%=detalleLibro.getCategoria()%></th>
						<th><%=detalleLibro.getStock()%></th>
						<th><%=detalleLibro.getPrecio()%></th>
						
						<td>
							<a href="FrmModificar?p_id_libro=<%=detalleLibro.getId_libro()%>" class="boton modificar">Modificar</a>
							<a href="BorrarLibro?p_id_libro=<%=detalleLibro.getId_libro()%>" class="boton borrar">Borrar</a>
						</td>
					</tr>
	
					<%
					}
					%>
	
				</tbody>
	
			</table>

		</section>
    </main>

   	<%@include file="includes/pie.jsp" %>

</body>
</html>