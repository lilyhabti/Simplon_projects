package ecole.gestion.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
    @Column(name = "studentid", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentid;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "level")
	private String level;
	
	@ManyToMany
	@JoinTable(name = "etudiant_course", joinColumns = @JoinColumn(name = "studentid"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private List<Course> courses = new ArrayList<>();

	public Student() {}

	public Student(Integer studentid, String fullname, String level, List<Course> courses) {
		this.studentid = studentid;
		this.fullname = fullname;
		this.level = level;
		this.courses = courses;
	}
	
	public Student(String fullname, String level, List<Course> courses) {
		this.fullname = fullname;
		this.level = level;
		this.courses = courses;
	}
	public Student(String fullname, String level) {
		this.fullname = fullname;
		this.level = level;
	}
	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", fullname=" + fullname + ", level=" + level + ", courses="
				+ courses + "]";
	}
}
