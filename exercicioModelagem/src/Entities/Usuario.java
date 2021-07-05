package Entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Usuario {

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	private String nome;
	private String sexo;
	private Date dataDeNascimento;
	private int idade;

	public Usuario() {

	}

	public Usuario(String nome, String sexo, Date dataDeNascimento) {
	
		this.nome = nome;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = calculaData();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Secretario [nome=" + nome + ", sexo=" + sexo + ", dataDeNascimento=" + dataDeNascimento + ", idade="
				+ idade + "]";
	}

	public int calculaData()
	{
		
		Date dataAtual=new Date();
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(getDataDeNascimento());
		int dia=cal.get(Calendar.DAY_OF_MONTH);
		int mes=1+cal.get(Calendar.MONTH);
		int ano=cal.get(Calendar.YEAR);
		
		
		Calendar cal2=Calendar.getInstance();
		cal2.setTime(dataAtual);
		int dia2=cal2.get(Calendar.DAY_OF_MONTH);
		int mes2=1+cal2.get(Calendar.MONTH);
		int ano2=cal2.get(Calendar.YEAR);
		
		int yearsOld=ano2-ano;
		System.out.println(yearsOld);
		if(mes>=mes2  && dia>=dia2)
		{
			yearsOld++;
		}
		else {
			yearsOld--;
		}
		
		return yearsOld;
	}
}
