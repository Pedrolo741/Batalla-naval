

public class Mapa {
	final int MAXCOL;
	final int MAXFIL;
	final int BOMBAS;
	
	public Mapa(int maxcol, int maxfil) {
		this.MAXCOL=maxcol;
		this.MAXFIL=maxfil;
		int max_bombas = (int) ((MAXFIL*MAXCOL)*0.15);
		this.BOMBAS = Buscaminas.pedir("cantidad de bombas", max_bombas);
		
	}
	
	public void imprimir_mapa(int[][] mapa) {
		for(int fila=0;fila<MAXFIL;fila++){
			for(int columna=0;columna<MAXCOL;columna++){
				System.out.print(mapa[fila][columna] + " | ");
			}
			System.out.println("");
			for(int i=0;i<MAXCOL;i++){
				System.out.print("-   ");
			}
			System.out.println("");
		}
	}
	
	public void cargar_mapa(int[][] mapa){
		colocar_bombas(mapa);
		colocar_numeros(mapa);
	}
	
	private void colocar_bombas(int[][] mapa) {
		int fila_random;
		int columna_random;
		for(int i=0; i<BOMBAS;i++){
			fila_random = (int) (MAXFIL*Math.random());
			columna_random = (int) (MAXCOL*Math.random());
			while (mapa[fila_random][columna_random]!=0){
				fila_random = (int) (MAXFIL*Math.random());
				columna_random = (int) (MAXCOL*Math.random());
			}
			mapa[fila_random][columna_random] = 9;		
		}
	}
	
	private void colocar_numeros(int[][] mapa) {
		for(int fila=0; fila<MAXFIL;fila++){
			for(int columna=0; columna<MAXCOL;columna++){
				if (mapa[fila][columna]!=9){					
					mapa[fila][columna]=cant_bombas(mapa,fila,columna);
				}			
			}
		}	
	}

	private int cant_bombas(int[][] mapa, int fila, int columna){
		int bombas=0;
		
		if(columna!=MAXCOL-1){
			if(fila!=MAXFIL-1){
				if(mapa[fila+1][columna+1]==9){
					bombas++;
				}
			}
			if(fila!=0){
				if(mapa[fila-1][columna+1]==9){
					bombas++;
				}
			}
			if(mapa[fila][columna+1]==9){
				bombas++;
			}
		}
		if(columna!=0){
			if(fila!=MAXFIL-1){			
				if(mapa[fila+1][columna-1]==9){
					bombas++;
				}
			}
			if(mapa[fila][columna-1]==9){
				bombas++;
			}
			if (fila!=0){
				if(mapa[fila-1][columna-1]==9){
					bombas++;
				}
			}
				
		}
		if (fila!=0){		
			if(mapa[fila-1][columna]==9){
				bombas++;
			}
		}
		if (fila!=MAXFIL-1){		
			if(mapa[fila+1][columna]==9){
				bombas++;
			}
		}
		
		return bombas;
	}
	
	public int getBombas(){
		return BOMBAS;
	}
	
	

}
