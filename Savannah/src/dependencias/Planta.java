package dependencias;

public class Planta extends SerVivo {
	private int altura;
	private int nivel;
	public Planta() {
		altura=0;
		nivel=0;
	}
public void grow() {
	altura++;
	nivel++;
}
}
