package batallanaval;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BatallaNaval {
final static int COL=pedir_tama�o_de_tablero("Ingrese ancho: ");
final static int FIL=pedir_tama�o_de_tablero("Ingrese alto: ");
	public static void main(String[] args) {
		//inicio objeto tablero 
		tablero t;
		t= new tablero();
		//pedir tama�o de tablero
		Jugador j;
		j=new Jugador();
		Jugador j2;
		j2=new Jugador();
		int matriz[][] = new int [COL][FIL];
		t.cargar_tablero(matriz, COL, FIL);
		t.imprimir_matriz(matriz,COL,FIL);
		
	}
	private static int pedir_tama�o_de_tablero(String texto) {
		int tama�o=0;
		try{	
			BufferedReader entrada = new BufferedReader(new
					InputStreamReader(System.in));
					System.out.println (texto);
					tama�o = Integer.valueOf(entrada.readLine());	
				
			}
			catch (Exception exc){
				System.out.println("ingreso invalido");			
			}	
		
		return tama�o;
	}
	
}
