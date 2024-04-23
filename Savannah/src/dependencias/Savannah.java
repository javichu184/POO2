package dependencias;

import java.util.*;

public class Savannah {

	private int diasJuego;
	private SerVivo tablero[][];

	public Savannah() {
		diasJuego = 1;
		tablero = new SerVivo[10][10];
		Random random = new Random();
		// Tipo 0: Planta
		// Tipo 1: Leon
		// Tipo 2: Gacela
		// Tipo 3: Humano
		int tipo = random.nextInt(4);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				switch (tipo) {
				case 0:
					tablero[i][j] = new Humano();
					break;
				case 1:
					tablero[i][j] = new Leon();
					break;
				case 2:
					tablero[i][j] = new Gacela();
					break;
				default:
					tablero[i][j] = new Planta();

				}
				tipo = random.nextInt(4);
			}
		}
	};

	public void mostrarTablero() {
		for (int i = 0; i < 10; i++) {
			for (int ii = 0; ii < 10; ii++) {
				if (tablero[i][ii] instanceof Planta) {
					System.out.print(" P |");
				} else if (tablero[i][ii] instanceof Animal) {
					System.out.print(" A |");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();// salto de linea
			for(int k=0;k<10;k++) {
			System.out.print(" ---"); 
		}System.out.println();
			}
	}
	public void simulacion() {
		System.out.println("Pulsa la tecla ENTER para realizar iteracciones de la simulacion");
		System.out.println("Para salir pulsa cualquier otra tecla");
		Scanner scanner = new Scanner(System.in);
		String linea = scanner.nextLine();

		while (linea.isEmpty()) {
			System.out.println("Dia " + diasJuego + " en la sabana:");
			mostrarTablero();
			int auxX = 0;
			int auxY = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					if (tablero[i][j] instanceof Planta) {
						((Planta) tablero[i][j]).grow();
					} else if (tablero[i][j] instanceof Animal) {
						((Animal) tablero[i][j]).move();

						auxX = ((Animal) tablero[i][j]).getPosicion().getX();
						auxY = ((Animal) tablero[i][j]).getPosicion().getY();
						if (tablero[auxY][auxX] instanceof Planta) {
							tablero[auxY][auxX] = (Animal)tablero[i][j];
							tablero[i][j] = new Planta();
						}else if(tablero[auxY][auxX] instanceof Animal) {
			if(tablero[auxY][auxX] instanceof Humano) {	
				
				if(tablero[auxY][auxX].getClass()==tablero[i][j].getClass()&&
					((Animal) tablero[auxY][auxX]).getSexo()!=((Animal) tablero[i][j]).getSexo()	) 
				{
					//en el mapa vuelve a su posicion inicial(no se mueve) y procean un nuevo animal 
					//que tendra la posicion de una planta
					for(int t=0;t<10;t++) {
						for(int w=0;w<10;w++) {
							if(tablero[w][t]instanceof Planta) {
								tablero[w][t]=new Humano();
							}((Animal)tablero[i][j]).noMove();
						}
					}
					System.out.println("Dos humanos han procreado");
				}else {
				
		((Humano)tablero[auxY][auxX]).hunt(tablero[i][j].getClass().getSimpleName());
		tablero[auxY][auxX] = (Animal)tablero[i][j];
		tablero[i][j] = new Planta();
				}
				
			}else if(tablero[auxY][auxX] instanceof Leon) {
				if(tablero[auxY][auxX].getClass()==tablero[i][j].getClass()&&
						((Animal) tablero[auxY][auxX]).getSexo()!=((Animal) tablero[i][j]).getSexo()	)
				{
					for(int t=0;t<10;t++) {
						for(int w=0;w<10;w++) {
							if(tablero[w][t]instanceof Planta) {
								tablero[w][t]=new Leon();
							}
						}
					}
					System.out.println("Dos leones han procreado");
					((Animal)tablero[i][j]).noMove();
			}else {
				((Leon)tablero[auxY][auxX]).hunt(tablero[i][j].getClass().getSimpleName());
			}
		
			}else if(tablero[auxY][auxX] instanceof Gacela) {
				
				if(tablero[auxY][auxX].getClass()==tablero[i][j].getClass()&&
						((Animal) tablero[auxY][auxX]).getSexo()!=((Animal) tablero[i][j]).getSexo()	)
				{
					for(int t=0;t<10;t++) {
						for(int w=0;w<10;w++) {
							if(tablero[w][t]instanceof Planta) {
								tablero[w][t]=new Gacela();
								System.out.println("Dos gacelas han procreado");
							}
						((Animal)tablero[i][j]).noMove();
						}
					}
					
				}else {
		((Gacela)tablero[auxY][auxX]).isHunt(tablero[i][j].getClass().getSimpleName());
				}
			
			}
						}
						

					}

				}
			}

			diasJuego++;
			linea = scanner.nextLine();
		}
		scanner.close();
		System.out.println("Cerrando..");
	};

}
