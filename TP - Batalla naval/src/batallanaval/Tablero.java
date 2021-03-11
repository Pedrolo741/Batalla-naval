package batallanaval;

import java.util.Random;

public class Tablero {
	final int MAXCOL;
	final int MAXFIL;
	int tablero[][];

	public Tablero(int MAXCOL, int MAXFIL) {						//arma el constructor del objeto Tablero recibiendo MAXCOL y MAXFIL con los valores q ingreso el usuario
		this.MAXCOL = MAXCOL;										//la constante del objeto Tablero, toma el valor que recibe el constructor
		this.MAXFIL = MAXFIL;
		this.tablero = new int[MAXCOL][MAXFIL];						//el tamaño de la matriz del objeto Tablero toma los valores recibidos

	}

	public void cargar() {											
		int maxbarcos;
		maxbarcos = porcentaje_segun_tablero();						//la variable maxbarcos toma el valor que retorne el metodo que devuelve la cantidad maxima de barcos segun el tamaño del tablero
		for (int fila = 0; fila < MAXFIL; fila++) {
			for (int columna = 0; columna < MAXCOL; columna++) {
				tablero[columna][fila] = 0;							//se carga la matriz con 0 (agua)
			}
		}
		generador_de_barcos(maxbarcos);								//invoca el metodo para generar barcos enviando como parametro el maximo de barcos

	}

	private void generador_de_barcos(int maxbarcos) {				
		/*Genera tamaños de barcos de manera random hasta lograr la cantidad maxima de barcos  */
		Random r = new Random();
		int contador = 0;											//contador para  llevar la cuenta de la cantidad de lugares para barcos
		while (contador < maxbarcos) {								
			int tamaño = r.nextInt((5 - 1 + 1) + 1);				//tamaño toma el valor random entre 1 y  5

			if (contador + tamaño > maxbarcos) {					//si el tamaño supera la cantidad maxima de lugares para barcos vuelve a tirar un random hasta que salga un tamaño adecuado
				while (contador + tamaño > maxbarcos) {				
					tamaño = r.nextInt(5 - 1 + 1) + 1;
				}

			}

			contador = (contador + tamaño);							
			agregar_barco(tamaño);									//agrega un barco segun el tamaño random  
		}
	}

	private void agregar_barco(int tamaño) {			
		Random r = new Random();
		int columna_random;
		int fila_random;
		boolean horizontal;											//
		do {/*elige una posicion y horizontalidad random hasta que el barco quepa en un lugar y no se salga de la matriz
		 		(el do while para no inicializar las variables)*/
			columna_random = r.nextInt((MAXCOL - 1) - 0 + 1);
			fila_random = r.nextInt((MAXFIL - 1) - 0 + 1);											//ese -0, hace algo?
			horizontal = r.nextBoolean();

		} while (verificar_lugar(tamaño, horizontal, fila_random, columna_random));				 	//mientras no haya lugar

		insertar_barco(tamaño, horizontal, fila_random, columna_random);							//cuando haya lugar inserta en el  tablero un barco	
	}

	private void insertar_barco(int tamaño, boolean horizontal, int fila_random, int columna_random) {
		/*Cambia el valor de la casilla de 0 a 1 indicando un barco.*/
		if (horizontal) {
			for (int i = 0; i < tamaño; i++) {					
				tablero[columna_random + i][fila_random] = 1;
			}
		} else {
			for (int i = 0; i < tamaño; i++) {
				tablero[columna_random][fila_random + i] = 1;
			}
		}

	}

	public boolean verificar_gano() {
		/*recorre la matriz buscando 3 (lugares bombardeados) y contandolos
		 *  si  la cantidad de lugares bombardeados es igual a la cantidad de barcos significa que gano*/
		int contador = 0;
		for (int fil = 0; fil < MAXFIL; fil++) {
			for (int col = 0; col < MAXCOL; col++) {
				if (tablero[col][fil] == 3) {												
					contador++;					
				}
				if (contador == porcentaje_segun_tablero()) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean verificar_lugar(int tamaño, boolean horizontal, int fila_random, int columna_random) {
		/*verifica que el barco en la posicion random no supere el tamaño de la matriz
		 * y q no haya un barco ocupando un lugar ya.*/
		if (horizontal) {
			if (columna_random + tamaño >= MAXCOL) {
				return true;
			}
			for (int i = 0; i < tamaño; i++) { 							//si entra,
				if (tablero[columna_random + i][fila_random] == 1) {
					return true;
				}
			}
			
			
			
		} else {
			if (fila_random + tamaño >= MAXFIL) {
				return true;
			}
			for (int i = 0; i < tamaño; i++) {
				if (tablero[columna_random][fila_random + i] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean bombardear(int col, int fil) {
		if (tablero[col][fil] == 1 || tablero[col][fil] == 3) {
			
			if (tablero[col][fil] == 1) {
				tablero[col][fil] = 3;
				System.out.println("acertaste");
			}
			else if(tablero[col][fil] == 3){
				System.out.println("Ya acertaste este lugar");
			}
			
			return true;
		} else {
			System.out.println("Fallaste");
			return false;
		}

	}

	private int porcentaje_segun_tablero() {
		return (int) ((MAXCOL * MAXFIL) * 0.2);
	}

	public void imprimir() {

		for (int fila = 0; fila < MAXFIL; fila++) {
			for (int columna = 0; columna < MAXCOL; columna++) {
				System.out.print(tablero[columna][fila] + " ");
				if (columna == MAXCOL - 1) {
					System.out.println(" ");
				}

			}
		}
	}

}
