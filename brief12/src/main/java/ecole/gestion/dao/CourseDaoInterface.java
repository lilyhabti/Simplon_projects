package ecole.gestion.dao;

import java.util.List;

import ecole.gestion.entities.Course;

public interface CourseDaoInterface {

	public List<Course> selectAllCourses();// List all courses

	public void insertCourse(Course course);// add an course

	public Course selectCourse(Integer courseId);// retrieve an course

	public void updateCourse(Course course);// update an course

	public boolean deleteCourse(int id);// delete an course
}
