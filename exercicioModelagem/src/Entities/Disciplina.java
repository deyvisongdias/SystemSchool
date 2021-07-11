package Entities;

public class Disciplina {

	private String nome;
	private String codigo;
	private String semestre;

	public Disciplina() {
		super();
	}

	public Disciplina(String nome, String codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", codigo=" + codigo + ", semestre=" + semestre + "]";
	}

	

}
