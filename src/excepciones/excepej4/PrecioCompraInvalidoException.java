package excepciones.excepej4;

public class PrecioCompraInvalidoException extends Exception{
	@Override
	public String toString() {
		return "Error: Precio de compra no válido";
	}
}
