package Entities;

import java.util.Date;

public class Aluno extends Usuario{

	private String matricula;
	private String curso;
	private int numeroDeCopiasGratuitas;
	

	public Aluno() {
		super();
	}


	public Aluno(String nome, String sexo, Date dataDeNascimento,String matricula, String curso,
			int numeroDeCopiasGratuitas) {
		super(nome, sexo, dataDeNascimento);
		this.setIdade(calculaData());
		this.matricula = matricula;
		this.curso = curso;
		this.numeroDeCopiasGratuitas = numeroDeCopiasGratuitas;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", curso=" + curso + "]";
	}

	
}
