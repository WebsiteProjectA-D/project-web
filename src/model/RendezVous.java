package model;

public class RendezVous {
	
	private String date;
	private String heure;
	private int cin_medecin;
	private int cin_patient;
	
	public RendezVous(String date, String heure, int cin_medecin, int cin_patient) {
		super();
		this.date = date;
		this.heure = heure;
		this.cin_medecin = cin_medecin;
		this.cin_patient = cin_patient;
	}
	
	

	public RendezVous() {
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

	public int getCin_medecin() {
		return cin_medecin;
	}

	public void setCin_medecin(int cin_medecin) {
		this.cin_medecin = cin_medecin;
	}

	public int getCin_patient() {
		return cin_patient;
	}

	public void setCin_patient(int cin_patient) {
		this.cin_patient = cin_patient;
	}
	
	

}
