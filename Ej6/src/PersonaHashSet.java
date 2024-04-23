import java.util.HashSet;

public class PersonaHashSet extends HashSet<Persona> {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 165834931701549277L;

	@Override
	    public boolean add(Persona persona) {
	        // Verificar si ya existe una persona igual en el conjunto
	        if (contains(persona)) {
	            System.out.println("Persona duplicada: " + persona);
	            return false; // No se agrega la persona duplicada
	        } else {
	        	
	        	for (Persona p : this) {
	                if (p.getNombre().equals(persona.getNombre())&&(p.getEdad()==persona.getEdad())) {
	                	  System.out.println("Persona duplicada: " + persona);
	                    return false;
	                }
	            }
	            // Agregar la persona al conjunto
	            return super.add(persona);
	        }
}}
