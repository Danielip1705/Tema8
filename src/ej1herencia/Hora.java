package ej1herencia;

import excepciones.execepej2.NegativeHourException;
import excepciones.execepej2.NegativeMinuteException;

/**
 * Clase hora
 */
public class Hora {
	/**
	 * Numero entero protegido que representa las horas
	 */
	protected int horas;
	/**
	 * Numero entero protegido que representa los minutos
	 */
	protected int minutos;

	/**
	 * constructor con parametros
	 * 
	 * @param hora   Numero entero que representa las horas
	 * @param minuto Numero entero que representa los minutos
	 */
	public Hora(int hora, int minuto) throws NegativeHourException, NegativeMinuteException {
		if (hora >= 0 && hora < 24) {
			this.horas = hora;
		} else {
			throw new NegativeHourException();
		}
		if (minutos >= 0 && minutos < 24) {
			this.minutos = minuto;
		} else {
			throw new NegativeMinuteException();
		}
	}

	/**
	 * Funcion donde se va a incrementar los minutos(Tambien las horas si ocurre
	 * ciertas condiciones)
	 */
	public void inc() {
		minutos++;
		if (minutos == 60) {
			minutos = 0;
			horas++;
			if (horas == 24) {
				horas = 0;
			}
		}
	}

	/**
	 * funcion donde se va a cambiar los minutos
	 * 
	 * @param valor Numero entero que sera el cambio de los minutos
	 * @return Booleano true (Si se ha podido realizar el cambio) o false (si no se
	 *         ha podido realizar el cambio)
	 */
	public boolean setMinutos(int valor) throws NegativeMinuteException {
		boolean valido = false;

		if (valor > 0 && valor < 60) {
			minutos = valor;
			valido = true;
		} else {
			throw new NegativeMinuteException();
		}
		return valido;
	}

	/**
	 * Funcion que cambia la hora actual
	 * 
	 * @param valor Numero entero que sera el cambio de hora
	 * @return Booleano true (Si se ha podido realizar el cambio) o false (si no se
	 *         ha podido realizar el cambio)
	 */
	public boolean setHora(int valor) throws NegativeHourException {
		boolean valido = false;

		if (valor > 0 && valor < 60) {
			horas = valor;
			valido = true;
		} else {
			throw new NegativeHourException();
		}
		return valido;
	}

	/**
	 * Funcion toString que imprimira la hora en un formato concreto
	 */
	public String toString() {
		String cad = "";
		if (horas < 10) {
			cad += "0";
		}
		cad += horas;

		cad += ":";
		if (minutos < 10) {
			cad += "0";
		}
		cad += minutos;

		return cad;
	}
}
