package com.ipartek.modelo;

public class Libro {
	//ATRIBUTOS
	private int id_libro;
	private String ISBN;
	private String nom_libro;
	private int stock;
	private double precio;
	private int FK_categoria;
	private int FK_autor;
	
	//CONSTRUCTOR
	public Libro(int id_libro, String ISBN, String nom_libro, int stock, double precio, int fk_categoria, int fk_autor) {
		super();
		this.id_libro = id_libro;
		this.ISBN = ISBN;
		this.nom_libro = nom_libro;
		this.stock = stock;
		this.precio = precio;
		this.FK_categoria = fk_categoria;
		this.FK_autor = fk_autor;
	}
	
	public Libro() {
		super();
		this.id_libro = 0;
		this.ISBN = "";
		this.nom_libro = "";
		this.stock = 0;
		this.precio = 0.0;
		this.FK_categoria = 0;
		this.FK_autor = 0;
	}

	//GETTERS & SETTERS
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getNom_libro() {
		return nom_libro;
	}

	public void setNom_libro(String nom_libro) {
		this.nom_libro = nom_libro;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getFK_Categoria() {
		return FK_categoria;
	}

	public void setFK_Categoria(int fk_categoria) {
		this.FK_categoria = fk_categoria;
	}

	public int getFK_autor() {
		return FK_autor;
	}

	public void setFK_autor(int fk_autor) {
		this.FK_autor = fk_autor;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", ISBN=" + ISBN + ", nom_libro=" + nom_libro + ", stock=" + stock
				+ ", precio=" + precio + ", FK_categoria=" + FK_categoria + ", FK_autor=" + FK_autor + "]";
	}	

}
