package ejercicios;

import java.util.Scanner;

import ej2crud.ArrayGestisimal;
import ej2crud.Gesticial;
import excepciones.excepej4.CodigoInvalidoException;
import excepciones.excepej4.DescripcionInvalidaException;
import excepciones.excepej4.PrecioCompraInvalidoException;
import excepciones.excepej4.PrecioVentaInvalidoException;
import excepciones.excepej4.StockInvalidoException;

public class Ej4 {

	public static void main(String[] args) {
		// Declaracion de variables
		String codigo;
		String descripcion;
		double compra;
		double venta;
		int stock;
		int ops = 0;

		// Creacion del scanner
		Scanner sc = new Scanner(System.in);

		// Creamos bucle while
		do {

			// Imprimimos menu
			menu();

			// Escribimos ops
			ops = sc.nextInt();

			// Limpiamos el buffer de escritura
			sc.nextLine();

			// Declaramos switch teniendo en cuenta el resultado de ops
			switch (ops) {

			// Caso 1
			case 1:

				// Imprimimos el listado a traves de la funcion listado de la clase
				// arrayGestisimal
				ArrayGestisimal.listado();

				// Rompemos caso
				break;

			// Caso 2
			case 2:
				try {
					// Imprimimos en consola el titulo del programa
					System.out.println("Registro de articulos");

					// Imprimimos en consola que indique el codigo
					System.out.println("Indique el codigo del articulo");

					// Escribimos codigo
					codigo = sc.nextLine();

					// Imprimimos en consola que indique la descripcion
					System.out.println("Indique la descripcion del articulo");

					// escribimos descripcion
					descripcion = sc.nextLine();

					// Imprimimos que indique el precio de la compra
					System.out.println("Indique el precio de compra del articulo");

					// Escribimos compra
					compra = sc.nextDouble();

					// Imprimimos que indique el precio de venta del articulo
					System.out.println("Indique el precio de venta del articulo");

					// escribimos venta
					venta = sc.nextDouble();

					// Limpiamos buffer
					sc.nextLine();

					// Imprimimos en consola que nos indique el stock del articulo
					System.out.println("Indique el stock del articulo");
					// EScribimos stock
					stock = sc.nextInt();
					// Limpiamos buffer
					sc.nextLine();

					// Intentamos crear el nuevo artículo dentro del try
					Gesticial art = new Gesticial(codigo, descripcion, compra, venta, stock);

					// Si el artículo se crea correctamente, intentamos agregarlo al sistema
					if (ArrayGestisimal.altaArticulo(codigo, descripcion, compra, venta, stock)) {
						// Que imprima en consola que el articulo se ha añadido
						System.out.println("Articulo añadido");
					} else {
						// Que imprima en consola que la lista de articulos esta llena
						System.out.println("Lista de articulos llena");
					}
				} catch (CodigoInvalidoException e) {
					System.out.println(e);
				} catch (DescripcionInvalidaException e) {
					System.out.println(e);
				} catch (PrecioCompraInvalidoException e) {
					System.out.println(e);
				} catch (PrecioVentaInvalidoException e) {
					System.out.println(e);
				} catch (StockInvalidoException e) {
					System.out.println(e);
				}
				break;

			case 3:
				try {
					// Imprimimos en consola que indique el código del artículo
					System.out.println("Indique el código del artículo que quiere eliminar");
					// Escribimos el código
					codigo = sc.nextLine();

					// Intentamos eliminar el artículo
					if (ArrayGestisimal.bajaArticulo(codigo)) {
						// Si se elimina correctamente, imprimimos en consola que el artículo se ha
						// eliminado
						System.out.println("Artículo eliminado");
					} else {
						// Si no se encuentra el artículo, imprimimos en consola que el artículo no
						// existe
						System.out.println("El artículo no existe");
					}
				} catch (CodigoInvalidoException e) {
					// Manejamos la excepción si el código es inválido
					System.out.println(e);
				}
				// Rompemos el caso 3
				break;

			case 4:
				try {
					// Imprimimos en consola que inserte el código del artículo a modificar
					System.out.println("Inserte el código del artículo que quiere modificar");
					// Escribimos el código
					codigo = sc.nextLine();

					// Imprimimos en consola que inserte la descripción nueva
					System.out.println("Inserte la descripción nueva");
					// Escribimos la descripción
					descripcion = sc.nextLine();

					// Imprimimos en consola que inserte el precio de compra nuevo
					System.out.println("Inserte el precio de compra nuevo");
					// Escribimos el precio de compra
					compra = sc.nextDouble();
					// Limpiamos buffer
					sc.nextLine();

					// Imprimimos en consola que inserte el precio de venta nuevo
					System.out.println("Inserte el precio de venta nuevo");
					// Escribimos el precio de venta
					venta = sc.nextDouble();
					// Limpiamos buffer
					sc.nextLine();

					// Intentamos modificar el artículo
					if (ArrayGestisimal.modificar(codigo, descripcion, compra, venta)) {
						// Si se modifica correctamente, imprimimos en consola que el artículo ha sido
						// modificado
						System.out.println("Artículo modificado");
					} else {
						// Si el artículo no existe, imprimimos en consola que el artículo no existe
						System.out.println("El artículo no existe");
					}
				} catch (CodigoInvalidoException e) {
					// Manejamos la excepción si el código es inválido
					System.out.println(e);
				} catch (DescripcionInvalidaException e) {
					// Manejamos la excepción si la descripción es inválida
					System.out.println(e);
				} catch (PrecioCompraInvalidoException e) {
					// Manejamos la excepción si el precio de compra es inválido
					System.out.println(e);
				} catch (PrecioVentaInvalidoException e) {
					// Manejamos la excepción si el precio de venta es inválido
					System.out.println(e);
				}
				// Rompemos el caso 4
				break;

			case 5:
				try {
					// Imprimimos en consola que inserte el código
					System.out.println("Inserte el código");
					// Escribimos el código
					codigo = sc.nextLine();

					// Imprimimos en consola que inserte la entrada de mercancía
					System.out.println("Inserte la entrada de mercancía");
					// Escribimos el stock
					stock = sc.nextInt();
					// Limpiamos buffer
					sc.nextLine();

					// Intentamos realizar la entrada de mercancía
					if (ArrayGestisimal.entradaMercancia(codigo, stock)) {
						// Si se realiza correctamente, imprimimos en consola que se ha realizado la
						// entrada de mercancía correctamente
						System.out.println("Se ha realizado la entrada de mercancía correctamente");
					} else {
						// Si no se realiza correctamente, imprimimos en consola que no se ha realizado
						// la entrada de mercancía
						System.out.println("No se ha realizado la entrada de mercancía");
					}
				} catch (CodigoInvalidoException e) {
					// Manejamos la excepción si el código es inválido
					System.out.println(e);
				} catch (StockInvalidoException e) {
					// Manejamos la excepción si el stock es inválido
					System.out.println(e);
				}
				// Rompemos el caso 5
				break;

			case 6:
				try {
					// Imprimimos en consola que inserte el código
					System.out.println("Inserte el código");
					// Escribimos el código
					codigo = sc.nextLine();

					// Imprimimos en consola que inserte la salida de mercancía
					System.out.println("Inserte la salida de mercancía");
					// Escribimos el stock
					stock = sc.nextInt();
					// Limpiamos buffer
					sc.nextLine();

					// Intentamos realizar la salida de mercancía
					if (ArrayGestisimal.salidaMercancia(codigo, stock)) {
						// Si se realiza correctamente, imprimimos en consola que se ha realizado la
						// salida de mercancía correctamente
						System.out.println("Se ha realizado la salida de mercancía correctamente");
					} else {
						// Si no se realiza correctamente, imprimimos en consola que no se ha realizado
						// la salida de mercancía
						System.out.println("No se ha realizado la salida de mercancía");
					}
				} catch (CodigoInvalidoException e) {
					// Manejamos la excepción si el código es inválido
					System.out.println(e);
				} catch (StockInvalidoException e) {
					// Manejamos la excepción si el stock es inválido
					System.out.println(e);
				}
				// Rompemos el caso 6
				break;

			case 7:
				// Imprimimos en consola que se esta saliendo del programa
				System.out.println("Saliendo del programa");
				// Rompemos caso 7
				break;
			}
			// Se termina el bucle si ops es igual que 7
		} while (ops != 7);

		// Cerramos scanner
		sc.close();

	}

	/**
	 * Funcion que muestra el menu
	 */
	public static void menu() {
		System.out.println("Indique que opciones quiere elegir");
		System.out.println("1. Listado");
		System.out.println("2. Alta");
		System.out.println("3. Baja");
		System.out.println("4. Modificacion");
		System.out.println("5. Entrada de mercancia");
		System.out.println("6. Salida de mercancia");
		System.out.println("7. Salir");
	}

}
