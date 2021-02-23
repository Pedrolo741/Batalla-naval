package batallanaval;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BatallaNaval {
final static int COL=pedir_tamaño_de_tablero("Ingrese ancho: ");
final static int FIL=pedir_tamaño_de_tablero("Ingrese alto: ");
	public static void main(String[] args) {
		//inicio objeto tablero 
		tablero t;
		t= new tablero();
		//pedir tamaño de tablero
		Jugador j;
		j=new Jugador();
		Jugador j2;
		j2=new Jugador();
		int matriz[][] = new int [COL][FIL];
		t.cargar_tablero(matriz, COL, FIL);
		t.imprimir_matriz(matriz,COL,FIL);
		
	}
	private static int pedir_tamaño_de_tablero(String texto) {
		int tamaño=0;
		try{	
			BufferedReader entrada = new BufferedReader(new
					InputStreamReader(System.in));
					System.out.println (texto);
					tamaño = Integer.valueOf(entrada.readLine());	
				
			}
			catch (Exception exc){
				System.out.println("ingreso invalido");			
			}	
		
		return tamaño;
	}
	
}
