package com.lanou3g.study;

public class Company {

	private Teacher teacher;
	private Doctor doctor;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public void work() {
			if (teacher != null) {
				teacher.work();
			}
			if (doctor != null) {
				doctor.work();
			}
	}
	
}
