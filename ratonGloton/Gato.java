package ratonGloton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class Gato {

	
	//ATRIBUTOS
	int gatx;//posicion para gato en x
	int gaty;//posicion para gato en y
	Timer timer;
	Random aleatorio;
	int direccion;
	int direcciony;
	int mx;
	int my;
	
	
	
	public Gato(int x, int y) {
		
		aleatorio=new Random();
		gatx=x;
		gaty=y;
		
		Juego.mat[gatx][gaty]=7;//las posiciones que vayan siendo seran igual a 7 que es el gato
		
		direccion=aleatorio.nextInt(4);//direccion sera igual a un numero aleatorio entre 0 y 3
		
		this.movimientoGato(); //para llamar a la funcion movimientoGato
		
	}//fin constructor
	
	public void movimientoGato() {
		
		
		timer = new Timer(200,(ActionListener) new ActionListener() {//esto es un bucle infinito que da una vuelta cada 200 milisegundos , para aumentar el movimiento resucir los 200
            
			public void actionPerformed(ActionEvent e) {  //esto registra cada 200 milisegundos si se ha pulsado alguna tecla de movimiento  
				
				
				
				//arriba
				if(gaty>0 && direccion==0) {
					//camina
					if(Juego.mat[gatx][gaty-1] !=2 && (Juego.mat[gatx][gaty-1]==0 || Juego.mat[gatx][gaty-1]==1 )) { //si la posicion de arriba que tenga el gato es suelo (0) o comida (1) sigue moviendose en esa direccion
						Juego.mat[gatx][gaty]= Juego.matAux[gatx][gaty];  //para borrar el rastro del gato                                                      
						gaty-=1;
						Juego.mat[gatx][gaty]=7; //para que el nuevo movimiento se haga efectivo
						Tablero.pintarMatriz();
					}else
					//choca pared
					 if(gatx>0 && Juego.mat[gatx][gaty-1]==2) { //cuando su posicion en x sea mayor a 0 y haya un muro en la posicion de arriba cambiara de direccion
						
						direccion=aleatorio.nextInt(4);//direccion sera igual a un numero aleatorio entre 0 y 3 para que toque una direccion
					}else
					//choca otro gato
					 if(Juego.mat[gatx][gaty-1]==7) {//si la posicion de arriba del gato es otro gato cambia de direccion
						
						direccion=aleatorio.nextInt(4);
					}
				}
				
				//abajo
				if(direccion==1) {
					//camina
					if(Juego.mat[gatx][gaty+1]!=2 && (Juego.mat[gatx][gaty+1]==0 || Juego.mat[gatx][gaty+1]==1 )) {
						Juego.mat[gatx][gaty]= Juego.matAux[gatx][gaty];  //para borrar el rastro del gato   
						gaty+=1;
						Juego.mat[gatx][gaty]=7; //para que el nuevo movimiento se haga efectivo
						Tablero.pintarMatriz();
					}else
					//choca pared
					 if(gatx<14 && Juego.mat[gatx][gaty+1]==2) { //cuando su posicion en x sea mayor a 0 y haya un muro cambiara de direccion
						
						direccion=aleatorio.nextInt(4);//direccion sera igual a un numero aleatorio entre 0 y 3
					}else	
					
					//choca otro gato
					 if(Juego.mat[gatx][gaty+1]==7) {//si la posicion de arriba del gato es otro gato cambia de direccion
						
						direccion=aleatorio.nextInt(4);
					}
				}
				
				//izquierda
				if(gaty>0 && direccion==2 ) {
					//camina
					if(Juego.mat[gatx-1][gaty]!=2 && (Juego.mat[gatx-1][gaty]==0 || Juego.mat[gatx-1][gaty]==1 )) {
						Juego.mat[gatx][gaty]= Juego.matAux[gatx][gaty];  //para borrar el rastro del gato   
						gatx-=1;
						Juego.mat[gatx][gaty]=7; //para que el nuevo movimiento se haga efectivo
						Tablero.pintarMatriz();
					}else
					//choca pared
					 if(gatx>0 && Juego.mat[gatx-1][gaty]==2) { //cuando su posicion en x sea mayor a 0 y haya un muro cambiara de direccion
						
						direccion=aleatorio.nextInt(4);//direccion sera igual a un numero aleatorio entre 0 y 3
					}else
					//choca otro gato
					 if(Juego.mat[gatx-1][gaty]==7) {//si la posicion de arriba del gato es otro gato cambia de direccion
						
						direccion=aleatorio.nextInt(4);
					}
				}
				
				//derecha
				if(direccion==3) {
					//camina
					if(Juego.mat[gatx+1][gaty]!=2 && (Juego.mat[gatx+1][gaty]==0 || Juego.mat[gatx+1][gaty]==1 )) {
						Juego.mat[gatx][gaty]= Juego.matAux[gatx][gaty];  //para borrar el rastro del gato   
						gatx+=1;
						Juego.mat[gatx][gaty]=7; //para que el nuevo movimiento se haga efectivo
						Tablero.pintarMatriz();
					}else
					//choca pared
					 if(gatx<14 && Juego.mat[gatx+1][gaty]==2) { //cuando su posicion en x sea mayor a 0 y haya un muro cambiara de direccion
						
						direccion=aleatorio.nextInt(4);//direccion sera igual a un numero aleatorio entre 0 y 3
					}else	
					//choca otro gato
					 if(Juego.mat[gatx+1][gaty]==7) {//si la posicion de arriba del gato es otro gato cambia de direccion
						
						direccion=aleatorio.nextInt(4);
					}
					
				}
				
				
			}
		});
		timer.start();//inicia el timer que contiene el movimiento aleatorio de los gato
		
	}//fin movimiento
	
	
	
		
	
	
	
	
	
	
	
	
	
	
}