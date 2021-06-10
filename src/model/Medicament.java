package model;

public class Medicament {
	
	private int id;
	private String nom;
	
	public Medicament(String nom) {
		this.nom = nom;
	}

	public Medicament() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
