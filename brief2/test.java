package brief2;

public class test {

	public static void main(String[] args) {
		System.out.println("Bienvenu dans votre programme salarie :");
		Employee employe1 = new Employee("Fatiha","EL HABTI","7/10/2002");
		System.out.println(employe1.toString());
		EmployeFixe employe2 = new EmployeFixe("Fatiha","EL HABTI","7/10/2002",10000);
		System.out.println(employe2.toString());
		EmployeComission employe3 = new EmployeComission("Fatiha","EL HABTI","7/10/2002",10000,100,30);
		System.out.println(employe3.toString());
		EmployeHoraire employe4 = new EmployeHoraire("Fatiha","EL HABTI","7/10/2002",25.5,125);
		System.out.println(employe4.toString());

	}

}
