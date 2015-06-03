
public class Equipo {
//atributos
private String nombre;
private int PJ,PG,PE,PP,GF,GC,puntos;

//constructor
public Equipo(String nombre, int pJ, int pG, int pE, int pP, int gF, int gC,int puntos) {
	this.nombre = nombre;
	this.PJ = pJ;
	this.PG = pG;
	this.PE = pE;
	this.PP = pP;
	this.GF = gF;
	this.GC = gC;
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
	return PJ;
}
public void setPJ(int pJ) {
	PJ = pJ;
}
public int getPG() {
	return PG;
}
public void setPG(int pG) {
	PG = pG;
}
public int getPE() {
	return PE;
}
public void setPE(int pE) {
	PE = pE;
}
public int getPP() {
	return PP;
}
public void setPP(int pP) {
	PP = pP;
}
public int getGF() {
	return GF;
}
public void setGF(int gF) {
	GF = gF;
}
public int getGC() {
	return GC;
}
public void setGC(int gC) {
	GC = gC;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}

}
