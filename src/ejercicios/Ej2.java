package ejercicios;

import ej1herencia.Hora;
import ej1herencia.HoraExacta;
import excepciones.execepej2.NegativeHourException;
import excepciones.execepej2.NegativeMinuteException;
import excepciones.execepej2.NegativeSecondException;

public class Ej2 {

	public static void main(String[] args) {

		try {
			Hora h = new HoraExacta(10, 11, 12);
			
			h.setHora(-14);
			
		} catch (NegativeHourException e) {
			System.out.println(e);
		} catch (NegativeMinuteException e) {
			System.out.println(e);
		} catch (NegativeSecondException e) {
			System.out.println(e);
		}

	}

}
