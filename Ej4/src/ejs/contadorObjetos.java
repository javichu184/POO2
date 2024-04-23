package ejs;

public class contadorObjetos {
static int contador=0;
public contadorObjetos(){
	contador++;
}
@SuppressWarnings("removal")
public void finalize() throws Throwable {
	contador--;
    super.finalize();
}
public static int getObjetos() {
	return contador;
}
}
