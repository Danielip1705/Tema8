package excepciones.excepej4;

public class DescripcionInvalidaException extends Exception{
	@Override
	public String toString() {
		return "Error: Descripción del artículo no válida";
	}
}
