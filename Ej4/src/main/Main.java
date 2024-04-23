package main;
import ejs.contadorObjetos;
import ejs.prueba;
import java.lang.Thread; 
public class Main {

	public static void main(String[] args) {
	ejs2.prueba.a=3;
	
	Runtime gc= Runtime.getRuntime();
	
	contadorObjetos a=new contadorObjetos();
	System.out.println(a.getObjetos());
	
	try {
		a.finalize();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(contadorObjetos.getObjetos());
	}
	//ejercicio7
	
	
	
	
}
