
public class final2020 {

	 static int[] par = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] arr = { 1, 0, 0, 0, 2, 3, 0, 0, 0, 1, 3, 2, 0, 0, 4, 0, 0, 2, 3, 0, 1, 0, 0, 4, 3, 2, 3, 1, 1, 0, 3, 0, 2, 2,
			2, 0, 6, 0, 1, 1, 1, 0 };

	public static void main(String[] args) {
		ordenar();
		imprimir() ;
	}

	public static  void ordenar() {
		int contador=0;
		int posPar=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				contador++;
				
				if(arr[i+1]==0&&contador%2==0) {
					for(int j=0;j<=contador; j++) {
						par[posPar+j]=arr[i-(contador-1)+j]; 
						
					}
					
					posPar=(posPar+contador)+1;
					par[posPar+1]=0;
					}
			}
			else {
				contador=0;
			}
		}
	}
	public static void imprimir() {
		for(int i=0; i<par.length; i++) {
			System.out.print(par[i]+" ");
		}
	}
}
