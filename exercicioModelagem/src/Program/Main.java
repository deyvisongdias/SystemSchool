package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Usuario;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Scanner sc =new Scanner (System.in);
		Date ano=sdf1.parse("05/04/2000");
		System.out.println(ano);
		
		Usuario deyvison=new Usuario("Deyvison","Masculino demais",ano);
		
		System.out.println(deyvison.toString());
		
		
		sc.close();
		

	}

}
