
public class Persona implements Comparable<Persona> {
public int edad;
public String nombre;

public Persona(int e, String n) {
	edad = e;
	nombre = n;
}
@Override
public int compareTo(Persona o) {
	if (this.nombre.length() < o.nombre.length()) {
		for (int i = 0; i < this.nombre.length();i++) {
			if((int)o.nombre.charAt(i) > (int)this.nombre.charAt(i)) {
				return -1;
			}else if ((int)o.nombre.charAt(i) < (int)this.nombre.charAt(i)){
				return 1;
			}
		}
			
	}
	else {
		for (int i = 0; i < o.nombre.length(); i++) {
			if((int)o.nombre.charAt(i) > (int)this.nombre.charAt(i)) {
				return -1;
			}else if ((int)o.nombre.charAt(i) < (int)this.nombre.charAt(i)){
				return 1;
			}
		}
			
	}
	return 0;
}
}
