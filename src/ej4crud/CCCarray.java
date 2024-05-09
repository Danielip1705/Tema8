package ej4crud;

import excepciones.excepej3.ExceptionNombre;
import excepciones.excepej3.ExceptionSaldo;

public class CCCarray {

	static CCC[] cuenta = new CCC[30];

	public static void listadoCuenta() {

		for (CCC valor : cuenta) {
			if (valor != null) {
				System.out.println(valor);
			}
		}
	}

	public static boolean nuevaCuenta(CCC cun) {
		boolean añadido = false;
		int i = 0;

		while (i < cuenta.length && cuenta[i] != null) {
			i++;
		}
		if (i < cuenta.length) {
			cuenta[i] = cun;
			añadido = true;
		}

		return añadido;

	}

	public static boolean eliminarCuenta(CCC cun) {

		boolean eliminado = false;

		int pos = buscarTitular(cun);

		if (pos >= 0) {

			cuenta[pos] = null;

			eliminado = true;
		}

		return eliminado;

	}

	public static int buscarTitular(CCC c) {
		int i = 0;
		int pos = -1;

		while (i < cuenta.length && pos == -1) {

			if (cuenta[i] != null && cuenta[i].equals(c)) {
				pos = i;
			}
			i++;
		}

		return pos;

	}

	/**
	 * Modifica el saldo de la cuenta corriente que le indicamos en el parametro
	 * sumandole la cantidad de dinero
	 * 
	 * @param cuenta     Cuenta corriente a la que cambiaremos el saldo
	 * @param cantDinero Cantidad de dinero que ingresaremos
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 * @throws ExceptionSaldo 
	 */
	public static boolean ingresarDinero(CCC cuentaa, double cantDinero) throws ExceptionSaldo {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean dineroIngresado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = buscarTitular(cuentaa);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Se llama al set para modificar el saldo de la cuenta corriente que se
			// encuentre en la posición correspondiente. Sumando la cantidad introducida
			cuenta[posicion].setSaldo(cuentaa.getSaldo() + cantDinero);
			// Asignamos el boolean como true
			dineroIngresado = true;
		}

		// Devolverá el valor de nuestro boolean
		return dineroIngresado;
	}

	/**
	 * Modifica el saldo de la cuenta corriente que le indicamos en el parametro
	 * restandole la cantidad de dinero
	 * 
	 * @param cuenta     Cuenta corriente a la que cambiaremos el saldo
	 * @param cantDinero Cantidad de dinero que retiraremos
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 * @throws ExceptionSaldo 
	 */
	public static boolean sacarDinero(CCC cuentaa, double cantDinero) throws ExceptionSaldo {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean dineroSacado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = buscarTitular(cuentaa);

		// Si lo ha encontrado y la cantidad a sacar es menor que el saldo de la cuenta
		if (posicion >= 0 && cantDinero < cuentaa.getSaldo()) {
			// Se llama al set para modificar el saldo de la cuenta corriente que se
			// encuentre en la posición correspondiente. Restando la cantidad introducida
			cuenta[posicion].setSaldo(cuentaa.getSaldo() - cantDinero);
			// Asignamos el boolean como true
			dineroSacado = true;
		}

		// Devolverá el valor de nuestro boolean
		return dineroSacado;
	}
	
	public static boolean cambiarNombre( CCC cuentaa, String nombre) throws ExceptionNombre {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean modificado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = buscarTitular(cuentaa);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Se llama al set para modificar el nombre de la cuenta corriente que se
			// encuentre
			// en la posición correspondiente
			cuenta[posicion].setNombre(nombre);
			// Asignamos el boolean como true
			modificado = true;
		}

		// Devolverá el valor de nuestro boolean
		return modificado;
	}
}
