package excepciones.excepej4;

public class StockInvalidoException extends Exception{

	@Override
	public String toString() {
		return "Error: Stock no válido";
	}
}
