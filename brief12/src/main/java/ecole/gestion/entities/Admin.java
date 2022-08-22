package ecole.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
    @Column(name = "idadmin", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idadmin;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	public Admin() {
	}

	public Admin(Integer idadmin,String username, String password) {
		this.idadmin = idadmin;
		this.username = username;
		this.password = password;
	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

	

	public Integer getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(Integer idadmin) {
		this.idadmin = idadmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [idadmin=" + idadmin + ", username=" + username + ", password=" + password + "]";
	}
}