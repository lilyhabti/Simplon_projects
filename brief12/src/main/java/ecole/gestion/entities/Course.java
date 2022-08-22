package ecole.gestion.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "courseid", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseid;

	@Column(name = "coursename")
	private String coursename;

	@Column(name = "description")
	private String description;

	@Column(name = "duration")
	private String duration;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profid")
	private Professor professor;

	@ManyToMany
	@JoinTable(name = "etudiant_course", joinColumns = @JoinColumn(name = "courseid"), inverseJoinColumns = @JoinColumn(name = "studentid"))
	private List<Student> students = new ArrayList<>();

	public Course() {}

	public Course(Integer courseid, String coursename, String description, String duration, Professor professor,
			List<Student> students) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.description = description;
		this.duration = duration;
		this.professor = professor;
		this.students = students;
	}

	public Course(Integer courseid, String coursename, String description, String duration, Professor professor) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.description = description;
		this.duration = duration;
		this.professor = professor;
	}
	
	public Course(String coursename, String description, String duration, Professor professor) {
		this.coursename = coursename;
		this.description = description;
		this.duration = duration;
		this.professor = professor;
	}
	
	public Course(Integer courseid,String coursename, String description, String duration) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.description = description;
		this.duration = duration;
	}

	public Course(String coursename, String description, String duration) {
		this.coursename = coursename;
		this.description = description;
		this.duration = duration;
	}
	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", description=" + description
				+ ", duration=" + duration + ", professor=" + professor + ", students=" + students + "]";
	}
}
