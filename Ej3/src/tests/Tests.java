package tests;
import main.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import dependencias.*;
class Tests {

	@Test
	void test() {
		assertEquals(true,Main.ej3MCD(18,9)== 9);
		assertEquals(false,Main.ej3esPrimo(20000));
		
		comprobacionSabana();
		
	}
	void comprobacionSabana() {
		Savannah sabana=new Savannah();
		sabana.simulacion();

		Gacela miGacela=new Gacela();
		Humano miHumano=new Humano();
		
		assertEquals(true,miGacela instanceof Animal);
		assertEquals(true,miHumano instanceof Animal);
		
		//Uno de estos dos de abajo tiene que ser verdadero y el otro falso
		assertEquals(true,sabana.obtenerTablero(0, 0)instanceof Animal);
		assertEquals(true,sabana.obtenerTablero(0, 0)instanceof Planta);
		
	}

}
