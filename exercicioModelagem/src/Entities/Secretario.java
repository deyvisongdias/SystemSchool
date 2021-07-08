package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Secretario extends Usuario {

	private String horario;

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

	@Override
	public String toString() {
		return "Secretario [horario=" + horario + "]";
	}

	// Metodos

	public void manterRegistroDeUsuario() throws ParseException {
		
		System.out.println("1 para adicionar usuario (aluno ou funcionario) \n 2 para remover usuario");
		int select=sc.nextInt();
		

		Map<String, Usuario> lista = new HashMap<String, Usuario>();

		if(select==1)
		{
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
			int numCopias = 0;
			int numCopiasGratuitas = 200;
			System.out.println("Digite o numero de disciplinas :");
			int num = sc.nextInt();
			Disciplina[] disciplina = new Disciplina[num];
			if (num == 0) {
				System.out.println("Adicione uma disciplina!!!");
				num = sc.nextInt();
			}
			for (int i = 0; i < num; i++) {
				System.out.println("Digite o nome da " + i + "Discilplina");
				String name = sc.next();
				disciplina[i].setNome(name);
				System.out.println("Digite o codigo da " + i + "Discilplina");
				String code = sc.next();
				disciplina[i].setCodigo(code);
			}
			Professor prof=new Professor(nome,sexo,data,matricula,unidade,
					departamento, numCopias, numCopiasGratuitas,disciplina);
             lista.put(nome,prof);
		}
		}
		
		else {
		//remover um Usuario
		System.out.println("Digite o nome do usuario para removelo(a)");
		for (String key : lista.keySet()) {
			System.out.println(lista.toString());
		}
		System.out.println("Digite o nome do usuario para removelo(a)");
		String nome=sc.next();
		
		for (String key : lista.keySet()) {
			if(key==nome)
			{
				lista.remove(nome);
			}
		}
		
	}
	}

}
