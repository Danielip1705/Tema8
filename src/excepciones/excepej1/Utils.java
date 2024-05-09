package excepciones.excepej1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	/**
	 * Funcion que lee si el numero pasado por parametros es int, en caso contrario
	 * lanza la excepcion
	 * 
	 * @param sc Numero escrito por el usuario
	 * @return Numero escrito por el usuario si no es un decimal, y 0 si es un
	 *         decimal
	 */
	public static int readInt(Scanner sc) {

		int a = 0;

		try {

			a = sc.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("El valor introducido no es de tipo int");
		} finally {
			sc.nextLine();
			System.out.println(a);
		}
		return a;
	}

	/**
	 * Funcion que lee si el numero pasado por parametro es double, en caso
	 * contrario lanza la excepcion
	 * 
	 * @param sc Numero escrito por el usuario
	 * @return Numero escrito por el usuario si no es un decimal, y 0 si es un int
	 */
	public static double readDouble(Scanner sc) {

		double a = 0;

		try {

			a = sc.nextDouble();

		} catch (InputMismatchException e) {
			System.out.println("El valor introducido no es de tipo double");
		} finally {
			sc.nextLine();
			System.out.println(a);
		}
		return a;
	}
}
