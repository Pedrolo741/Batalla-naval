
public class Tablero {
	final int MAXCOL;
	final int MAXFIL;
	final int BOMBAS;
	
	public Tablero(int maxcol, int maxfil, int bombas) {
		this.MAXCOL = maxcol;
		this.MAXFIL = maxfil;
		this.BOMBAS = bombas;
		
		}
	
	public boolean jugar( int[][] mapa) {
		
		int guia_columna[]= new int[MAXCOL];
		int guia_fila[]= new int[MAXFIL];
		cargar_guia(MAXCOL, guia_columna);
		cargar_guia(MAXFIL, guia_fila);	
		String tablero [][] = new String [MAXFIL][MAXCOL];
		cargar_tablero(tablero);
		imprimir_tablero(guia_columna, guia_fila, tablero);
		boolean jugando=true;
		boolean gano=false;
		boolean perdio=false;
		while(jugando){
			descubrir_casilla(mapa,tablero);
			imprimir_tablero(guia_fila, guia_fila, tablero);
			gano=verificar_gano(tablero);
			perdio=verificar_perdio(tablero);
		if(gano){
			return true;
		}
		if (perdio){
			return false;
		}
		}
		
		
	return true;
	}
	
	private void cargar_guia(int max, int[] guia ) {
		for(int i=0; i<max; i++){
			guia[i]=i+1;
		}
	}
	
	private boolean verificar_perdio(String[][] tablero) {
		
		for(int fila=0;fila<MAXFIL;fila++){
			for (int columna=0;columna<MAXCOL;columna++){
				if(tablero[fila][columna]=="*"){
				return true;
				
				}
			}
		} 
		return false;
		}
		
		

	private boolean verificar_gano(String[][] tablero) {
		int casillas_cubiertas=0;
		for(int fila=0;fila<MAXFIL;fila++){
			for (int columna=0;columna<MAXCOL;columna++){
				if(tablero[fila][columna]=="+"){
					casillas_cubiertas++;
				}			
			}
		}
		if(casillas_cubiertas==BOMBAS){
			return true;
		}
		return false;
	}

	private void descubrir_casilla(int[][] mapa, String[][] tablero) {
		int fila=Buscaminas.pedir("fila", MAXFIL)-1;
		int columna=Buscaminas.pedir("columna", MAXCOL)-1;
				
		if(mapa[fila][columna]==0){
			tablero[fila][columna]=" ";
			
			descubrir_zona(fila, columna, mapa, tablero);
		
		}
		else if(mapa[fila][columna]==9){
			tablero[fila][columna]="*";
		}
		else {
			tablero[fila][columna]= Integer.toString(mapa[fila][columna]);
		}
		
		
	}

	private void descubrir_zona(int fila, int columna, int[][] mapa, String[][] tablero) {
		if(columna!=MAXCOL-1){
			if(fila!=MAXFIL-1){
				descubrir_casilla_zona(fila+1, columna+1,mapa, tablero);	
			}
			if(fila!=0){
				descubrir_casilla_zona(fila-1, columna+1,mapa, tablero);	
			}
			descubrir_casilla_zona(fila, columna+1,mapa, tablero);
		}
		if(columna!=0){
			if(fila!=MAXFIL-1){			
				descubrir_casilla_zona(fila+1, columna-1,mapa, tablero);
				}
			descubrir_casilla_zona(fila, columna-1,mapa, tablero);
			if (fila!=0){
				descubrir_casilla_zona(fila-1, columna-1,mapa, tablero);
			}
				
		}
		if (fila!=0){		
			descubrir_casilla_zona(fila-1, columna,mapa, tablero);
		}
		if (fila!=MAXFIL-1){		
			descubrir_casilla_zona(fila+1, columna,mapa, tablero);
		}
				
	}

	private void descubrir_casilla_zona(int fila, int columna, int[][] mapa, String[][] tablero) {
			
		if(tablero[fila][columna]=="+"){	
			if(mapa[fila][columna]==0){
			tablero[fila][columna]=" ";		
			descubrir_zona(fila, columna,mapa, tablero);
			}
			else  {
				tablero[fila][columna]= Integer.toString(mapa[fila][columna]);
			}
		}
		
			if(mapa[fila][columna]==9){
				tablero[fila][columna]="*";
			}
		
		
	}


	private void imprimir_tablero(int[] guia_columna, int[] guia_fila, String[][] tablero) {
		System.out.println("      COLUMNAS");
		for(int i=0;i<MAXCOL;i++){
			if(i==0){
				System.out.print("        "+guia_columna[i]);
			}
			else{			
			System.out.print("   "+guia_columna[i]);
			}
		}
		System.out.println(" ");
		for(int i=0;i<MAXCOL;i++){
			if(i==0){
				System.out.print("      -");
			}
				System.out.print("----");
		}
		System.out.println("");
		for(int fila=0;fila<MAXFIL;fila++){
			for(int columna=0;columna<MAXCOL;columna++){
						
				if(columna==0){
					if(fila==0){
						System.out.print(" F "+guia_fila[fila]+"  | ");
					}
					
					else if(fila==1){
						System.out.print(" I "+guia_fila[fila]+"  | ");
					}
					else if(fila==2){
						System.out.print(" L "+guia_fila[fila]+"  | ");
					}
					else if(fila==3){
						System.out.print(" A "+guia_fila[fila]+"  | ");
					}	
					else if(fila==4){
						System.out.print(" S "+guia_fila[fila]+"  | ");
					}
					else{
						System.out.print("   "+guia_fila[fila]+"  | ");	
					}
					
				}
				System.out.print(tablero[fila][columna] + " | ");
			}
			System.out.println("");
			for(int i=0;i<MAXCOL+1;i++){
				if (i==0){
					System.out.print("      ----");
				}
					System.out.print("---");
				}
			System.out.println("");
		}
	}

	private void cargar_tablero(String[][] tablero) {
		for (int fila=0;fila<MAXFIL;fila++){
			for(int columna=0;columna<MAXCOL;columna++){
				tablero[fila][columna]="+";
			}
		}
		
		
	}

}
