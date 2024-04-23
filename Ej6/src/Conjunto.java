import java.util.HashSet;
import java.util.Random;
public class Conjunto extends HashSet<Conjunto> {
	
	/**protected int FI;
	protected int Second;
	protected int Third;*/

	protected HashSet<Integer> storage=new HashSet<Integer>();
	
	public Conjunto() {
		Random random=new Random();
		
		for(int i=0;i<10;i++) {
			storage.add(random.nextInt(10));
		}
		System.out.println("Conjunto base: "+storage);
	}
	
	public void union(Conjunto otro) {
		HashSet<Integer>union=new HashSet<Integer>();
		for(Integer iter:otro.storage) {
			union.add(iter);
		}
		for(Integer iter:storage) {
			union.add(iter);
		}
		
		
		
		System.out.println("Conjunto union:"+union);
	}
	public void interseccion(Conjunto otro) {
		HashSet<Integer>interseccion=new HashSet<Integer>();
		for(Integer iter:otro.storage) {
			if(storage.contains(iter))
			interseccion.add(iter);	
		}
		System.out.println("Conjunto interseccion:"+interseccion);
	}

	/**
	public Conjunto(int i,int j,int k) {
		FI=i;
		Second=j;
		Third=k;
	}
	
*/
	
}
