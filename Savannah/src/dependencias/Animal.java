package dependencias;
import java.util.*;
public class Animal extends SerVivo{
	protected Posicion2D posicion;
	protected boolean sexo; //true=masculino  //false=femenino
	protected Posicion2D anteriorPosicion;
	public Animal() {
		posicion=new Posicion2D(0,0);
		sexo=true;
		anteriorPosicion=new Posicion2D(0,0);
	}
	public Animal(int x,int y,boolean sexo) {
		posicion=new Posicion2D(x,y);
	}
public void move() {
	anteriorPosicion=posicion;
	Random random=new Random();
	int direccion=random.nextInt(3);
	
	switch(direccion) {
	case 0:
		if(posicion.getX()<9) {posicion.Xmas1();}//derecha
	break;
	
	case 1:if(posicion.getY()<9) {posicion.Ymas1();} //abajo
	break;
	case 2:if(posicion.getX()>0) {posicion.Xmas1();}//izquierda
	break;
	case 3: if(posicion.getY()>0) {posicion.Ymas1();} //arriba
	default:
		System.out.println("Ha habido un problema interno");
	}
};
public Posicion2D getPosicion() {
	return posicion;
}
public boolean getSexo() {
	return sexo;
}

public void noMove() {
	posicion=anteriorPosicion;
}

}
