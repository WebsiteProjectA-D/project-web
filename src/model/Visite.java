package model;

public class Visite {
	
	private int id;
	private String date;
	private String observation;
	private String heure;
	private int cin_medecin;
	
	public Visite(String date, String observation, String heure, int cin_medecin) {
		super();
		this.date = date;
		this.observation = observation;
		this.heure = heure;
		this.cin_medecin = cin_medecin;
	}

	public Visite() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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
	

}
