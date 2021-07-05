package Entities;

import java.sql.Date;

import Entities.enumeration.Status;

public class Impressao {

	private int numero;
	private Date date;
	private String hora;
	private String arquivos;
	private int numeroDeCopias;
	private Status status;

	public Impressao() {
		super();
	}

	public Impressao(int numero, Date date, String hora, String arquivos, int numeroDeCopias, Status status) {
		super();
		this.numero = numero;
		this.date = date;
		this.hora = hora;
		this.arquivos = arquivos;
		this.numeroDeCopias = numeroDeCopias;
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getArquivos() {
		return arquivos;
	}

	public void setArquivos(String arquivos) {
		this.arquivos = arquivos;
	}

	public int getNumeroDeCopias() {
		return numeroDeCopias;
	}

	public void setNumeroDeCopias(int numeroDeCopias) {
		this.numeroDeCopias = numeroDeCopias;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Impressao [numero=" + numero + ", date=" + date + ", hora=" + hora + ", arquivos=" + arquivos
				+ ", numeroDeCopias=" + numeroDeCopias + ", status=" + status + "]";
	}

}
