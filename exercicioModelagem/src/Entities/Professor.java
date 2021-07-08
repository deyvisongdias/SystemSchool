package Entities;

import java.util.Arrays;
import java.util.Date;

public class Professor extends Funcionario {

	private int numCopias;
	private int numCopiasGratuitas;
	private Disciplina disciplina[];

	public Professor() {
		super();
	}

	public Professor(String nome, String sexo, Date dataDeNascimento, String matricula, String unidade,
			String departamento, int numCopias, int numCopiasGratuitas, Disciplina[] disciplina) {
		super(nome, sexo, dataDeNascimento, matricula, unidade, departamento);
		this.numCopias = numCopias;
		this.numCopiasGratuitas = numCopiasGratuitas;
		this.disciplina = disciplina;
	}

	public int getNumCopias() {
		return numCopias;
	}

	public void setNumCopias(int numCopias) {
		this.numCopias = numCopias;
	}

	public int getNumCopiasGratuitas() {
		return numCopiasGratuitas;
	}

	public void setNumCopiasGratuitas(int numCopiasGratuitas) {
		this.numCopiasGratuitas = numCopiasGratuitas;
	}

	public Disciplina[] getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina[] disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Professor [numCopias=" + numCopias + ", numCopiasGratuitas=" + numCopiasGratuitas + ", disciplina="
				+ Arrays.toString(disciplina) +  "]";
	}

}
