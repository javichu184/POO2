package dependencias;

public class Humano extends Animal implements Hunter{

	public void hunt(String cazado){
		System.out.println("El humano ha cazado a "+cazado);
	}
}
