package tp2048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class juego {
	
	final int MAXFIL;
	final int MAXCOL;
	int puntaje=0;
	
	public juego(int maxfil2, int maxcol2) {
		this.MAXFIL=maxfil2;
		this.MAXCOL=maxcol2;
		
	}
	public  void comenzar_juego(int[][] matriz) {
		boolean jugando = true;
		while(jugando){
			jugando=jugada(matriz);	
		}
	}
	private  boolean jugada(int[][] matriz) {
		mover m;
		m= new mover();
		boolean gano=false;
		boolean jugando=true;
		boolean perdio=false;
		char movimiento = pedir_movimiento();

		puntaje += m.mover_function(matriz,movimiento);
		imprimir_matriz(matriz);	
		gano=m.verifica_2048(matriz);
		perdio=m.verificar_perdio(matriz);
		System.out.println("Puntaje="+puntaje);
		
		if(gano){
			System.out.print("ganaste");
			jugando=false;
			return jugando;
		}
		else if(perdio){
			System.out.print("Perdiste");
			jugando=false;
			return jugando;
		}
		return jugando;
	}
	
	
	

	private char pedir_movimiento() {
		char movimiento = '0';
		try{
			BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Mueva con 'w' 'A' 'S' 'D'" );
			movimiento = (char) (entrada.readLine().charAt(0));
		}
		catch(Exception exc){
			System.out.println("ingreso invalido");
		}
		return movimiento;
	}

	

	public  void imprimir_matriz(int[][] matriz) {
		
		for(int fila =0; fila<=MAXFIL-1; fila++){
			for(int columna = 0;columna<=MAXCOL-1;columna++){
				System.out.print(matriz[fila][columna]+" ");
				if(columna==MAXCOL-1){
					System.out.println(" ");
				}

			}
		}
	}

}
