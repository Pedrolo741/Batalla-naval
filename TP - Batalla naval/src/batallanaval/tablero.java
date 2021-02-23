package batallanaval;

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
