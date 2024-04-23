package dependencias;

public class Leon extends Animal implements Hunter{

	public void hunt(String cazado){
		System.out.println("El leon ha cazado a "+cazado);
	}
}
