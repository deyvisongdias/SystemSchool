package Entities;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

import Entities.enumeration.Pagamento;
import Entities.enumeration.Status;

public class Aluno extends Usuario {

	private String matricula;
	private String curso;
	private int numeroDeCopiasGratuitas;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String sexo, Date dataDeNascimento, String matricula, String curso,
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

	// Metodos

	@Override
	public void pedidoImpressao() throws ParseException {

		System.out.println("Digite o numero de impressoes :");
		int n = sc.nextInt();
		String hora1 = dtf4.format(LocalDateTime.now());
		System.out.println("Digite os arquivos para impressao");
		String arquivos = sc.next();
		System.out.println("Digite o numero de copias :");
		int numeroDeCopias = sc.nextInt();
		numeroDeCopiasGratuitas -= n;
		System.out.println("Digite  a cor da impressao :");
		String cor = sc.next();
		System.out.println("Digite a data de entrega :(dd/MM/yyyy)");
		String d = sc.next();
		Date data = sdf1.parse(d);
		System.out.println("Digite a hora de entrega (xx:xx)");
		String hora = sc.next();

		if (numeroDeCopias <= numeroDeCopiasGratuitas) {
			Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, 0.0);
		} else {
			int val = numeroDeCopias - numeroDeCopiasGratuitas;
			System.out.println("Digite o tipo de pagamento :(credito/debito/dinheiro)");
			String str = sc.next();
			if (str.equals("cartao")) {
				Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
						Pagamento.CREDITO);
			}
			if (str.equals("debito")) {
				Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
						Pagamento.DEBITO);
			} else if (str.equals("cartao")) {
				Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
						Pagamento.DINHEIRO);
			} else {
				System.out.println("Valor invalido");
			}
		}
	}

}
