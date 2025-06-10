package com.ipartek.modelo;

public interface IConstantes {

////CONSTANTES DE LA BBDD/////////////////////////////////////////////////////////////////////////////////////////////////////////
	String BD = "jsp_libreria_ipartek";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BD;
	String USUARIO = "root";
	String PASS = "1234";
	
	
////CONSTANTES DE LOS JSP/////////////////////////////////////////////////////////////////////////////////////////////////////////
	String JSP_INDEX = "index.jsp";
	String JSP_FRM_MODIFICAR = "frm_modificar.jsp";
	String JSP_CARGAR = "Cargar";
	
	
////CONSTANTES DE LAS TABLAS//////////////////////////////////////////////////////////////////////////////////////////////////////
	//LIBRO
	String TABLA_LIBROS = "libros";
	String LIBROS_ID = "id_libro";
	String LIBROS_ISBN = "ISBN";
	String LIBROS_NOMBRE = "nom_libro";
	String LIBROS_STOCK = "stock";
	String LIBROS_PRECIO = "precio";
	String LIBROS_CATEGORIA = "fk_categoria";
	String LIBROS_AUTOR = "fk_autor";
	
	//AUTOR
	String TABLA_AUTOR = "autor";
	String AUTOR_ID = "id_autor";
	String AUTOR_NOMBRE = "nom_autor";
	String AUTOR_NACIONALIDAD = "nacionalidad";
	String AUTOR_FECHA_NACIMIENTO = "fecha_nacimiento";
	String AUTOR_FECHA_DEFUNCION = "fecha_defuncion";
	String AUTOR_FK_NACIONALIDAD = "fk_nacionalidad";
	
	//NACIONALIDAD
	String TABLA_NACIONALIDAD = "nacionalidad";
	String NACIONALIDAD_ID = "id_nacionalidad";
	String NACIONALIDAD_NOMBRE = "nom_pais";
	
	//CATEGORIA
	String TABLA_CATEGORIA = "categoria";
	String CATEGORIA_ID = "id_categoria";
	String CATEGORIA_NOMBRE = "nom_categoria";
	
	//V_DETALLE_LIBRO
	String VISTA_DETALLE_LIBRO = "v_detalle_libro";
	String VISTA_DETALLE_LIBRO_ID = "id_libro";
	String VISTA_DETALLE_LIBRO_ISBN = "ISBN";
	String VISTA_DETALLE_LIBRO_NOMBRE = "nom_libro";
	String VISTA_DETALLE_LIBROS_STOCK = "stock";
	String VISTA_DETALLE_LIBRO_PRECIO = "precio";
	String VISTA_DETALLE_LIBRO_CATEGORIA = "nom_categoria";
	String VISTA_DETALLE_LIBRO_AUTOR = "nom_autor";
	String VISTA_DETALLE_LIBRO_NACIONALIDAD = "nacionalidad";
	
	
////CONSTANTES DE LA MOCHILA//////////////////////////////////////////////////////////////////////////////////////////////////////
	String ATR_LISTA_LIBROS = "lista_libros";
	String ATR_LIBRO = "atr_libro";
	String ATR_LISTA_AUTORES = "lista_autores";
	String ATR_AUTOR = "atr_autor";
	String ATR_LISTA_NACIONALIDADES = "lista_nacionalidades";
	String ATR_NACIONALIDAD = "atr_nacionalidad";
	String ATR_LISTA_CATEGORIAS = "lista_categorias";
	String ATR_CATEGORIA = "atr_categoria";
	String ATR_LISTA_DETALLE_LIBRO = "lista_detalle_libro";
	String ATR_DETALLE_LIBRO = "atr_detalle_libro";
		
	
////STORED PROCEDURES/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	String SP_OBTENER_TODOS_LIBROS = "call jsp_todos_libros();"; 
	String SP_VISTA_DETALLE_LIBRO= "call jsp_vista_detalle_libros();";
	String SP_OBTENER_TODOS_AUTORES = "call jsp_todos_autores();";
	String SP_OBTENER_TODAS_NACIONALIDADES = "call jsp_todas_nacionalidades()";
	String SP_OBTENER_TODAS_CATEGORIAS = "call jsp_todas_categorias();";
	String SP_INSERTAR_LIBROS = "call jsp_insertar_libro(?,?,?,?,?,?);";
	String SP_BORRAR_LIBROS = "call jsp_borrar_libro_id(?);";
	String SP_OBTENER_LIBRO_POR_ID = "call jsp_obtener_libro_por_id(?);";
	String SP_MODIFICAR_LIBRO = "call jsp_modificar_libro(?,?,?,?,?,?,?);";
	
}