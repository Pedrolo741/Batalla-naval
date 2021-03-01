package batallanaval;

import java.util.Random;
public class Tablero {
	final int MAXCOL;
	final int MAXFIL;
	int tablero[][];
	public Tablero(int MAXFIL, int MAXCOL) {
		this.MAXCOL= MAXCOL;
		this.MAXFIL= MAXFIL;
		this.tablero= new int [MAXCOL][MAXFIL];

	}
	public void cargar() {
		int maxbarcos;
		maxbarcos=porcentaje_segun_tablero();
		for(int fila=0; fila<MAXFIL; fila++) {
			for(int columna=0; columna<MAXCOL; columna++) {
				tablero[columna][fila]=0;
			}
		}
		generador_de_barcos(maxbarcos);
		
	}
	private void generador_de_barcos(int maxbarcos) {

		Random r = new Random();
		int contador = 0;
		while (contador<maxbarcos){
			int tamaño= r.nextInt((5-1+1)+1);
			
			if (contador+tamaño>maxbarcos) {	
				while(contador+tamaño>maxbarcos) {				
					tamaño= r.nextInt(5-1+1)+1;
				}
				
			}
			
		contador=(contador+tamaño);
		agregar_barco(tamaño);
		}
	}
	private void agregar_barco(int tamaño) {
		Random r = new Random();
		int columna_random;
		int fila_random;
		boolean horizontal;
		do {
			 columna_random= r.nextInt((MAXCOL-1)-0+1);
			 fila_random= r.nextInt((MAXFIL-1)-0+1);
			 horizontal = r.nextBoolean();
		}
		while(!verificar_lugar(tamaño, horizontal, fila_random, columna_random)); 
		 
		insertar_barco(tamaño, horizontal, fila_random, columna_random);
	}
	
	
	private void insertar_barco(int tamaño, boolean horizontal, int fila_random, int columna_random) {
		if(horizontal) {
			for(int i=0; i<tamaño; i++) {
				tablero[columna_random+i][fila_random]=1;
			}
		}
		else {
			for(int i=0; i<tamaño;  i++) {
				tablero[columna_random][fila_random+i]=1;
			}
		}
		
	}
	
	
	private boolean verificar_lugar(int tamaño,boolean horizontal , int fila_random, int columna_random) {
		if(horizontal) {
			if(columna_random+tamaño>=MAXCOL) {
				return false;
			}
			for(int i=0; i<tamaño; i++) {
				if(tablero[columna_random+i][fila_random]==1) {
					return false;
				}
			}
		}
		else {
			if(fila_random+tamaño>=MAXFIL) {
				return false;
			}
			for(int i=0;i<tamaño; i++) {
				if(tablero[columna_random][fila_random+i]==1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	private int porcentaje_segun_tablero() {
		return (int) ((MAXCOL*MAXFIL)*0.2);
	}
	public  void imprimir() {
		
		for(int fila =0; fila<MAXFIL; fila++){
			for(int columna = 0;columna<MAXCOL;columna++){
				System.out.print(tablero[columna][fila]+" ");
				if(columna==MAXCOL-1){
					System.out.println(" ");
				}

			}
		}
	}
	
	
	
}
