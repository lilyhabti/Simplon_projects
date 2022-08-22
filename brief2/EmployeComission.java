package brief2;

public class EmployeComission extends Employee {
	private int vente;
	private double comission;
	public double salaire;
	
	public EmployeComission(String prenom , String nom , String date , double salaire ,int vente , int comission ) {
		super(prenom,nom,date);
		this.vente=vente;
		this.comission=comission;
		this.salaire=salaire;
	}
	public int getVente() {
		return vente;
	}
	public void setVente(int vente) {
		this.vente=vente;
	}
	public double getComission() {
		return comission;
	}
	public void setComission(double comission) {
		this.comission=comission;
	}
	
	public double calculerSalaire() {
		return super.calculerSalaire(salaire) + (this.vente * this.comission); 
	}
    @Override
	public String toString() {
		return super.toString() + "  Salaire fixe : " + super.calculerSalaire(salaire) +  "DHS;  Salaire mensuel : " + calculerSalaire() + "DHS";
	}
}