package Entities;

import java.util.Date;

public class Professor extends Funcionario {

	private String matricula;
	private String unidade;
	private String departamento;

	public Professor() {
		super();
	}

	public Professor(String nome, String sexo, Date dataDeNascimento, String matricula, String unidade,
			String departamento, String matricula2, String unidade2, String departamento2) {
		super(nome, sexo, dataDeNascimento, matricula, unidade, departamento);
		matricula = matricula2;
		unidade = unidade2;
		departamento = departamento2;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + ", unidade=" + unidade + ", departamento=" + departamento + "]";
	}

}
