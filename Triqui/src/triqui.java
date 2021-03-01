
import java.util.Scanner;


	

public class triqui {
	
	static final char JUGADOR1= 'O';
	static final char JUGADOR2='X';
	static final char TAG='-';
	
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
			

		System.out.println("cantidad de matrices =");
		int V;
		V = teclado.nextInt();
			char T[][] = new char[V][V];
			boolean Existeganador = false;
			
			int jugadas =0;
			int y=0;
			int f,c;
			boolean salir =false;
			int numero=0;
			
			String valorSt="";
			int array[] = new int[1005];
			
			clean(T,V);
			
			System.out.println("Juego del triqui");
			
			 while (Existeganador==false && jugadas<V*V) {
				 
				 
				 
				System.out.println("Jugada de jugador 1");

				System.out.println("Fila =");
				f = teclado.nextInt();

				System.out.println("Columna =");
				c = teclado.nextInt();
				
				if(c>V || f>V) {
					System.out.println("Jugador 1 pierde el juego, por repetir elegir una casilla mas grande de la existente");
					
					break;
				}
				String	valorc = Integer.toString(c);
				String	valorf = Integer.toString(f);
				valorSt = valorc+valorf;
				System.out.println(valorSt);
				array[y]=numero;
				 numero = Integer.parseInt(valorSt);
										
				if(y>0) {
				for (int m=0;m<=1000;m++) {
					  
					if (numero == array[m]) {
						System.out.println("mismo valor jugador pierde ");
						salir = true;
						break;
					}
				}
				}
				
				if (salir==true) {
					break;
			}
				y++;
				
				T[f-1][c-1]= JUGADOR1;
				ShowTable(T,V);
				
				if (Winner(T,JUGADOR1,V)) {
					
					System.out.println("Jugador1 GANO");
					Existeganador=true;
					break;
					
				}
				jugadas ++;
				System.out.println(jugadas);
				if(jugadas >=V*V) {
					
					break;
				}
				System.out.println("Jugada de jugador 2");

				System.out.println("Fila =");
				f = teclado.nextInt();

				System.out.println("Columna =");
				c = teclado.nextInt();
				
				if(c>V || f>V) {
					System.out.println("Jugador 1 pierde el juego, por repetir elegir una casilla mas grande de la existente");
					
					break;
				}
					valorc = Integer.toString(c);
					valorf = Integer.toString(f);
				valorSt = valorc+valorf;
				System.out.println(valorSt);
				array[y]=numero;
				 numero = Integer.parseInt(valorSt);
	
				for (int m=0;m<=1000;m++) {
					
					if (numero==array[m]) {
						System.out.println("Jugador 1 pierde el juego, por repetir en misma casilla");
						salir = true;
						break;
						
					}
				}
				
				
				if (salir==true) {
					break;
					
				}
				
				
				y++;
				T[f-1][c-1]= JUGADOR2;
				ShowTable(T,V);
				
				if (Winner(T,JUGADOR2,V)) {
					
					System.out.println("Jugador 2 GANO");
					Existeganador=true;
					break;
					
				}
				jugadas ++;
			
			}
		
			if(Existeganador == false && salir == false ) {
		
				System.out.println("juego en empate");
			
			}
		}

	private static boolean Winner(char[][] t, char MJ,int Vm) {
		// TODO Auto-generated method stub
		int cont =0;
		int cont2 =0;
		int cont3 =0;
		int cont4 =0;
		boolean sw = false;
		
		
		for (int i=0; i<Vm;i++) {
			
			for (int j=0; j<Vm;j++) {
				
				if(t[i][j]==MJ) {	
			    cont++;
			  
					
				}
				if(t[i][j]==MJ && i==j) {
					cont3++;
				
				}
				
if(t[j][i]==MJ) {
					
					cont2++;
							
				}

if(t[i][j]==MJ && (i+j)==(Vm-1)) {
	
	cont4++;
	
	
}

				if(cont>=Vm) {
					
					sw=true;
					
				}
				
				
			}
			
			if(cont2>=Vm) {
				System.out.println("contador 2 " + cont2);
				sw=true;
				
				
				
			}
			if(cont3>=Vm) {
				System.out.println("contador 3 " + cont3);
				sw=true;
				
			}
if(cont4>=Vm) {
	System.out.println("contador 4 " + cont4);
				sw=true;
				
			}
			
			cont=0;
			cont2=0;
			
		}

		return sw;
	}

	private static void ShowTable(char t[][], int Vm) {
		// TODO Auto-generated method stub
		
		int f,c;
		for( f=0; f<Vm;f++) {

			for( c=0; c<Vm;c++) {
				System.out.print("|"+ t[f][c]);
				
			}
			System.out.println("|");
	
	}
	}

	private static void clean(char[][] t, int Vm) {
		// TODO Auto-generated method stub
		int f,c;
		for( f=0; f<Vm;f++) {

			for( c=0; c<Vm;c++) {
				
				t[f][c]= TAG;
			}
			
		}

		
	}
	
	

    

}