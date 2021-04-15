package tp2048;

public class mover {
	final  int MAXCOL=4;
	final  int MAXFIL=4;


	
	public int  mover_function(int[][] matriz,char movimiento) {
		numeros_de_tablero n;
		n= new numeros_de_tablero();
		int puntaje=0;
		System.out.println(movimiento);
		switch (movimiento){
			case 'w': puntaje= mover_arriba(matriz);break;	
			case 'a': puntaje= mover_izquierda(matriz);break;
			case 's': puntaje= mover_abajo(matriz);break;
			case 'd': puntaje= mover_derecha(matriz);break;
			}
			n.generar_numero(matriz);
			return puntaje;
		}
private  int mover_arriba(int[][] matriz) {
		int puntaje = 0;
		for(int columna=0; columna<MAXCOL;columna++){
			for(int i=0; i<MAXFIL;i++)
			{
				
			
			for(int fila=1;fila<MAXFIL;fila++){
					while(matriz[fila-1][columna]==0){
						
					if(matriz[fila][columna]!=0||matriz[fila-1][columna]==0){
					if(matriz[fila-1][columna]==0){
						
						matriz[fila-1][columna]=matriz[fila][columna];
						matriz[fila][columna]=0;
						
					}
					}
					break;	
					}
					if(matriz[fila][columna]==matriz[fila-1][columna]&&matriz[fila][columna]!=0){
						matriz[fila-1][columna]+=matriz[fila][columna];
						matriz[fila][columna]=0;
						puntaje=matriz[fila-1][columna];
						i=MAXFIL;
					}
					
				}
				}	
			}
		return puntaje;
		}

	private  int  mover_abajo(int[][] matriz) {
		int puntaje = 0;
		for(int columna=0; columna<MAXCOL;columna++){
			for(int i=0; i<MAXFIL;i++)
			{
				
			
			for(int fila=MAXFIL-2;fila>=0;fila--){
					while(matriz[fila+1][columna]==0){
						
					if(matriz[fila][columna]!=0||matriz[fila+1][columna]==0){
					if(matriz[fila+1][columna]==0){
						
						matriz[fila+1][columna]=matriz[fila][columna];
						matriz[fila][columna]=0;
						
					}
					}
					break;	
					}
					if(matriz[fila][columna]==matriz[fila+1][columna]&&matriz[fila][columna]!=0){
						matriz[fila+1][columna]+=matriz[fila][columna];
						matriz[fila][columna]=0;
						puntaje=matriz[fila+1][columna];
						i=MAXFIL;

					}
				}
				}	
			}
		return puntaje;
	}

	private  int  mover_izquierda(int[][] matriz) {
		int puntaje=0;
		for(int fila=0; fila<MAXFIL;fila++){
			for(int i=0; i<MAXFIL;i++)
			{
				
			
			for(int columna=1;columna<MAXCOL;columna++){
					while(matriz[fila][columna-1]==0){
						
					if(matriz[fila][columna]!=0||matriz[fila][columna-1]==0){
					if(matriz[fila][columna-1]==0){
						
						matriz[fila][columna-1]=matriz[fila][columna];
						matriz[fila][columna]=0;
						
					}
					}
					break;	
					}
					if(matriz[fila][columna]==matriz[fila][columna-1]&&matriz[fila][columna]!=0){
						matriz[fila][columna-1]+=matriz[fila][columna];
						matriz[fila][columna]=0;
						puntaje=matriz[fila][columna-1];
						i=MAXFIL;

					}
				}
				}	
			}
		return puntaje;
	}

	private  int  mover_derecha(int[][] matriz) {
		int puntaje=0;
		for(int fila=0; fila<MAXFIL;fila++){
			for(int i=0; i<MAXCOL;i++){
				
			
			for(int columna=MAXCOL-2;columna>=0;columna--){
					while(matriz[fila][columna+1]==0){
						
					if(matriz[fila][columna]!=0||matriz[fila][columna+1]==0){
					if(matriz[fila][columna+1]==0){
						
						matriz[fila][columna+1]=matriz[fila][columna];
						matriz[fila][columna]=0;
						
					}
					}
					break;	
					}
					if(matriz[fila][columna]==matriz[fila][columna+1]&&matriz[fila][columna]!=0){
						matriz[fila][columna+1]+=matriz[fila][columna];
						matriz[fila][columna]=0;
						puntaje+=matriz[fila][columna+1];
						i=MAXFIL;

					}
				}
				}	
			}
		return puntaje;
	}
	public  boolean verificar_perdio(int[][] matriz) {
		numeros_de_tablero n;
		n= new numeros_de_tablero();
		
		boolean perdio=false;
		int casillas_ocupadas=n.casillas_ocupadas(matriz);
		int cantidad_casillas=16;
		
		for(int fila=0;fila<MAXFIL;fila++){
			for(int columna=1;columna<MAXCOL;columna++){
				if(matriz[fila][columna-1]==matriz[fila][columna]&&matriz[fila][columna]!=0){
				casillas_ocupadas--;
				break;
			}
		}
		}
		for(int columna=0;columna<MAXCOL;columna++){
				for(int fila2=1;fila2<MAXFIL;fila2++){
					if(matriz[fila2-1][columna]==matriz[fila2][columna]&&matriz[fila2][columna]!=0){
					casillas_ocupadas--;
					break;
		}
	}
		}
		if(casillas_ocupadas==cantidad_casillas){
			perdio=true;
			return perdio;
	}
		return perdio;
}
	
	public  boolean verifica_2048(int[][] matriz) {
		 boolean gano=false;
		for(int columna=0; columna<MAXCOL;columna++){
			for(int fila=0; fila<MAXFIL;fila++){
				if(matriz[fila][columna]==2048){
					gano=true;
					
				}
				if(gano){
					return gano;
				}
			}
		}
		return gano;
	}
	

}
