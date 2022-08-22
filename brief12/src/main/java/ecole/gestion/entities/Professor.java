package ecole.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
    @Column(name = "profid", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profid;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "departement")
	private String departement;

	public Professor() {}

	public Professor(Integer profid, String fullname, String departement) {
		super();
		this.profid = profid;
		this.fullname = fullname;
		this.departement = departement;
	}

	public Professor(String fullname, String departement) {
		super();
		this.fullname = fullname;
		this.departement = departement;
	}

	public Integer getProfid() {
		return profid;
	}

	public void setProfid(Integer profid) {
		this.profid = profid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Professor [profid=" + profid + ", fullname=" + fullname + ", departement=" + departement + "]";
	}
}
