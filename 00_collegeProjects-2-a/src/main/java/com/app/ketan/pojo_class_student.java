package com.app.ketan;

public class pojo_class_student {
	private int roll;
	private String name;
	private String course;
	
	public pojo_class_student(int Roll,String Name,String Course) {
		this.roll=Roll;
		this.name=Name;
		this.course=Course;
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}
}

