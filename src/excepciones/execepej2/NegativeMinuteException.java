package excepciones.execepej2;

public class NegativeMinuteException extends Exception{
	@Override
	public String toString() {
		return "Minuto negativo";
	}
}
