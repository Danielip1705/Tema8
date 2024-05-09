package ejercicios;

import java.util.Scanner;

import excepciones.excepej1.Utils;

public class Ej1 {

	public static void main(String[] args) {
		// Creamos scanner
		Scanner sc = new Scanner(System.in);

		// Imprimimos en consola que se escriba un numero entero
		System.out.println("Escribe un numero entero");

		// Llamamos a la funcion readint para comprobar si es un numero entero
		Utils.readInt(sc);

		// Imprimimos en consola que se escriba un numero decimal
		System.out.println("Escribe un numero decimal");

		// Llamamos a la funcion readDouble para comprobar si es un numero decimal
		Utils.readDouble(sc);
	}
}
