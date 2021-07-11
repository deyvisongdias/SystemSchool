package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Secretario;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		Date date = new Date();

		Secretario s = new Secretario("Pedro", "Masculino", date, "15:00");
		s.toString();

		sc.close();

	}

}
