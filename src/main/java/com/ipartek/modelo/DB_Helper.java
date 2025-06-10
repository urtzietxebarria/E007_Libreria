package com.ipartek.modelo;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DB_Helper implements IConstantes{
	
	
	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}
		
		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}


////OBTENER
////OBTENER TODOS LOS LIBROS////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<V_Detalle_Libros> obtenerTodosLibros(Connection con) {
		try {

			List<V_Detalle_Libros> lista = new ArrayList<>();
			//call jsp_todos_libros();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODOS_LIBROS);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				V_Detalle_Libros libro = new V_Detalle_Libros();
				libro.setId_libro(rs.getInt(VISTA_DETALLE_LIBRO_ID));
				libro.setNom_libro(rs.getString(VISTA_DETALLE_LIBRO_NOMBRE));
				libro.setISBN(rs.getString(VISTA_DETALLE_LIBRO_ISBN));
				libro.setStock(rs.getInt(VISTA_DETALLE_LIBROS_STOCK));
				libro.setPrecio(rs.getInt(VISTA_DETALLE_LIBRO_PRECIO));
				libro.setNom_autor(rs.getNString(VISTA_DETALLE_LIBRO_AUTOR));
				libro.setCategoria(rs.getNString(VISTA_DETALLE_LIBRO_CATEGORIA));
				lista.add(libro);

			}

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
	}

	
////OBTENER TODOS LOS AUTORES///////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Autor> obtenerTodosAutores(Connection con) {
		try {

			List<Autor> lista = new ArrayList<Autor>();
			//call jsp_todos_autores();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODOS_AUTORES);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setId_autor(rs.getInt(AUTOR_ID));
				autor.setNom_autor(rs.getString(AUTOR_NOMBRE));
				autor.setFechaNacimiento(rs.getDate(AUTOR_FECHA_NACIMIENTO));
				autor.setFechaDefuncion(rs.getDate(AUTOR_FECHA_DEFUNCION));
				autor.setFK_nacionalidad(rs.getInt(AUTOR_FK_NACIONALIDAD));

				lista.add(autor);

			}

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
	}

	
////OBTENER TODAS LAS NACIONALIDADES////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Nacionalidad> obtenerTodasNacionalidades(Connection con) {
		try {

			List<Nacionalidad> lista = new ArrayList<Nacionalidad>();
			//call jsp_todas_nacionalidades();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODAS_NACIONALIDADES);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setId_nacionalidad(rs.getInt(NACIONALIDAD_ID));
				nacionalidad.setNom_pais(rs.getString(NACIONALIDAD_NOMBRE));
	
				lista.add(nacionalidad);

			}

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
		
	}

	
////OBTENER TODAS LAS CATEGORÍAS////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Categoria> obtenerTodasCategorias(Connection con) {
		try {

			List<Categoria> lista = new ArrayList<Categoria>();
			//call jsp_todas_categorias();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODAS_CATEGORIAS);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				Categoria categoria = new Categoria();
				categoria.setId_categoria(rs.getInt(CATEGORIA_ID));
				categoria.setNom_categoria(rs.getString(CATEGORIA_NOMBRE));

				lista.add(categoria);

			}

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
	}

	
////OBTENER VISTA LIBRO////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<V_Detalle_Libros> ObtenerDetalleLibro(Connection con) {	
		try {

			List<V_Detalle_Libros> lista = new ArrayList<V_Detalle_Libros>();
			//call jsp_vista_detalle_libros();
			CallableStatement cstmt = con.prepareCall(SP_VISTA_DETALLE_LIBRO);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				V_Detalle_Libros detalleLibro = new V_Detalle_Libros();
				
				detalleLibro.setId_libro(rs.getInt(VISTA_DETALLE_LIBRO_ID));
				detalleLibro.setNom_libro(rs.getString(VISTA_DETALLE_LIBRO_NOMBRE));
				detalleLibro.setISBN(rs.getString(VISTA_DETALLE_LIBRO_ISBN));
				detalleLibro.setStock(rs.getInt(VISTA_DETALLE_LIBROS_STOCK));
				detalleLibro.setPrecio(rs.getInt(VISTA_DETALLE_LIBRO_PRECIO));
				detalleLibro.setNom_autor(rs.getString(VISTA_DETALLE_LIBRO_AUTOR));
				detalleLibro.setNacionalidad(rs.getString(VISTA_DETALLE_LIBRO_NACIONALIDAD));
				detalleLibro.setCategoria(rs.getString(VISTA_DETALLE_LIBRO_CATEGORIA));

				lista.add(detalleLibro);

			}

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
		
	}

	
