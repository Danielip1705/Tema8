package excepciones.excepej4;

public class PrecioVentaInvalidoException extends Exception{
	@Override
	public String toString() {
		return "Error: Precio de venta no válido";
	}
}
