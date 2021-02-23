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
		generador_de_barcos(matriz, maxbarcos);
		
	}
	private void generador_de_barcos(int[][] matriz, int maxbarcos) {
		Random r = new Random();
		int tamaño= r.nextInt((5-1+1)+1);
		System.out.println(tamaño);
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
