package aula4.ex1;

import java.util.ArrayList;
import java.util.List;

import aula3.Estudantes.Student;

public class Disciplina {
	private String nome;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private List<Student> alunos;
	
	public Disciplina(String nome,String areaCientifica,int ects,Professor responsavel) {
		this.nome = nome;
		this.areaCientifica = areaCientifica;
		this.ects = ects;
		this.responsavel = responsavel;
		this.alunos = new ArrayList<>();
	}
	
	public boolean addAluno(Student est) {
		if(alunos.contains(est)) {
			return false;
		}
		alunos.add(est);
		return true;	
	}
	
	public boolean delAluno(int nMec) {
		for(Student a: alunos.toArray(new Student[0])) {
			if(a.getnMec()==nMec) {
				alunos.remove(a);
				return true;
			}	
		}
	return false;
	}
	
	public boolean alunoInscrito(int nMec) {
		for(Student a: alunos.toArray(new Student[0])) {
			if(a.getnMec()==nMec) {
				return true;
			}	
		}
	return false;
	}
	
	public int numAlunos() {
		return alunos.size();
	}
	
	@Override
	public String toString() {
		return "Disciplina: " + nome + "(" + ects + ") , da area de " + areaCientifica + "\n" + responsavel ;
	}
	
	public Student[] getAlunos() {
		return alunos.toArray(new Student[0]);
	}
	public Student[] getAlunos(String tipo) {
		List<Student> alunosTipo = new ArrayList<>();
		for(Student a: alunos.toArray(new Student[0])) {
			if(a.getClass().toString().contains(tipo)) {
				alunosTipo.add(a);
			}
		}
		return alunosTipo.toArray(new Student[0]);
	}
	
	
	
}
