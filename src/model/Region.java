package model;

public class Region {
	
	private int id;
	private String nom;
	
	public Region(String nom) {
		this.nom = nom;
	}

	public Region() {
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