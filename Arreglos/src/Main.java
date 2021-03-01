
import java.util.Random;

public class Main {
	
	
public static void main (String arg[]) {
	
	
	
		//tipo[] nombreArreglo = new tipo[tamañoArreglo];
		int[] arregloEnteros = new int[100];
		//String[] arregloCadenas = new String[10];
		int x =0;
		Random numero = new Random();
		
		for ( int i=0 ; i<100;i++) {
			
			x=1+numero.nextInt(100000);
			arregloEnteros[i]=x;
			
		}
		int ValorMaximo= arregloEnteros[0];
		int aux =0;
		
		for (int j=0; j<99;j++) {
for ( int i=0 ; i<99;i++) {
	
	//System.out.println(arregloEnteros[i+1]);
			
			if (arregloEnteros[i]<arregloEnteros[i+1]) {
				
				aux = arregloEnteros[i];
				
				arregloEnteros[i]= arregloEnteros[i+1];
				arregloEnteros[i+1]=aux;
				
			}
			
		}


		}
		
		
		for ( int i=0 ; i<100;i++) {
			
			System.out.println(arregloEnteros[i]);
					
				}
					
				}

	}




