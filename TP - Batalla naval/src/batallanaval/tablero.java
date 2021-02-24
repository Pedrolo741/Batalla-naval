package batallanaval;
import java.util.Random;
public class tablero {
	//cargar la matriz con agua
	public void cargar_tablero(int[][] matriz, int MAXCOL, int MAXFIL) {
		int maxbarcos;
		maxbarcos=porcentaje_segun_tablero(MAXCOL,MAXFIL);
		for(int fila=0; fila<MAXFIL; fila++) {
			for(int columna=0; columna<MAXCOL; columna++) {
				matriz[columna][fila]=0;
			}
		}
		generador_de_barcos(matriz, maxbarcos, MAXCOL, MAXFIL);
		
	}
	private void generador_de_barcos(int[][] matriz, int maxbarcos, int MAXCOL, int MAXFIL) {

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
		agregar_barco(matriz, tamaño, MAXCOL, MAXFIL);
		}
	}
	private void agregar_barco(int[][] matriz, int tamaño, int MAXCOL, int MAXFIL) {
		Random r = new Random();
		int columna_random;
		int fila_random;
		boolean horizontal;
		do {
			 columna_random= r.nextInt((MAXCOL-1)-0+1);
			 fila_random= r.nextInt((MAXFIL-1)-0+1);
			 horizontal = r.nextBoolean();
		}
		while(!verificar_lugar(matriz, tamaño, horizontal, fila_random, columna_random, MAXCOL, MAXFIL)); 
		 
		insertar_barco(matriz, tamaño, horizontal, fila_random, columna_random, MAXCOL, MAXFIL);
	}
	
	
	private void insertar_barco(int[][] matriz, int tamaño, boolean horizontal, int fila_random, int columna_random,
			int MAXCOL, int MAXFIL) {
		if(horizontal) {
			for(int i=0; i<tamaño; i++) {
				matriz[columna_random+i][fila_random]=1;
			}
		}
		else {
			for(int i=0; i<tamaño;  i++) {
				matriz[columna_random][fila_random+i]=1;
			}
		}
		
	}
	
	
	private boolean verificar_lugar(int[][] matriz,int tamaño,boolean horizontal , int fila_random, int columna_random, int MAXCOL, int MAXFIL) {
		if(horizontal) {
			if(columna_random+tamaño>=MAXCOL) {
				return false;
			}
			for(int i=0; i<tamaño; i++) {
				if(matriz[columna_random+i][fila_random]==1) {
					return false;
				}
			}
		}
		else {
			if(fila_random+tamaño>=MAXFIL) {
				return false;
			}
			for(int i=0;i<tamaño; i++) {
				if(matriz[columna_random][fila_random+i]==1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	private int porcentaje_segun_tablero(int col, int fil) {
		return (int) ((col*fil)*0.2);
	}
	public  void imprimir_matriz(int[][] matriz,int MAXCOL, int MAXFIL) {
		
		for(int fila =0; fila<MAXFIL; fila++){
			for(int columna = 0;columna<MAXCOL;columna++){
				System.out.print(matriz[columna][fila]+" ");
				if(columna==MAXCOL-1){
					System.out.println(" ");
				}

			}
		}
	}
	
}
