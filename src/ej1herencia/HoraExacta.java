package ej1herencia;

import excepciones.execepej2.NegativeHourException;
import excepciones.execepej2.NegativeMinuteException;
import excepciones.execepej2.NegativeSecondException;

/**
 * Clase hija HoraExacta heredada de Clase padre hora
 */
public class HoraExacta extends Hora {

	/**
	 * Numero entero que contiene los segundos
	 */
	private int segundos;

	/**
	 * Constructor con parametros
	 * 
	 * @param hora    Atributo de la clase padre que contiene un numero entero que
	 *                representa la hora
	 * @param minuto  Atributo de la clase padre que contiene un numero entero que
	 *                representa los minutos
	 * @param segundo Numero entero de la clase hija que contiene un numero entero
	 *                que respresenta los segundos
	 * @throws NegativeMinuteException 
	 * @throws NegativeHourException 
	 */
	public HoraExacta(int hora, int minuto, int segundo) throws NegativeHourException, NegativeMinuteException, NegativeSecondException{
		super(hora, minuto);

		if (segundos >= 0 && segundos < 60) {
			this.segundos = segundo;
		} else {
			throw new NegativeSecondException();
		}
	}

	/**
	 * Funcion que cambia los segundos
	 * 
	 * @param valor Numero entero que contiene el segundo a cambiar
	 * @return Booleano true (si se ha podido cambiar los segundos) o false (Si no
	 *         se ha podido realizar el cambio)
	 */
	boolean setSegundo(int valor) throws NegativeSecondException {
		boolean valido = false;

		if (valor >= 0 && valor < 60) {
			segundos = valor;
			valido = true;
		} else {
			throw new NegativeSecondException();
		}
		return valido;

	}

	/**
	 * Funcion de la clase padre donde se modifica para que incremente tambien los
	 * segundos
	 */
	@Override
	public void inc() {
		segundos++;
		if (segundos == 60) {
			segundos = 0;
			super.inc();
		}
	}

	/**
	 * Funcion de la clase padre modificado que muestra la hora, minutos y tambien
	 * los segundos
	 */
	@Override
	public String toString() {
		String cad = super.toString();

		cad += ":";
		if (segundos < 10) {
			cad += "0";
		}
		cad += segundos;

		return cad;
	}
}
