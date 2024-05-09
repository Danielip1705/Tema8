package excepciones.execepej2;

public class NegativeHourException extends Exception{
	@Override
	public String toString() {
		return "Hora negativa";
	}
}
