package model;

public class Ordonnance {
	
	private int id;
	private String date;
	private int visite_id;
	
	
	public Ordonnance(String date, int visite_id) {
		this.date = date;
		this.visite_id = visite_id;
	}


	public Ordonnance() {
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


	public int getVisite_id() {
		return visite_id;
	}


	public void setVisite_id(int visite_id) {
		this.visite_id = visite_id;
	}
	
	

}
