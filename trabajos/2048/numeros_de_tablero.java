package tp2048;


public class numeros_de_tablero {
	final static int MAXCOL=4;
	final static int MAXFIL=4;

	public  void generar_numero(int[][] matriz) {
		int casillas_ocupadas=casillas_ocupadas(matriz);
		int val= (int) (2*Math.random());
		int fila_random = (int) (MAXFIL*Math.random());
		int columna_random = (int) (MAXCOL*Math.random());
		if(matriz[fila_random][columna_random]==0){
			
		switch (val){
				case 0:{			
					matriz[fila_random][columna_random]=2;			
					break;
				}	
				case 1:	{
					matriz[fila_random][columna_random]=4;
					break;
				}
			}
		}
		else if(matriz[fila_random][columna_random]!=0&&casillas_ocupadas!=16){
			
			generar_numero(matriz);
		}
	}
	public int casillas_ocupadas(int[][] matriz) {
		int casillas_ocupadas=0;
		for(int columna=0;columna<MAXCOL;columna++){
			for(int fila=0;fila<MAXFIL;fila++){
				
				if(matriz[fila][columna]!=0){
					casillas_ocupadas++;
				}
				
				
			}
		}
		return casillas_ocupadas;
	}
}
