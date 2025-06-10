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
import com.ipartek.modelo.V_Detalle_Libros;

@WebServlet("/BorrarLibro")
public class BorrarLibro extends HttpServlet implements IConstantes{
	private static final long serialVersionUID = 1L;

    public BorrarLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)RECEPCIÓN DE PARÁMETROS
		int id_libro = 0;
		if(request.getParameter("p_id_libro")!=null) {
			id_libro = Integer.parseInt(request.getParameter("p_id_libro"));
		}
		
		
		//3)CONEXIÓN A LA BBDD
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		
		//4)REALIZACIÓN DE LA FUNCIONALIDAD
		db.borrarPorID(id_libro, con);
		List<V_Detalle_Libros>listaLibros = db.obtenerTodosLibros(con);
		
		
		//5)CIERRE DE CONEXIÓN
		db.desconectar(con);
		
		
		//6)EMPAQUETADO DE DATOS
		request.setAttribute(ATR_LISTA_LIBROS, listaLibros);
		
		
		//7)REDIRECCIÓN A UNA VISTA
		request.getRequestDispatcher(JSP_CARGAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
