import java.util.Scanner;

public class SumaElevada {

	public static void main (String arg[]) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("ingese  valor de la base ");
		int a = teclado.nextInt(); // base 
		System.out.println("ingese  valor del exponente ");
		int b = teclado.nextInt(); // exponente 
		int valor1=0;
		int resultado=0;
		int valor2 = a;
		int aux=0;
		
		for (int j=0;j<b-1;j++) {
			
			if ( aux==0) {
		
for ( int i=0 ; i<a;i++) {
	
	valor1 += valor2;
	aux++;
	
}
			}
			else {
			for ( int i=0 ; i<a-1;i++) {
				
				valor1 += valor2;
				
			}
			}
System.out.println(valor1);
valor2=valor1;

	


}
	
		System.out.println("Resultado final de la operacion  "+valor1);
		
	}

}


