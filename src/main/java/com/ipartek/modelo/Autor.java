package com.ipartek.modelo;

import java.util.Date;

public class Autor {
	//ATRIBUTOS
	private int id_autor;
	private String nom_autor;
	private Date fecha_nacimiento;
	private Date fecha_defuncion;
	private int FK_nacionalidad;
	
	//CONSTRUCTORES
	public Autor(int id_autor, String nom_autor, Date fecha_nacimiento, Date fecha_defuncion, int fk_nacionalidad) {
		super();
		this.id_autor = id_autor;
		this.nom_autor = nom_autor;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_defuncion = fecha_defuncion;
		this.FK_nacionalidad = fk_nacionalidad;
	}
	
	public Autor() {
		super();
		this.id_autor = 0;
		this.nom_autor = "";
		this.fecha_nacimiento = null;
		this.fecha_defuncion = null;
		this.FK_nacionalidad = 0;
	}

	//GETTERS & SETTERS
	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNom_autor() {
		return nom_autor;
	}

	public void setNom_autor(String nom_autor) {
		this.nom_autor = nom_autor;
	}

	public Date getFechaNacimiento() {
		return fecha_nacimiento;
	}

	public void setFechaNacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public Date getFechaDefuncion() {
		return fecha_defuncion;
	}

	public void setFechaDefuncion(Date fecha_defuncion) {
		this.fecha_defuncion = fecha_defuncion;
	}

	public int getFK_nacionalidad() {
		return FK_nacionalidad;
	}

	public void setFK_nacionalidad(int fk_nacionalidad) {
		FK_nacionalidad = fk_nacionalidad;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nom_autor=" + nom_autor + ", fecha_nacimiento=" + fecha_nacimiento 
				+ ", fecha_defuncion=" + fecha_defuncion + ", FK_nacionalidad=" + FK_nacionalidad + "]";
	}	

}
