package com.ipartek.modelo;

public class Nacionalidad {
	//ATRIBUTOS
	private int id_nacionalidad;
	private String nom_pais;
	
	//CONSTRUCTORES
	public Nacionalidad(int id_nacionalidad, String nom_pais) {
		super();
		this.id_nacionalidad = id_nacionalidad;
		this.nom_pais = nom_pais;
	}
	
	public Nacionalidad() {
		super();
		this.id_nacionalidad = 0;
		this.nom_pais = "";
	}

	//GETTERS & SETTERS
	public int getId_nacionalidad() {
		return id_nacionalidad;
	}

	public void setId_nacionalidad(int id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	public String getNom_pais() {
		return nom_pais;
	}

	public void setNom_pais(String nom_pais) {
		this.nom_pais = nom_pais;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Nacionalidad [id_nacionalidad=" + id_nacionalidad + ", nom_pais=" + nom_pais + "]";
	}
	
	
	
	

}
