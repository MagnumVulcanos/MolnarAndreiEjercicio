import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Scanner;

public class TestDateJunit {

	public static void main(String[] args) {
		// dateTestSinJunit();
		dateTestConJunit();
	}

	public static void dateTestSinJunit() {
		Scanner sc = new Scanner(System.in);
		int d, m, y;

		System.out.println("Introduce fecha: ");
		System.out.print("dia: ");
		d = sc.nextInt();
		System.out.print("mes: ");
		m = sc.nextInt();
		System.out.print("año: ");
		y = sc.nextInt();

		Date date = new Date(d, m, y);

		System.out.println("FECHA: " + date.toString());

		System.out.println(date.isCorrectDateToString());

		sc.close();
	}

	@Test
	public static void dateTestConJunit() {
		try {
			// caso de prueba valido para isCorrectDate
				Date fechaValidador = new Date(12, 5, 1995);
			assertEquals(fechaValidador.isCorrectDate(), true);

			// casos de prueba invalidos para isCorrectDate
				Date fechaDia = new Date(32, 5, 1995);
			assertEquals(fechaDia.isCorrectDate(), false);
				Date fechaMes = new Date(12, 13, 1995);
			assertEquals(fechaMes.isCorrectDate(), false);
				Date fechaNegativoDia = new Date(-2, 5, 1995);
			assertEquals(fechaNegativoDia.isCorrectDate(), false);
				Date fechaNegativoMes = new Date(12, -5, 1995);
			assertEquals(fechaNegativoMes.isCorrectDate(), false);
				Date fechaNegativoAño = new Date(12, 5, -1);
			assertEquals(fechaNegativoAño.isCorrectDate(), false);
				Date fechaCeroDia = new Date(0, 5, 1995);
			assertEquals(fechaNegativoMes.isCorrectDate(), false);
				Date fechaCeroMes = new Date(12, 0, 1995);
			assertEquals(fechaNegativoMes.isCorrectDate(), false);
				Date fechaDiaNoInt = new Date('a', 5, 1995);
			assertEquals(fechaDiaNoInt.isCorrectDate(), false);
				Date fechaMesNoInt = new Date(12, 'b', 1995);
			assertEquals(fechaMesNoInt.isCorrectDate(), false);
				Date fechaAñoNoInt = new Date(12, 5, 'c');
			assertEquals(fechaAñoNoInt.isCorrectDate(), false);

			// caso de prueba valido para toString
				Date fechaString = new Date(12, 5, 1995);
			assertEquals(fechaDia.toString(), "12/5/1995");
			
			//caso de prueba valido para isLapYear
				Date fechaBisiesto = new Date(12, 5, 2024);
			assertEquals(fechaBisiesto.isLapYear(), true);
				Date fechaNOBisiesto = new Date(12, 5, 2023);
			assertEquals(fechaNOBisiesto.isLapYear(), false);
			
			//caso de prueba para nextDay
				Date fechaDiaSiguiente = new Date(12, 5, 1995);
			fechaDiaSiguiente.nextDay();
			assertEquals(fechaBisiesto.getDay(), 13);
			assertEquals(fechaBisiesto.getMonth(), 5);
			assertEquals(fechaBisiesto.getDay(), 1995);
				Date fechaMesSiguiente = new Date(31, 1, 1995);
			fechaDiaSiguiente.nextDay();
			assertEquals(fechaBisiesto.getDay(), 1);
			assertEquals(fechaBisiesto.getMonth(), 2);
			assertEquals(fechaBisiesto.getDay(), 1995);
				Date fechaAñoSiguiente = new Date(31, 12, 1995);
			fechaDiaSiguiente.nextDay();
			assertEquals(fechaBisiesto.getDay(), 1);
			assertEquals(fechaBisiesto.getMonth(), 1);
			assertEquals(fechaBisiesto.getDay(), 1996);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
