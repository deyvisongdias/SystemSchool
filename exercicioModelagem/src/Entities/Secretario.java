package Entities;

import static Entities.Professor.disciplinas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Entities.enumeration.Pagamento;
import Entities.enumeration.Status;

public class Secretario extends Usuario {

	private String horario;
	List<Impressao> l = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	public Secretario() {

	}

	public Secretario(String nome, String sexo, Date dataDeNascimento, String horario) {
		super(nome, sexo, dataDeNascimento);
		this.horario = horario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Impressao> getList() {
		return l;
	}

	public void setList(List<Impressao> list) {
		this.l = list;
	}

	@Override
	public String toString() {
		return "Secretario [horario=" + horario + "]";
	}

	// Metodos

	public void manterRegistroDeUsuario() throws ParseException {

		System.out.println("1 para adicionar usuario (aluno ou funcionario) \n 2 para remover usuario");
		int select = sc.nextInt();

		Map<String, Usuario> lista = new HashMap<String, Usuario>();

		if (select == 1) {
			System.out.println("Digite o tipo de usuario a ser adicionado :");
			System.out.println("1-ALUNO\n2-PROFESSOR\n3");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				System.out.println("Digite o nome :");
				String nome = sc.next();
				System.out.println("Digite o sexo");
				String sexo = sc.next();
				System.out.println("Digite a data de nascimento (dd/MM/yyyy):");
				String Data = sc.next();
				Date data = sdf1.parse(Data);
				System.out.println("Digite a matricula :");
				String matricula = sc.next();
				System.out.println("Digite o curso :");
				String curso = sc.next();
				Aluno a = new Aluno(nome, sexo, data, matricula, curso, 50);
				lista.put(nome, a);

			} else {
				System.out.println("Digite o nome :");
				String nome = sc.next();
				System.out.println("Digite o sexo");
				String sexo = sc.next();
				System.out.println("Digite a data de nascimento (dd/MM/yyyy):");
				String Data = sc.next();
				Date data = sdf1.parse(Data);
				System.out.println("Digite a matricula :");
				String matricula = sc.next();
				System.out.println("Digite a unidade :");
				String unidade = sc.next();
				System.out.println("Digite o departamento");
				String departamento = sc.next();

				System.out.println("Digite o numero de disciplinas");
				int num = sc.nextInt();
				int cont = 0;

				Disciplina disp;

				boolean verifica = true;

				List<Disciplina> list = new ArrayList<>();

				while (cont != num) {
					System.out.println("Digite o nome da " + cont + "Discilplina");
					String name = sc.next();
					System.out.println("Digite o codigo da " + cont + "Discilplina");
					String code = sc.next();
					disp = new Disciplina(name, code);

					for (Disciplina disciplina : disciplinas) {

						if (disciplina.getNome() == disp.getNome() && disciplina.getCodigo() == disp.getCodigo()) {
							System.out.println("Disciplina ja ministrada no semestre");
							verifica = false;
						}
					}
					if (verifica == false) {
						cont++;
						list.add(disp);
					}
				}

				Professor prof = new Professor(nome, sexo, data, matricula, unidade, departamento, 0, 200, list);
				lista.put(nome, prof);
			}
		}

		else {
			// remover um Usuario
			System.out.println("Digite o nome do usuario para removelo(a)");
			for (String key : lista.keySet()) {
				System.out.println(lista.toString());
			}
			System.out.println("Digite o nome do usuario para removelo(a)");
			String nome = sc.next();

			for (String key : lista.keySet()) {
				if (key == nome) {
					lista.remove(nome);
				}
			}

		}
	}

	@Override
	public void pedidoImpressao() throws ParseException {

		System.out.println("Digite 1-pedido para professor\n2-pedido para aluno");
		int op = sc.nextInt();

		if (op == 1) {
			int numeroDeCopiasGratuitas = 200;
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
				l.add(i);
			} else {
				int val = numeroDeCopias - numeroDeCopiasGratuitas;
				System.out.println("Digite o tipo de pagamento :(credito/debito/dinheiro)");
				String str = sc.next();
				if (str.equals("cartao")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.CREDITO);
					l.add(i);
				}
				if (str.equals("debito")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.DEBITO);
					l.add(i);
				} else if (str.equals("cartao")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.DINHEIRO);
					l.add(i);
				} else {
					System.out.println("Valor invalido");
				}
			}
		}
		if (op == 2) {
			int numeroDeCopiasGratuitas = 50;
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
				l.add(i);
			} else {
				int val = numeroDeCopias - numeroDeCopiasGratuitas;
				System.out.println("Digite o tipo de pagamento :(credito/debito/dinheiro)");
				String str = sc.next();
				if (str.equals("cartao")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.CREDITO);
					l.add(i);
				}
				if (str.equals("debito")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.DEBITO);
					l.add(i);
				} else if (str.equals("cartao")) {
					Impressao i = new Impressao(new Date(), hora1, arquivos, cor, n, Status.SOLICITADA, val * 0.25,
							Pagamento.DINHEIRO);
					l.add(i);
				} else {
					System.out.println("Valor invalido");
				}
			}
		}

	}

	public void VerificaFilaImpressasao() {
		for (Impressao imp : l) {
			System.out.println(l.toString());
		}

	}

}
