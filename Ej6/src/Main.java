import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		
		Conjunto conj1=new Conjunto();
		Conjunto conj2=new Conjunto();
	conj1.union(conj2);
	conj1.interseccion(conj2);
	
	List<Persona> miLista=new LinkedList<Persona>();
	for(int i=0;i<100;i++) {
	miLista.add(new Persona());
	
	}
	PersonaHashSet setPersonas=new PersonaHashSet();
	
	for(Persona cont:miLista) {
		setPersonas.add(cont);
	}//si ya se ha añadido, no se agrega
	System.out.println(setPersonas);
	
	
	for (Persona p : setPersonas) {
		System.out.println(p.getNombre());
        }
	
	}

}
