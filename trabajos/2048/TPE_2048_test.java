package tp2048;

import java.io.BufferedReader; //contiene operaciones de E/S
import java.io.InputStreamReader;
public class TPE_2048_test {
	final static int MAXCOL=4;
	final static int MAXFIL=4;
	
	
	public static void main(String[] args) {
		numeros_de_tablero n;
		n= new numeros_de_tablero();
		mover m;
		m= new mover();
		int matriz[][]= new int [MAXFIL][MAXCOL];
		juego j;
		j= new juego(MAXFIL, MAXCOL);
		n.generar_numero(matriz);
		n.generar_numero(matriz);		
		j.imprimir_matriz(matriz);		
		j.comenzar_juego(matriz);
	}
}