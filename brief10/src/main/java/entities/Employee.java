package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @Column(name = "idemployee", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idemployee;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "departement")
	private String departement;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer idemployee, String fullname, String email, String departement) {
		super();
		this.idemployee = idemployee;
		this.fullname = fullname;
		this.email = email;
		this.departement = departement;
	}

	public Employee(String fullname, String email, String departement) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.departement = departement;
	}

	public Integer getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Employee [idemployee=" + idemployee + ", fullname=" + fullname + ", email=" + email + ", departement="
				+ departement + "]";
	}
}