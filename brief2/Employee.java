package brief2;

public  class Employee {// abstract redefinition des fonctions abstraites

	       private String nom;
           private String prenom;
           private String date;

           public Employee(String prenom, String nom,String date) {
               this.nom = nom;
               this.prenom = prenom;
               this.date=date;
           }
           
           public Employee() {
			// TODO Auto-generated constructor stub
		}
          

           public String getNom() {
               return nom;
           }
           public void setNom(String nom) {
        	   this.nom=nom;
           }
           public String getPrenom() {
               return prenom;
           }
           public void setPrenom(String prenom) {
        	   this.prenom=prenom;
           }

	       public String getDate() {
		       return date;
	       }

	       public void setDate(String date) {
		       this.date = date;
	       }
	       @Override
	      public String toString() {
			return "Nom : " + nom + "; Prenom : " + prenom + "; Date: " + date;
	      }
	      
	      public  double calculerSalaire(double salaire) {
				return salaire;
			}
	          
}
