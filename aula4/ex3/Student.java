package aula4.ex3;

import aula1.Data;

public class Student extends Person {

	private int nMec;
	private String courseName;

	public Student(String name, int nCC, Data birthday, int nMec, String courseName) {
		super(name, nCC, birthday);
		this.nMec = nMec;
		this.courseName = courseName;
	}

	public int nMec() {
		return nMec;
	}

	public String courseName() {
		return courseName;
	}

	public String toString() {
		return super.toString()+"Mecanografic Number: "+nMec+", Course: "+courseName;
	}
}
