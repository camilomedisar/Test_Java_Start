package com.portalj.ctrl;

import java.awt.Button;
import java.math.BigDecimal;



import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.text.DateFormat;

import javax.naming.NamingException;

import org.zkoss.zhtml.Col;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;

import com.portalj.dao.CatProductoDao;
import com.portalj.model.CatProducto;

import net.sf.jasperreports.components.table.Column;

import org.zkoss.zk.ui.select.SelectorComposer;
public class CatProductoCtrl extends BaseCtrl{
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<CatProducto> lst = new  ArrayList<CatProducto>();
	List<CatProducto> lst2 = new  ArrayList<CatProducto>();
	private Listbox lbxCatProducto; 
	private  Listbox lbxCatProducto2;
	private Intbox intMatrix; 
	private Button btnOk;
	private Textbox Status;
	
	
	

	private Intbox Row;
	private Intbox Column;
	private Intbox Row2;
	private Intbox Column2;
	private Textbox Player1;
	private Textbox Player2;
	
	String play1 ="Player 1";
	String play2 ="Player 2";
	
	
	
	
	
	static final String JUGADOR1= "O";
	static final String JUGADOR2="X";
	static final String TAG="-";
	String T[][] = new String[100][100];
	boolean Existeganador = false;
	int c=0;
	int f=0;
	int juegos =0;
	static int jugadas =0;
	int y=0;
	boolean salir =false;
	int numero=0;
	
	String valorSt="";
	static int array[] = new int[1005];
	
	


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		
			
		
		
		
		
		
		
	}
	
	public void onClick$btnStart(Event evt) {
		

		int x = intMatrix.getValue();
	
		cargarCatProducto(x);
		
	}
	
	
	
	private void cargarCatProducto(int V) {
		
		for (int i =0;i<V;i++) {
		
			for (int j =0;j<V;j++) {
				T[i][j]= TAG;
			}
			
		}
		
		clean(T,V);
		Generarvista(V, T);
		
		
}
	
	public void onClick$btnOK(Event evt) {
		
		int x = intMatrix.getValue();
		


		int r = Row.getValue();
		int c = Column.getValue();
		
		
		
		guardarProducto(c,r,x);
		
	}
	
public void onClick$btnOK2(Event evt) {
		
		int x = intMatrix.getValue();
		
		

		int r = Row2.getValue();
		int c = Column2.getValue();
		
		
		
		guardarProducto2(c,r,x);
		
	}
	
	private void guardarProducto(int c,int f, int V) {
		
		System.out.print("jugadaaaaaaaaaaaaaaaaaa::");
		System.out.print(c);
		System.out.print(f);
		List<CatProducto> lst = new  ArrayList<CatProducto>();

 		
		

		System.out.println("cantidad de matrices =");
			
		
				System.out.println("Jugada de jugador 1");

				
				
				if(c>V || f>V) {
					
					Status.setValue("player 1 lost the game, cause select a inexistent box ");
					System.out.println("Jugador 1 pierde el juego, por repetir elegir una casilla mas grande de la existente");
					clean(T, V);
					
					
				}
				String	valorc = Integer.toString(c);
				String	valorf = Integer.toString(f);
				valorSt = valorc+valorf;
				System.out.println(valorSt);
				array[y]=numero;
				 numero = Integer.parseInt(valorSt);
										
				if(y>0 ) {
				for (int m=0;m<=1000;m++) {
					  
					if (numero == array[m]) {
						Status.setValue("The player 1 lost, cause he selected a used box");
						System.out.println("mismo valor jugador pierde ");
						clean(T, V);
						salir = true;
						break;
					}
				}
				}
				
			
				y++;
				
				T[f-1][c-1]= JUGADOR1;
				ShowTable(T,V);
				
				if (Winner(T,JUGADOR1,V)) {
					
					Ganador1();					
					System.out.println("Jugador1 GANO");
					clean(T, V);
					c=0;
					f=0;
					for(int m=0; m<V;m++) {
					
					for(int l=0; l<V;l++) {
					System.out.print(T[l][m]);
					
					}
					System.out.println();
					}
					Existeganador=true;
					
				}
				jugadas ++;
				System.out.println(jugadas);
				if(jugadas >=V*V) {
					
					Status.setValue("Tied game");
					System.out.println("Tied game");
					clean(T, V);
				}
				
	
				Generarvista(V, T);

		
		
	}
	
