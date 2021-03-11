package batallanaval;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatallaNaval {
	final static int COL = pedir_tamaño_de_tablero("Ingrese ancho: ");				//Declaro constante que toma el valor que retorna la funcion pedir tamaño
	final static int FIL = pedir_tamaño_de_tablero("Ingrese alto: ");

	public static void main(String[] args) {
		boolean jugando = true;											//un boolean para q arranque el juego
		int modo_de_juego = pedir_modo_de_juego();//la variable toma el valor q devuelve el metodo (que va a ser 1 o 2)
		if (modo_de_juego == 2) {
			System.out.println("1 VS 1");
			Tablero t1 = new Tablero(COL, FIL);  						//inicializo objeto tablero y creo el tablero de jugador1 (le paso COL y FIL q es el tamaño q va a tener la matriz)		
			Jugador j1 = new Jugador();									//jugador 1
			Tablero t2 = new Tablero(COL, FIL);							//tablero jugador2
			Jugador j2 = new Jugador();									//jugador2
			t1.cargar();												//cargo el tablero con un metodo del objeto Tablero
			t2.cargar();												//cargo el tablero con un metodo del objeto Tablero
			while (jugando) {											//comienza el juego en un bucle, mientras jugando sea true
				System.out.println("Turno jugador 1");
				j1.ataque(COL, FIL, t2);								//jugador1 usa metodo ataque del objeto Jugador con el tablero de j2 como parametro para poder atacarlo
				if (t2.verificar_gano()) {								//uso el metodo del objeto Tablero que me va a devolver un boolean para saber si entra o no al if
					jugando = false;									//si se cumple el if, jugando pasa a ser false por lo q no va a entrar mas al while
					System.out.println("Gano jugador 1");
					break;												//para q salga del while ni bien gane alguien
				}
				t2.imprimir();
				System.out.println("Turno jugador 2");
				j2.ataque(COL, FIL, t1);

				if (t1.verificar_gano()) {
					jugando = false;
					System.out.println("Gano jugador 2");
					break;
				}
				t1.imprimir();
			}

		} else {														//en caso de jugar vs com
			/*la misma logica q vs 1, solamente uso el metodo ataque_automatico del objeto Jugador para usar random*/
			System.out.println("1 VS COM");

			Tablero t1 = new Tablero(COL, FIL);
			Jugador j1 = new Jugador();
			Tablero t2 = new Tablero(COL, FIL);
			Jugador j2 = new Jugador();
			t1.cargar();
			t2.cargar();
			while (jugando) {
				System.out.println("Turno jugador 1");

				j1.ataque(COL, FIL, t2);
				if (t2.verificar_gano()) {
					jugando = false;
					System.out.println("Gano Player 1");
					break;
				}
				t2.imprimir();
				System.out.println("Turno COM");

				j2.ataque_automatico(COL, FIL, t1);//
				if (t1.verificar_gano()) {
					jugando = false;
					System.out.println("Gano Player 2");
					break;
				}
				t1.imprimir();
			}

		}

	}

	private static int pedir_tamaño_de_tablero(String texto) {
		int tamaño = 0;
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(texto);
			tamaño = Integer.valueOf(entrada.readLine());

		} catch (Exception exc) {
			System.out.println("ingreso invalido");
		}

		return tamaño;
	}

	private static int pedir_modo_de_juego() {
		int modo = 0;												//modo en 0 para q arranque el while
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			while (modo < 1 || modo > 2) {							//si modo no vale ni uno ni dos(asi limito las opciones, y si eligen 1 o 2 no entra al while de nuevo), va a comenzar el while para pedir un modo de juego
				if (modo != 0) {									//si modo no vale 0 (el valor con el q inicialice), significa q ya intento ingresar un valor q no es valido
					System.out.println("opcion invalida: ");
				}
				System.out.println("Ingresar cantidad de jugadores 1 (1vsCOM) o 2 (1vs1): ");
				modo = (int) Integer.valueOf(entrada.readLine());

			}

		} catch (Exception exc) {

		}
		return modo;
	}
}
