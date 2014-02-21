package refactoring;

import java.sql.*;

public class Offering {
	private int id;
	private Course course;
	private String daysTimes;
	

	public Offering(int id, Course course, String daysTimesCsv) {
		this.setId(id);
		this.setCourse(course);
		this.setDaysTimes(daysTimesCsv);
	}


	public String toString() {
		return "Offering " + getId() + ": " + getCourse() + " meeting " + getDaysTimes();
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Course getCourse() {
		return course;
	}




	public void setCourse(Course course) {
		this.course = course;
	}




	public String getDaysTimes() {
		return daysTimes;
	}




	public void setDaysTimes(String daysTimes) {
		this.daysTimes = daysTimes;
	}
}