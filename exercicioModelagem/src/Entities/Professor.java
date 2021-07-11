package Entities;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Entities.enumeration.Pagamento;
import Entities.enumeration.Status;

public class Professor extends Funcionario {

	private int numCopias;
	private int numeroCopiasGratuitas;

	public static List<Disciplina> disciplinas = new ArrayList<>();
	private List<Disciplina> discip = new ArrayList<>();

	public Professor() {
		super();
	}

	public Professor(String nome, String sexo, Date dataDeNascimento, String matricula, String unidade,
			String departamento, int numCopias, int numCopiasGratuitas, List<Disciplina> discip) {
		super(nome, sexo, dataDeNascimento, matricula, unidade, departamento);
		this.numCopias = numCopias;
		this.numeroCopiasGratuitas = numCopiasGratuitas;
		this.discip = discip;
	}

	public int getNumCopias() {
		return numCopias;
	}

	public static List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static void setDisciplinas(List<Disciplina> disciplinas) {
		Professor.disciplinas = disciplinas;
	}

	public List<Disciplina> getDiscip() {
		return discip;
	}

	public void setDiscip(List<Disciplina> discip) {
		this.discip = discip;
	}

	public void setNumCopias(int numCopias) {
		this.numCopias = numCopias;
	}

	public int getNumCopiasGratuitas() {
		return numeroCopiasGratuitas;
	}

	public void setNumCopiasGratuitas(int numCopiasGratuitas) {
		this.numeroCopiasGratuitas = numCopiasGratuitas;
	}

	@Override
	public String toString() {
		return "Professor [numCopias=" + numCopias + ", numeroCopiasGratuitas=" + numeroCopiasGratuitas + ", discip="
				+ discip + "]";
	}

	@Override
	public void pedidoImpressao() throws ParseException {

		System.out.println("Digite o numero de impressoes :");
		int n = sc.nextInt();
		String hora1 = dtf4.format(LocalDateTime.now());
		System.out.println("Digite os arquivos para impressao");
		String arquivos = sc.next();
		System.out.println("Digite o numero de copias :");
		int numeroDeCopias = sc.nextInt();
		numeroCopiasGratuitas -= n;
		System.out.println("Digite  a cor da impressao :");
		String cor = sc.next();
		System.out.println("Digite a data de entrega :(dd/MM/yyyy)");
		String d = sc.next();
		Date data = sdf1.parse(d);
		System.out.println("Digite a hora de entrega (xx:xx)");
		String hora = sc.next();

		if (numeroDeCopias <= numeroCopiasGratuitas) {
			Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, 0.0);
		} else {
			int val = numeroDeCopias - numeroCopiasGratuitas;
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
