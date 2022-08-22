package brief5;

//import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		DaoImp daoimpl = new DaoImp();

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose One : ");
		System.out.println("1: Save");
		System.out.println("2: Read");
		System.out.println("3: UpDate");
		System.out.println("4: Delete");
		int operation = sc.nextInt();

		

		if (operation == 1) {
			System.out.print("Enter your last name :  ");
			String nom = sc.next();
			
			System.out.print("Enter your first name:  ");
			String prenom = sc.next();

			System.out.print("Enter your mail:  ");
			String mail = sc.next();

			System.out.print("Enter your adress:  ");
			String adress = sc.next();

			System.out.print("Enter your city :  ");
			String ville = sc.next();

			System.out.print("Enter your country:  ");
			String pays = sc.next();
			
			Candidats candidat = new Candidats(nom, prenom, mail, adress, ville, pays);
			
			System.out.println(daoimpl.save(candidat));
			
		}else if (operation==2) {
			System.out.print("Enter the candidat ID:  ");
			int id = sc.nextInt();
			System.out.println(daoimpl.getById(id));
		}
		else if (operation == 3) {
			System.out.print("Enter Id of the candidat to be updated :  ");
			int id = sc.nextInt();
			
			System.out.print("Enter your last name :  ");
			String nom = sc.next();
			
			System.out.print("Enter your first name:  ");
			String prenom = sc.next();

			System.out.print("Enter your mail:  ");
			String mail = sc.next();

			System.out.print("Enter your adress:  ");
			String adress = sc.next();

			System.out.print("Enter your city :  ");
			String ville = sc.next();

			System.out.print("Enter your country:  ");
			String pays = sc.next();
			
			Candidats candidat = new Candidats(nom, prenom, mail, adress, ville, pays);

			daoimpl.update(id, candidat);

		} else if (operation == 4) {
			System.out.print("Enter Id of the candidat to be deleted :  ");
			int id = sc.nextInt();
			
			daoimpl.delete(id);
		}

	}

}
