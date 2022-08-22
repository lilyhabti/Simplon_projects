package brief2;

public class EmployeFixe extends Employee {
	private double salaire;
	
	public EmployeFixe(String prenom , String nom , String date , double salaire) {
		super(prenom,nom,date);
		this.salaire = salaire;
		
	}
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire=salaire;
	}
    
	@Override
	public String toString() {
		return super.toString() + " Salaire Fixe = " + super.calculerSalaire(salaire) + "DHS";
	}
}