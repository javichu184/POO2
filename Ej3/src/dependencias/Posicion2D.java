package dependencias;

public class Posicion2D {
private int x;
private int y;
public Posicion2D() {
	x=0;
	y=0;
}
public Posicion2D(int x,int y) {
	this.x=x;
	this.y=y;
}
public int getX() {
	return x;
}
public int getY() {
return y;
}
public Posicion2D Xmas1() {
    x++;
    return this;
}
public Posicion2D Ymas1() {
    y++;
    return this;
}
}
