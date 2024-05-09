package ej4crud;

import java.util.Scanner;

import excepciones.excepej3.ExceptionDni;
import excepciones.excepej3.ExceptionNombre;
import excepciones.excepej3.ExceptionSaldo;

import java.util.Scanner;

public class CCCmain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion;
		boolean operacion;
		CCC cuenta;
		String dni = "";
		String nombre = "";
		double saldo;
		double cantDinero;

		System.out.println("Bienvenid@ al sistema de gestión de nuestro banco");

		do {
			muestraMenu();

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				try {
					System.out.println("Introduzca el dni del titular de la cuenta");
					dni = sc.nextLine();

					System.out.println("Introduzca el nombre del titular de la cuenta");
					nombre = sc.nextLine();

					System.out.println("Introduzca el saldo de la cuenta");
					saldo = sc.nextDouble();
					sc.nextLine();

					cuenta = new CCC(dni, nombre, saldo);

					operacion = CCCarray.nuevaCuenta(cuenta);

					System.out.println(operacion ? "Cuenta abierta correctamente" : "No se ha podido abrir la cuenta");
				} catch (ExceptionDni | ExceptionNombre | ExceptionSaldo e) {
					System.out.println("Error al crear la cuenta: " + e);
				}
				break;

			case 2:
				try {
					CCCarray.listadoCuenta();
				} catch (Exception e) {
					System.out.println("Error al listar las cuentas: " + e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Introduzca el dni del titular de la cuenta");
					dni = sc.nextLine();

					cuenta = new CCC(dni);

					operacion = CCCarray.eliminarCuenta(cuenta);

					System.out.println(operacion ? "Cuenta eliminada" : "No se ha podido eliminar la cuenta");
				} catch (Exception e) {
					System.out.println("Error al eliminar la cuenta: " + e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println("Introduzca el dni del titular de la cuenta");
					dni = sc.nextLine();

					System.out.println("Introduzca el nuevo nombre");
					nombre = sc.nextLine();

					cuenta = new CCC(dni);

					operacion = CCCarray.cambiarNombre(cuenta, nombre);

					System.out.println(
							operacion ? "Nombre modificado correctamente" : "No se ha podido modificar el nombre");
				} catch (Exception e) {
					System.out.println("Error al cambiar el nombre: " + e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Introduzca el dni del titular de la cuenta");
					dni = sc.nextLine();

					System.out.println("Introduzca la cantidad a ingresar");
					cantDinero = sc.nextDouble();
					sc.nextLine();

					cuenta = new CCC(dni);

					operacion = CCCarray.ingresarDinero(cuenta, cantDinero);

					System.out.println(operacion ? "Transferencia hecha" : "No se ha podido realizar la transferencia");
				} catch (Exception e) {
					System.out.println("Error al ingresar dinero: " + e.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println("Introduzca el dni del titular de la cuenta");
					dni = sc.nextLine();

					System.out.println("Introduzca la cantidad a retirar");
					cantDinero = sc.nextDouble();
					sc.nextLine();

					cuenta = new CCC(dni);

					operacion = CCCarray.sacarDinero(cuenta, cantDinero);

					System.out.println(operacion ? "Transferencia hecha" : "No se ha podido realizar la transferencia");
				} catch (Exception e) {
					System.out.println("Error al retirar dinero: " + e.getMessage());
				}
				break;

			case 0:
				break;

			default:
				System.out.println("Opción incorrecta");
				break;
			}

		} while (opcion != 0);

		System.out.println("Saliendo del sistema...");

		sc.close();
	}

	public static void muestraMenu() {
		System.out.println("1. Abrir nueva cuenta");
		System.out.println("2. Listar cuentas");
		System.out.println("3. Eliminar cuenta");
		System.out.println("4. Cambiar nombre");
		System.out.println("5. Ingresar dinero");
		System.out.println("6. Sacar dinero");
		System.out.println("0. Salir");
		System.out.println("Elija una opción:");
	}
}
