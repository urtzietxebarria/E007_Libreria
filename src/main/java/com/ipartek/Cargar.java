package com.ipartek;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.IConstantes;
import com.ipartek.modelo.Nacionalidad;
import com.ipartek.modelo.V_Detalle_Libros;
import com.ipartek.modelo.Autor;
import com.ipartek.modelo.Categoria;

@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements IConstantes {
	private static final long serialVersionUID = 1L;
       
    public Cargar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//CONEXIÓN A BBDD
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		//VISTA_DETALLE_LIBRO
		List<V_Detalle_Libros> listaDetalleLibro = db.ObtenerDetalleLibro(con);
		System.out.println(listaDetalleLibro);
		
		//LIBRO
		List<V_Detalle_Libros> listaLibros = db.obtenerTodosLibros(con);
		System.out.println(listaLibros);
		
		//AUTOR
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		System.out.println(listaAutores);
		
		//NACIONALIDAD
		List<Nacionalidad> listaNacionalidades = db.obtenerTodasNacionalidades(con);
		System.out.println(listaNacionalidades);
		
		//CATEGORIA
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
		System.out.println(listaCategorias);

		//DESCONEXIÓN DE LA BBDD
		db.desconectar(con);
		
		//REQUEST
		request.setAttribute(ATR_LISTA_DETALLE_LIBRO, listaDetalleLibro);
		
		request.setAttribute(ATR_LISTA_LIBROS, listaLibros);
		
		request.setAttribute(ATR_LISTA_AUTORES, listaAutores);
		
		request.setAttribute(ATR_LISTA_NACIONALIDADES, listaNacionalidades);
	
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);


		//REDIRECCIÓN
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
