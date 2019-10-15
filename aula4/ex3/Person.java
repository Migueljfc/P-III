package aula4.ex3;

import aula1.Data;

public class Person {
	private String name;
	private int nCC;
	private Data birthday;
	private int currentID=100;
	private int nMember;
	private int videosPossession = 0;

	public Person(String name, int nCC, Data birthday) {
		this.name = name;
		this.nCC = nCC;
		this.birthday = birthday;
		this.nMember = currentID++;
	}

	public String name() {
		return name;
	}

	public int nCC() {
		return nCC;
	}

	public Data birthday() {
		return birthday;
	}

	public int nMember() {
		return nMember;
	}

	public int videosPossession() {
		return videosPossession;
	}

	public void checkout() {
		videosPossession += 1;
	}

	public void checkin() {
		videosPossession -= 1;
	}

	@Override
	public String toString() {
		return "Name: "+name+", CC Number: "+nCC+", Birthday: "+birthday+", Member Number: "+nMember;
	}
}
