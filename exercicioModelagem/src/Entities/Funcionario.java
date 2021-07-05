package Entities;

import java.util.Date;

public class Funcionario extends Usuario{
	
	private String matricula;
	private String unidade;
	private String departamento;
	
	public Funcionario(){
	}
	
	
	
	public Funcionario(String nome, String sexo, Date dataDeNascimento, String matricula, String unidade,
			String departamento) {
		super(nome, sexo, dataDeNascimento);
		this.matricula = matricula;
		this.unidade = unidade;
		this.departamento = departamento;
		super.setIdade(calculaData());
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
		return "Funcionarios [matricula=" + matricula + ", unidade=" + unidade + ", departamento=" + departamento + "]";
	}
	
	

}
