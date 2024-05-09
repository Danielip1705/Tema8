package excepciones.excepej4;

public class CodigoInvalidoException extends Exception {
	// Excepción para código inválido

	@Override
	public String toString() {
		return "Error: Código del artículo no válido";
	}
}
