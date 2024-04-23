import java.util.Random;

public class Persona {

	private String nombre;
	private int edad;
	
	Persona()
	{
		nombre="Juan";
		Random random=new Random();
		edad=random.nextInt(51);
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
}
