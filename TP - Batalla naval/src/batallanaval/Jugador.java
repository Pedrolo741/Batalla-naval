package batallanaval;

public class Jugador {
	
	public Jugador(int MAXCOL, int MAXFIL){
		Tablero tablero= new Tablero(MAXCOL, MAXFIL);
		tablero.cargar();
		tablero.imprimir();
		
	}
}