private void guardarProducto2(int c,int f, int V) {
	
	
	

				String	valorc = Integer.toString(c);
				String	valorf = Integer.toString(f);
				valorSt = valorc+valorf;
				System.out.println(valorSt);
				array[y]=numero;
				 numero = Integer.parseInt(valorSt);
										
				if(y>0) {
				for (int m=0;m<=1000;m++) {
					  
					if (numero == array[m]) {
						Status.setValue("The player 2 lost, cause he selected a used box");
						System.out.println("mismo valor jugador pierde ");
						clean(T, V);
						salir = true;
						break;
					}
				}
				}
				
				if (salir==true) {
					
			}
				y++;
				
			
				if(jugadas >=V*V) {
					
					
				}
				System.out.println("Jugada de jugador 2");

			
				
				if(c>V || f>V) {
					
					
					Status.setValue("player 2 lost the game, cause select a inexistent box ");

					System.out.println("Jugador 2 pierde el juego, por repetir elegir una casilla mas grande de la existente");
					clean(T, V);
					
					
				}
					valorc = Integer.toString(c);
					valorf = Integer.toString(f);
				valorSt = valorc+valorf;
				System.out.println(valorSt);
				array[y]=numero;
				 numero = Integer.parseInt(valorSt);
	
			
			
				
				
				y++;
				T[f-1][c-1]= JUGADOR2;
				ShowTable(T,V);
				
				if (Winner(T,JUGADOR2,V)) {
					
					Ganador2();
					System.out.println("Jugador 2 GANO");
					clean(T, V);
					
					
				}
				jugadas ++;
				System.out.println(jugadas);
				if(jugadas >=V*V) {
					Status.setValue("Tied game");
					System.out.println("Tied game");
					clean(T, V);
				}
			
				
				Generarvista(V, T);
			
		
		

		
	}
	
	private static boolean Winner(String[][] t, String MJ,int Vm) {
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
	
	private static void ShowTable(String t[][], int Vm) {
		
		int f,c;
		for( f=0; f<Vm;f++) {

			for( c=0; c<Vm;c++) {
				System.out.print("|"+ t[f][c]);
				
			}
			System.out.println("|");
	
	}
	}
	
	
	private void nameWinner(String name) {
		juegos++;
		System.out.println("cantidad de juegos");
		System.out.println(juegos);
		CatProducto prod = new CatProducto();
		prod.setPlayer1(name);
		prod.setNumJueg(juegos);
		lst2.add(prod);
		
		Listitem item;
		Listcell cell;
		
	
		if(lst2!= null && lst2.size()> 0) {
			
			lbxCatProducto2.getItems().clear();
		
			
			for(CatProducto _prod : lst2 ) {
				
				item = new Listitem();
				item.setParent(lbxCatProducto2);
				item.setValue(_prod);
				
				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(String.valueOf(_prod.getPlayer1()));
				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(String.valueOf(_prod.getNumJueg()));
			
			}
			}
		

	}

	private  void clean(String[][] t, int Vm) {
		
		
		
		
		
		
		int f,c;
		f =0;
		f=0;
		numero =0;
		
		jugadas =0;
		y=0;
		
		
		for (int m=0;m<1005;m++) {
		array[m] =0;
		
		}
		
		for( f=0; f<=20;f++) {
			
			for( c=0; c<=Vm;c++) {
				
				t[f][c]= TAG;
			}
			
		}
		
		
		
		
	}
	
	private void Ganador1 () {
		Status.setValue("Player 1 winner");
		if(Player1.getValue()!= null) {
		
		 play1 = Player1.getValue();
		}
		nameWinner(play1);
		
	
	

	}
	
	private void Ganador2() {
		
		Status.setValue("Player 2 winner");
		if(Player1.getValue()!= null) {
		play2 = Player2.getValue();
		}
		nameWinner(play2);
		
		
	}
	
	
	private void Generarvista(int V, String[][] T) {
		
		
		List<CatProducto> lst = new  ArrayList<CatProducto>();
		
		switch (V) 
        {
            case 3: 
            	
        		
            	for(int i=0;i<V;i++) {
            	CatProducto prod = new CatProducto();
        		prod.setCol1(T[i][0]);
        		prod.setCol2(T[i][1]);
        		prod.setCol3(T[i][2]);
     		     lst.add(prod);         	       		
        }
        		
      
                     break;
            case 4:  
            	List<CatProducto> lst1 = new  ArrayList<CatProducto>();
        		
            	
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		lst.add(prod); 
            		
            }
            	
            	
                     break;
            case 5:  
            	
            	
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		prod.setCol5(T[i][4]);
            		lst.add(prod); 
            }
                     break;
            case 6: 
            	
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		prod.setCol5(T[i][4]);
            		prod.setCol6(T[i][5]);
            		lst.add(prod); 
            }
                     break;
            case 7:  
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		prod.setCol5(T[i][4]);
            		prod.setCol6(T[i][5]);
            		prod.setCol7(T[i][6]);
            		lst.add(prod); 
            }
                     break;
            case 8:
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		prod.setCol5(T[i][4]);
            		prod.setCol6(T[i][5]);
            		prod.setCol7(T[i][6]);
            		prod.setCol8(T[i][7]);
            		lst.add(prod); 
            }
            	
                    break;
            case 9:  
            	for(int i=0;i<V;i++) {
                	CatProducto prod = new CatProducto();
            		prod.setCol1(T[i][0]);
            		prod.setCol2(T[i][1]);
            		prod.setCol3(T[i][2]);
            		prod.setCol4(T[i][3]);
            		prod.setCol5(T[i][4]);
            		prod.setCol6(T[i][5]);
            		prod.setCol7(T[i][6]);
            		prod.setCol8(T[i][7]);
            		prod.setCol9(T[i][8]);
            		lst.add(prod); 
            }
                     break;
            default: 
                     break; 
        }
			
		
			Listitem item;
			Listcell cell;
			
		
			if(lst != null && lst.size()> 0) {
				
				lbxCatProducto.getItems().clear();
			
				
				for(CatProducto _prod : lst ) {
					
					
					
					switch (V) 
			        {
			            case 3: 
					item = new Listitem();
					item.setParent(lbxCatProducto);
					item.setValue(_prod);
					
					cell = new Listcell();
					cell.setParent(item);
					cell.setLabel(String.valueOf(_prod.getCol1()));
					cell = new Listcell();
					cell.setParent(item);
					cell.setLabel(String.valueOf(_prod.getCol2()));
					cell = new Listcell();
					cell.setParent(item);
					cell.setLabel(String.valueOf(_prod.getCol3()));
					cell = new Listcell();
					
					
					break;
					
			            case 4:
			            	
			            	item = new Listitem();
							item.setParent(lbxCatProducto);
							item.setValue(_prod);
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol1()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol2()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol3()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol4()));

			            	break;
			            case 5:
			            	
			            	item = new Listitem();
							item.setParent(lbxCatProducto);
							item.setValue(_prod);
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol1()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol2()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol3()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol4()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol5()));
			            	break;
			            case 6:
			            	
			            	item = new Listitem();
							item.setParent(lbxCatProducto);
							item.setValue(_prod);
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol1()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol2()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol3()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol4()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol5()));
			            	cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol6()));
			            	break;
			            	
			            case 7:
			            	
			            	item = new Listitem();
							item.setParent(lbxCatProducto);
							item.setValue(_prod);
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol1()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol2()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol3()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol4()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol5()));
			            	cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol6()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol7()));
			            	break;
			            	
			            	case 8:
			            	
			            	item = new Listitem();
							item.setParent(lbxCatProducto);
							item.setValue(_prod);
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol1()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol2()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol3()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol4()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol5()));
			            	cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol6()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol7()));
							cell = new Listcell();
							cell.setParent(item);
							cell.setLabel(String.valueOf(_prod.getCol8()));
			            	break;
			            	case 9:
				            	
				            	item = new Listitem();
								item.setParent(lbxCatProducto);
								item.setValue(_prod);
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol1()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol2()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol3()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol4()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol5()));
				            	cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol6()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol7()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol8()));
								cell = new Listcell();
								cell.setParent(item);
								cell.setLabel(String.valueOf(_prod.getCol9()));
				            	break;
			        }
					
				}
			}
		
		
	}
	
}
