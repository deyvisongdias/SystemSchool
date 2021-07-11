package Entities;

import java.util.Date;

import Entities.enumeration.Pagamento;
import Entities.enumeration.Status;

public class Impressao {

	private Date date;
	private String hora;
	private String arquivos;
	private String cor;
	private int numeroDeCopias;
	private Status status;
    private Double custo;
    private Pagamento p;
    

	public Impressao(Date data, String hora, String arquivos, String cor, int numeroDeCopias, Status status,Double custo) {
		super();
		this.date = data;
		this.hora = hora;
		this.arquivos = arquivos;
		this.cor = cor;
		this.numeroDeCopias = numeroDeCopias;
		this.status = status;
		this.custo=custo;
	}
	
	public Impressao(Date data, String hora, String arquivos, String cor, int numeroDeCopias, Status status,Double custo,Pagamento p) {
		super();
		this.date = data;
		this.hora = hora;
		this.arquivos = arquivos;
		this.cor = cor;
		this.numeroDeCopias = numeroDeCopias;
		this.status = status;
		this.custo=custo;
		this.p=p;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
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
	
	

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Impressao [date=" + date + ", hora=" + hora + ", arquivos=" + arquivos + ", cor=" + cor
				+ ", numeroDeCopias=" + numeroDeCopias + ", status=" + status + ", custo=" + custo + ", p=" + p + "]";
	}

	
}
