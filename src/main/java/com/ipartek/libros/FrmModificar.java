package com.ipartek.libros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import com.ipartek.modelo.Autor;
import com.ipartek.modelo.Categoria;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.IConstantes;
import com.ipartek.modelo.Libro;
import com.ipartek.modelo.Nacionalidad;
import com.ipartek.modelo.V_Detalle_Libros;


@WebServlet("/FrmModificar")
public class FrmModificar extends HttpServlet implements IConstantes{
	private static final long serialVersionUID = 1L;
  
    public FrmModificar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)RECEPCIÓN DE PARÁMETROS
		int id_libro = 0;
		if(request.getParameter("p_id_libro")!=null) {
			id_libro =Integer.parseInt(request.getParameter("p_id_libro"));
		}
		
		//3)CONEXIÓN A LA BBDD
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		//4)REALIZACIÓN DE LA FUNCIONALIDAD
		Libro libro = db.obtenerLibroPorID(id_libro, con);
		System.out.println(libro);
		
			//LISTA LIBROS
			List<V_Detalle_Libros> listaLibros = db.obtenerTodosLibros(con);
			System.out.println(listaLibros);
			
			//LISTA AUTORES
			List<Autor> listaAutores = db.obtenerTodosAutores(con);
			System.out.println(listaAutores);
			
			//LISTA CATEGORIAS
			List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
			System.out.println(listaCategorias);
			
			//LISTA NACIONALIDADES
			List<Nacionalidad> listaNacionalidades = db.obtenerTodasNacionalidades(con);
			System.out.println(listaNacionalidades);
		
		//5)CIERRE DE CONEXIÓN
		db.desconectar(con);

		//6)REQUEST (EMPAQUETADO DE DATOS)
		request.setAttribute(ATR_LIBRO, libro);
		
		request.setAttribute(ATR_LISTA_LIBROS, listaLibros);
		
		request.setAttribute(ATR_LISTA_AUTORES, listaAutores);
		
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);

		request.setAttribute(ATR_LISTA_NACIONALIDADES, listaNacionalidades);
		
		//7)REDIRECCIÓN A UNA VISTA
		request.getRequestDispatcher(JSP_FRM_MODIFICAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
