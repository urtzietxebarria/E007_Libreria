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

@WebServlet("/InsertarLibro")
public class InsertarLibro extends HttpServlet implements IConstantes{
	private static final long serialVersionUID = 1L;

    public InsertarLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1)RECEPCIÓN DE PARÁMETROS
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
		

		//2)MAQUETAR DATOS A DTO pero en la tabla
		Libro lib = new Libro(0, ISBN, nom_libro, stock, precio, fk_categoria, fk_autor);
		
		
		//3)CONEXIÓN A LA BBDD
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
			
		
		//4)REALIZACIÓN DE LA FUNCIONALIDAD
		db.insertarLibro(lib, con);
		List<V_Detalle_Libros> listaLibros = db.obtenerTodosLibros(con);
		
		
		//5)CIERRE DE CONEXIÓN
		db.desconectar(con);
		
		
		//6)EMPAQUETADO DE DATOS
		request.setAttribute(ATR_DETALLE_LIBRO, listaLibros);
		
		
		//7)REDIRECCIÓN A UNA VISTA
		request.getRequestDispatcher(JSP_CARGAR).forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
