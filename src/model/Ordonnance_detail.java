package model;

public class Ordonnance_detail {
	
	private int id;
	private int duration;
	private int quantite;
	private int ordonnance_id;
	private int medicament_id;
	
	public Ordonnance_detail(int duration, int quantite, int ordonnance_id, int medicament_id) {
		this.duration = duration;
		this.quantite = quantite;
		this.ordonnance_id = ordonnance_id;
		this.medicament_id = medicament_id;
	}

	public Ordonnance_detail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getOrdonnance_id() {
		return ordonnance_id;
	}

	public void setOrdonnance_id(int ordonnance_id) {
		this.ordonnance_id = ordonnance_id;
	}

	public int getMedicament_id() {
		return medicament_id;
	}

	public void setMedicament_id(int medicament_id) {
		this.medicament_id = medicament_id;
	}
	
	

}
