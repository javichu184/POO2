package main;
import java.util.Scanner;

import dependencias.Savannah;

public class Main {

	public static void main(String[] args) {
		
		ej1(25);
		ej2(25);
		System.out.println(ej3Factorial(6));
		float inicial=System.nanoTime();
		for(int i=0;i<1000;i++) {
		System.out.println(ej3MCD(16, 200));
		}
		System.out.println("Se tarda "+ (System.nanoTime()-inicial)+" Nanosegundos");
		System.out.println("Si influye la naturaleza de los numeros");
		System.out.println(ej3Fibonacci(9));
		System.out.println(ej3esPrimo(4));
		ej4();
		ej5();
		ej6();
		inicial=System.nanoTime();
		ej7();
		
		System.out.println("En las piramides se tardan "+(System.nanoTime()-inicial)+" nanosegundos");
		
		
	}

	public static void ej1(int num) {
		for (int i = 1; i < num; i++) {
			System.out.println(i);
		}
	}

	public static void ej2(int num) {
		for (int i = 1; i < num; i++) {

			System.out.print(i);

			if (i % 3 == 0 && i % 2 == 0) {
				System.out.println(": es par y trio");
			} else if (i % 3 == 0) {
				System.out.println(": es trio");
			} else if (i % 2 == 0) {
				System.out.println(": es par");
			} else {
				System.out.print("\n");
			}
		}
	}

	public static int ej3Factorial(int factorial) {

		if (factorial == 0) {
			return 1;
		} else {
			return factorial * ej3Factorial(factorial - 1);
		}
	}

	public static int ej3MCD(int num1, int num2) {
		if (num1 > num2) {
			int aux = 0;
			aux = num1;
			num1 = num2;
			num2 = aux;
		}
		if (num2 % num1 == 0) {
			return num1;
		} else {
			return ej3MCD(num2 % num1, num1);
		}
	}

	public static int ej3Fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return ej3Fibonacci(n - 1) + ej3Fibonacci(n - 2);
		}
	}

	public static boolean ej3esPrimo(int numero, int divisor) {
		if (numero <= 1) {
			return false;
		}
		if (divisor == 1) {
			return true;
		}
		if (numero % divisor == 0) {
			return false;
		}
		return ej3esPrimo(numero, divisor - 1);
	}

	public static boolean ej3esPrimo(int numero) {
		return ej3esPrimo(numero, numero - 1);
	}

	public static void ej4() {
		System.out.print("\n");// imprimir linea
		System.out.println("\"\"\"");// imprimir comillas
		System.out.print("\n\n\n\n");// imprimir lineas
	}

	public static void ej5() {

		for (int i = 0; i < 256; i++) {
			System.out.println((char) i);
		}

	}

	public static void ej6() {
		boolean toca = true;

		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el numero de columnas: ");

		int columnas = entrada.nextInt();
		System.out.println("Introduce el numero de filas: ");
		int filas = entrada.nextInt();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (toca) {
					System.out.print("N");
					toca = false;
				} else {
					System.out.print("B");
					toca = true;
				}

			}
			System.out.println();
		}
		entrada.close();
	}

	public static void ej7() {
	
		Scanner entrada2 = new Scanner(System.in);

		System.out.println("Introduce el numero de alturas: ");
		int alturas = entrada2.nextInt();
		entrada2.next();
		for (int i = 0; i < alturas; i++) {

			for (int j = 0; j < alturas - i - 1; j++) {
				System.out.print("-");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < alturas - i - 1; j++) {
				System.out.print("-");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = alturas - 1; i >= 0; i--) {
			for (int j = 0; j < alturas - i - 1; j++) {
				System.out.print("-");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < alturas - i - 1; j++) {
				System.out.print("-");
			}
			System.out.println();
		}

		entrada2.close();
	}

}