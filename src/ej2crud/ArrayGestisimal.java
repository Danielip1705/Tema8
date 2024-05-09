package ej2crud;

import excepciones.excepej4.CodigoInvalidoException;
import excepciones.excepej4.DescripcionInvalidaException;
import excepciones.excepej4.PrecioCompraInvalidoException;
import excepciones.excepej4.PrecioVentaInvalidoException;
import excepciones.excepej4.StockInvalidoException;

public class ArrayGestisimal {

	/**
	 * Array unidimensinal de la clase Gesticial con longitud de 20
	 */
	public static Gesticial[] articulos = new Gesticial[20];

	/**
	 * Funcion que muestra el array a aquellas posiciones que no sean nulas
	 */
	public static void listado() {
		for (Gesticial ges : articulos) {
			if (ges != null) {
				System.out.println(ges);
			}
		}
	}

	/**
	 * Funcion que añade un objeto de la clase Gesticial al array de articulos
	 * 
	 * @param codigo Cadena que tiene el articulo
	 * @param desc   Descripcion que contiene la descripcion un articulo
	 * @param compra Precio decimal que conteine el precio de la compra
	 * @param venta  Precio decimal que contiene el precio del articulo
	 * @param stock  Numero entero que contiene la cantidad de ariculos almafendos
	 * @return booleano true o false dependiendo si hay articulos
	 */
	public static boolean altaArticulo(String codigo, String desc, double compra, double venta, int stock) {
		int i = 0;
		boolean añadido = false;
		Gesticial art = null;
		try {
			art = new Gesticial(codigo, desc, compra, venta, stock);
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DescripcionInvalidaException e) {
			e.printStackTrace();
		} catch (PrecioCompraInvalidoException e) {
			e.printStackTrace();
		} catch (PrecioVentaInvalidoException e) {
			e.printStackTrace();
		} catch (StockInvalidoException e) {
			e.printStackTrace();
		}

		while (i < articulos.length && articulos[i] != null) {
			i++;
		}

		if (i < articulos.length) {
			articulos[i] = art;
			añadido = true;
		}
		return añadido;
	}

	/**
	 * Funcion que elimina el articulo segun el codigo
	 * 
	 * @param codigo codigo del articulo a eliminar
	 * @return Booleano eliminado (True o false dependiendo si hay articulos a
	 *         eliminar o no)
	 * @throws CodigoInvalidoException 
	 */
	public static boolean bajaArticulo(String codigo) throws CodigoInvalidoException {
		boolean eliminado = false;
		int i = buscarArticulo(codigo);

		if (i < articulos.length) {
			articulos[i] = null;
			eliminado = true;

		}

		return eliminado;
	}

	/**
	 * Funcion que modifica la descripcion, compra y venta del ariculo segun el
	 * codigo que se ha pasado
	 * 
	 * @param codigo Cadena que contiene el codigo a modificar
	 * @param desc   Descripcion nueva que se va a añadir
	 * @param compra Numero decimal de compra nueva que se va a añadir
	 * @param venta  Numero decimal de venta nueva que se va a añadir
	 * @return Booleano modificado (True o false dependiendo si esta el codigo en el
	 *         array)
	 * @throws CodigoInvalidoException 
	 */
	public static boolean modificar(String codigo, String desc, double compra, double venta)
			throws PrecioVentaInvalidoException, PrecioCompraInvalidoException, DescripcionInvalidaException, CodigoInvalidoException {
		boolean modificado = false;
		int i = buscarArticulo(codigo);

		if (i < articulos.length) {
			try {
				articulos[i].setDescripcion(desc);
			} catch (DescripcionInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				articulos[i].setPrecioCompra(compra);
			} catch (PrecioCompraInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				articulos[i].setPrecioVenta(venta);
			} catch (PrecioVentaInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modificado = true;
		}

		return modificado;
	}

	/**
	 * Funcion que añade stock al articulo segun el codigo
	 * 
	 * @param codigo Cadena que contiene el codigo del articulo a modificar
	 * @param stock  Numero entero que contiene el numero de articulos almacenados
	 * @throws CodigoInvalidoException
	 */
	public static boolean entradaMercancia(String codigo, int stock) throws StockInvalidoException, CodigoInvalidoException {
		boolean merc = false;

		int i = buscarArticulo(codigo);

		if (i < articulos.length) {

			if (stock >= 0) {
				try {
					articulos[i].setStock(articulos[i].getStock() + stock);
				} catch (StockInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				merc = true;
			}
		}

		return merc;
	}

	/**
	 * Funcion que elimina stock al articulo segun el codigo
	 * 
	 * @param codigo Cadena que contiene el codigo del articulo
	 * @param stock  Numero entero que contiene la cantidad del articulo
	 * @throws StockInvalidoException 
	 * @throws CodigoInvalidoException 
	 */
	public static boolean salidaMercancia(String codigo, int stock) throws StockInvalidoException, CodigoInvalidoException {
		boolean merc = false;

		int i = buscarArticulo(codigo);

		if (i < articulos.length) {

			if (stock >= 0) {
				articulos[i].setStock(articulos[i].getStock() - stock);
				merc = true;
			} else {
				throw new StockInvalidoException();
			}
		}

		return merc;
	}

	/**
	 * Funcion que busca la posicion del objeto segun el codigo
	 * 
	 * @param codigo Cadena que contiene el codigo del articulo
	 * @return Numero entero de la posicion del obejto en el array
	 * @throws CodigoInvalidoException 
	 */
	private static int buscarArticulo(String codigo) throws CodigoInvalidoException {
		int i = 0;

		Gesticial ges = new Gesticial(codigo);

		while (i < articulos.length && (articulos[i].equals(ges) || !articulos[i].getCodigo().equals(codigo))) {
			i++;
		}
		return i;
	}

}