////OBTENER VISTA LIBRO POR ID//////////////////////////////////////////////////////////////////////////////////////////////////////
	public V_Detalle_Libros obtenerLibroPorID(int id_libro, Connection con) {
		
		try {

			//call jsp_obtener_libro_por_id(?);
			V_Detalle_Libros detalleLibro = new V_Detalle_Libros();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_LIBRO_POR_ID);
			cstmt.setInt(1, id_libro);
			cstmt.execute();

			ResultSet rs = cstmt.getResultSet();

			while (rs.next()) {

				detalleLibro.setId_libro(rs.getInt(VISTA_DETALLE_LIBRO_ID));
				detalleLibro.setNom_libro(rs.getString(VISTA_DETALLE_LIBRO_NOMBRE));
				detalleLibro.setISBN(rs.getString(VISTA_DETALLE_LIBRO_ISBN));
				detalleLibro.setStock(rs.getInt(VISTA_DETALLE_LIBROS_STOCK));
				detalleLibro.setPrecio(rs.getInt(VISTA_DETALLE_LIBRO_PRECIO));
				detalleLibro.setNom_autor(rs.getString(VISTA_DETALLE_LIBRO_AUTOR));
				detalleLibro.setNacionalidad(rs.getString(VISTA_DETALLE_LIBRO_NACIONALIDAD));
				detalleLibro.setCategoria(rs.getString(VISTA_DETALLE_LIBRO_CATEGORIA));

			}

			return detalleLibro;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
	}


////INSERTAR
////INSERTAR LIBRO//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertarLibro(Libro libro, Connection con) {
		try {

			//call jsp_libreria_ipartek.jsp_insertar_libro(?,?,?,?,?,?);
			CallableStatement cstmt = con.prepareCall(SP_INSERTAR_LIBROS);

			cstmt.setString(1, libro.getISBN());
			cstmt.setString(2, libro.getNom_libro());
			cstmt.setInt(3, libro.getStock());
			cstmt.setDouble(4, libro.getPrecio());
			cstmt.setInt(5, libro.getFK_autor());
			cstmt.setInt(6, libro.getFK_Categoria());
			
			cstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	}

	
////MODIFICAR
////MODIFICAR LIBRO/////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void modificarLibro(Libro libro, Connection con) {
		
		try {

			//call jsp_modificar_libro(?,?,?,?,?,?,?);
			CallableStatement cstmt = con.prepareCall(SP_MODIFICAR_LIBRO);

			cstmt.setInt(1, libro.getId_libro());
			cstmt.setString(2, libro.getISBN());
			cstmt.setString(3, libro.getNom_libro());
			cstmt.setInt(4, libro.getStock());
			cstmt.setDouble(5, libro.getPrecio());
			cstmt.setInt(6, libro.getFK_autor());
			cstmt.setInt(7, libro.getFK_Categoria());

			cstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
	
	
////BORRAR
////BORRAR LIBRO POR ID/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void borrarPorID(int id_libro, Connection con) {
		try {

			//cal jsp_borrar_libro_id(?);
			CallableStatement cstmt = con.prepareCall(SP_BORRAR_LIBROS);
			cstmt.setInt(1, id_libro);
			cstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	}
	
}
