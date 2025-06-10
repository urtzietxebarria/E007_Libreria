package com.ipartek.libros;

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
import com.ipartek.modelo.Libro;
import com.ipartek.modelo.V_Detalle_Libros;


@WebServlet("/ModificarLibro")
public class ModificarLibro extends HttpServlet implements IConstantes{
	private static final long serialVersionUID = 1L;

    public ModificarLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)RECEPCIÓN DE PARÁMETROS
		int id_libro = 0;
		if(request.getParameter("p_id_libro")!=null) {
			id_libro = Integer.parseInt(request.getParameter("p_id_libro"));
		}
		
		String ISBN = "";
		if(request.getParameter("p_isbn")!=null) {
			ISBN = request.getParameter("p_isbn");
		}
		
		String nom_libro = "";
		if(request.getParameter("p_nom_libro")!=null) {
			nom_libro = request.getParameter("p_nom_libro");
		}
		
		int stock = 0;
		if(request.getParameter("p_stock")!=null) {
			stock = Integer.parseInt(request.getParameter("p_stock"));
		}
		
		double precio = 0.0;
		if(request.getParameter("p_precio")!=null) {
			precio = Double.parseDouble(request.getParameter("p_precio"));
		}
		
		int fk_categoria = 0;
		if(request.getParameter("p_fk_categoria")!=null) {
			fk_categoria = Integer.parseInt(request.getParameter("p_fk_categoria"));
		}
		
		int fk_autor = 0;
		if(request.getParameter("p_fk_autor")!=null) {
			fk_autor = Integer.parseInt(request.getParameter("p_fk_autor"));
		}
				
		//2)MAQUETAR DATOS A DTO
		Libro libro = new Libro(id_libro, ISBN, nom_libro, stock, precio, fk_categoria, fk_autor);
		
		//3)CONEXIÓN A LA BBDD
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();

		//4)REALIZACIÓN DE LA FUNCIONALIDAD
		db.modificarLibro(libro, con);
		System.out.println("ID libro " + id_libro);

			//VISTA LIBRO
			List<V_Detalle_Libros> listaLibros = db.obtenerTodosLibros(con);
			System.out.println(listaLibros);
		
		//5)CIERRE DE CONEXIÓN
		db.desconectar(con);
		
		//6)REQUEST (EMPAQUETADO DE DATOS)	
		request.setAttribute(ATR_LISTA_DETALLE_LIBRO, listaLibros);
		
		//7)REDIRECCIÓN A UNA VISTA
		request.getRequestDispatcher(JSP_CARGAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
