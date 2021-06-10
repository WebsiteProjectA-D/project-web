package model;

public class Medecin {
	
	private int CIN;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String Email;
	private String password;
	private String Tel;
	private int Age;
	private String sexe;
	private String Adresse;
	private String tel_cabinet;
	private String specialite_id;
	private String region_id;
	
	public Medecin(int cin, String nom, String prenom, String dateNaissance, String email, String password, String tel,
			int age, String sexe, String adresse, String tel_cabinet, String specialite_id, String region_id) {
		super();
		this.CIN = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.Email = email;
		this.password = password;
		this.Tel = tel;
		this.Age = age;
		this.sexe = sexe;
		this.Adresse = adresse;
		this.tel_cabinet = tel_cabinet;
		this.specialite_id = specialite_id;
		this.region_id = region_id;
	}

	public Medecin() {
		super();
	}

	public int getCIN() {
		return CIN;
	}

	public void setCIN(int cIN) {
		CIN = cIN;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getTel_cabinet() {
		return tel_cabinet;
	}

	public void setTel_cabinet(String tel_cabinet) {
		this.tel_cabinet = tel_cabinet;
	}

	public String getSpecialite_id() {
		return specialite_id;
	}

	public void setSpecialite_id(String specialite_id) {
		this.specialite_id = specialite_id;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	
	
	
	
	
	
	
	
	
	

}
