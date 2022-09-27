package ratonGloton;

import javax.swing.ImageIcon;

public class Tablero extends Juego {
	
	public static int[][] tablero/*tablero=nivel*/(int opcion) {//METODO SETTER  PARA ELEGIR TABLERO//el parametro de entrada es para elegir el la opcion de tablero 
			
			int[][] aux1=new int[15][15];//CAMBIAR NUMEROS Y NOMBRES DE LOS ARRAYS
			if(opcion==1) {
				
				int[][] aux= {
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},        
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
						{2,1,1,1,2,2,2,2,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,2,2,2,2,1,1,1,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,2,1,2},
						{2,2,2,2,1,1,1,1,1,2,1,1,2,1,2},
						{2,1,1,1,1,2,1,1,1,2,2,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
						
				};
				
				return aux;
			}
			
	        if(opcion==2) {
	        	
	        	int[][] aux= {
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
						{2,1,1,1,2,2,2,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,2,1,1,1,1,2,2,1,1,2},
						{2,2,2,1,1,2,1,2,1,1,2,2,1,1,2},
						{2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
						{2,1,2,2,1,1,1,2,1,1,1,1,1,1,2},
						{2,1,1,2,2,1,1,2,2,1,1,2,2,1,2},
						{2,1,2,2,2,1,1,1,1,1,1,2,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,2,1,1,2},
						{2,1,2,2,2,2,1,1,1,1,2,2,1,1,2},
						{2,1,2,1,1,2,1,1,1,1,1,1,1,1,2},
						{2,1,2,1,1,2,1,1,2,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,2,2,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
				
			};
	        	return aux;
	      }  	
			
	        if(opcion==3) {
	        	
	        	int[][] aux= {
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
						{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
	        };
	        
	            return aux;
	        }
			
	        return aux1;
		
	}//FIN METODO SETTER PARA ELEGIR TABLERO

	public static void pintarMatriz() {//pinta el tableto seguns la posicion correspondiente
		//fotos del tablero
				for(int i=0;i<mat.length;i++) { 
					for(int j=0;j<mat.length;j++) {
						matriz[i][j].setIcon(new ImageIcon("imagenes/"+mat[i][j]+".png"));//coge la imagen de la direccion segun i j que son los numeros con los que hemos compuesto el laberinto
						matriz[i][j].setBounds(100+(i*30),100+(j*30),30,30);//esto es igual que para los botones del menu, pero lo estamos haciendo para construir el laberinto
						matriz[i][j].setVisible(true);
						panelJuego.add(matriz[i][j],0);
					}
				}	
	}//FIN METODO PINTAR MATRIZ
	
	
	
	


      

}
