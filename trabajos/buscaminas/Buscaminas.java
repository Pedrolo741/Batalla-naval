import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Buscaminas {
	
	
	final static int MAXCOL=pedir("ancho del tablero",10);
	final static int MAXFIL=pedir("alto del tablero",10);
	

public static void main(String[] args) {
	Mapa m;
	m=new Mapa(MAXCOL, MAXFIL);
	int mapa [][] = new int [MAXFIL][MAXCOL];		
	m.cargar_mapa(mapa);
	
	Tablero t;
	t=new Tablero(MAXCOL, MAXFIL, m.getBombas());
	boolean gano = t.jugar(mapa);
	if (gano) {
		System.out.println("GANASTEE");
	}
	else {
		System.out.println("PERDISTEE");
	}
}


public static int pedir(String texto,int maximo) {
	int x = -1;
	while(x<=0 || x>maximo){		
	try{	
		BufferedReader entrada = new BufferedReader(new
				InputStreamReader(System.in));
				System.out.println ("Ingrese " + texto + " :");
				x = new Integer.valueOf(entrada.readLine());	
		}
		catch (Exception exc){
			System.out.println("ingreso invalido");			
		}	
	}
	return x;
}

}
