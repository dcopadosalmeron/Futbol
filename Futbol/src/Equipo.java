
public class Equipo {
//atributos
private String nombre;
private int pj,pg,pe,pp,gf,gc,puntos;

//constructor
public Equipo(String nombre, int pJ, int pG, int pE, int pP, int gF, int gC,int puntos) {
	this.nombre = nombre;
	this.pj = pJ;
	this.pg = pG; 
	this.pe = pE;
	this.pp = pP;
	this.gf = gF;
	this.gc = gC;
	this.puntos = puntos;
}

//getters y setters
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getPJ() {
	return pj;
}
public void setPJ(int pJ) {
	pj = pJ;
}
public int getPG() {
	return pg;
}
public void setPG(int pG) {
	pg = pG;
}
public int getPE() {
	return pe;
}
public void setPE(int pE) {
	pe = pE;
}
public int getPP() {
	return pp;
}
public void setPP(int pP) {
	pp = pP;
}
public int getGF() {
	return gf;
}
public void setGF(int gF) {
	gf = gF;
}
public int getGC() {
	return gc;
}
public void setGC(int gC) {
	gc = gC;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}

@Override
public String toString() {
	return nombre + "|" + pj + "|" + pg + "|"
			+ pe + "|" + pp + "|" + gf + "|" + gc + "|"
			+ puntos;
}




}
