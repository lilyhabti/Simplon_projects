package brief2;

public class EmployeHoraire extends Employee {
	private double tauxHoraire;
	private double heurePrestes;
	
	public EmployeHoraire(String prenom , String nom , String date , double tauxHoraire , double heurePrestes) {
		super(prenom,nom,date);
		this.tauxHoraire=tauxHoraire;
		this.heurePrestes=heurePrestes;
	}
	public double getTauxHoraire() {
		return tauxHoraire;
	}
	public void setTauxHoraire(double tauxHoraire) {
		this.tauxHoraire=tauxHoraire;
	}
	public double getHeurePrestes() {
		return heurePrestes;
	}
	public void setHeurePrestes(double heurePrestes) {
		this.heurePrestes=heurePrestes;
	}
	
	public double calculerSalaire() {
		return this.heurePrestes * this.tauxHoraire;
	}
	@Override
	public String toString() {
		return super.toString() + " Salaire mensuel : " + calculerSalaire() + "DHS";
	}
}