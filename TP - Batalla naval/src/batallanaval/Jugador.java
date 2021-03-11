package batallanaval;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Jugador {

	public void ataque(int maxcol, int maxfil, Tablero tablero) {
		int columna = -1;
		int fila = -1;
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

			while (columna > maxcol || columna < 0 || fila > maxfil || fila < 0) {
				if (columna != -1) {
					System.out.println("coordenada invalida: ");
				}
				System.out.println("Ingresar coordenadas para bombardear: ");
				columna = (int) Integer.valueOf(entrada.readLine());
				fila = (int) Integer.valueOf(entrada.readLine());

			}

		} catch (Exception exc) {

		}
		tablero.bombardear(columna - 1, fila - 1);

	}
	public void ataque_automatico(int maxcol, int maxfil, Tablero tablero) {
		
		Random r = new Random();
		int columna_random=r.nextInt((maxcol - 1) - 0 + 1);//ese -0, hace algo?
		int fila_random=r.nextInt((maxfil - 1) - 0 + 1);//ese -0, hace algo?
		tablero.bombardear(columna_random, fila_random);
		
	}

}
