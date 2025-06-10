package com.ipartek.modelo;

public class V_Detalle_Libros extends Libro{
	//ATRIBUTOS 
	private String nom_autor;  
	private String nacionalidad;
	private String categoria;
	
	//CONSTRUCTOR
	public V_Detalle_Libros(int id_libro, String ISBN, String nom_libro, int stock, double precio, int fk_categoria,
			int fk_autor, String nom_autor, String nacionalidad, String categoria) {
		super(id_libro, ISBN, nom_libro, stock, precio, fk_categoria, fk_autor);
		this.nom_autor = nom_autor;
		this.nacionalidad = nacionalidad;
		this.categoria = categoria;
	}
	
	public V_Detalle_Libros() {
		super();
		this.nom_autor = "";
		this.nacionalidad = "";
		this.categoria = "";
	}

	//GETTERS & SETTERS
	public String getNom_autor() {
		return nom_autor;
	}

	public void setNom_autor(String nom_autor) {
		this.nom_autor = nom_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "V_Detalle_Libros [nom_autor=" + nom_autor + ", nacionalidad=" + nacionalidad + ", categoria="
				+ categoria + ", toString()=" + super.toString() + "]";
	}


	//TO STRING
//	@Override
//	public String toString() {
//		return "V_Detalle_Libros [nom_autor=" + nom_autor + ", nacionalidad=" + nacionalidad + ", categoria="
//				+ categoria + "]";
//	}
	
	

}
