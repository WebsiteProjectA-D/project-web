package model;

public class MyRdv {
	
	private String date;
	private String heure;
	private String nom;
	private String prenom;
	private String tel_cabinet;
	private String adresse;
	
	public MyRdv(String date, String heure, String nom, String prenom, String tel_cabinet, String adresse) {
		super();
		this.date = date;
		this.heure = heure;
		this.nom = nom;
		this.prenom = prenom;
		this.tel_cabinet = tel_cabinet;
		this.adresse = adresse;
	}
	
	

	public MyRdv() {
		super();
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel_cabinet() {
		return tel_cabinet;
	}

	public void setTel_cabinet(String tel_cabinet) {
		this.tel_cabinet = tel_cabinet;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

}
